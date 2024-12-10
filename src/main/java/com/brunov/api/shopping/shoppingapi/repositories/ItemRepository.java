package com.brunov.api.shopping.shoppingapi.repositories;

import com.brunov.api.shopping.shoppingapi.models.Item;
import com.brunov.api.shopping.shoppingapi.models.Shop;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
    List<Item> findByProductIdentifier(String productIdentifier);
}
