# SpringBoot
基于SpringBoot和Spring Security框架的基础搭配，以及使用Spring Test进行功能上的测试。
1. 项目里基于SpringBoot的自动化配置，进行部分自定义配置（dev/test）两个不同环境的配置文件进行管理，dev使用的是properties文件，
   而test使用的是yml格式的文件。
2. 运行Application类时在jvm options参数上配置-Dspring.profiles.active=dev来指定程序启动时是加载application-dev配置。
此项目为SpringBoot+Spring Security+内置的tomcat+本地的elasticsearch为基础组合的可供开发的环境。

2017-06-16：项目中加入了Spring-data-mongodb模块，并实现了一个新增和查询的功能。

2017-08-14：项目中加入SpringBatch组件的集成，并基于batch模拟一个批处理的demo例子——Person导入。