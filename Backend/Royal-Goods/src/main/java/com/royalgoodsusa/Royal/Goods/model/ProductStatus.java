package com.royalgoodsusa.Royal.Goods.model;

// Enum representing the availability status of a product
public enum ProductStatus {
    AVAILABLE,        // Product is in stock and available for purchase
    OUT_OF_STOCK,     // Product is currently out of stock
    DISCONTINUED,     // Product is no longer available for sale
    COMING_SOON,      // Product is not yet available but will be released soon
    PRE_ORDER         // Product is available for pre-order
}
