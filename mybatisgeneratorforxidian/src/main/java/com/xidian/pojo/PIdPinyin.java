package com.xidian.pojo;

import javax.persistence.*;

@Table(name = "p_id_pinyin")
public class PIdPinyin {
    /**
     * paperid_name
     */
    @Id
    private Integer id;

    /**
     * 论文id
     */
    @Column(name = "paper_id")
    private Integer paperId;

    /**
     * 状态位表示这篇文章的这个名字的映射关系 的状态
     */
    private String status;

    /**
     * 论文拼音
     */
    private String name;

    /**
     * 获取paperid_name
     *
     * @return id - paperid_name
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置paperid_name
     *
     * @param id paperid_name
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取论文id
     *
     * @return paper_id - 论文id
     */
    public Integer getPaperId() {
        return paperId;
    }

    /**
     * 设置论文id
     *
     * @param paperId 论文id
     */
    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    /**
     * 获取状态位表示这篇文章的这个名字的映射关系 的状态
     *
     * @return status - 状态位表示这篇文章的这个名字的映射关系 的状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态位表示这篇文章的这个名字的映射关系 的状态
     *
     * @param status 状态位表示这篇文章的这个名字的映射关系 的状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取论文拼音
     *
     * @return name - 论文拼音
     */
    public String getName() {
        return name;
    }

    /**
     * 设置论文拼音
     *
     * @param name 论文拼音
     */
    public void setName(String name) {
        this.name = name;
    }
}