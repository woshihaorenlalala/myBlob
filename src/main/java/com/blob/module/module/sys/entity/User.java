package com.blob.module.module.sys.entity;


import com.blob.module.common.sys.entity.DataEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by cc on 2018/6/15.
 */
@Entity
@Table(name = "sys_user")
public class User extends DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //昵称
    @Column(columnDefinition = "varchar(20) COMMENT  '昵称'")
    private String name;

    @Column(unique = true, columnDefinition = "varchar(50) COMMENT '登陆账号'")
    private String username;

    @Column(columnDefinition = "varchar(50) COMMENT  '密码'")
    private String password;

    @Transient
    private String newPassword;

    @Column(columnDefinition = "varchar(50) COMMENT '盐'")
    private String salt;

    @Column(columnDefinition = "bit(2) COMMENT '状态'")
    private String status;

    //权限
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_user_role",joinColumns = {@JoinColumn(name = "uid")},
            inverseJoinColumns = {@JoinColumn(name = "rid")} )
    private List<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 密码盐
     * @return
     */
    public String getCredentialsSalt(){
        return this.username + this.salt;
    }
}
