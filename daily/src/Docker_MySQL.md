# 在龙蜥（OpenAnolis）系统中使用 Docker 安装配置 MySQL 8.0.20

本教程将指导你如何在龙蜥系统（或 CentOS/RHEL）中通过 Docker 安装并配置 MySQL 数据库。

---

## 一、拉取 MySQL 镜像

```bash
docker pull mysql:8.0.20
```

---

## 二、创建容器

通过下面的命令创建容器，并设置端口映射、目录挂载：

```bash
# 在用户目录下创建 mysql 目录用于存储 MySQL 数据
mkdir /home/mysql
cd /home/mysql

# 创建 Docker 容器
docker run -id \
  -p 3306:3306 \
  --name mysql8 \
  --restart always \
  -v $PWD/conf:/etc/mysql/conf.d \
  -v $PWD/log:/var/log/mysql \
  -v $PWD/data:/var/lib/mysql \
  -e MYSQL_ROOT_PASSWORD=123456 \
  mysql:8.0.20 \
  --lower_case_table_names=1
```

### 参数说明：

- `-p 3306:3306`：将容器的 3306 端口映射到宿主机的 3306 端口。
- `-v $PWD/conf:/etc/mysql/conf.d`：挂载配置文件目录。
- `-v $PWD/log:/var/log/mysql`：挂载日志目录。
- `-v $PWD/data:/var/lib/mysql`：挂载数据目录。
- `-e MYSQL_ROOT_PASSWORD=123456`：设置 root 用户初始密码。
- `--lower_case_table_names=1`：设置表名不区分大小写（适用于 Windows 兼容）。

> 注意：在云服务器部署时，**应使用更复杂的密码**，并且**避免将宿主机端口直接映射为 3306**，以防止被自动扫描攻击。

---

## 三、查看容器状态

```bash
docker ps
```

如果看到 STATUS 为 `Up`，说明容器创建成功。

---

## 四、配置防火墙（仅限本地部署）

若希望从外部访问数据库，需要开放宿主机对应端口（如 3306）：

```bash
# 查看是否已开放 3306 端口
firewall-cmd --list-ports

# 未开放则执行以下命令
firewall-cmd --add-port=3306/tcp --permanent

# 重新加载防火墙配置
firewall-cmd --reload
```

> ⚠️ 如果是云服务器，不需要通过命令开放端口，应登录云控制台，在防火墙设置中配置入方向规则。

---

**Last Updated**: 2025-05-16
