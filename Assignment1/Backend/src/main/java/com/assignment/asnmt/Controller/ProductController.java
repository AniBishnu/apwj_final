package com.assignment.asnmt.Controller;

import com.assignment.asnmt.Model.Product;
import com.assignment.asnmt.ProductCategory;
import com.assignment.asnmt.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return "Product added successfully";
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/Product/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/update")
    public String updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return "Product updated successfully";
    }

    @GetMapping("/expiring")
    @ResponseBody
    public List<Product> getExpiringProducts() {
        return productService.getExpiringSoon();
    }

    @PostMapping("/apply")
    public String applyDiscounts(@RequestParam double discount) {
        productService.applyDiscountToExpiringProducts(discount);
        return "Discounts applied.";
    }


    @GetMapping("/category-discount")
    @ResponseBody
    public List<Product> getProductsByCategoryWithDiscount(
            @RequestParam ProductCategory category,
            @RequestParam double discount
    ) {
        return productService.getProductsByCategoryWithDiscount(category, discount);
    }

    @PostMapping("/add-bulk")
    public String addProducts(@RequestBody List<Product> products) {
        productService.addProducts(products);
        return "Bulk products added successfully";
    }




}
