package com.xidian.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_paper")
public class UserPaper {
    /**
     * id 认领记录的id
     */
    @Id
    private Integer id;

    /**
     * 工资号 工资号
     */
    private Integer gzh;

    /**
     * 论文id 论文id
     */
    @Column(name = "paper_id")
    private Integer paperId;

    /**
     * ut索引号
     */
    private String ut;

    private String title;

    @Column(name = "authors_fullname")
    private String authorsFullname;

    @Column(name = "pub_year")
    private String pubYear;

    /**
     * 所属状态字段 0表示待定,1表示属于,2表示不属于
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * wos引用
     */
    @Column(name = "wos_cited")
    private Integer wosCited;

    /**
     * 获取id 认领记录的id
     *
     * @return id - id 认领记录的id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id 认领记录的id
     *
     * @param id id 认领记录的id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取工资号 工资号
     *
     * @return gzh - 工资号 工资号
     */
    public Integer getGzh() {
        return gzh;
    }

    /**
     * 设置工资号 工资号
     *
     * @param gzh 工资号 工资号
     */
    public void setGzh(Integer gzh) {
        this.gzh = gzh;
    }

    /**
     * 获取论文id 论文id
     *
     * @return paper_id - 论文id 论文id
     */
    public Integer getPaperId() {
        return paperId;
    }

    /**
     * 设置论文id 论文id
     *
     * @param paperId 论文id 论文id
     */
    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    /**
     * 获取ut索引号
     *
     * @return ut - ut索引号
     */
    public String getUt() {
        return ut;
    }

    /**
     * 设置ut索引号
     *
     * @param ut ut索引号
     */
    public void setUt(String ut) {
        this.ut = ut;
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

    /**
     * 获取所属状态字段 0表示待定,1表示属于,2表示不属于
     *
     * @return status - 所属状态字段 0表示待定,1表示属于,2表示不属于
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置所属状态字段 0表示待定,1表示属于,2表示不属于
     *
     * @param status 所属状态字段 0表示待定,1表示属于,2表示不属于
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取wos引用
     *
     * @return wos_cited - wos引用
     */
    public Integer getWosCited() {
        return wosCited;
    }

    /**
     * 设置wos引用
     *
     * @param wosCited wos引用
     */
    public void setWosCited(Integer wosCited) {
        this.wosCited = wosCited;
    }
}