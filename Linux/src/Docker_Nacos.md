# Nacos 单机模式部署指南

## 1. 在 `/home` 目录下创建 nacos-docker 目录

```bash
mkdir -p /home/nacos/nacos-docker
cd /home/nacos/nacos-docker
```

## 2. 放行防火墙端口

> ⚠️ 注意：如果你使用的是云服务器（如阿里云、腾讯云），请前往控制台开放端口。无需使用命令行。

本地服务器端口开放命令：

```bash
firewall-cmd --add-port=8848/tcp --add-port=9848/tcp --permanent
firewall-cmd --reload
```

## 3. 启动单机模式服务

服务编排配置参考链接：  
https://github.com/nacos-group/nacos-docker/blob/master/example/standalone-derby.yaml

在 `nacos-docker` 目录下新建 `standalone-derby.yaml` 文件，
```
vim standalone-derby.yaml
```

写入以下内容：

```yaml
version: "2"
services:
  nacos:
    image: nacos/nacos-server:v2.1.0
    container_name: nacos-standalone
    environment:
      - PREFER_HOST_MODE=hostname
      - MODE=standalone
      - JVM_XMS=256m
      - JVM_XMX=256m
      - JVM_XMN=128m
      - JVM_MS=32m
      - JVM_MMS=80m
    volumes:
      - ./standalone-logs/:/home/nacos/logs
      - ./init.d/custom.properties:/home/nacos/init.d/custom.properties
    ports:
      - "8848:8848"
      - "9848:9848"
```

## 4. 前台启动服务

```bash
docker-compose -f standalone-derby.yaml up
```
## 5. 切换为后台启动服务

当前台启动无误后，按 `Ctrl + C` 退出前台启动。然后使用下面的命令后台启动：

```bash
docker-compose -f standalone-derby.yaml up -d
```

## 6. 查看启动日志

确认服务启动情况：

```bash
docker logs nacos-standalone
```

如果你看到类似如下日志，说明启动成功：

```
Nacos started successfully in standalone mode.
```

---

## 7. 常见问题解决

### 问题 1：云服务器部署的 Nacos 无法访问

请参考官方说明文档：  
👉 [2.0.0 兼容性升级指南](https://nacos.io/zh-cn/docs/v2/upgrading/2.0.0-compatibility.html)

---

### 问题 2：Nacos 服务重启后数据丢失

这通常是因为你使用了如下命令重启服务：

```bash
docker-compose -f standalone-derby.yaml up -d
```

`up` 命令默认会重新创建容器，从而导致数据丢失。

#### 正确方式（重启 Nacos 服务）：

```bash
docker-compose -f standalone-derby.yaml start
```

或者将数据持久化到数据库中（这里不做说明，建议参考官方文档与编排模板进行配置）。

---

📝 **TIP：**
- 如果你使用的是生产环境，强烈建议配置数据库持久化；
- 使用 `start` 而不是 `up`，避免不必要的容器重建。



export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
export PATH=$JAVA_HOME/bin:$PATH
