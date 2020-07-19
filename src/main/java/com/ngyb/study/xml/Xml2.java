package com.ngyb.study.xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/19 20:12
 */
public class Xml2 {

    public static void main(String[] args) throws XmlPullParserException, IOException {
        List<Book> lists = null;
        Book book = null;
        XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
        XmlPullParser pp = xppf.newPullParser();
        pp.setInput(new FileInputStream("bookstore.xml"), "utf-8");
        int eventType = pp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    if ("bookstore".equals(pp.getName())) {
                        lists = new ArrayList<>();
                        System.out.println(1);
                    } else if ("book".equals(pp.getName())) {
                        book = new Book();
                        System.out.println(2);
                    } else if ("name".equals(pp.getName())) {
                        book.setName(pp.nextText());
                        System.out.println(3);
                    } else if ("price".equals(pp.getName())) {
                        book.setPrice(pp.nextText());
                        System.out.println(4);
                    }
                    break;
                case XmlPullParser.END_TAG:
                    System.out.println(5);
                    if ("book".equals(pp.getName())) {
                        lists.add(book);
                    }
                    break;
            }
            eventType = pp.next();
        }
        for (Book book2 : lists) {
            System.out.println(book2.toString());
        }
    }
}
