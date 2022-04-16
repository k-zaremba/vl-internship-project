package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.Product;

import java.math.BigDecimal;
import java.util.*;

public class ReceiptGenerator {

    public Receipt generate(Basket basket) {
        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        HashMap<Product, Integer> basketProductsAndCount = new HashMap<>();

        basket.getProducts().forEach(e -> fillHashMap(basketProductsAndCount, e));

        for (Map.Entry<Product, Integer> set : basketProductsAndCount.entrySet()) {
            receiptEntries.add(new ReceiptEntry(set.getKey(), set.getValue()));
        }

        return new Receipt(receiptEntries);
    }

    private void fillHashMap(HashMap<Product, Integer> basketProductsAndCount, Product product){
        if(!basketProductsAndCount.containsKey(product))
            basketProductsAndCount.put(product, 1);
        else
            basketProductsAndCount.put(product, basketProductsAndCount.get(product) + 1);
    }

}
