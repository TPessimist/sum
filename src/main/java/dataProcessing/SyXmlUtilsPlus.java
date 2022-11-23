package dataProcessing;


import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import java.util.*;

public class SyXmlUtilsPlus {
    /**
     *
     * @param xml xml字符串
     * @return List<Map < String, String>>
     * @throws DocumentException
     * @author 沈宇
     * @version 1.0
     */

    public static List<Map<String, String>> killXmlPlus(String xml) throws Exception {
        try {
            //结果list
            List<Map<String, String>> resultList = new ArrayList();
            //创建xml text流为document
            org.dom4j.Document outdocument = DocumentHelper.parseText(xml);
            //获取根节点，即最外层节点
            org.dom4j.Element rootelement = outdocument.getRootElement();
            //获取子节点
            List<org.dom4j.Element> list = rootelement.elements();
            //取节点的方法
            resultList = digToTheEnd(rootelement.getName(), list);
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反正是拿到对的数据了。支持深层节点名称为相同的xml
     */
    public static List<Map<String, String>> digToTheEnd(String rootNodeName, List<org.dom4j.Element> list) {
        List<Map<String, String>> resultList = new ArrayList<>();
        //nodeName用于记录当前节点的名称格式为rootNode.node1.node2...
        String nodeName = rootNodeName;
        //遍历根节点下所有节点
        for (org.dom4j.Element e : list) {
            //用于记录
            int i = 0;
            //若有子节点内部节点数量大于2
            if (e.elements().size() >= 2) {
                List<org.dom4j.Element> eToList = e.elements();
                //遍历判断是否为最深层节点
                for (org.dom4j.Element eTo : eToList) {
                    //判断内层是否还有多数节点,如果没了即eTo元素个数小于等于1，说明eTo就是深层节点
                    if (eTo.elements().size() <= 1) {
                        //添加深层节点至resuleList中
                        Map<String, String> map = new HashMap<>();
                        map.put(nodeName + "." + e.getName() + i + "." + eTo.getName(), eTo.getTextTrim());
                        resultList.add(map);
                    } else {
                        //如果还有那就继续挖这个节点，并传入当前节点的名称
                        resultList.addAll(digToTheEnd(nodeName + "." + e.getName() + "." + eTo.getName() +i, eTo.elements()));
                    }
                    //下标更新
                    i+=1;
                }
            } else {

                //普通节点直接加入resultList中
                Map<String, String> map = new HashMap<>();
                map.put(nodeName + "." + e.getName(), e.getTextTrim());
                resultList.add(map);
            }
        }
        return resultList;
    }
}

