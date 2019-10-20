package com.janio.service;

import com.janio.model.OrderModel;
import com.janio.util.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    private StateMachineService stateMachineService = new StateMachineService();
    private Map<Integer, OrderModel> orders = new HashMap<>();

    {


        orders.put(1,new OrderModel(1,1, 2, State.PENDING));
        orders.put(2, new OrderModel(2,5, 6, State.PENDING));
        orders.put(3, new OrderModel(3,6, 1, State.PENDING));
        orders.put(4, new OrderModel(5,12, 4, State.PENDING));
        orders.put(5, new OrderModel(6,14, 10, State.PENDING));
        orders.put(6, new OrderModel(7,17, 20, State.PENDING));
    }

    public void printAllOrders() {
        System.out.printf("%-1s%-50s%-1s", "+", "----------------------------------------------------------", "+\n");
        System.out.printf("%-1s%-10s%-1s%-15s%-1s%-15s%-1s%-15s%-1s", "|", "Order ID", "|",  "Product ID", "|", "Quantity", "|", "State", "|\n");
        System.out.printf("%-1s%-50s%-1s", "+", "----------------------------------------------------------", "+\n");
        orders.forEach( (key, order) -> {
            System.out.printf("%-1s%-10s%-1s%-15s%-1s%-15s%-1s%-15s%-1s", "|", order.getOrderId(), "|", order.getProductID(), "|", order.getQuantity(), "|", order.getState(), "|\n");
            System.out.printf("%-1s%-10s%-1s%-15s%-1s%-15s%-1s%-15s%-1s", "+", "----------", "+",  "---------------", "+", "---------------", "+", "---------------", "+\n");
        });
    }

    public void changeState(int orderID, State nextState) {

        OrderModel order = orders.get(orderID);

        if(orderID == 0 || orders.get(orderID) == null)
            throw new IllegalArgumentException("Invalid order ID");

        State currentState = order.getState();
        List<State> possibleStates = stateMachineService.getPossibleTransitions(currentState);
        System.out.println(possibleStates);



    }

    public List<State> getNextStateTrasitions(int orderID) {
        OrderModel order = orders.get(orderID);

        if(orderID == 0 || orders.get(orderID) == null)
            throw new IllegalArgumentException("Invalid order ID");

        State currentState = order.getState();
        List<State> possibleStates = stateMachineService.getPossibleTransitions(currentState);
        return possibleStates;
    }

    public void updateOrderState(int orderID, State state) {

        OrderModel order = orders.get(orderID);

        if(orderID == 0 || orders.get(orderID) == null)
            throw new IllegalArgumentException("Invalid order ID");
        else if(state == null)
            throw new IllegalArgumentException("Invalid order ID");

        List<State> possibleStates = getNextStateTrasitions(orderID);
        if(possibleStates.contains(state)){
            order.setState(state);
            orders.put(orderID,order);
            System.out.println("Order updated successfully");
        } else{
            System.out.println("Invalid State");
            System.out.println();
            System.out.println("Possible States");
            int count = 1;
            for(State st: possibleStates) {
                System.out.println(count++ +". "+ st);
            }
        }


    }


}
