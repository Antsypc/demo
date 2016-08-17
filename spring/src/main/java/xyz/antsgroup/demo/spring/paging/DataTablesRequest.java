package xyz.antsgroup.demo.spring.paging;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DataTablesRequest {

    /*
    DataTables 确保通信的序列号
     */
    private Integer draw;
    /*
    起始页
     */
    private Integer start;
    /*
    每页显示记录数
     */
    private Integer length;
    /*
    搜索框输入值
     */
    private String search;

    private ArrayList<Order> order;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Order> order) {
        this.order = order;
    }

    public class Order {
        /*
        排序列号
        */
        private Integer column;
        /*
        排序方向, asc 或者 desc
        */
        private String dir;

        public Integer getColumn() {
            return column;
        }

        public void setColumn(Integer column) {
            this.column = column;
        }

        public String getDir() {
            return dir;
        }

        public void setDir(String dir) {
            this.dir = dir;
        }
    }


}
