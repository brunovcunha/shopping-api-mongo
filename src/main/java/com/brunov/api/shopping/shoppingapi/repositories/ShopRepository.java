package com.brunov.api.shopping.shoppingapi.repositories;

import com.brunov.api.shopping.shoppingapi.models.Shop;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShopRepository extends MongoRepository<Shop, String> {
    List<Shop> findByUserIdentifier(String userIdentifier);
    List<Shop> findByDate(LocalDateTime date);
    List<Shop> findByItemsProductIdentifier(String productIdentifier);
}
