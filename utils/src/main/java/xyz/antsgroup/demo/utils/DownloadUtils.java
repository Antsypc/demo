package xyz.antsgroup.demo.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 */
public class DownloadUtils {

    /**
     * 客户端请求下载文件的文件在本地,直接传给客户端
     *
     * @param request 客户端请求
     * @param response 客户端响应
     * @param localFile 本地文件绝对路径
     * @throws IOException
     */
    public static void downloadFile(HttpServletRequest request, HttpServletResponse response, String localFile) throws IOException {
        String[] tmp = localFile.split("/");
        download(request, response, new FileInputStream(localFile), tmp[tmp.length - 1]);
    }


    /**
     * 客户端请求下载的文件在网络,并且客户端不能直接访问
     * 先下载下来再传给客户端
     *
     * @param request 客户端请求
     * @param response 客户端响应
     * @param url 文件对应 URL
     * @throws IOException
     */
    public static void downloadFile(HttpServletRequest request, HttpServletResponse response, URL url) throws IOException {
        URLConnection conn = url.openConnection();
        InputStream inputStream = conn.getInputStream();
        String[] tmp = url.getPath().split("/");
        download(request, response, inputStream, tmp[tmp.length - 1]);
    }

    /**
     * 客户端请求文件下载.
     * 从 input 流传给 HttpServletResponse 的 OutputStream
     * @param request 客户端请求
     * @param response 客户端相应
     * @param input 输入流
     * @param filename 返回给客户端的文件名
     * @throws IOException
     */
    private static void download(HttpServletRequest request, HttpServletResponse response, InputStream input,
                                 String filename) throws IOException {
        OutputStream output = response.getOutputStream();
        String agent = request.getHeader("User-Agent").toLowerCase();
        if (agent != null && agent.contains("msie")) {
            filename = java.net.URLEncoder.encode(filename, "UTF-8");
        } else {
            filename = new String(filename.getBytes("UTF-8"), "iso-8859-1");
        }
        response.setHeader("Content-Disposition","attachment;filename="+filename);
        byte[] data = new byte[2048];
        int len;
        while ((len = input.read(data)) > 0) {
            output.write(data, 0, len);
        }
        input.close();
        output.close();
    }

}
