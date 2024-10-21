package com.fd.wishlistservice.controller;
import com.fd.wishlistservice.entity.CategoryEntity;
import com.fd.wishlistservice.repository.CategoryRepository;
import com.fd.wishlistservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*") // Frontend'in API'ye erişebilmesi için CORS ayarı
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Tüm kategorileri listeleme
    @GetMapping
    public List<CategoryEntity> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Yeni kategori ekleme
    @PostMapping("/add")
    public CategoryEntity addCategory(@RequestBody CategoryEntity category) {
        return categoryService.addCategory(category);
    }

    // Belirli bir kategoriye erişme (opsiyonel)
    @GetMapping("/{id}")
    public CategoryEntity getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }
}
