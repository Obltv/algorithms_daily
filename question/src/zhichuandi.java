public class zhichuandi {
//    public static void main(String[] args) {
//        int a = 10;
//        int b = 20;
//        swap(a, b);
//        System.out.println(a);
//        System.out.println(b);
//
//        /*
//        输出：
//        10
//        20
//         */
//
//    }
//
//    static void swap(int num1, int num2) {
//        int temp = num1;
//        num1 = num2;
//        num2 = temp;
//    }

//    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 4, 5};
//
//        //输出1
//        System.out.println(arr[0]);
//        change(arr);
//        //输出100
//        System.out.println(arr[0]);
//    }
//
//    static void change(int[] arr){
//        arr[0]=100;
//    }

//    public static class Person {
//        private String name;
//
//        public Person(String name) {
//            this.name = name;
//        }
//
//        public String getName() {
//            return name;
//        }
//    }
//
//    public static void main(String[] args) {
//        Person xiaoZhang = new Person("小张");
//        Person xiaoLi = new Person("小李");
//        swap(xiaoZhang, xiaoLi);
//        System.out.println("xiaoZhang:" + xiaoZhang.getName());
//        System.out.println("xiaoLi:" + xiaoLi.getName());
//    }
//
//    public static void swap(Person person1, Person person2) {
//        Person temp = person1;
//        person1 = person2;
//        person2 = temp;
//        System.out.println("person1:" + person1.getName());
//        System.out.println("person2:" + person2.getName());
//    }


    /*
    输出
    person1:小李
    person2:小张
    xiaoZhang:小张
    xiaoLi:小李
     */


    static class Person {
        String name;

        public Person() {
        }

        public Person(String name) {
            this.name = name;
        }

        /**
         * 获取
         *
         * @return name
         */
        public String getName() {
            return name;
        }

        /**
         * 设置
         *
         * @param name
         */
        public void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return "Person{name = " + name + "}";
        }
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Tom";
        modify(p);
        System.out.println("name = " + p.name); // 输出 name = Tom
    }

    public static void modify(Person p1) {
        p1.name = "Obltv";
        p1 = new Person();
        p1.name = "Jerry";
    }


}
