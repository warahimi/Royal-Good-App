package com.royalgoodsusa.Royal.Goods.controller;

import com.royalgoodsusa.Royal.Goods.dto.ProductRequest;
import com.royalgoodsusa.Royal.Goods.dto.ProductResponse;
import com.royalgoodsusa.Royal.Goods.service.ProductService;
import com.royalgoodsusa.Royal.Goods.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
//@CrossOrigin(origins = "http://localhost:5173") // Allow requests from the React app
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final S3Service s3Service;


    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest)
    {
        ProductResponse productResponse = productService.addProduct(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts()
    {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable long id)
    {
        return new ResponseEntity<>(productService.findProductById(id), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable long id, @RequestBody ProductRequest productRequest)
    {
        return new ResponseEntity<>(productService.updateProduct(id,productRequest), HttpStatus.OK);
    }

    /*
    End point to upload Image to S3
     */
    @PostMapping("/uploadImages")
    public ResponseEntity<List<String>> uploadImages(@RequestParam("images") List<MultipartFile> files) {
        List<String> imageUrls = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                String url = s3Service.uploadFile(file);
                imageUrls.add(url);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
        return ResponseEntity.ok(imageUrls);
    }
    // Delete image from S3 by file url
    @DeleteMapping("/deleteImage")
    public ResponseEntity<String> deleteImage(@RequestParam("fileUrl") String fileUrl) {
        try {

            s3Service.deleteFile(fileUrl);                    // Delete using the fileUrl
            return ResponseEntity.ok("File deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to delete file.");
        }
    }
}
