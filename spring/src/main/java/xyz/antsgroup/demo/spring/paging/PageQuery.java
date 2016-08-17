package xyz.antsgroup.demo.spring.paging;

/**
 *
 */
public class PageQuery {
    /*
    每页显示条数
     */
    private Integer perPage = -1;

    /*
    当前页编号
     */
    private Integer current = 1;

    /*
    总共的页数
     */
    private Integer pageTotal;

    /*
    排序依据的字段, 空则忽略排序
     */
    private String order;

    /*
    是否升序, 1: 是, 0: 否, 其他则忽略排序
     */
    private String asc;

    public PageQuery() {
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getAsc() {
        return asc;
    }

    public void setAsc(String asc) {
        this.asc = asc;
    }

    @Override
    public String toString() {
        return "PageQuery{" +
                "perPage=" + perPage +
                ", current=" + current +
                ", pageTotal=" + pageTotal +
                ", order='" + order + '\'' +
                ", asc='" + asc + '\'' +
                '}';
    }
}
