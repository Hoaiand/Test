package vn.week01_lab1_doanhoaian_20116041.repositories;

import vn.week01_lab1_doanhoaian_20116041.connectDB.ConnectDB;
import vn.week01_lab1_doanhoaian_20116041.models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository {
    private Connection con;
    public AccountRepository() {
        con = ConnectDB.getInstance().getConnection();
    }

    public boolean authenticateUser(String accountId, String password){
        try {
            String sql = "SELECT * FROM account WHERE account_id = ? AND password = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, accountId);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            // Nếu có kết quả từ truy vấn và người dùng hợp lệ, trả về true
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addAccount(Account acc) {
        try {
            String sql = "insert into account (account_id,full_name,password,email,phone,status) values (?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, acc.getAccountId());
            stm.setString(2, acc.getFullName());
            stm.setString(3, acc.getPassword());
            stm.setString(4, acc.getEmail());
            stm.setString(5, acc.getPhone());
            stm.setInt(6, acc.getStatus());

            if (stm.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateAccount(Account acc, String accountId) {
        try {
            String sql = "update account set full_name=?, password=?, email=?, phone=?, status=? where account_id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, acc.getFullName());
            stm.setString(2, acc.getPassword());
            stm.setString(3, acc.getEmail());
            stm.setString(4, acc.getPhone());
            stm.setInt(5, acc.getStatus());
            stm.setString(6, accountId); // Sử dụng accountId để xác định tài khoản cần cập nhật

            if (stm.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAccount(String accountId) {
        try {
            String sql = "delete from account where account_id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, accountId); // Sử dụng accountId để xác định tài khoản cần xóa

            if (stm.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
