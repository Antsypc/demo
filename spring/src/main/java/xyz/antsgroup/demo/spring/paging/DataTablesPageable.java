package xyz.antsgroup.demo.spring.paging;

/**
 * 符合 DataTables 接口的请求/响应对象
 */
public class DataTablesPageable<T> extends Pageable<T> {

    private Integer draw;
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

    public Long getRecordsTotal() {
        return super.getTotal();
    }

    public void setRecordsTotal(Long recordsTotal) {
        super.setTotal(recordsTotal);
    }

    public Long getRecordsFiltered() {
        // recordsTotal == recordsFiltered
        return super.getTotal();
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        super.setTotal(recordsFiltered);
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
                ", recordsTotal=" + super.getTotal() +
                ", recordsFiltered=" + super.getTotal() +
                ", search='" + search + '\'' +
                ", status=" + status +
                ", msg='" + msg + '\'' +
                '}';
    }

}
