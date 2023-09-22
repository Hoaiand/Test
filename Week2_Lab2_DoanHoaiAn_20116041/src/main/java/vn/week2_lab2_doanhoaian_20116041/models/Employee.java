package vn.week2_lab2_doanhoaian_20116041.models;

import jakarta.persistence.*;
import org.joda.time.DateTime;
import vn.week2_lab2_doanhoaian_20116041.enums.EmployeeStatus;

import java.util.List;

@Entity(name = "emloyee")
@NamedQueries(@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM emloyee e where e.status = 1"))
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", length = 150,nullable = false)
    private long emp_id;

    @Column(name = "full_name", length = 150, nullable = false)
    private String fullName;

    @Column(nullable = false)
    private DateTime dob;

    @Column(length = 150, unique = true)
    private String email;

    @Column(length = 15,nullable = false)
    private String phone;

    @Column(length = 250, nullable = false)
    private String address;

    @Column(name = "status", nullable = false)
    private EmployeeStatus status;

    @OneToMany
    private List<Order> orderList;


    public Employee(String address) {
        this.address = address;
    }

    public Employee(long emp_id, String fullName, DateTime dob, String email, String phone, String address, EmployeeStatus status, List<Order> orderList) {
        this.emp_id = emp_id;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.orderList = orderList;
    }

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public DateTime getDob() {
        return dob;
    }

    public void setDob(DateTime dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", orderList=" + orderList +
                '}';
    }
}
