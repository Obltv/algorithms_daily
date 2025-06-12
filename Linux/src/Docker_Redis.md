# Redis Docker 安装与连接指南

## 1. 拉取镜像

```bash
docker pull redis:6.2.7
```

## 2. 启动服务

创建容器并设置端口映射：

```bash
docker run -id --name redis6 --restart always -p 6379:6379 redis:6.2.7
```

### 参数说明：

- `-p 6379:6379`：将容器的 6379 端口映射到宿主机的 6379 端口
- `--restart always`：无论容器如何退出，都自动重启

`--restart` 参数值说明：

- `no`：容器退出时不自动重启
- `on-failure`：仅当容器非正常退出（状态码非 0）时重启
- `always`：无论退出状态如何都重启

## 3. 防火墙端口开放

若希望外部访问 Redis，需要开放宿主机的 6379 端口。

**注意：** 若使用云服务器，应登录云控制台配置防火墙入方向规则。

本地防火墙操作如下：

```bash
# 查看是否已经开放 6379 端口
firewall-cmd --list-port

# 开放 6379 端口
firewall-cmd --add-port=6379/tcp --permanent

# 重新加载防火墙配置
firewall-cmd --reload
```

## 4. 连接 Redis

### 方法一：使用外部程序连接 Docker 容器中的 Redis

```bash
./redis-cli.exe -h <你的IP地址> -p 6379
```

### 方法二：使用 Docker 容器内自带的 Redis 客户端连接

```bash
docker exec -it redis6 redis-cli
```
