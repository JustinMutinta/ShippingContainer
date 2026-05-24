package com.shipping.model;

import java.util.List;

public class ContainerInfo {
    private String     name;
    private int        capacity;
    private int        used;
    private List<Item> items;

    public ContainerInfo(String name, int capacity, int used, List<Item> items) {
        this.name     = name;
        this.capacity = capacity;
        this.used     = used;
        this.items    = items;
    }

    public String     getName()     { return name; }
    public int        getCapacity() { return capacity; }
    public int        getUsed()     { return used; }
    public List<Item> getItems()    { return items; }
}
