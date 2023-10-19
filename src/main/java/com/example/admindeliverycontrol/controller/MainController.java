package com.example.admindeliverycontrol.controller;

import com.example.admindeliverycontrol.model.Product;
import com.example.admindeliverycontrol.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    ProductService productService;

    @GetMapping
    public String showAllGoods(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "main_page";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }

    @PostMapping
    public String createProduct(@RequestParam double coast, @RequestParam String productName,
                          @RequestParam String photoUrl, @RequestParam String description,
                          @RequestParam int weight) {
        productService.createProduct(coast, productName, photoUrl, description, weight);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        System.out.println("editProductForm -> CALLED, product_id = " + id);

        Product product = productService.getProductById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "edit_product_form";
        }
        return "redirect:/products";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, @ModelAttribute Product updatedProduct) {
        System.out.println("editProduct -> PRODUCT EDITED");

        updatedProduct.setId(id);
        productService.updateProduct(updatedProduct);
        return "redirect:/";
    }
}
