package xyz.antsgroup.demo.spring.paging;

/**
 *
 */
public class Order {
    /* 需要排序的列号,从0计数 */
    private Integer column;

    /* asc 或 desc */
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
