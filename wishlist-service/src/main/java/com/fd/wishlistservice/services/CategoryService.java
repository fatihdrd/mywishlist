package com.fd.wishlistservice.services;


import com.fd.wishlistservice.entity.CategoryEntity;
import com.fd.wishlistservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Tüm kategorileri döndür
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Yeni kategori ekle
    public CategoryEntity  addCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    // ID ile kategori bul (opsiyonel)
    public CategoryEntity getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));
    }
}
