package com.shipping.repository;

import com.shipping.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByContainerNameIsNull();
    List<Item> findByContainerName(String containerName);
}
