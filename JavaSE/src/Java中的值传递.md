## Java中只有值传递

## 什么是值传递

### 🔹 值传递（Pass by Value）

- 调用方法时，**传递的是参数的值**，是原始数据的一个副本。
- 方法内部改变这个副本，不影响原始数据。

## 什么是引用传递
### 🔹 引用传递（Pass by Reference）

- 调用方法时，**传递的是变量的地址**（指针），
- 方法内部对这个引用的任何更改，都会影响原始对象的引用。

## 举例

一个方法不能修改一个基本类型的参数，而对象引用参数作为参数就不一样
```java
public static void main(String[] args) {
    int a = 10;
    int b = 20;
    swap(a, b);
    System.out.println(a);
    System.out.println(b);  
  
    /*  
    输出：  
    10    20     
    */
}

static void swap(int num1, int num2) {
    int temp = num1;
    num1 = num2;
    num2 = temp;
}
```
基本数据类型传递的相当于是原数据的副本，并不会影响到原数据

接下来看一组数组做参数的方法
```java
public static void main(String[] args) {  
    int[] arr = new int[]{1, 2, 3, 4, 5};  
      
    //输出1  
    System.out.println(arr[0]);  
    change(arr);  
    //输出100  
    System.out.println(arr[0]);  
}  
  
static void change(int[] arr){  
    arr[0]=100;  
}
```
传入引用类型参数时直接改变了原数据
实际上传入的是引用数据类型的地址
传递的是引用对象的副本，而不是其本身

举个例子🌰
```java
class Person {
    String name;
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Tom";
        modify(p);
        System.out.println("name = " + p.name); // 输出 name = Tom
    }

    public static void modify(Person p1) {
        p1 = new Person();
        p1.name = "Jerry";
    }
}

```

虽然p1指向了新的对象，但并没有改变p的状态

修改一下
```java
class Person {
    String name;
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Tom";
        modify(p);
        System.out.println("name = " + p.name); // 输出 name = Obltv
    }

    public static void modify(Person p1) {
	    p1.name = "Obltv";
        p1 = new Person();
        p1.name = "Jerry";
    }
}

```

再来看一个经典的例子
```java
public class Person {
    private String name;
   
}

public static void main(String[] args) {
    Person xiaoZhang = new Person("小张");
    Person xiaoLi = new Person("小李");
    swap(xiaoZhang, xiaoLi);
    System.out.println("xiaoZhang:" + xiaoZhang.getName());
    System.out.println("xiaoLi:" + xiaoLi.getName());
}

public static void swap(Person person1, Person person2) {
    Person temp = person1;
    person1 = person2;
    person2 = temp;
    System.out.println("person1:" + person1.getName());
    System.out.println("person2:" + person2.getName());
}

/*  
输出  
person1:小李  
person2:小张  
xiaoZhang:小张  
xiaoLi:小李  
 */

```

## 为什么Java这样设计
那么接下来是GPT的回答：

这是个非常好的问题—— **为什么 Java 选择“值传递”作为唯一的参数传递方式？为什么不能支持引用传递？**

其实，这和 Java 的设计哲学有关：**“简单、安全、可预测”。**

---

## ✅ 一、Java 采用值传递的目的

### 1️⃣ 简化语言复杂度

> 📌 只采用值传递，使得 Java 的方法参数传递模型**更一致、更简单**。

- 如果像 C++ 一样同时支持值传递和引用传递，**程序员需要明确每次是值还是引用**，容易混淆。

- Java 明确规定：**统一使用值传递**（包括对象引用的值），从语法到行为都很简洁。


---

### 2️⃣ 提高代码可读性和可维护性

> 📌 值传递的副本机制，能让程序的行为更容易“预测”。

- 开发者知道：**方法内改的是副本，主调函数不会受影响，除非显式操作对象内容。**

- 不像 C++ 或 JavaScript，可能因为传的是引用，结果主函数的变量就“悄悄”变了。


---

### 3️⃣ 增强安全性，防止“副作用”

> 📌 Java 的值传递可以**减少不小心修改外部变量的风险**。

- 你要改变外部对象，必须明确调用对象的方法或属性，不会不小心“传引用就改外部”。

- 这也让 Java 更符合它追求的「**不容易出错的语言设计**」目标。


---

## ✅ 二、Java 的传递模型，其实已经足够灵活

虽然它是“值传递”，但 Java 允许我们：

- 修改对象内部的字段（因为引用是共享的）；

- 使用包装对象（如数组、Holder）来“模拟”引用传递的效果；

- 用 `return` 返回对象或数据结构来更新值。


所以它并不“功能缺失”，只是：

> ⚠️ 不允许通过形参直接**改变调用者变量的引用指向**（即不能 swap(x, y) 就能换掉 x 和 y）。

---

## ✅ 三、类比其它语言

|语言|参数传递方式|支持引用传递？|特点说明|
|---|---|---|---|
|Java|值传递（包括引用的值）|❌ 不支持真正引用传递|安全、统一、简洁|
|C++|值传递 + 引用传递|✅ 支持|灵活但容易出错|
|Python|类似 Java 的“对象引用值传递”|❌ 变量不可通过 swap 改变|初学者也容易混淆|
|JavaScript|值传递，但对象是“共享引用”|❌ 不支持变量指向的改变|容易出现副作用|
|C|只支持值传递|✅ 通过指针模拟引用传递|很底层、手动管理内存|

---

## ✅ 四、总结

> 💡 **Java 的值传递不是落后，而是有意识的设计选择。**

- 保证代码行为的**清晰性、可控性、安全性**；

- 杜绝了很多由引用传递带来的“隐式副作用”；

- 需要“交换引用”时，程序员可以用数组或包装类显式完成，**不会让传参行为暗箱操作**。

