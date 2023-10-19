package com.example.admindeliverycontrol.service;

import com.example.admindeliverycontrol.model.Product;
import com.example.admindeliverycontrol.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product createProduct(double coast, String productName, String photoUrl, String description, int weight) {
        Product product = new Product();
        product.setCoast(coast);
        product.setProductName(productName);
        product.setPhotoUrl(photoUrl);
        product.setDescription(description);
        product.setWeight(weight);
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product updateProduct(Product updatedProduct) {
        return productRepository.save(updatedProduct);
    }
}
