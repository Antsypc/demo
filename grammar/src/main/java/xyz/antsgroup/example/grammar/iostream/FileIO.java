package xyz.antsgroup.example.grammar.iostream;

import java.io.*;
import java.util.Scanner;

/**
 * 使用Java I/O 向文件读写数据的基本操作.
 *
 * 在java.io包下 InputStream,OutputStream,Reader,Writer 都是抽象类. java.util.Scanner 是一个读的类.
 * 一般情况下,字节流使用 BufferedInputStream, BufferedOutputStream;字符流使用 BufferedReader, Scanner, PrintWriter.
 *
 * @author ants_ypc
 * @version 1.0 3/7/16
 */
public class FileIO {
    private static final String FILENAME = "grammar/test.dat";

    public void writeData(String path, String info) {

        // 使用 FileOutputStream
        try (OutputStream fileOutputStream = new FileOutputStream(path /* , boolean append*/)) {
            byte[] infoByte = info.getBytes();
            fileOutputStream.write(infoByte);
            fileOutputStream.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 使用 BufferedOutputStream 嵌套,更利于网络不稳定的环境下的输出.
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path, true))) {
            byte[] infoByte = info.getBytes();
            outputStream.write(infoByte);
            outputStream.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 使用 DataOutputStream 输出数字数据.是以二进制格式输出,所以也只能以二进制方式读DataInputStream.
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(path, true))){
            byte[] infoByte = info.getBytes();
            outputStream.writeInt(3);           // 该方法的写数据方法并不能在文件中看到正确显示,他有自己的写入规则,
            outputStream.writeDouble(3.111);    // 用read方法读的时候可以看到正确的形式
            outputStream.write(infoByte);
            outputStream.writeUTF(info);        // 该方法写入的UTF数据会在头部加2byte数据,用readUTF方法可以正确显示
            outputStream.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 使用 FileWriter, OutputStreamWriter 同理.继承关系是 Writer -> OutputStreamWriter -> FileWriter
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            char[] infoByte = info.toCharArray();
            fileWriter.write(infoByte); // 注意 Writer 一类的流不能写 byte
            fileWriter.write("4" + info + "encoding=" + fileWriter.getEncoding() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 使用 PrintWriter,不使用 PrintStream,之所以还保留这个方法是为了兼容 System.out 这个.
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(path, true))/*, boolean append*/) {
            // 如果需要在文件后追加就必须使用上述构造方法,没有 PrintWriter(String filename, boolean append) 方法.
            printWriter.println(info);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData(String path) {
        // 预先写入数据到文件
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(path))) {
            printWriter.print("123abc3.1\nefg");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 使用 FileInputStream
        try (InputStream inputStream = new FileInputStream(path)) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);        // 由于是 Stream 所以只能读取字节流
            System.out.println(new String(bytes));

            // 最好使用下面的结构,如果网络不好可以不被阻塞
            /*int avi = inputStream.available();
            if (avi > 0) {
                byte[] bytes = new byte[inputStream.available()];
                inputStream.read(bytes);        // 由于是 Stream 所以只能读取字节流
                System.out.println(new String(bytes));
            }
            */
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 使用 BufferedInputStream
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(path))) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);        // 由于是 Stream 所以只能读取字节流
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 使用 DataInputStream
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(path))) {
            /*System.out.println(inputStream.readInt());
            System.out.println(inputStream.readUTF());
            System.out.println(inputStream.readDouble());
            byte[] tmp = new byte[1024];
            inputStream.read(tmp);
            System.out.println(new String(tmp));
            */
            // 以上被注释的方法读取数据是错误的, DataInputStream读取的数据必须是使用 DataOutputStream 写入的才能正确读出
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 使用 FileReader, OutputStreamReader 同理.继承关系是 Reader -> OutputStreamReader -> FileReader
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(path))) {
            char[] chars = new char[1024];
            reader.read(chars);
            System.out.print(chars);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 使用 BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            System.out.println("使用 BufferedReader:");
            char[] chars = new char[1024];
            reader.read(chars);
            System.out.println(chars);
//            reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 使用 Scanner.Scanner 功能丰富.
        try (Scanner in = new Scanner(new FileInputStream(path), "UTF-8")){
            System.out.println("使用 Scanner:");
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String info = "abcdefg";
        FileIO fileIO = new FileIO();

        // 以下两种方法一次只执行一个,注释另一个
        fileIO.writeData(FILENAME, info);
//        fileIO.readData(FILENAME);
    }
}
