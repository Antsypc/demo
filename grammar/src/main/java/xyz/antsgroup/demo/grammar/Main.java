package xyz.antsgroup.demo.grammar;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://docs.spring.io/spring/docs/current/spring-framework-reference/epub/spring-framework-reference.epub");
        URLConnection conn = url.openConnection();
        InputStream input = conn.getInputStream();
        OutputStream output = new FileOutputStream("D:/ypc-test-remote.fi");
        byte[] data = new byte[2048];
        int len;
        while ((len = input.read(data)) > 0) {
            output.write(data, 0, len);
        }
        input.close();
        output.close();
    }
}
