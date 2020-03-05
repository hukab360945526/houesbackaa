package com.team.houes.houesbacka.util;

/**
 * @ClassName HouesQu
 * @Description
 * @Author HU
 * @Date 2020/3/3 14:08
 */
//条件查询类
public class HouesQu extends PagePrameter {

    private Integer did;

    private String title;

    private Integer sid;

    private Integer tid;

    private Long staProce;

    private Long enProce;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Long getStaProce() {
        return staProce;
    }

    public void setStaProce(Long staProce) {
        this.staProce = staProce;
    }

    public Long getEnProce() {
        return enProce;
    }

    public void setEnProce(Long enProce) {
        this.enProce = enProce;
    }
}
