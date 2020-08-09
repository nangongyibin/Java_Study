package com.ngyb.study.test.other;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 15:04
 */
public class Puppy {
    int puppyAge;//这里设置int型是因为年龄是整数2

    public Puppy() {
    }

    public Puppy(String name) {
        // 这个构造器仅有一个参数：name
        System.out.println("小狗的名字是 : " + name);
    }

    public void setAge(int age) {
        puppyAge = age;
    }

    //这里是void是返回值，就是不需要返回类型，后面不要跟return+类型值，也可以只写一个return；
    public int getAge() {
        System.out.println("小狗的年龄为 : " + puppyAge);
        return puppyAge;
    }

    //这里要注意，因为方法上面谢了int返回类型，就必须写return后面跟相应的类型值
    public static void main(String[] args) {
        /* 创建对象 */
        Puppy myPuppy = new Puppy("tommy");
        /* 通过方法来设定age */
        myPuppy.setAge(2);
        /* 调用另一个方法获取age */
        myPuppy.getAge();
        /*你也可以像下面这样访问成员变量 */
        System.out.println("变量值 : " + myPuppy.puppyAge);
    }
}
