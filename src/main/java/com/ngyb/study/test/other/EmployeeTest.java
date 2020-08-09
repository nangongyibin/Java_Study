package com.ngyb.study.test.other;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 09:48
 */
public class EmployeeTest {

    public static void main(String [] args){
        //使用构造器创建两个对象
        Employee empOne = new Employee("RUNOOB1");
        Employee empTwo = new Employee("RUNOOB2");
        //调用者两个对象的成员方法
        empOne.empAge(26);
        empOne.empDesignation("高级程序猿");
        empOne.empSalary(6);
        empOne.printEmployee();

        empOne.empAge(21);
        empOne.empDesignation("菜鸟程序猿");
        empOne.empSalary(3);
        empOne.printEmployee();
    }
}
