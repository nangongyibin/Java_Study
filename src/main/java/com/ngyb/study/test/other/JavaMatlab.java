package com.ngyb.study.test.other;

import com.mathworks.toolbox.javabuilder.MWNumericArray;
import matlab.matlab;

/**
 * 作者：南宫燚滨
 * 描述：需要在安装matlab的环境中运行 无mclmcrrt9_0_1.dll
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/8/9 10:20
 */
public class JavaMatlab {

    public static void main(String[] args) {
        System.out.println(1);
        //java调动MATLAB方法
        // matlab方法为[sum,m] = add[a,b]
        //java中方法为matlab实例的方法matlab.add(int,object...),返回值为object[]
        //其中输入的int为输出的个数，object...为输入参数，返回值object[]为输出的集合
        matlab matlab;//定义matlab类型
        try {
            matlab = new matlab();//实例化方法集合
            int[][] a = new int[][]{{1, 0}, {0, 1}};//定义输入参数
            int[][] b = new int[][]{{3, 2}, {1, 4}};//定义输入参数
            Object[] rs = matlab.add(2, a, b);//调用方法1，方法1中调用方法2
            System.out.println("输入结果1：");
            System.out.println(rs[0]);
            MWNumericArray is = (MWNumericArray) rs[0];//转为matlab格式矩阵
            System.out.println("输出第2行第2列数值：");
            System.out.println(is.getInt(new int[]{2, 2}));
            System.out.println("输出结果2：");
            System.out.println(rs[1]);
            System.out.println("输出调用方法2的结果：");
            System.out.println(matlab.ims(1, 12, 5)[0]);//调用方法2
        } catch (com.mathworks.toolbox.javabuilder.MWException e) {
            e.printStackTrace();
        }
    }
}
