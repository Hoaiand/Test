package vn.week2_lab2_doanhoaian_20116041.models;

import jakarta.persistence.*;

@Entity
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 150,nullable = false)
    private long product_id;

    @Id
    @Column(nullable = false, length = 150)
    private long image_id;

    @Column(length = 250, nullable = false)
    private String path;

    @Column(length = 250,nullable = false)
    private String alternative;

    @ManyToOne
    private Product product;
}
