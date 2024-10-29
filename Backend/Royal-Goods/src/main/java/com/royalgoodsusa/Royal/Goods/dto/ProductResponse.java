package com.royalgoodsusa.Royal.Goods.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductResponse {
    private long id;
    private String name;
    // Detailed description of the product
    private String description;
    // Price of the product using BigDecimal for precision in financial calculations
    private BigDecimal price;
    // List of URLs for product images, stored as a collection of strings in the database
    private List<String> imageUrls;
    // Category to which the product belongs (e.g., Electronics, Men, Women)
    private String category;
    // Sub-category of the product (e.g., Mobile Phones under Electronics, Topwear)
    private String subCategory;
    private List<String> sizes;
    // Flag indicating if the product is a bestseller
    private boolean bestSeller;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy h:mm a")
    private LocalDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy h:mm a")
    private LocalDateTime updatedAt;

//    // Custom formatted getters for createdAt and updatedAt
//    public String getFormattedCreatedAt() {
//        return createdAt != null ? createdAt.format(DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a")) : null;
//    }
//
//    public String getFormattedUpdatedAt() {
//        return updatedAt != null ? updatedAt.format(DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a")) : null;
//    }
}
