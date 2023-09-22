package vn.week2_lab2_doanhoaian_20116041.models;

import jakarta.persistence.*;
import vn.week2_lab2_doanhoaian_20116041.enums.ProductStatus;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false,length = 150)
    private long product_id;

    @Column(name = "product_name", length = 250,nullable = false)
    private String name;

    @Column(nullable = false,length = 250)
    private String description;

    @Column(nullable = false,length = 250)
    private String unit;

    @Column(nullable = false,length = 250)
    private String manufacturer_name;

    @Column(name = "status", nullable = false)
    private ProductStatus status;

    @OneToMany
    private List<ProductImage> listImage;

    @OneToOne
    private ProductPrice productPrice;
}
