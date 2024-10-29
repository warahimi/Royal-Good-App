package com.royalgoodsusa.Royal.Goods.initial.setup;

import com.royalgoodsusa.Royal.Goods.dto.ProductRequest;
import com.royalgoodsusa.Royal.Goods.dto.ProductResponse;
import com.royalgoodsusa.Royal.Goods.repository.ProductRepository;
import com.royalgoodsusa.Royal.Goods.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class LoadData implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        ProductRequest priduct1 = ProductRequest.builder()
                .name("Men Round Neck Pure Cotton Men T-shirt")
                .description("A light-weight, usually knitted, pull over t-shirt, close fitting and with different colors. ")
                .price(BigDecimal.valueOf(5.6))
                .imageUrls(new ArrayList<>(Arrays.asList(
                        "https://royalgoodsstorage.s3.us-east-1.amazonaws.com/image+(5).jpg",
                        "https://royalgoodsstorage.s3.us-east-1.amazonaws.com/image+(5).jpg",
                        "https://royalgoodsstorage.s3.us-east-1.amazonaws.com/image+(4).jpg"
                )))
                .category("Men")
                .subCategory("Topwear")
                .sizes(Arrays.asList("S", "M", "L", "XL"))
                .bestSeller(true)
                .build();
        ProductRequest priduct2 = ProductRequest.builder()
                .name("Women's Casual Sneakers")
                .description("Comfortable and stylish casual sneakers for everyday wear. Available in various colors.")
                .price(BigDecimal.valueOf(24.99))
                .imageUrls(new ArrayList<>(Arrays.asList(
                        "https://royalgoodsstorage.s3.us-east-1.amazonaws.com/image+(1).jpg",
                        "https://royalgoodsstorage.s3.us-east-1.amazonaws.com/image+(15).jpg",
                        "https://royalgoodsstorage.s3.us-east-1.amazonaws.com/image+(8).jpg"
                )))
                .category("Women")
                .subCategory("Footwear")
                .sizes(Arrays.asList("5", "6", "7", "8"))
                .bestSeller(true)
                .build();

        ProductRequest priduct3 = ProductRequest.builder()
                .name("Unisex Waterproof Jacket")
                .description("Waterproof jacket for all-weather protection. Lightweight and available in multiple colors.")
                .price(BigDecimal.valueOf(49.99))
                .imageUrls(new ArrayList<>(Arrays.asList(
                        "https://royalgoodsstorage.s3.us-east-1.amazonaws.com/image+(7).jpg",
                        "https://royalgoodsstorage.s3.us-east-1.amazonaws.com/image+(4).jpg"
                )))
                .category("Unisex")
                .subCategory("Outerwear")
                .sizes(Arrays.asList("XS", "S", "M", "L", "XL"))
                .bestSeller(false)
                .build();

        ProductRequest priduct4 = ProductRequest.builder()
                .name("Kids' Cartoon Print T-Shirt")
                .description("Fun and vibrant t-shirt for kids, featuring popular cartoon characters. Made from soft cotton.")
                .price(BigDecimal.valueOf(8.5))
                .imageUrls(new ArrayList<>(Arrays.asList(
                        "https://royalgoodsstorage.s3.us-east-1.amazonaws.com/image+(14).jpg"
                )))
                .category("Kids")
                .subCategory("Topwear")
                .sizes(Arrays.asList("XS", "S", "M"))
                .bestSeller(true)
                .build();

        ProductRequest priduct5 = ProductRequest.builder()
                .name("Men's Slim Fit Jeans")
                .description("Durable and comfortable slim fit jeans for men, perfect for both casual and formal occasions.")
                .price(BigDecimal.valueOf(35.99))
                .imageUrls(new ArrayList<>(Arrays.asList(
                        "https://royalgoodsstorage.s3.us-east-1.amazonaws.com/image+(12).jpg",
                        "https://royalgoodsstorage.s3.us-east-1.amazonaws.com/image+(10).jpg",
                        "https://royalgoodsstorage.s3.us-east-1.amazonaws.com/image+(17).jpg"
                )))
                .category("Men")
                .subCategory("Bottomwear")
                .sizes(Arrays.asList("30", "32", "34", "36"))
                .bestSeller(false)
                .build();

        ProductRequest priduct6 = ProductRequest.builder()
                .name("Women's Lightweight Scarf")
                .description("Soft and lightweight scarf, perfect for adding a touch of elegance to any outfit.")
                .price(BigDecimal.valueOf(12.0))
                .imageUrls(new ArrayList<>(Arrays.asList(
                        "https://royalgoodsstorage.s3.us-east-1.amazonaws.com/image+(17).jpg",
                        "https://royalgoodsstorage.s3.us-east-1.amazonaws.com/image+(23).jpg"
                )))
                .category("Women")
                .subCategory("Accessories")
                .sizes(Arrays.asList("One Size"))
                .bestSeller(true)
                .build();

        if(productRepository.findAll().isEmpty())
        {
            productService.addProduct(priduct1);
            productService.addProduct(priduct2);
            productService.addProduct(priduct3);
            productService.addProduct(priduct4);
            productService.addProduct(priduct5);
            productService.addProduct(priduct6);
        }
    }
}
