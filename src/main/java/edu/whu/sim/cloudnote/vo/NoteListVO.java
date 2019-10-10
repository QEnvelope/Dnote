package edu.whu.sim.cloudnote.vo;

import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 笔记列表vo
 */
public class NoteListVO {
    private Integer id;
    @NotNull
    private String title;
    @NotNull
    @SerializedName("update_time")
    private String updateTime;

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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
