package com.portfolio_wnsferreira.ecommerce.view.model;

public class ProductRequest {
    
    private String name;
    private Integer quantityStock;
    private Integer costValue;
    private Integer saleValue;    
    // private Data dateRegister;
    private String note;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(Integer quantityStock) {
        this.quantityStock = quantityStock;
    }

    public Integer getCostValue() {
        return costValue;
    }

    public void setCostValue(Integer costValue) {
        this.costValue = costValue;
    }

    public Integer getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(Integer saleValue) {
        this.saleValue = saleValue;
    }

    // public Data getDateRegister() {
    //     return dateRegister;
    // }

    // public void setDateRegister(Data dateRegister) {
    //     this.dateRegister = dateRegister;
    // }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
