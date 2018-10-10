package com.blob.module.module.sys.entity;

import com.blob.module.common.sys.entity.DataEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by cc on 2018/10/8.
 */
@Entity
@Table(name = "sys_role")
public class Role extends DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 编号

    @Column(columnDefinition = "varchar(50) COMMENT '权限名称'")
    private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:

    @Column(columnDefinition = "varchar(200) COMMENT '描述'")
    private String description; // 角色描述,UI界面显示使用

    @Column(columnDefinition = "bit(1) COMMENT '是否可用'")
    private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户

    //角色 -- 权限关系：多对多关系;
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="sys_role_permission",joinColumns={@JoinColumn(name="rid")},inverseJoinColumns={@JoinColumn(name="pid")})
    private List<Permission> permissions;

    //角色--用户关系：多对多关系，加载方式Lazy
    @ManyToMany
    @JoinTable(name = "sys_user_role", joinColumns = {@JoinColumn(name = "rid")}, inverseJoinColumns = {@JoinColumn(name = "uid")})
    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
