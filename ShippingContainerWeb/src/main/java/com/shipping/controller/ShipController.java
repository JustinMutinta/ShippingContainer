package com.shipping.controller;

import com.shipping.model.ApiResponse;
import com.shipping.model.ContainerInfo;
import com.shipping.model.Item;
import com.shipping.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShipController {

    @Autowired
    private ShipService shipService;

    @GetMapping("/items/available")
    public List<Item> getAvailableItems() {
        return shipService.getAvailableItems();
    }

    @GetMapping("/containers")
    public List<ContainerInfo> getAllContainers() {
        return shipService.getAllContainers();
    }

    @PostMapping("/containers/{name}/items/{itemId}")
    public ResponseEntity<ApiResponse> addItem(
            @PathVariable String name,
            @PathVariable Long itemId) {
        boolean success = shipService.addToContainer(itemId, name);
        if (success) {
            return ResponseEntity.ok(new ApiResponse(true, "Added to " + name + "."));
        }
        return ResponseEntity.badRequest()
                .body(new ApiResponse(false, name + " is full or the item is already loaded."));
    }

    @DeleteMapping("/items/{itemId}/placement")
    public ResponseEntity<ApiResponse> removeItem(@PathVariable Long itemId) {
        boolean success = shipService.removeFromContainer(itemId);
        if (success) {
            return ResponseEntity.ok(new ApiResponse(true, "Item returned to available pool."));
        }
        return ResponseEntity.badRequest()
                .body(new ApiResponse(false, "Item not found or not currently in a container."));
    }
}
