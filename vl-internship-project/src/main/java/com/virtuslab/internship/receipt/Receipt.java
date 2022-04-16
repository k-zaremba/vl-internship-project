package com.virtuslab.internship.receipt;

import com.virtuslab.internship.product.Product;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public record Receipt(
        List<ReceiptEntry> entries,
        List<String> discounts,
        BigDecimal totalPrice) {

    public Receipt(List<ReceiptEntry> entries) {
        this(entries,
                new ArrayList<>(),
                entries.stream()
                        .map(ReceiptEntry::totalPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );
    }


}
