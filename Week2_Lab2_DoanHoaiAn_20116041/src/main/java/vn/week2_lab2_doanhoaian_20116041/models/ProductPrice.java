package vn.week2_lab2_doanhoaian_20116041.models;

import jakarta.persistence.*;
import org.joda.time.DateTime;

@Entity(name = "product_price")
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 150,nullable = false)
    private long product_id;

    @Column(nullable = false)
    private DateTime price_date_time;

    @Column(nullable = false)
    private float price;


    @OneToOne
    private Product product;
}
