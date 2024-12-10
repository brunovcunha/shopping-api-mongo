package com.brunov.api.shopping.shoppingapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brunov.api.shopping.shoppingapi.models.Item;
import com.brunov.api.shopping.shoppingapi.repositories.ItemRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    // Constructor, etc.

    public List<Item> findByProductIdentifier(String productIdentifier) {
        // Supondo que o Item tenha um campo productIdentifier
        return itemRepository.findByProductIdentifier(productIdentifier);
    }
}
