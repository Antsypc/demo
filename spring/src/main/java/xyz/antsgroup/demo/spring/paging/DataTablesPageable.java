package xyz.antsgroup.demo.spring.paging;

import java.util.List;

/**
 * 符合 DataTables 接口的请求/响应对象
 */
public class DataTablesPageable<T> extends Pageable<T> {

    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    /* 搜索框输入值 */
    private String search;

    // 自定义的额外信息
    private Integer status;
    private String msg;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        // recordsTotal == recordsFiltered
        return recordsTotal;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "DataTablesPageable{" +
                "start=" + getStart() +
                ", length=" + getLength() +
                ", order=" + getOrder() +
                ", data=" + getData() +
                "draw=" + draw +
                ", recordsTotal=" + recordsTotal +
                ", recordsFiltered=" + recordsFiltered +
                ", search='" + search + '\'' +
                ", status=" + status +
                ", msg='" + msg + '\'' +
                '}';
    }

}
