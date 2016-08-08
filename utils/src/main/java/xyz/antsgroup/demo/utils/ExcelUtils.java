package xyz.antsgroup.demo.utils;

import jxl.Workbook;
import jxl.write.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel 表格操作
 * 1. 构造 ExcelUtils.
 * 2. 添加 sheet: addSheet(String sheetName, int index).一个 sheet 最多65535行,更多行需要放入另一个 sheet.
 * 3. 往指定 sheet 添加头部(粗体): setHeaders(List<String> headers, int sheetNum).
 * 4. 向指定 sheet 的尾部追加任意行: appendLines(List<List<String>> bodyList, int sheetNum).
 * 5. 输出: write
 * <p>
 * 注:
 * 头部默认字体是(Times New Roman, 13号, 粗体), 正文默认字体是(Arial, 10号, 不加粗).
 * 单元格格式为常规.
 */
public class ExcelUtils {

    private WritableWorkbook book;

    private List<WritableSheet> sheetList = new ArrayList<WritableSheet>();

    public ExcelUtils(HttpServletRequest request, HttpServletResponse response, String filename) throws IOException {
        this.book = Workbook.createWorkbook(response.getOutputStream());
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/msexcel;charset=utf-8");
        String agent = request.getHeader("User-Agent");
        if (null !=agent) {
            agent = agent.toLowerCase();
            if (agent.contains("firefox")) {
                filename = new String(filename.getBytes(),"iso8859-1");
            } else {
                filename = java.net.URLEncoder.encode(filename,"UTF-8");
            }
        }
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
    }

    public ExcelUtils(File file) throws IOException {
        this.book = Workbook.createWorkbook(file);
    }

    /**
     * 添加 sheet
     *
     * @param sheetName sheet名字
     * @param index     sheet索引从0开始
     */
    public void addSheet(String sheetName, int index) {
        sheetList.add(book.createSheet(sheetName, index));
    }

    /**
     * 向指定 sheet 第一行添加粗体信息
     *
     * @param headers    头部 List
     * @param sheetIndex sheet 索引
     * @throws WriteException
     */
    public void setHeaders(List<String> headers, int sheetIndex) throws WriteException {
        WritableFont headFont = new WritableFont(WritableFont.TIMES, 13, WritableFont.BOLD, false);
        WritableCellFormat cellFormat = new WritableCellFormat(headFont);

        WritableSheet sheet = sheetList.get(sheetIndex);
        for (int i = 0, len = headers.size(); i < len; ++i) {
            // Label(列,行,格式)
            sheet.addCell(new Label(i, 0, headers.get(i), cellFormat));
        }
    }

    /**
     * 向指定 sheet 追加一行
     *
     * @param list       一行数据 List String
     * @param sheetIndex sheet索引
     * @throws WriteException
     */
    public void appendLine(List<String> list, int sheetIndex) throws WriteException {
        if (list.isEmpty()) {
            return;
        }
        WritableSheet sheet = sheetList.get(sheetIndex);
        int line = sheet.getRows();
        for (int j = 0, len = list.size(); j < len; j++) {
            sheet.addCell(new Label(j, line, list.get(j)));
        }

    }

    /**
     * 向指定 sheet 追加任意行
     *
     * @param bodyList   需要添加的信息 List<List<String>>
     * @param sheetIndex sheet索引
     * @throws WriteException
     */
    public void appendLines(List<List<String>> bodyList, int sheetIndex) throws WriteException {
        WritableSheet sheet = sheetList.get(sheetIndex);
        int line = sheet.getRows();
        for (List<String> list : bodyList) {
            for (int j = 0, len = list.size(); j < len; j++) {
                sheet.addCell(new Label(j, line, list.get(j)));
            }
            line++;
        }
    }

    /**
     * 向指定 sheet 追加任意行
     * 将每个 Object 的 getter 返回数据依次插入到一行.
     * 可能表格头部和正文不能一一对应,这需要自己调整 POJO 方法定义顺序.
     *
     * @param sheetIndex sheet索引
     * @param list       追加的List Object, 每个 Object 即一行数据
     * @throws WriteException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public <T> void appendLines(List<T> list, Class c, int sheetIndex) throws WriteException, InvocationTargetException, IllegalAccessException {
        if (list.isEmpty()) {
            return;
        }
        WritableSheet sheet = sheetList.get(sheetIndex);
        int line = sheet.getRows();

        // 获得当前Pojo所有方法对象
        Method[] methods = c.getDeclaredMethods();

        // List容器存放所有带get字符串的Method对象
        List<Method> getterMethods = new ArrayList<Method>();

        // 将当前Pojo类所有带get字符串的Method对象,存入getterMethods
        for (Method m : methods) {
            if (m.getName().startsWith("get")) {
                getterMethods.add(m);
            }
        }
        for (Object o : list) {
            for (int i = 0, len = getterMethods.size(); i < len; i++) {
                sheet.addCell(new Label(i, line, (String) getterMethods.get(i).invoke(o)));
            }
            line++;
        }
    }

    /**
     * 输出 Excel.
     * 如果是用 HttpServletResponse 构造的对象,则向 HTTP 流输出;
     * 如果是用文件构造的对象,则向文件输出.
     *
     * @throws IOException
     * @throws WriteException
     */
    public void write() throws IOException, WriteException {
        if (book != null) {
            book.write();
            book.close();
        }
    }

}