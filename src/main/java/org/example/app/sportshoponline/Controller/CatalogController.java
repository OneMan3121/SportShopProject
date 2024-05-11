package org.example.app.sportshoponline.Controller;

import org.example.app.sportshoponline.model.Product;
import org.example.app.sportshoponline.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CatalogController {
    private CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/products")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        catalogService.addProduct(product);
        return ResponseEntity.ok("Product added successfully");
    }

    // Додаткові методи контролеру для редагування, видалення, отримання товарів і т.д.
}
