package com.sample.thymeleaf.entity;

import java.io.Serializable;

/**
 * @author gaoy
 * @since 2019/8/2
 */
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
