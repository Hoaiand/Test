package vn.week2_lab2_doanhoaian_20116041.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cus_id",length = 150, nullable = false)
    private long cus_id;

    @Column(length = 250, nullable = false)
    private String cust_name;

    @Column(length = 50, unique = true,nullable = false)
    private String email;

    @Column(length = 15, nullable = false)
    private String phone;

    @Column(length = 250, nullable = false)
    private String address;


    @OneToMany
    private List<Order> orderList;
}
