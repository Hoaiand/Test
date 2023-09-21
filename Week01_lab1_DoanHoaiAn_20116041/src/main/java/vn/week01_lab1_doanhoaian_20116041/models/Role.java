package vn.week01_lab1_doanhoaian_20116041.models;

public class Role {
    private  String roleId;
    private  String role_name;
    private  String description;
    private  int status;

    public Role(String roleId) {
        this.roleId = roleId;
    }

    public Role() {
    }

    public Role(String roleId, String role_name, String description, int status) {
        this.roleId = roleId;
        this.role_name = role_name;
        this.description = description;
        this.status = status;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", role_name='" + role_name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
