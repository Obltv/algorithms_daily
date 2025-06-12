# 静态变量

## 特点
- 被该类的所有对象共享
- 不属于对象，属于类
- 优先于对象存在，随着类的加载而加载

## 调用方式
- 类名调用
- 对象名调用（不推荐）


# 静态方法
## 没有this关键字
```java
public class Student {  
    private String name;  
    private int age;  
    private String teacherName;  
  
    public void show(Student this) {  
        System.out.println(this);  
    }  
}


public class StudentTest {  
    public static void main(String[] args) {  
        Student s1 = new Student();  
        Student s2 = new Student();  
  
        System.out.println("s1:" + s1);  
        System.out.println("s2:" + s2);  
        s1.show();  
        s2.show();  
    }  
}

/*  
s1:Student@6acbcfc0  
s2:Student@5b480cf9  
Student@6acbcfc0  
Student@5b480cf9  
 */
```


# 一些问题

## 1. 如果类只有静态的方法，你可以将构造函数标记为private的以避免被初始化是什么意思



这句话的意思是：

> **如果一个类中只包含静态方法（没有实例方法和属性），你可以将它的构造函数设置为 `private`，这样就可以防止这个类被外部代码创建实例。**

---

### 为什么要这样做？

当一个类 **只用来提供工具方法（通常是`static`静态方法）**，例如 `Math` 类，**创建它的实例是没有意义的**，因为你根本不需要访问类的属性或者调用对象上的方法。

比如：

```java
public class MyUtils {
    public static int add(int a, int b) {
        return a + b;
    }
}
```

上面这个类只是提供了一个加法工具方法，**不需要创建 `MyUtils` 的对象**来使用。

但是，如果你不写构造函数，Java 默认会生成一个 **公有的无参构造函数**，别人就可以这样用：

```java
MyUtils utils = new MyUtils(); // 这是没必要的
```

所以，为了防止这种用法，你可以 **自己声明一个私有的构造函数**：

```java
public class MyUtils {
    private MyUtils() {
        // 私有构造函数，防止实例化
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
```

这样，别人再想创建对象时：

```java
MyUtils utils = new MyUtils(); // 编译报错：构造函数不可访问
```

---

### 总结一句话：

当类是工具类（只包含静态方法）时，加上 `private` 构造函数可以防止别人不小心或错误地创建实例，体现“这个类只是工具，不该被实例化”的设计意图。



## 2. 静态方法不能存取非静态的方法是为什么?

这是 Java 的一个基本规则，我们来一步一步解释：

---

### 🔹结论：

**静态方法不能直接访问非静态方法或成员变量**，因为静态方法在**没有对象的情况下**就可以被调用，而非静态方法属于对象。

---

### 🔸先看个例子：

```java
public class Demo {
    int age = 18;

    public void sayHello() {
        System.out.println("Hello");
    }

    public static void test() {
        // System.out.println(age); // ❌ 错误：静态方法不能访问非静态成员
        // sayHello();              // ❌ 错误：静态方法不能直接调用非静态方法
    }
}
```

`test()` 是静态方法，它**不能访问** `age` 和 `sayHello()`。

---

### 🔹为什么会这样？

#### ✅静态成员：

- 属于 **类本身**。

- 不需要创建对象，就能通过 `类名.方法名()` 访问。


#### ❌非静态成员（实例成员）：

- 属于 **对象**。

- 必须创建对象，才能使用这些成员。


---

### 🔸通俗解释：

想象一个“班级类”：

```java
class ClassRoom {
    int studentCount = 30; // 非静态，属于每一个具体的班级对象
    static String schoolName = "Obltv's School"; // 静态，属于所有班级共享
}
```

- `schoolName` 是所有班级共享的静态属性，和具体哪个班级无关。

- `studentCount` 是每个班级对象特有的，必须先有对象（一个班级），才能知道人数。


---

### ✅那如果一定要在静态方法中用非静态成员呢？

可以手动创建一个对象：

```java
public static void test() {
    Demo d = new Demo();
    System.out.println(d.age); // ✅ 正确
    d.sayHello();              // ✅ 正确
}
```

---

### 🔹总结一句话：

> **静态方法属于类，而非静态成员属于对象。** 在没有对象的前提下，类级别的静态方法是无法访问具体对象的成员的。

如果你还想了解反过来：**非静态方法可以访问静态成员吗？** 也是可以的，我可以顺便给你解释。



## 3.《Head First》上的一些问题

### 🧠 题目要求：

根据你所学的 `static` 和 `final` 知识，判断下面六段 Java 代码中**哪些是合法的（可以编译通过）？**

---

### ✅ 题解（强化版）

---

### ❓问题 1：以下代码是否合法？

```java
public class Foo1 {
    static int x;

    public void go() {
        System.out.println(x);
    }
}
```

🔍**分析**：`x` 是 `static`，是属于类的变量，而 `go()` 是实例方法，实例方法访问类变量是合法的。

✅**结果**：合法 ✅

---

### ❓问题 2：

```java
public class Foo2 {
    int x;

    public static void go() {
        System.out.println(x);
    }
}
```

🔍**分析**：`x` 是实例变量，但 `go()` 是静态方法，**静态方法不能访问非静态成员变量**，因为没有 `this`。

❌**结果**：不合法 ❌（编译错误）

---

### ❓问题 3：

