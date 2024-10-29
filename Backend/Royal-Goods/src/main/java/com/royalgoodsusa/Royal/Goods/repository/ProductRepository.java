package com.royalgoodsusa.Royal.Goods.repository;

import com.royalgoodsusa.Royal.Goods.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
}
