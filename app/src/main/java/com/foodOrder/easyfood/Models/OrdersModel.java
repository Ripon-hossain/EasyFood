package com.foodOrder.easyfood.Models;

public class OrdersModel {

    int orderImage;
    String OderItemName, price, orderNumber;

    public OrdersModel() {
        this.orderImage = orderImage;
        this.OderItemName = OderItemName;
        this.price = price;
        this.orderNumber = orderNumber;
    }



    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getOderItemName() {
        return OderItemName;
    }

    public void setOderItemName(String oderItemName) {
        OderItemName = oderItemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
