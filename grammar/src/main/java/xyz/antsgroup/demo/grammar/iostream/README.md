Java I/O 阅读顺序及说明
================
以`Stream`结尾的类是对字节进行处理的，以`Reader`,`Writer`结尾的是对字符进行处理的。

## 输出流
java.io.OutputStream

1. 该对象write()是有网络开销的，所以有多次较少字节write()时。将它们转化成byte类型，存入一个数组中，然后一次性write()该数组将提高效率。
2. 输出会先放在缓冲，缓冲区达到一定量才会真的输出，所以为了防止死锁，要做必要的flush()操作。
3. 带资源的try()语句能自动关闭流，但是这些流必须实现了`Closeable`接口。特别注意，如果该流来自网络连接，关闭流后该网络连接也将关闭。 

## 输入流
java.io.InputStream

    public abstract int read() throws IOException  //返回0-255，错误则返回-1；
    public int read(byte[] input) throws IOException  
    public int read(byte[] input,int offset,int length) throws IOException  //从offset读length个字节到input

由于在网络情况下读取流可能堵塞，采用下方法：

    int bytesRead = 0;
    int bytesToRead = 1024;
    byte[] input = new byte[bytesToRead];
    while(bytesRead < bytesToRead) {
        int result = in.read(input, bytesRead, bytesToRead - bytesRead);    
        if(result == -1) break;
        bytesRead += result;
    }

InputStream类还可以对流进行标记，方便以后重新读取：

    public void mark(int readAheadLimit)
    public void reset() throws IOException
    public boolean markSupported()

两点需要注意：
1. 由于输入输出开销比较大，所以建议采用Buffered流，并且将I/O操作放在一个单独的线程；
2. `InputStream`,`OutputStream`都是对字节进行读取，包括其子类。所以有了对字符进行操作的`Writer`和`Reader`类及其子类。

## Writer
java.io.OutputStream的映射，和其类似，Writer类从不直接使用，通过其子类以多态方式使用。使用方式和其也类似。
其重要子类OutputStreamWriter，可指定编码方式进行读写。

    public OutputStreamWriter(OutputStream out, String encoding) throws UnsupportedEncodingException
    public String getEncoding();

## Reader
和上面类似，是java.io.InputStream的映射，和其类似，Reader类从不直接使用，通过其子类以多态方式使用。
其重要子类InputStreamReader，可指定编码方式进行读写。
也一样有InputStream的各种基本方法。


## 缓冲流

    BufferedInputStream//默认构造方法缓冲区为2048
    BufferedOutputStream//默认构造方法缓冲区为512
    以上两个都有指定缓冲区大小的构造方法(OutputStream out ,int buffersize)

和读字节的几个缓冲流类似，读字符的缓冲流：

    public BufferedReader(Reader in, int bufferSize)
    public BufferedWriter(Writer out, int bufferSize)
    
默认构造方法缓冲区大小是8192字节。
这两个类有读写行的方法：`readLine()`,`newLine()`.

## 过滤器
两个版本：过滤器流；`Reader`&`Writer`；
过滤器串链在一起使用时，约定从最后一个过滤器读取数据。

## PrintWriter代替PrintStream
    public PrintStream(OutputStream out)
    public PrintStream(OutputSream out, boolean autoFlush)
    
可直接使用print()，但是有三个严重问题：
1. 由于各平台换行符不一致。UNIX是`\n`,Mac是`\r`,windows是回车换行对`\r\n`.
2. PrintStream假定使用所在平台的默认编码方式。
3. 其提供的异常不足。

`PrintWriter`对字符集能自动转换，但是仍然不推荐使用。

## 数据流
`DataInputStream`
`DataOutputStream`
能读写java基本类型和字符串,但是他们都是字节流,如果写入到文件是不可读的.主要用于Java内部,如对象序列化等。