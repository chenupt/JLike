package me.risky.jlike.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table COLLECTION.
 */
public class Collection {

    private Long id;
    private String title;
    private String content;
    private String detailUrl;
    private String imageSrc;
    private String scanNum;
    private String dateTime;
    private Integer type;
    private String remark;
    private String createTime;

    public Collection() {
    }

    public Collection(Long id) {
        this.id = id;
    }

    public Collection(Long id, String title, String content, String detailUrl, String imageSrc, String scanNum, String dateTime, Integer type, String remark, String createTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.detailUrl = detailUrl;
        this.imageSrc = imageSrc;
        this.scanNum = scanNum;
        this.dateTime = dateTime;
        this.type = type;
        this.remark = remark;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getScanNum() {
        return scanNum;
    }

    public void setScanNum(String scanNum) {
        this.scanNum = scanNum;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
