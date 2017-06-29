package kr.ac.seoultech.myapplication.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by eveck on 2017-06-27.
 */

public class Todo implements Serializable {

    private Long id;
    private String title;
    private String content;
    private Date createAt;

    public Todo(){  // default 생성자
    }

    public Todo(Long id, String title, String content, Date createAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
