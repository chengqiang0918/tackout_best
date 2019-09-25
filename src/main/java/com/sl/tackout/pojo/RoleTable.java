package com.sl.tackout.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by happy on 2019/8/21.
 */
@Data
public class RoleTable implements Serializable {//角色表只针对用户
    private int roleId;//角色id
    private String roleName;//角色名称

    public RoleTable() {
    }

    public RoleTable(int roleId, String roleName) {

        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {

        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "RoleTable{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
