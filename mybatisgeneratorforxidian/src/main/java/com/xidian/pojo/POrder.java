package com.xidian.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "p_order")
public class POrder {
    /**
     * 0 默认表示未确认1 表示确认, 2 表示否定
     */
    @Id
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "paper_id")
    private Integer paperId;

    private Integer status;

    @Column(name = "create_time")
    private Date createTime;

    private String ut;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "authors_fullname")
    private String authorsFullname;

    private String title;

    @Column(name = "source_title")
    private String sourceTitle;

    @Column(name = "wos_cited")
    private String wosCited;

    private String abstracts;

    @Column(name = "research_areas")
    private String researchAreas;

    private String emails;

    @Column(name = "pub_year")
    private String pubYear;

    /**
     * 获取0 默认表示未确认1 表示确认, 2 表示否定
     *
     * @return id - 0 默认表示未确认1 表示确认, 2 表示否定
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置0 默认表示未确认1 表示确认, 2 表示否定
     *
     * @param id 0 默认表示未确认1 表示确认, 2 表示否定
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return paper_id
     */
    public Integer getPaperId() {
        return paperId;
    }

    /**
     * @param paperId
     */
    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return ut
     */
    public String getUt() {
        return ut;
    }

    /**
     * @param ut
     */
    public void setUt(String ut) {
        this.ut = ut;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return authors_fullname
     */
    public String getAuthorsFullname() {
        return authorsFullname;
    }

    /**
     * @param authorsFullname
     */
    public void setAuthorsFullname(String authorsFullname) {
        this.authorsFullname = authorsFullname;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return source_title
     */
    public String getSourceTitle() {
        return sourceTitle;
    }

    /**
     * @param sourceTitle
     */
    public void setSourceTitle(String sourceTitle) {
        this.sourceTitle = sourceTitle;
    }

    /**
     * @return wos_cited
     */
    public String getWosCited() {
        return wosCited;
    }

    /**
     * @param wosCited
     */
    public void setWosCited(String wosCited) {
        this.wosCited = wosCited;
    }

    /**
     * @return abstracts
     */
    public String getAbstracts() {
        return abstracts;
    }

    /**
     * @param abstracts
     */
    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    /**
     * @return research_areas
     */
    public String getResearchAreas() {
        return researchAreas;
    }

    /**
     * @param researchAreas
     */
    public void setResearchAreas(String researchAreas) {
        this.researchAreas = researchAreas;
    }

    /**
     * @return emails
     */
    public String getEmails() {
        return emails;
    }

    /**
     * @param emails
     */
    public void setEmails(String emails) {
        this.emails = emails;
    }

    /**
     * @return pub_year
     */
    public String getPubYear() {
        return pubYear;
    }

    /**
     * @param pubYear
     */
    public void setPubYear(String pubYear) {
        this.pubYear = pubYear;
    }
}