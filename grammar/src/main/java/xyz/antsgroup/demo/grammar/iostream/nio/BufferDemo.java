package xyz.antsgroup.demo.grammar.iostream.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.FloatBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

/**
 * @author antsyoung@qq.com
 * @version 1.0 2016-12-10
 */
public class BufferDemo {

    public static void main(String[] args) throws FileNotFoundException {
        FloatBuffer buffer = FloatBuffer.allocate(10);

        for (int i = 0; i < 10; i++) {
            buffer.put((float)(i + 0.2));
        }

        buffer.flip();
        while (buffer.hasRemaining()) {
            float f = buffer.get();
            System.out.println( f );
        }

        FileChannel fc = new FileInputStream("").getChannel();
        
    }
}
