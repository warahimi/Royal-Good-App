package com.royalgoodsusa.Royal.Goods.utilities;

import com.royalgoodsusa.Royal.Goods.dto.ProductRequest;
import com.royalgoodsusa.Royal.Goods.dto.ProductResponse;
import com.royalgoodsusa.Royal.Goods.entity.Product;

public class Utilities {
    public static Product chageProductRequestToProduct(ProductRequest productRequest)
    {
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .imageUrls(productRequest.getImageUrls())
                .category(productRequest.getCategory())
                .subCategory(productRequest.getSubCategory())
                .sizes(productRequest.getSizes())
                .bestSeller(productRequest.isBestSeller())
                .build();
    }
    public static ProductResponse changeProductToProductResponse(Product product)
    {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .imageUrls(product.getImageUrls())
                .category(product.getCategory())
                .subCategory(product.getSubCategory())
                .sizes(product.getSizes())
                .bestSeller(product.isBestSeller())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }
}
