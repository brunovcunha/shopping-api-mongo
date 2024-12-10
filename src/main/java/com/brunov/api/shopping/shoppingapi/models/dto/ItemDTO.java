package com.brunov.api.shopping.shoppingapi.models.dto;

import com.brunov.api.shopping.shoppingapi.models.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private String productIdentifier;
    private double price;

    public static ItemDTO convert(Item item) {
        if (item == null) {
            return null;
        }
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProductIdentifier(item.getProductIdentifier());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    }


}
