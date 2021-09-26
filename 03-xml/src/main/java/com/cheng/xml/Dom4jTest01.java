package com.cheng.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jTest01 {

    /*
     * 得到某个具体的节点内容：第三本书的书名--> java之道
     */
    @Test
    public void test1() throws DocumentException {
        //创建一个xml解析对象
        SAXReader reader = new SAXReader();
        //把xml文档加载到document对象中
        Document document = reader.read("src/book.xml");
        //获取根节点
        Element root = document.getRootElement();
        //获取当前节点的所有子节点
        List list = root.elements();
        Element thirdBook = (Element)list.get(2);
        String name = thirdBook.element("name").getText();
        System.out.println(name);
    }

    /*
     * 遍历所有元素节点
     */
    @Test
    public void test2() throws DocumentException{
        //创建一个xml解析对象
        SAXReader reader = new SAXReader();
        //把xml文档加载到document对象中
        Document document = reader.read("src/book.xml");
        //获取根节点
        Element root = document.getRootElement();
        treeSelect(root);
    }

    //递归
    private void treeSelect(Element ele){
        //输出当前节点的名字
        System.out.println(ele.getName());
        for(int i=0; i<ele.nodeCount(); i++){
            //取出下标为i的节点
            Node node = ele.node(i);
            //判断当前节点是否为标签
            if(node instanceof Element){
                treeSelect((Element)node);
            }else{
                System.out.println(node.getText());
            }
        }
    }
}
