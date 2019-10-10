package edu.whu.sim.cloudnote.vo;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * 笔记详情vo
 */
public class NoteVO {

    private Integer id;
    private String title;
    @SerializedName("author_id")
    private Integer authorId;
    @SerializedName("author_name")
    private String authorName;
    @SerializedName("create_time")
    private String createTime;
    @SerializedName("update_time")
    private String updateTime;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
