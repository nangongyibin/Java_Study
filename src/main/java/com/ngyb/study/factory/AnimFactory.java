package com.ngyb.study.factory;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 16:17
 */
public class AnimFactory {

    private  AnimFactory() {
    }

    public static Anim getAnim(String type){
        if (type.equals("dog")){
            return new Dog();
        }else if (type.equals("cat")){
            return new Cat();
        }else{
            return null;
        }
    }
}
