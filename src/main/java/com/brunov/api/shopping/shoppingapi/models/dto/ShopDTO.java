package com.brunov.api.shopping.shoppingapi.models.dto;

import com.brunov.api.shopping.shoppingapi.models.Shop;
import com.mongodb.lang.Nullable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDTO {
    private String id;

    @NotBlank(message = "User identifier is required")
    private String userIdentifier;
    private LocalDateTime date;
    
    @Size(min = 1, message = "Items are required")
    private List<ItemDTO> items;
    private Double total;
    
    public static ShopDTO convert(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setId(shop.getId());
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setDate(shop.getDate());
        shopDTO.setTotal(shop.getTotal());

        if (shop.getItems() != null) {
            shopDTO.setItems(
                    shop.getItems().stream()
                            .map(ItemDTO::convert)
                            .collect(Collectors.toList())
            );
        }

        return shopDTO;
    }


}
