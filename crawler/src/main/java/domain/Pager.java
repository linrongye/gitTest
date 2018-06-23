package domain;

public class Pager {
    private Integer currentPage;
    private Object data;
    private Integer result;
    private String msg;
    private Integer total_page;
    private String last_dateline;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getTotal_page() {
        return total_page;
    }

    public void setTotal_page(Integer total_page) {
        this.total_page = total_page;
    }

    public String getLast_dateline() {
        return last_dateline;
    }

    public void setLast_dateline(String last_dateline) {
        this.last_dateline = last_dateline;
    }
}
