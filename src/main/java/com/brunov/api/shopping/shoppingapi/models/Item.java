package com.brunov.api.shopping.shoppingapi.models;

import com.brunov.api.shopping.shoppingapi.models.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "item")
public class Item {
    private String productIdentifier;
    private double price;

    public static Item convert(ItemDTO itemDTO) {
        if (itemDTO == null) {
            return null;
        }

        Item item = new Item();
        item.setProductIdentifier(itemDTO.getProductIdentifier());
        item.setPrice(itemDTO.getPrice());
        return item;
    }

}
