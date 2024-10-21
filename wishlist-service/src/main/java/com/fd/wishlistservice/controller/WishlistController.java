package com.fd.wishlistservice.controller;

import com.fd.wishlistservice.entity.CategoryEntity;
import com.fd.wishlistservice.entity.Wishlist;
import com.fd.wishlistservice.repository.CategoryRepository;
import com.fd.wishlistservice.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/add")
    public Wishlist addWishlistItem(@RequestBody Wishlist wishlist) {
        CategoryEntity category = categoryRepository.findById(wishlist.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));
        wishlist.setCategory(category);
        return wishlistRepository.save(wishlist);
    }

    @GetMapping("/list")
    public List<Wishlist> getWishlist() {
        return wishlistRepository.findAll();
    }
}

