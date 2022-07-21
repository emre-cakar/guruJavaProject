package com.guru.Model;

public class Stock {
    private String code;
    private String name;
    private int type;
    private String unit;
    private String barcode;
    private double varType;
    private String description;
    private String createdDate;

    public Stock(){};
    public Stock(String code, String name, int type, String unit, String barcode, double varType, String description, String createdDate) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.unit = unit;
        this.barcode = barcode;
        this.varType = varType;
        this.description = description;
        this.createdDate = createdDate;
    }
    public Stock(String code, String name){
        this.code=code;
        this.name=name;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBarcode() {
        return barcode;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getVarType() {
        return varType;
    }
    public void setVarType(double varType) {
        this.varType = varType;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
