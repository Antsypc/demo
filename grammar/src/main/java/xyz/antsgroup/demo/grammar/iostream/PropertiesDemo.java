package xyz.antsgroup.demo.grammar.iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Properties
 * public class Properties extends Hashtable<Object,Object>
 * 所以很好理解和使用了,和 Hashtable 差不多,即 Map 类似.
 *
 * Created by Ants Young on 2016/7/19.
 */
public class PropertiesDemo {

    public static void main(String[] args) throws IOException {

        String filePath = PropertiesDemo.class.getResource("/").getPath() + "database.properties";

        /*
        初始值可以从 InputStream, Reader 读入, 也可 setProperties
         */
        Properties properties = new Properties();
        properties.load(new FileInputStream(filePath));

        /*
        添加
         */
        properties.setProperty("my", "value");

        /*
        输出
         */
        properties.list(System.out);

        /*
        遍历
         */
        System.out.println("------------");
        Enumeration enum1 = properties.propertyNames();
        while(enum1.hasMoreElements()) {
            String strKey = (String) enum1.nextElement();
            String strValue = properties.getProperty(strKey);
            System.out.println(strKey + "=" + strValue);
        }

        /*
        输出到文件
         */
        properties.store(new FileOutputStream(filePath), "add prop");
    }


}
