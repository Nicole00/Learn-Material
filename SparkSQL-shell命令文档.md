## SparkSQL xshell常用命令  ##

1. **进入SparkSQL：**

	在Spark 安装目录bin下执行：

    `spark-sql --master yarn --driver-cores 1 --driver-java-options "-Dspark.driver.port=4050" `

2. **创建数据库：**

    `create database database_name;` 
  
	 database_name为自己要创建的数据库名字

3. **使用数据库：**

	`use database_name;`


4. **创建数据表：**

	有两种情况：
	
	（1） 从源数据中创建数据表 （以person表为例，有id和name两个字段）

		CREATE TABLE IF NOT EXISTS person
		 (
			id string,
			name string
		  )ROW FORMAT DELIMITED FIELDS TERMINATED BY '\u0001\t' STORED AS TEXTFILE;

	（2）从其他表的操作中保存临时表

		 CREATE TABLE IF NOT EXISTS table_name

		 SELECT * FROM other_table_name;
		
	   	 #select语句是获得的临时表

5. **将数据导入数据表：**
	
	源数据各字段之间是以“SOH	”分割的，即SOH加一个tab空格
	
	    LOAD DATA INPATH 'path' OVERWRITE INTO TABLE table_name;
    
    	#path表示 你的源数据存储的位置

		
	 **例子**：往person表中导入数据，源数据存在HDFS上
	
	`LOAD DATA INPATH 'hdfs://ip:port/person.txt' OVERWRITE INTO TABLE person;`
	

6. **查询数据字段：**
	
	`SELECT column_name FROM table_name;`

	column: 要查询的列名

	table_name： 要查询的表名

7. **条件查询：**

	`SELECT column_name FROM table_name WHERE condition;`

	WHERE 后面跟着你要查询的字段需满足的条件。


	**例子**：查询person表中age大于10的人所有的信息。如果需要多条件则条件之间用 AND、OR等连接。

	`SELECT * FROM person WHERE age>10;`

	***注意：如果WHERE column=值，该值类型为string时，注意要加单引号，查询效率比不加单引号的效率高很多。***	

	`SELECT * FROM person WHERE column = ‘123’；`  

8. **聚合操作：**

	`SELECT column_1 FROM table_name GROUP BY column_1;`

	注意：对于聚合操作，SELECT的列中 只能选择group by 后面的列 和由聚合函数得到的结果。 group by 和where一起用时， where语句在前， 即`WHERE condition GROUP BY column` 

	**例子**： 对person求年龄相同的人的数目。

	`SELECT age， COUNT（id） FROM person GROUP BY id；`
 
9. **起别名：** AS

	对字段起别名
	
	`SELECT column AS alias FROM table_name；`

	对临时表起别名

	`（SELECT * FROM table_name） AS new_table_name`


10. **字段分箱操作：**

	分箱： 类似于代码中的swich case，对于不同条件有不同操作。 用case when来实现，其中condition表示条件，execution表示条件满足时执行的语句。

	`CASE WHEN（condition1） THEN execution1 WHEN （condition） THEN execution2 。。。ELSE THEN execution END`

	例子： 将person表中人的年龄分段，0-10岁分为第一段，标识为0； 11-20分为第二段，标识为1； 21-30分为第三段，标识为2； 其他的标识为3



	    SELECT id， CASE WHEN（age>=0 AND age <10） THEN 0 WHEN(age>=10 AND age<20) THEN 1 WHEN (age>=20 AND age<30) THEN 2 ELSE 3 END
    	
		FROM person；
	 
	

	注意：在SparkSQL，case when中多个 when 最好不要换行，有时候换行会出错

11. **对字段做基础操作：**（求和、求平均值、求最大值、最小值、去重）

	这些接口多数情况下是和聚合函数一起使用
	
	求和：     COUNT（column）
	
	求平均值： AVG（column）

	求最大值： MAX（column）
	
	求最小值： MIN（column）
	
	去重：    DISTINCT（column）

12. **对小数进行处理：**

	保留小数点后两位：round

	`ROUND(float_number, k)`

	取上整： ceil

	`CEIL(float)`


13. **对时间的处理：**

	datetime 作为参数时用单引号引起来， 如： ‘2017-01-01 12：00:00’

	**current_date:**  获取当前时间date  包括年月日

	`SELECT current_date;`


	**current_timestamp:** 获取当前datetime 包括年月日 时分秒-毫秒

	`SELECT current_timestamp;`

	**unix_timestamp(now()):** 获取当前时间戳 

	`SELECT unix_timestamp(now());`


	**unix_timestamp:** datetime转时间戳
	
	`SELECT unix_timestamp('2017-08-16 12:12:12');`


	**from_unixtime:** 时间戳转datetime
	
	`SELECT from_unixtime(1502856732);`

	**从datetime获取年份、月份、日**

	    year(datetime)
    
    	month(datetime)
    
    	day(datetime)
    	
    	hour(datetime)
    
    	minute(datetime)
    
    	second(datetime)




	**datediff:** 获取两个date之间间隔的天数

	    SELECT datediff(date1, date2);
    
    	例子： 
    	
    	SELECT datediff('2017-08-16', '2017-08-10');


	**dayofyear:** 获取某天为该年的第几天
	
		`SELECT dayofyear(datetime);`

	**weekofyear：** 获取某周为该年的第几周

		`SELECT weekofyear(datetime);`


	
14. **对字符串的处理：**

	**concat:** 字符串拼接

	`concat(string1, string2)`


	**substring:** 取子字符串

	    substring(string, start, length)
    	
    	start: 子字符串开始的位置，第一个位置为0
    	
    	length: 要截取的子串长度


	**length:** 求字符串长度

	`length(string)`

15. **join 连接操作**  与ON搭配

	**LEFT JOIN ： 左连接**
	
	以左表为基础，在条件之上将右表连接过来。

	例子：	person表：`person_id，name `  Car表：`person_id， car_id， car_type` 将两个表根据`person_id`进行左连接,即结果中person_id 与person表中的person_id一致。

	    SELECT person_id, name, car_id, car_type
    	
    	FROM person LEFT JOIN car 
	
		ON person.person_id = Car.person_id;

	**RIGHT JOIN ： 右连接**

	以右表为基础，在条件之上将左表连接到右表上，即结果中`person_id与`Car表中的`person_id`一致。

	**FULL JOIN ： 全连接**

	结果中`person_id`是person表与Car表中`person_id`的并集， 如果person表中的`person_id`在Car中不存在，则结果中对应的`car_id` 、 `car_type`为空； 如果Car表中的`person_id`在person表中不存在，则结果中对应的`name`为空。

	**CROSS JOIN 笛卡尔积**

	在person表与Car表上做笛卡尔积操作。
	
	例子：

	Person表
	
    	person_id  name
    	1       A
    	2       B

	Car表
	
	    persion_id  car_id， car_type
    	 1            01       type1
         3            02       type2
   
                             
	执行全连接操作：

	    SELECT *
    	
    	FROM person CROSS JOIN Car；

	结果表：

	    person_id name person_id1 car_id car_type
    	1     A	1	01	type1
    	1     A	3	02	type2
    	2     B	1	01	type1
    	2     B	3	02	type2