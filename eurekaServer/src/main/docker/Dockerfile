#Image 指定名称和版本号
FROM frolvlad/alpine-oraclejdk8:slim

#用来指定镜像创建者信息
MAINTAINER Dong

#指定挂载点,/tmp目录用来持久化到 Docker 数据文件夹，因为 Spring Boot 使用的内嵌 Tomcat 容器默认使用/tmp作为工作目录
VOLUME ["/tmp"]

#项目的 jar 文件作为 "app.jar" 添加到容器的
ADD eurekaServer-1.0-SNAPSHOT.jar app.jar

#RUN bash -c 'touch /app.jar'

#ENTRYPOINT 执行项目 app.jar。为了缩短 Tomcat 启动时间，添加一个系统属性指向 "/dev/urandom" 作为 Entropy Source
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

#对外暴露端口号8761
EXPOSE 8761