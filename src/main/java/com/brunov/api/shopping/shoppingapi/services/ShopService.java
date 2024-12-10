package com.brunov.api.shopping.shoppingapi.services;

import org.springframework.stereotype.Service;

import com.brunov.api.shopping.shoppingapi.models.Item;
import com.brunov.api.shopping.shoppingapi.models.Shop;
import com.brunov.api.shopping.shoppingapi.models.dto.ShopDTO;
import com.brunov.api.shopping.shoppingapi.repositories.ShopRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ShopService {
    private final ShopRepository shopRepository;
    private final ItemService itemService;

    // Save ShopDTO (existing method)
    public ShopDTO saveShopDTO(ShopDTO shopDTO) {
        Shop shop = shopRepository.save(Shop.convert(shopDTO));
        return ShopDTO.convert(shop);
    }

    // Get all shops
    public List<ShopDTO> getAllShops() {
        List<Shop> shops = shopRepository.findAll();
        return shops.stream()
                    .map(ShopDTO::convert)
                    .collect(Collectors.toList());
    }

    // Get a shop by its ID
    public ShopDTO getShopById(String id) {
        Optional<Shop> shop = shopRepository.findById(id);
        return shop.map(ShopDTO::convert).orElse(null);
    }

    // Get shops by user identifier
    public List<ShopDTO> getShopsByUser(String userIdentifier) {
        List<Shop> shops = shopRepository.findByUserIdentifier(userIdentifier);
        return shops.stream()
                    .map(ShopDTO::convert)
                    .collect(Collectors.toList());
    }

    // Get shops by date
    public List<ShopDTO> getShopsByDate(LocalDateTime date) {
        List<Shop> shops = shopRepository.findByDate(date);
        return shops.stream()
                    .map(ShopDTO::convert)
                    .collect(Collectors.toList());
    }

    // Get shop by product identifier
    public List<ShopDTO> getShopsByProductIdentifier(String productIdentifier) {
        // Busque as lojas com base no productIdentifier
        List<Shop> shops = shopRepository.findByItemsProductIdentifier(productIdentifier);

        // Converta para DTO e retorne
        return shops.stream()
                    .map(ShopDTO::convert)
                    .collect(Collectors.toList());
    }

    public List<ShopDTO> getShopsByFilter(LocalDateTime dataInicio, LocalDateTime dataFim, Double valorMinimo) {
        List<Shop> shops = shopRepository.findByDateBetweenAndTotalGreaterThanEqual(dataInicio, dataFim, valorMinimo);
        return shops.stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getReportByDate(LocalDateTime dataInicio, LocalDateTime dataFim) {
        List<Shop> shops = shopRepository.findByDateBetween(dataInicio, dataFim);
        return shops.stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }
}
