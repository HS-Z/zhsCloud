# zhsCloud

# 说明
目前所启用的服务有 zhs-eureka、zhs-zuul、zhs-admin、zhs-basic、zhs-provider 。
zhs-eureka 服务提供服务的注册与发现支持。
zhs-zuul 服务提供路由及网关支持。
zhs-admin 服务提供服务的监控支持，使用 springboot-admin。
zhs-basic 服务是基础服务，包括登陆及一些基本操作。
zhs-provider 服务是一个测试服务，用于 zhs-basic 服务的调用测试，调用方式为 feign。
zhs-common 为公共模块。

# 项目的启动顺序
zhs-eureka、zhs-admin、zhs-zuul、zhs-basic、zhs-provider

# 注意事项
启动zhs-basic服务前，需要先启动redis。

windows版本的redis下载地址：https://github.com/MicrosoftArchive/redis/releases
或者在当前项目的 项目所需 文件夹下获取 redis-latest.zip 

# zipkin使用指南
windows版本：
在当前项目的“项目所需”文件夹下获取 zipkin-server-2.11.12-exec.jar
将 zipkin-server-2.11.12-exec.jar 文件保存到本地，假设保存在c盘根目录
在windows下使用WIN+R指令进入运行运行界面，输入cmd指令，然后再输入指令 java -jar zipkin-server-2.11.12-exec.jar 启动
浏览器输入 http://127.0.0.1:9411/zipkin/ 进行查看
