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

HTTP1.0之前是不支持长连接

图片上传
二维码生成
搜索好友
添加好友---先发送请求--

好友请求列表
忽略----通过

好友列表

看到P25


WebSocket:
1>持久化的协议
2>主动实时反馈服务端信息，客户端不需要主动请求服务器

