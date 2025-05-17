# Nacos 单机部署指南（云服务器环境）

## 1. 准备部署目录

```bash
mkdir -p /home/nacos/nacos-docker
cd /home/nacos/nacos-docker
```

---

## 2. 云服务器开放端口

> 注意：在云服务器中，**不要使用 `firewall-cmd` 命令**，应登录云服务器控制台配置端口规则。

### 必须开放的端口：

| 端口 | 用途              |
|------|-------------------|
| 8848 | Nacos 主服务端口 |
| 9848 | Nacos gRPC 端口  |

### 开放方法：

1. 登录云服务商控制台（如阿里云、腾讯云、华为云）
2. 找到实例 -> 安全组配置 -> 入方向规则
3. 添加以下规则：

- 协议：TCP
- 端口范围：8848、9848
- 授权对象：0.0.0.0/0（或指定 IP）

---

## 3. 编写 Docker Compose 配置文件

在 `/home/nacos/nacos-docker` 目录下创建文件：

```bash
nano standalone-derby.yaml
```

粘贴以下内容：

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

---

## 4. 启动服务

前台启动：

```bash
docker-compose -f standalone-derby.yaml up
```

后台启动：

```bash
docker-compose -f standalone-derby.yaml up -d
```

---

## 5. 访问 Nacos 控制台

浏览器中访问：

```
http://<你的云服务器公网IP>:8848/nacos
```

默认账号密码：

- 用户名：`nacos`
- 密码：`nacos`

---

## 🔧 常见问题排查

- 无法访问页面：
    - 检查云服务器端口是否开放
    - 使用 `docker ps` 确认容器是否正常运行
    - 宿主机防火墙是否限制（如你也配置了 firewalld）


export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
export PATH=$JAVA_HOME/bin:$PATH
