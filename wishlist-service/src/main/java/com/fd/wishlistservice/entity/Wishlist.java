package com.fd.wishlistservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String imageUrl;
    private String link;

    @ManyToOne
    @JoinColumn(name = "category_id") // Foreign Key ile kategori ilişkisini kuruyoruz
    private CategoryEntity category;
}
