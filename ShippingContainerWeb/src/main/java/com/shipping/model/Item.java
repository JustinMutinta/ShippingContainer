package com.shipping.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(name = "serial_number")
    private String serialNumber;

    private int height;
    private int width;
    private int length;
    private int weight;

    @Column(name = "container_name")
    private String containerName;

    @Column(name = "slot_index")
    private Integer slotIndex;

    public Item() {}

    public Item(String description, String serialNumber,
                int height, int width, int length, int weight) {
        this.description  = description;
        this.serialNumber = serialNumber;
        this.height       = height;
        this.width        = width;
        this.length       = length;
        this.weight       = weight;
    }

    public Long    getId()            { return id; }
    public String  getDescription()   { return description; }
    public String  getSerialNumber()  { return serialNumber; }
    public int     getHeight()        { return height; }
    public int     getWidth()         { return width; }
    public int     getLength()        { return length; }
    public int     getWeight()        { return weight; }
    public String  getContainerName() { return containerName; }
    public Integer getSlotIndex()     { return slotIndex; }

    public void setDescription(String description)     { this.description  = description; }
    public void setSerialNumber(String serialNumber)   { this.serialNumber = serialNumber; }
    public void setHeight(int height)                  { this.height       = height; }
    public void setWidth(int width)                    { this.width        = width; }
    public void setLength(int length)                  { this.length       = length; }
    public void setWeight(int weight)                  { this.weight       = weight; }
    public void setContainerName(String containerName) { this.containerName = containerName; }
    public void setSlotIndex(Integer slotIndex)        { this.slotIndex    = slotIndex; }
}
