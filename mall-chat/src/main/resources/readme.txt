启动FastDFS
启动跟踪器：
/etc/init.d/fdfs_trackerd start

停⽌tracker命令：
/etc/init.d/fdfs_trackerd stop


启动跟踪器：
/etc/init.d/fdfs_storaged start

使用zuul往下游服务传递header的巨坑，header属性不要定义为Authorization,此属性会被过滤掉，下游服务接受不到，产生巨坑。



项目服务端口整理：
mall-zuul:1001      网关
mall-chat:1002      netty服务
mall-auth-service:1003   鉴权
