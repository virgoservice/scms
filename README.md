#塞拉SCMS内容管理系统完整版J2EE代码
当前版本:1.0.0<br/>
塞拉科技官网:http://www.seelecloud.com<br/>
#面向对象
* 塞拉SCMS是企业在创立初期很好的技术基础框架，加快公司项目开发进度，当然也可以对现有的系统进行升级；
* 个人开发者也可以经过塞拉科技授权后使用SCMS承接外包项目。

#技术框架
* 核心框架：Spring Framework 4
* 安全框架：Apache Shiro 1.2
* 视图框架：Spring MVC 4
* 任务调度：Spring Task 4
* 持久层框架：MyBatis 3
* 数据库连接池：Alibaba Druid 1.0
* 日志管理：SLF4J 1.7、Log4j
* JS框架：jQuery 1.10
* CSS框架：Twitter Bootstrap 2.3.1。
* 富文本：Ueditor

#开发环境
建议开发者使用以下环境，这样避免版本带来的问题
* IDE:Spring Tools Suite 3.6.4-RELEASE
* DB:Mysql5.5
* JDK:JAVA 8、J2EE6

#运行环境
* WEB服务器：Tomcat、Jetty 等
* 数据库服务器：Mysql5.5
* 操作系统：Windows、Linux、Unix 等

#4.项目结构：
##scms
* |_src/main/java    //存放项目的java源代码<br/>
|_com.seelecloud.cms.consts     //放置项目中静态的全局变量，枚举类型的java类<br/>
|_com.seelecloud.cms.controller	//放置项目的视图控制类	<br/>
|_com.seelecloud.cms.dao      //放置数据访问类和mapper映射文件<br/>
|_com.seelecloud.cms.entity		//放置实体对象类<br/>
|_com.seelecloud.cms.filter     //放置系统中的过滤器类<br/>
|_com.seelecloud.cms.interceptor  //放置系统中的拦截器类<br/>
|_com.seelecloud.cms.listener	//放置系统中的监听器类<br/>
|_com.seelecloud.cms.security	//放置Shiro的认证和授权类<br/>
|_com.seelecloud.cms.service	//放置业务接口类<br/>
|_com.seelecloud.cms.service.impl //放置业务接口实现类<br/>
|_com.seelecloud.cms.util		//放置系统中的各种工具类<br/>
|_com.seelecloud.cms.vo      //放置实体对象的封装类Value-Object<br/>
 |_src/test/java<br/>
    |_com.seelecloud.cms.*test   //放置对各个模块的测试用例类<br/>   
 |_src/main/resources<br/>
    |_*.xml、*.resources        //放置各种系统配置文件<br/>

 |_src/main/webapp			//放置前端的文件<br/>
  |_resources				//前端的静态资源文件，css,js,img，auth=none<br/>
  |_upload                //文件上传目录，用户文件都上传到这个目录 auth=admin<br/>
  |_backup					//系统备份文件放置目录 auth = admin<br/>
*|_WEB-INF<br/>
  |_jsp					//放置具体的业务视图文件，以模块名称区分<br/>
    |_app<br/>
    |_article<br/>
    |_column<br/>
    |_index<br/>
    ..........<br/>
    |_web.xml           //web配置文件<br/>
|_pom.xml              //Maven的配置文件<br/>

# 系统文档
## 持续更新中，敬请关注....