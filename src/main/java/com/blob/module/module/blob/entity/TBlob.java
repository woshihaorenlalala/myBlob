package com.blob.module.module.blob.entity;

import com.blob.module.common.sys.entity.DataEntity;

import javax.persistence.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author cc
 * @since 2018-10-10
 */
@Entity
@Table(name = "t_blob")
public class TBlob extends DataEntity<TBlob> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 标题
     */
    @Column(columnDefinition = "varchar(40) COMMENT  '标题'")
    private String title;

    /**
     * 内容
     */
    @Column(columnDefinition = "blob COMMENT  '内容'")
    private String content;

    /**
     * 是否可见（0否1是）
     */
    @Column(columnDefinition = "int(1) COMMENT  '是否显示'")
    private int show;

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

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
