#2：插件读取Dockerfile进行构建

#基于哪个镜像
FROM java:latest
#将本地文件夹挂载到当前容器
#由于Spring Boot使用内置的Tomcat容器，Tomcat默认使用/tmp作为工作目录
#这个命令的效果是：在宿主机的/var/lib/docker目录下创建一个临时文件并把它链接到容器中的/tmp目录
VOLUME /tmp
#复制文件到容器
ADD docker2-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
#声明需要暴露的端口
EXPOSE 8080
#配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]