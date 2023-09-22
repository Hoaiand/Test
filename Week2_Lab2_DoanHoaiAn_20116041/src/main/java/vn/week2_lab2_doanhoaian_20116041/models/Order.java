package vn.week2_lab2_doanhoaian_20116041.models;

import jakarta.persistence.*;
import org.joda.time.DateTime;

import java.util.List;

@Entity()
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 150,nullable = false)
    private long order_id;

    @Column(nullable = false)
    private DateTime order_date;

    @Column(length = 150,nullable = false)
    private int emp_id;

    @Column(length = 150,nullable = false)
    private int cust_id;

    @OneToMany
    private List<OrderDetail> orderDetails;

    @ManyToOne
    private  Employee employee;

    @OneToOne
    private Customer customer;

}
