package com.shipping.service;

import com.shipping.model.ContainerInfo;
import com.shipping.model.Item;
import com.shipping.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ShipService {

    @Autowired
    private ItemRepository itemRepository;

    public static final Map<String, Integer> CAPACITIES = Map.of(
            "Container 1", 5,
            "Container 2", 5,
            "Container 3", 5,
            "Platform 1",  1,
            "Platform 2",  1
    );

    public static final List<String> CONTAINER_NAMES = List.of(
            "Container 1", "Container 2", "Container 3", "Platform 1", "Platform 2"
    );

    public List<Item> getAvailableItems() {
        return itemRepository.findByContainerNameIsNull();
    }

    public List<ContainerInfo> getAllContainers() {
        return CONTAINER_NAMES.stream()
                .map(name -> {
                    List<Item> items = itemRepository.findByContainerName(name);
                    int capacity = CAPACITIES.get(name);
                    return new ContainerInfo(name, capacity, items.size(), items);
                })
                .collect(Collectors.toList());
    }

    // Returns true if added, false if container is full or item is already placed
    public boolean addToContainer(Long itemId, String containerName) {
        Item item = itemRepository.findById(itemId).orElse(null);
        if (item == null || item.getContainerName() != null) return false;

        Integer capacity = CAPACITIES.get(containerName);
        if (capacity == null) return false;

        List<Item> current = itemRepository.findByContainerName(containerName);
        if (current.size() >= capacity) return false;

        Set<Integer> usedSlots = current.stream()
                .map(Item::getSlotIndex)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        for (int i = 0; i < capacity; i++) {
            if (!usedSlots.contains(i)) {
                item.setContainerName(containerName);
                item.setSlotIndex(i);
                itemRepository.save(item);
                return true;
            }
        }
        return false;
    }

    // Returns true if removed, false if item was not in a container
    public boolean removeFromContainer(Long itemId) {
        Item item = itemRepository.findById(itemId).orElse(null);
        if (item == null || item.getContainerName() == null) return false;
        item.setContainerName(null);
        item.setSlotIndex(null);
        itemRepository.save(item);
        return true;
    }
}
