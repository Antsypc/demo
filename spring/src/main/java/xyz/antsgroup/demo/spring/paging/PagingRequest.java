package xyz.antsgroup.demo.spring.paging;

import java.util.List;

/**
 * 分页请求对象
 */
public class PagingRequest {

    /*
    前端表格使用 DataTables 分页时: 确保通信的序列号,从1递增.不用考虑这个值,把他再返回给客户端就OK.
     */
    private Integer draw;
    /*
    起始页,即请求页号
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
    /*
    order[0].column=1&order[0].dir=asc
     */
    private List<Order> order;

    public static class Order {
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

        @Override
        public String toString() {
            return "Order{" +
                    "column=" + column +
                    ", dir='" + dir + '\'' +
                    '}';
        }
    }

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

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "PagingRequest{" +
                "draw=" + draw +
                ", start=" + start +
                ", length=" + length +
                ", search='" + search + '\'' +
                ", order=" + order +
                '}';
    }
}
