package xyz.antsgroup.demo.spring.paging;

/**
 *
 */
public class PageQuery {
    /*
    每页显示条数
     */
    private int perPage = 20;

    /*
    当前页编号
     */
    private int current = 1;

    /*
    总共的页数
     */
    private int pageTotal;

    /*
    排序依据的字段, 空则忽略排序
     */
    private String order;

    /*
    是否升序, 1: 是, 0: 否, 其他则忽略排序
     */
    private int asc;

    public PageQuery() {
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getAsc() {
        return asc;
    }

    public void setAsc(int asc) {
        this.asc = asc;
    }

    @Override
    public String toString() {
        return "PageQuery{" +
                "perPage=" + perPage +
                ", current=" + current +
                ", pageTotal=" + pageTotal +
                ", order='" + order + '\'' +
                ", asc=" + asc +
                '}';
    }
}
