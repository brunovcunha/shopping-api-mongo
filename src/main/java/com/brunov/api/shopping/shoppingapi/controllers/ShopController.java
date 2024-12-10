package com.brunov.api.shopping.shoppingapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.brunov.api.shopping.shoppingapi.models.dto.ShopDTO;
import com.brunov.api.shopping.shoppingapi.services.ShopService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shopping")
public class ShopController {
    private final ShopService shopService;

    // Save a Shop
    @PostMapping
    public ResponseEntity<ShopDTO> saveShop(@RequestBody @Valid ShopDTO shopDTO) {
        return ResponseEntity.ok(shopService.saveShopDTO(shopDTO));
    }

    // Get all shops
    @GetMapping
    public ResponseEntity<List<ShopDTO>> getAllShops() {
        List<ShopDTO> shopDTOs = shopService.getAllShops();
        return ResponseEntity.ok(shopDTOs);
    }

    // Get shop by ID
    @GetMapping("/{id}")
    public ResponseEntity<ShopDTO> getShopById(@PathVariable String id) {
        ShopDTO shopDTO = shopService.getShopById(id);
        if (shopDTO != null) {
            return ResponseEntity.ok(shopDTO);
        }
        return ResponseEntity.notFound().build();
    }

    // Get shops by user identifier
    @GetMapping("/user/{userIdentifier}")
    public ResponseEntity<List<ShopDTO>> getShopsByUser(@PathVariable String userIdentifier) {
        List<ShopDTO> shopDTOs = shopService.getShopsByUser(userIdentifier);
        return ResponseEntity.ok(shopDTOs);
    }

    // Get shops by date
    @GetMapping("/date/{date}")
    public ResponseEntity<List<ShopDTO>> getShopsByDate(@PathVariable String date) {
        LocalDateTime parsedDate = LocalDateTime.parse(date); // Make sure to handle the format
        List<ShopDTO> shopDTOs = shopService.getShopsByDate(parsedDate);
        return ResponseEntity.ok(shopDTOs);
    }

    // Get shops by product identifier
    @GetMapping("/product/{productIdentifier}")
    public ResponseEntity<List<ShopDTO>> getShopsByProductIdentifier(@PathVariable String productIdentifier) {
        List<ShopDTO> shopDTOs = shopService.getShopsByProductIdentifier(productIdentifier);
        return ResponseEntity.ok(shopDTOs);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ShopDTO>> getShopsByFilter(
            @RequestParam("dataInicio") LocalDateTime dataInicio,
            @RequestParam("dataFim") LocalDateTime dataFim,
            @RequestParam("valorMinimo") Double valorMinimo) {

        List<ShopDTO> shops = shopService.getShopsByFilter(dataInicio, dataFim, valorMinimo);
        return ResponseEntity.ok(shops);
    }

    @GetMapping("/report")
    public ResponseEntity<List<ShopDTO>> getReportByDate(
            @RequestParam("dataInicio") LocalDateTime dataInicio,
            @RequestParam("dataFim") LocalDateTime dataFim) {

        List<ShopDTO> report = shopService.getReportByDate(dataInicio, dataFim);
        return ResponseEntity.ok(report);
    }
}
