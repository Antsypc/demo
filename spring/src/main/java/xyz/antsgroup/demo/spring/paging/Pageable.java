package xyz.antsgroup.demo.spring.paging;

import java.util.List;

/**
 * 分页查询
 */
public class Pageable<T> {
    // 记录起始,从0计数
    private Integer start;
    // 记录长度
    private Integer length;
    /* 排序, order[0].column=1&order[0].dir=asc */
    private List<Order> order;
    // 返回的数据
    private List<T> data;

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

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Pageable{" +
                "start=" + start +
                ", length=" + length +
                ", order=" + order +
                ", data=" + data +
                '}';
    }
}
