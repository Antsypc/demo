package xyz.antsgroup.example.grammar.xml.dom;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * 使用 java api 中 DOM 解析方法读取 xml 文档.
 *
 * Node 接口是整个 XML 文档解析对象的接口,所有的元素都可以是一个 Node.
 * ELement 表示一个不能再小的具体元素,如<a>d</a>.
 *
 * @author ants_ypc
 * @version 1.0 3/11/16
 */
public class XmlParse {

    /**
     *
     * 运行输出结果:
     * root node name:Server
     * the length of children under root node:11
     * the number of 'logger' node under root node:3
     *
     * xml文件根节点的直接子节点和属性:
     * Logger属性:
     * name=tc_log verbosityLevel=INFORMATION
     * Logger属性:
     * name=servlet_log path=logs/servlet.log
     * Logger属性:
     * name=JASPER_LOG path=logs/jasper.log verbosityLevel=INFORMATION
     * ContextManager属性:
     * debug=0 showDebugInfo=true workDir=work
     * MyNode属性:
     *
     *
     * 获取MyNode中的值
     * TextContent:aa中文mynode
     * firstChild nodeValue:null
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{

        // 获取 server.xml 对应的 Document 对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(XmlParse.class.getResourceAsStream("/server.xml"));

        Node root = document.getDocumentElement();
        System.out.println("root node name:" + root.getNodeName());

        NodeList children = root.getChildNodes();
        NodeList loggerList = document.getElementsByTagName("Logger");
        System.out.println("the length of children under root node:" + children.getLength());        // 解析时把每两个元素间的空格也算上了
        System.out.println("the number of 'logger' node under root node:" + loggerList.getLength()); // 但是该方法不会把Text节点(server.xml中标签元素中)算入

        // 获取根节点的子节点
        System.out.println("\nxml文件根节点的直接子节点和属性:");
        int i = 0;
        while (i < children.getLength()) {
            // 获取每个子节点
            Node child = children.item(i++);
            if (child instanceof Element) { // if(child.getNodeType() == Node.ELEMENT_NODE)
                Element childElement = (Element) child;
                // 获取节点指定属性值,必须通过 Element 对象获取, Node 对象没有相应方法
                childElement.getAttribute("name");

                // 获取节点的所有属性
                NamedNodeMap attributes = childElement.getAttributes();
                System.out.println(childElement.getTagName() + "属性:");
                for (int j = 0; j < attributes.getLength(); ++j) {
                    Node attrNode = attributes.item(j);
                    System.out.print(attrNode.getNodeName() + "="+attrNode.getNodeValue() + " ");
                }
                System.out.println();
            }
        }

        System.out.println("\n获取MyNode中的值");
        NodeList myNodes = document.getElementsByTagName("MyNode");
        for (int j = 0; j < myNodes.getLength(); ++j) {
            Node child = myNodes.item(j);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("TextContent:"+child.getTextContent());  // 获取其本身及孩子节点的 Text
                System.out.println("firstChild nodeValue:"+child.getFirstChild().getNodeValue());
            }
        }

    }
}
