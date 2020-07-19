package com.ngyb.study.enumtest;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 13:07
 */
public enum TrafficLight {
    RED{
        @Override
        public TrafficLight nextTrafficLight() {
            return GREEN;
        }
    },
    GREEN{
        @Override
        public TrafficLight nextTrafficLight() {
            return BLUE;
        }
    },
    BLUE{
        @Override
        public TrafficLight nextTrafficLight() {
            return RED;
        }
    };
    public abstract TrafficLight nextTrafficLight();
}
