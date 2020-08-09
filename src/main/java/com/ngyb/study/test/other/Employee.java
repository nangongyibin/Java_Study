package com.ngyb.study.test.other;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 09:39
 */
public class Employee {
    public String name;//这个实例变量对子类可见
    int age;
    String designation;
    private double salary;//私有变量，仅对该类可见
    public static double salary_two;
    public static final String DEPARTMENT = "开发人员";

    /**
     * Employee类的构造器
     *
     * @param name
     */
    public Employee(String name) {
        this.name = name;
    }

    /**
     * 设置age的值
     *
     * @param empAge
     */
    public void empAge(int empAge) {
        age = empAge;
    }

    /**
     * 设置designation的值
     *
     * @param empDesig
     */
    public void empDesignation(String empDesig) {
        designation = empDesig;
    }

    /**
     * 设置salary值
     *
     * @param empSalary
     */
    public void empSalary(double empSalary) {
        salary = empSalary;
    }

    public void printEmployee() {
        System.out.println("姓名:" + name);
        System.out.println("年龄:" + age);
        System.out.println("职位:" + designation);
        System.out.println("薪水:" + salary);
    }

    public static void main(String[] args) {
        Employee employee = new Employee("RUNOOB");
        employee.empSalary(1000);
        employee.printEmployee();
        System.out.println();
        salary_two = 10000;
        System.out.println(DEPARTMENT + "平均工资：" + salary_two);
    }
}
