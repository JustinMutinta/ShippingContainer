package com.shipping;

import com.shipping.model.Item;
import com.shipping.repository.ItemRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void seed() {
        if (itemRepository.count() > 0) return;

        itemRepository.saveAll(List.of(
                new Item("Box 1",              "No Serial Number", 10, 10,  10,    5),
                new Item("Box 2",              "No Serial Number", 10, 10,  10,    5),
                new Item("Box 3",              "No Serial Number", 10, 10,  10,    5),
                new Item("Box 4",              "No Serial Number", 10, 10,  10,    5),
                new Item("Box 5",              "No Serial Number", 10, 10,  10,    5),
                new Item("Electronics Crate A","No Serial Number", 10, 10,  10,    5),
                new Item("Electronics Crate B","No Serial Number", 10, 10,  10,    5),
                new Item("Food Supply Box",    "No Serial Number", 10, 10,  10,    5),
                new Item("Fragile Items Box",  "No Serial Number", 10, 10,  10,    5),
                new Item("BMW Vehicle",        "45RFT90RV",        60, 60, 120,  450),
                new Item("Honda Vehicle",      "KL5690TR5",        54, 60, 100,  450),
                new Item("Ford Truck",         "FT7823KL",         65, 70, 140, 1200),
                new Item("Motorcycle",         "MC4521XR",         40, 40,  80,  200)
        ));
    }
}
