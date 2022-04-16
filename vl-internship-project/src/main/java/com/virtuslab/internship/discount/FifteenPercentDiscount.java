package com.virtuslab.internship.discount;

import com.virtuslab.internship.product.Product;
import com.virtuslab.internship.receipt.Receipt;
import com.virtuslab.internship.receipt.ReceiptEntry;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class FifteenPercentDiscount {
    public static String NAME = "FifteenPercentDiscount";

    public Receipt apply(Receipt receipt) {
        if (shouldApply(receipt)) {
            var totalPrice = receipt.totalPrice().multiply(BigDecimal.valueOf(0.85));
            var discounts = receipt.discounts();
            discounts.add(NAME);
            return new Receipt(receipt.entries(), discounts, totalPrice);
        }
        return receipt;
    }

    private boolean shouldApply(Receipt receipt) {
        int totalNumOfGrainProducts = receipt.entries().stream()
                .filter(e -> e.product().type().equals(Product.Type.GRAINS))
                .map(ReceiptEntry::quantity)
                .reduce(0, Integer::sum);

        return totalNumOfGrainProducts >= 3;
    }
}
