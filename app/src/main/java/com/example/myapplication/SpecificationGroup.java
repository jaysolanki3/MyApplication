package com.example.myapplication;

import java.util.List;

public class SpecificationGroup {
    private String id;
    private List<String> name;
    private int sequenceNumber;
    private int unique_id;
    private List<SpecificationItem> list;
    private int maxRange;
    private int range;
    private int type;
    private boolean isRequired;
    private boolean isParentAssociate;
    private String modifierName;



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

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public int getUnique_id() {
        return unique_id;
    }

    public void setUniqueId(int uniqueId) {
        this.unique_id = unique_id;
    }

    public List<SpecificationItem> getList() {
        return list;
    }

    public void setList(List<SpecificationItem> list) {
        this.list = list;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public boolean isParentAssociate() {
        return isParentAssociate;
    }

    public void setParentAssociate(boolean parentAssociate) {
        isParentAssociate = parentAssociate;
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }
}
