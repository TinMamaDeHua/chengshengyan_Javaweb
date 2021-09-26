package com.cheng.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class XpathTest01 {
    @Test
    public void test1() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/book.xml");

        Node node1 = document.selectSingleNode("/books/book[1]/name");
        System.out.println(node1.getText());

//        Node node2 = document.selectSingleNode("/books/book[4]/name");
//        System.out.println(node2.getText());
//
//        Node node3 = document.selectSingleNode("books/book/attribute::id");
//        System.out.println(node3.getText());
//
//        Node node4 = document.selectSingleNode("books/book[3]/attribute::id");
//        System.out.println(node4.getText());
    }
}
