package xyz.antsgroup.demo.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 *
 */
public class CSVUtils {


    /**
     * 针对http请求获得输出 .csv 文件的输出对象
     * @param response 客户端响应
     * @param request 客户端请求
     * @param filename 文件名
     * @return CSVPrinter 输出对象
     * @throws IOException
     */
    public static CSVPrinter newPrinter(HttpServletResponse response, HttpServletRequest request,
                                        String filename) throws IOException {
        CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator('\n');  // 每条记录间隔符
        CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(response.getOutputStream(),"GBK"), csvFormat);
        response.setCharacterEncoding("utf-8");
        response.reset();
        response.setContentType("application/csv;charset=utf-8");
        String agent = request.getHeader("User-Agent").toLowerCase();
        if (null != agent && agent.contains("msie")) {
            filename = new String(filename.getBytes(), "iso-8859-1");
        } else {
            filename = java.net.URLEncoder.encode(filename, "UTF-8");
        }
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        return csvPrinter;
    }

    /**
     * 向文件输出 .csv 格式的数据
     * @param file 文件对象
     * @return CSVPrinter 输出对象
     * @throws IOException
     */
    public static CSVPrinter newPrinter(File file) throws IOException {
        CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator('\n');
        CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(new FileOutputStream(file)), csvFormat);
        return csvPrinter;
    }

}
