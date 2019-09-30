
#泗洪能源服务中心:

#Nacos 服务地址 
192.168.11.186:8848
#Nacos 界面访问 
192.168.11.186:8848/nacos 账号: nacos 密码: nacos

#Nexus 私服地址 
192.168.11.186:8081
#Nexus 私服界面访问 
192.168.11.186:8081 账号: root 密码: Chinavnet.1


#Swagger2 在线文档 使用整理 
http://localhost:8300/doc.html
http://www.jfinal.com/share/1569
#注解参考
https://www.cnblogs.com/chancy/p/9759553.html

   #@ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "int",paramType = "body")
   此注解写在方法体上
   #dataType="int" 代表请求参数类型为int类型，
   当然也可以是Map、User、String等；
   #paramType="body" 代表参数应该放在请求的什么地方：
   #参数可以为:
    header:放在请求头。请求参数的获取：@RequestHeader(代码中接收注解)
    query: 用于get请求的参数拼接。请求参数的获取：@RequestParam(代码中接收注解)
    path:  请求参数的获取：@PathVariable(代码中接收注解)（用于restful接口）
    body:  放在请求体。请求参数的获取：@RequestBody(代码中接收注解)
    form: （不常用）
    
Maven 打包配置
#springboot多模块打包报错，找不到xxx包，找不到xxx类 
https://blog.csdn.net/qq_42714869/article/details/83537794

1.0版本问题
 1: 代码生成器没有加入项目
 2: logback 框架 日志文件存放位置修改
 3: VO实体类加入 Swagger注解之后 在在线文档中 会显示不出 或者 null
 4: 网关在线文档中 error接口会被加入进去
 5: 网关在线文档的基础信息显示 该放到配置文件中实现可动态配置
 

  