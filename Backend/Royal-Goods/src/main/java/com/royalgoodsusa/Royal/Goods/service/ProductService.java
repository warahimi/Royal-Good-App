package com.royalgoodsusa.Royal.Goods.service;

import com.royalgoodsusa.Royal.Goods.dto.ProductRequest;
import com.royalgoodsusa.Royal.Goods.dto.ProductResponse;
import com.royalgoodsusa.Royal.Goods.entity.Product;
import com.royalgoodsusa.Royal.Goods.repository.ProductRepository;
import com.royalgoodsusa.Royal.Goods.utilities.Utilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse addProduct(ProductRequest productRequest)
    {
        if(productRequest == null)
        {
            // through exeption
        }
        assert productRequest != null;
        Product product = Utilities.chageProductRequestToProduct(productRequest);
        Product savedProduct = productRepository.save(product);
        return Utilities.changeProductToProductResponse(savedProduct);
    }
    public ProductResponse findProductById(long id)
    {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent())
        {
            System.out.println("Product not found");
        }
        return Utilities.changeProductToProductResponse(product.get());
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        if(products.isEmpty())
        {

        }
        return products.stream()
                .map(Utilities::changeProductToProductResponse)
                .collect(Collectors.toList());
    }
    public ProductResponse updateProduct(long id, ProductRequest productRequest) {
        // Check if the product exists in the database by name
        Optional<Product> productOptional = productRepository.findById(id);

        // If the product is not found, handle the missing case by throwing an exception
        if (productOptional.isEmpty()) {
            //throw new EntityNotFoundException("Product with name " + productRequest.getName() + " not found");
        }

        // Get the existing product to update its properties
        Product product = productOptional.get();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setImageUrls(productRequest.getImageUrls());
        product.setCategory(productRequest.getCategory());
        product.setSubCategory(productRequest.getSubCategory());
        product.setSizes(productRequest.getSizes());
        product.setBestSeller(productRequest.isBestSeller());

        // Save the updated product back to the database
        Product savedProduct = productRepository.save(product);

        // Convert the saved product to ProductResponse and return it
        return Utilities.changeProductToProductResponse(savedProduct);
    }
}