```java
public class Foo3 {
    final int x;

    public void go() {
        System.out.println(x);
    }
}
```

🔍**分析**：`x` 是 `final` 实例变量，**但没有初始化**，又在 `go()` 方法中被访问，会报“变量未初始化”的错误。

final 必须要显式的初始化一次
❌**结果**：不合法 ❌

---

### ❓问题 4：

```java
public class Foo4 {
    static final int x = 12;

    public void go() {
        System.out.println(x);
    }
}
```

🔍**分析**：`x` 是 `static final` 常量，已经初始化，访问合法。

✅**结果**：合法 ✅

---

### ❓问题 5：

```java
public class Foo5 {
    static final int x = 12;

    public void go(final int x) {
        System.out.println(x);
    }
}
```

🔍**分析**：方法的参数名也叫 `x`，虽然和类变量重名，但它会**隐藏**类变量中的 `x`，访问的是参数，也没问题。

✅**结果**：合法 ✅

---

### ❓问题 6：

```java
public class Foo6 {
    int x = 12;

    public static void go(final int x) {
        System.out.println(x);
    }
}
```

🔍**分析**：方法参数 `x` 与成员变量同名，但 `go()` 是静态方法，不能访问非静态成员 `x`，这里打印的是参数 x，合法。

✅**结果**：合法 ✅

---

### ✅ 最终结果总结：

|代码段|是否合法|原因简述|
|---|---|---|
|Foo1|✅ 合法|实例方法访问静态变量|
|Foo2|❌ 不合法|静态方法不能访问实例变量|
|Foo3|❌ 不合法|final 实例变量未初始化|
|Foo4|✅ 合法|static final 常量已初始化|
|Foo5|✅ 合法|方法参数隐藏类变量 x|
|Foo6|✅ 合法|打印的是参数 x，不涉及成员变量|

## 4.为什么Java设计时不直接强制用类名调用静态变量和方法，而是也可以用对象名，这样不是不好吗？

看看GPT的回答

这个问题问得特别好，你这已经是在站在语言设计的高度思考 Java 的“规范性”与“灵活性”之间的取舍了，确实是一个值得深思的问题。

我们来深入聊聊：**为什么 Java 没强制只能用类名调用静态变量和方法，而也允许用对象名调用？**

---

### 🌟 一、现象回顾

```java
public class Student {
    public static int count = 0;

    public static void printCount() {
        System.out.println("Count = " + count);
    }
}
```

### 这两种都是合法的：

```java
Student.printCount();   // 推荐做法 ✔️
new Student().printCount(); // 合法，但不推荐 ❌
```

---

### 🧠 二、为什么 Java 允许通过对象名调用静态方法？

### ✅ 1. **简化语法 & 向下兼容**

- Java 是一门面向对象语言，但也力图让初学者容易入门。

- Java 没像 C++ 一样用复杂的语法限制行为（比如 `::` 运算符），很多地方做了**宽松处理**。

- 早期 Java 就允许这种写法，后来如果突然禁止，会造成**大量老项目不兼容**。


---

### ✅ 2. **统一语法模型**

Java 的方法调用语法是：

```java
reference.method()
```

- 不论 `method` 是实例方法还是静态方法，这种形式都统一。

- 语法分析器可以更容易处理调用表达式，无需复杂区分。


---

### ✅ 3. **允许在对象上下文中访问静态资源**

有些工具类、第三方框架，确实会把静态方法“挂”在对象中方便使用，比如：

```java
logger.debug("Message"); // logger 是对象，但 debug 可能是静态的
```

虽然不是推荐，但在一些语法糖中很方便。

---

### ❌ 4. 但确实存在 **误导性**

- 对静态方法用对象调用，会**误导初学者**以为这个方法是跟对象状态有关的，其实完全没关系。

- 对静态变量用对象访问，也会让人以为每个对象一份，实际上是一份共享。


---

### ✅ 三、Java 的解决方案：**允许，但发出警告**

虽然语法上允许，但：

- 编译器（如 IDEA、javac）会发出 warning：

  > "Static method should be accessed in a static way"

- 专业开发者或团队通常会启用这些 **静态分析规则**，比如 CheckStyle、SonarLint、IDEA 检查等。


---

### 💡 四、为什么不强制？

> 如果 Java 彻底禁止对象名访问静态方法，那很多现有代码会“炸锅”，兼容性问题太大。

Java 的哲学是：**"尽量不破坏已有代码"**，所以它选择：

- **允许你这么写**

- **但提示你这么写不好**


---

### 🏁 总结

|项目|是否允许|原因|
|---|---|---|
|用类名调用静态方法|✅ 推荐|明确、规范、效率高|
|用对象名调用静态方法|✅ 不推荐|允许是为了语法统一、兼容旧代码|
|编译器警告|✅|引导开发者写更清晰的代码|

---

### ✍️ 建议你记住的口诀：

> **静态归类不归对象，访问最好用类名。**

---

如果你未来会写代码规范文档或者带项目组，可以明确规定“禁止用对象名访问静态成员”，这是一种工程上的“约束设计”，Java 本身就给你了自由和选择。


# Main方法
```java
public class Test {  
    public static void main(String[] args) {  
        System.out.println(args.length);  
  
        for (int i = 0; i < args.length; i++) {  
            System.out.println(args[i]);  
        }  
    }  
}
// 0
```