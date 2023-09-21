package vn.week01_lab1_doanhoaian_20116041.models;

public class GrantAccess {
    private String roleId;
    private String accountId;
    private  int is_grant;
    private  String note;

    public GrantAccess() {
    }


    public GrantAccess(String roleId, String accountId, int is_grant, String note) {
        this.roleId = roleId;
        this.accountId = accountId;
        this.is_grant = is_grant;
        this.note = note;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getIs_grant() {
        return is_grant;
    }

    public void setIs_grant(int is_grant) {
        this.is_grant = is_grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "grantAccess{" +
                "roleId='" + roleId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", is_grant=" + is_grant +
                ", note='" + note + '\'' +
                '}';
    }
}
