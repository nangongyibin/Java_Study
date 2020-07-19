package com.ngyb.study.xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 20:03
 */
public class Xml1 {

    public static void main(String[] args) {
        try {
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser pullParser = xmlPullParserFactory.newPullParser();
            pullParser.setInput(new FileInputStream("bookstore.xml"), "utf-8");
            int eventType = pullParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if ("name".equals(pullParser.getName())) {
                    String name = pullParser.nextText();
                    System.out.println("name:" + name);
                } else if ("price".equals(pullParser.getName())) {
                    String price = pullParser.nextText();
                    System.out.println("price:" + price);
                }
                eventType = pullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
