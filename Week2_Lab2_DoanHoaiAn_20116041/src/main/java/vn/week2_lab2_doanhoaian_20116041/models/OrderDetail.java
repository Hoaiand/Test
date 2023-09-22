package vn.week2_lab2_doanhoaian_20116041.models;

import jakarta.persistence.*;

@Entity()
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 150,nullable = false)
    private long order_id;

    @Column(length = 150,nullable = false)
    private int product_id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private float price;

    @Column(length = 250,nullable = false)
    private String note;

    @ManyToOne
    private Order order;
}
