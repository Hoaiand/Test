package vn.week01_lab1_doanhoaian_20116041.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.week01_lab1_doanhoaian_20116041.models.Account;
import vn.week01_lab1_doanhoaian_20116041.repositories.AccountRepository;

import java.io.IOException;

@WebServlet(urlPatterns = "/admin")
public class ControllerServlet extends HttpServlet {
    private AccountRepository AccRepo = new AccountRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            resp.getWriter().println("Action is missing!");
            return;
        }

        HttpSession session = req.getSession(false);

        if (session != null) {
            switch (action) {
                case "login":
                    String account_id = req.getParameter("account_id");
                    String password = req.getParameter("password");

                    AccountRepository accountRepo = new AccountRepository();
                    boolean isAuthenticated = accountRepo.authenticateUser(account_id, password);

                    if (isAuthenticated) {
                        resp.sendRedirect("admin.jsp");
                    } else {
                        resp.getWriter().println("Login failed!");
                    }
                    break;
                case "Create":
                    CRUD(req, resp, "Create");
                    break;
                case "Delete":
                    CRUD(req, resp, "Delete");
                    break;
                case "Update":
                    CRUD(req, resp, "Update");
                    break;
                default:
                    resp.getWriter().println("Invalid action!");
            }
        } else {
            resp.getWriter().println("Please login!");
        }
    }

    private void CRUD(HttpServletRequest req, HttpServletResponse resp, String action) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        if (session != null) {

            String roleName = (String) session.getAttribute("roleName");
            Account acc = (Account) session.getAttribute("userLogin");


            switch (action) {
                case "Create":
                    String accountID = req.getParameter("account_id");
                    String fullName = req.getParameter("full_name");
                    String password = req.getParameter("password");
                    String email = req.getParameter("email");
                    String phone = req.getParameter("phone");
                    int status = Integer.parseInt(req.getParameter("status"));

                    // Tạo tài khoản mới
                    Account acc_new = new Account(accountID, fullName, password, email, phone, status);

                    // Thử thêm tài khoản
                    Boolean result_add_account = AccRepo.addAccount(acc_new);

                    if (result_add_account) {
                        resp.getWriter().println("Create success !!!");
                    } else {
                        resp.getWriter().println("Create failed !!!");
                    }
                    break;

                case "Delete":
                    String uidToDelete = req.getParameter("account_id_delete");
                    Boolean resultDeleteAccount = AccRepo.deleteAccount(uidToDelete);
                    if (resultDeleteAccount) {
                        resp.getWriter().println("Deletion success !!!");
                    } else {
                        resp.getWriter().println("Deletion failed !!!");
                    }
                    break;

                case "Update":
                    String accountIdToUpdate = req.getParameter("account_id"); // Lấy account_id của tài khoản cần cập nhật
                    String newFullName = req.getParameter("full_name");
                    String newPassword = req.getParameter("password");
                    String newEmail = req.getParameter("email");
                    String newPhone = req.getParameter("phone");
                    int newStatus = Integer.parseInt(req.getParameter("status"));

                    // Tạo tài khoản cần cập nhật
                    Account updatedAccount = new Account(accountIdToUpdate, newFullName, newPassword, newEmail, newPhone, newStatus);

                    // Thử cập nhật tài khoản
                    Boolean resultUpdateAccount = AccRepo.updateAccount(updatedAccount, accountIdToUpdate);

                    if (resultUpdateAccount) {
                        resp.getWriter().println("Update success !!!");
                    } else {
                        resp.getWriter().println("Update failed !!!");
                    }
                    break;
                default:

            }


        } else {
            resp.getWriter().println("please login !!!");
        }

    }
}
