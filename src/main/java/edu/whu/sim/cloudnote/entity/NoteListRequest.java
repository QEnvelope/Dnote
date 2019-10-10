package edu.whu.sim.cloudnote.entity;

/**
 * 获得note列表的bean类
 */
public class NoteListRequest {

    private String keyword;

    private Integer authorId;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
}
