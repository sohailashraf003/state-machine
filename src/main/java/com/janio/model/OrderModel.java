package com.janio.model;

import com.janio.util.State;

public class OrderModel {

    private int orderId;
    private int productID;
    private int quantity;
    private State state;

    public OrderModel(int orderId, int productID, int quantity, State state) {
        this.orderId = orderId;
        this.productID = productID;
        this.quantity = quantity;
        this.state = state;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "orderId=" + orderId +
                ", productID=" + productID +
                ", quantity=" + quantity +
                ", state='" + state + '\'' +
                '}';
    }
}
