package com.virtuslab.internship.controller;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.Product;
import com.virtuslab.internship.product.ProductDb;
import com.virtuslab.internship.receipt.Receipt;
import com.virtuslab.internship.receipt.ReceiptGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@RestController
public class BasketController {
    @PostMapping("/receipt")
    public Receipt getBasket(@RequestBody Basket basket){
        ReceiptGenerator receiptGenerator = new ReceiptGenerator();
        Receipt receipt = receiptGenerator.generate(basket);
        return receipt;
    }

    @GetMapping("/products")
    public Set<Product> getProducts(){
        var productDb = new ProductDb();
        return productDb.getProducts();
    }
}
