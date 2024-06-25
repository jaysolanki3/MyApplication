package com.example.myapplication;

import java.util.Collections;
import java.util.List;

public class SpecificationItem {
    private String id;
    private List<String> name;
    private int price;
    private int sequenceNumber;
    private boolean isDefaultSelected;
    private String specificationGroupId;
    private int uniqueId;


    public SpecificationItem(String name, int price) {
        this.name = Collections.singletonList(name);
        this.price = price;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public boolean isDefaultSelected() {
        return isDefaultSelected;
    }

    public void setDefaultSelected(boolean defaultSelected) {
        isDefaultSelected = defaultSelected;
    }

    public String getSpecificationGroupId() {
        return specificationGroupId;
    }

    public void setSpecificationGroupId(String specificationGroupId) {
        this.specificationGroupId = specificationGroupId;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }
}
