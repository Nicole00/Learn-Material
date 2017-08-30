# SpringMVC配置过程中出现servlet找不到对应的mapping #

在web.xml中配置servlet时，明明对所有的servlet配置了对应的mapping，仍然出现错误：“servlet should have a mapping”。

**解决方法：**

在File ——>  project Structure  ——>  Project Settings ——> Modules中为Web增加Development Descriptors。

选择Development Descriptors 模块的右边+号，对于自动识别的Path是out路径，需要修改为自己工程中的web.xml所在的路径，apply即可。
