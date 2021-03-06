package com.imooc.pojo.vo;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * 用于展示商品评价的VO
 * 下面是mapper.xml中的结果集
 *              ic.comment_level as commentLevel,
 *             ic.content as content,
 *             ic.sepc_name as sepcName,
 *             ic.created_time as createdTime,
 *             u.face as userFace,
 *             u.nickname as nickname
 */
public class ItemCommentVO {
    private Integer commentLevel;
    private String content;
    private String sepcName;
    private Date createdTime;
    private String userFace;
    private String nickname;

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSepcName() {
        return sepcName;
    }

    public void setSepcName(String sepcName) {
        this.sepcName = sepcName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
