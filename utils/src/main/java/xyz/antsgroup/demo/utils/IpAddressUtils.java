package xyz.antsgroup.demo.utils;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * IP 地址工具类
 */
public class IpAddressUtils {

    /**
     * 根据点分十进制的IP地址,获取该IP所在地理位置
     *
     * @param ip 点分十进制的IP地址,如:56.48.231.5
     * @return 地理位置
     */
    public static String getLocationByIp(String ip) {
        try {
            URLConnection connection = new URL("http://ip138.com/ips138.asp?ip=" + ip + "&action=2").openConnection();
            connection.setConnectTimeout(3000);
            connection.connect();

            Scanner cin = new Scanner(connection.getInputStream(), "gbk");
            String line = "";
            while (cin.hasNextLine()) {
                line = cin.nextLine();
                if (line.contains("<ul class=\"ul1\"><li>")) {
                    String[] tmp = line.split("li>")[1].split("：|\\s");
                    line = tmp[1];
                    break;
                }
            }
            return line;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
