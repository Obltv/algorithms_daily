# 在龙蜥（OpenAnolis）系统上配置 Docker

本教程适用于基于 RHEL/CentOS 的龙蜥操作系统（OpenAnolis），帮助你快速完成 Docker 的安装与配置。

---

## 一、确认系统版本

```bash
cat /etc/os-release
```

输出示例：

```
NAME="anolis"
VERSION="8.6"
```

---

## 二、 配置Docker的yum库

1. 更新系统：

```bash
sudo dnf update -y
```

2. 卸载旧版：

```bash
yum remove docker \
    docker-client \
    docker-client-latest \
    docker-common \
    docker-latest \
    docker-latest-logrotate \
    docker-logrotate \
    docker-engine \
    docker-selinux 
```

---

3. 配置Docker的yum库：

```bash
sudo yum install -y yum-utils device-mapper-persistent-data lvm2
```

4. 配置yum源(阿里云)：

```bash
sudo yum-config-manager --add-repo https://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo

sudo sed -i 's+download.docker.com+mirrors.aliyun.com/docker-ce+' /etc/yum.repos.d/docker-ce.repo
```

5. 更新yum，建立缓存：

```bash
sudo yum makecache fast
```


---

## 三、安装Docker

```bash
yum install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```

## 四、校验

```bash
# 启动Docker
systemctl start docker

# 停止Docker
systemctl stop docker

# 重启
systemctl restart docker

# 设置开机自启
systemctl enable docker

# 执行docker ps命令，如果不报错，说明安装启动成功
docker ps
```

---

## 五、配置国内镜像加速器（推荐）

```bash
# 创建目录
rm -f /etc/docker/daemon.json

# 复制内容
tee /etc/docker/daemon.json <<-'EOF'
{
    "registry-mirrors": [
        "http://hub-mirror.c.163.com",
        "https://mirrors.tuna.tsinghua.edu.cn",
        "http://mirrors.sohu.com",
        "https://ustc-edu-cn.mirror.aliyuncs.com",
        "https://ccr.ccs.tencentyun.com",
        "https://docker.m.daocloud.io",
        "https://docker.awsl9527.cn"
    ]
}
EOF

# 重新加载配置
systemctl daemon-reload

# 重启Docker
systemctl restart docker
```

---

## 附：Docker 常用命令

| 功能         | 命令                            |
|--------------|---------------------------------|
| 查看版本     | `docker version`               |
| 查看信息     | `docker info`                  |
| 查看镜像     | `docker images`                |
| 查看容器     | `docker ps -a`                 |
| 删除镜像     | `docker rmi <image-id>`        |
| 停止容器     | `docker stop <container-id>`   |
| 启动容器     | `docker start <container-id>`  |

**Last Updated**: 2025-05-16
