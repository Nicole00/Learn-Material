# Web项目中写Controller时需要引入Servlet的包，但是在引入时总显示“cannot resolve http..” #


项目代码中下面语句总有错误

import javax.servlet.http.HttpServletRequest;

是因为项目中没有导入javax.servlet的包。

1.看网上资料写只需要把tomcat中lib目录下的servlet-api.jar和jsp-api.jar拖到项目WEB-INF下的lib目录即可，但试过仍然无效。

2.在pom文件中导入依赖包也无效。

**有效的解决方法：** 在IDEA中手动导入tomcat的lib目录中的servlet-api.jar和jsp-api.jar包。

操作：File ——> Project Structure ——> Libraries　——> 选择右边+ ——> 选择两个包所在位置 OK即可。

![](https://github.com/Nicole00/Learn-Material/blob/master/Pictures/3.png)
