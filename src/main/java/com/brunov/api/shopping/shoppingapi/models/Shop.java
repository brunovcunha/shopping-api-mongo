package com.brunov.api.shopping.shoppingapi.models;

import com.brunov.api.shopping.shoppingapi.models.dto.ShopDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "shop")
public class Shop {
    @Id
    private String id;
    private String userIdentifier;
    private LocalDateTime date;
    private List<Item> items;
    private Double total;

    public static Shop convert(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setId(shopDTO.getId());
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setDate(shopDTO.getDate());
        shop.setTotal(shopDTO.getTotal());

        if (shopDTO.getItems() != null) {
            shop.setItems(
                    shopDTO.getItems().stream()
                            .map(Item::convert)
                            .collect(Collectors.toList())
            );
        }

        return shop;
    }


}
