# Ubuntu 上安装 Zsh + Oh My Zsh + Powerlevel10k 全套美化教程

本文将指导你一步一步在 Ubuntu 系统上配置一套炫酷高效的终端环境，包括 Zsh、Oh My Zsh、Powerlevel10k 主题、以及常用插件。

---

## 📦 第一步：安装 Zsh

打开终端，输入以下命令：

```bash
sudo apt update
sudo apt install -y zsh git curl wget
```

安装完成后可验证：

```bash
zsh --version
```

---

## 🔁 第二步：将 Zsh 设为默认 Shell

```bash
chsh -s $(which zsh)
```

⚠️ 该操作需要重新登录或重启终端才会生效。

---

## 🌈 第三步：安装 Oh My Zsh

Oh My Zsh 是 Zsh 的一个配置框架：

```bash
sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
```

---

## 🎨 第四步：更换主题为 Powerlevel10k

### 1. 克隆 Powerlevel10k 仓库：

```bash
git clone https://github.com/romkatv/powerlevel10k.git $ZSH_CUSTOM/themes/powerlevel10k
```

### 2. 设置主题

打开配置文件：

```bash
nano ~/.zshrc
```

修改主题为：

```bash
ZSH_THEME="powerlevel10k/powerlevel10k"
```

按下 Crtl+O  保存

按下回车

按下 Crtl+X 退出

保存后执行：

```bash
source ~/.zshrc
```

### 3. 执行配置向导

```bash
p10k configure
```

---

## 🔌 第五步：安装实用插件

### 🔹 自动建议插件 zsh-autosuggestions

```bash
git clone https://github.com/zsh-users/zsh-autosuggestions ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-autosuggestions
```

### 🔹 语法高亮插件 zsh-syntax-highlighting

```bash
git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting
```

---

## ⚙️ 第六步：启用插件

编辑 `~/.zshrc` 文件：

```bash
nano ~/.zshrc
```

找到 plugins 一行，修改为：

```bash
plugins=(git zsh-autosuggestions zsh-syntax-highlighting)
```

保存并执行：

```bash
source ~/.zshrc
```

---

## ✅ 完成！

现在你已经拥有一个功能强大、外观美观的终端环境啦！🎉

到这里你就拥有了一个语法部分高亮，有提示的好看的终端，不再想传统那样简洁(当然也有许多优秀工程师喜欢那种最原始的风格)。



## 补充

如果你会vim的话，其实我更推荐vim。

比如你可以将

```bash
source ~/.zshrc
```

改为

```bash
vim ~/.zshrc
```

这样改了之后，你就可以使用`/+你想搜索🔍的内容`来快速查找，非常方便。

