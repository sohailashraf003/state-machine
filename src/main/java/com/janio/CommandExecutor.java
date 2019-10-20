package com.janio;

import com.janio.service.OrderService;
import com.janio.util.CommandUtil;
import com.janio.util.State;

import java.util.List;


public class CommandExecutor {

    private OrderService orderService;


    public CommandExecutor(OrderService orderService) {

        this.orderService = orderService;
    }

    public void execute(final String[] args) throws IllegalArgumentException {


        try {
            validate(args);
            String command = CommandUtil.commandLookup(args[0].trim());
            if (command.equalsIgnoreCase("list")) {

                orderService.printAllOrders();

            } else if (command.equalsIgnoreCase("next_transition")) {

                List<State> possibleStates = orderService.getNextStateTrasitions(Integer.parseInt(args[1]));
                int count = 1;
                for(State state: possibleStates) {
                    System.out.println(count++ +". "+ state);
                }

            } else if(command.equalsIgnoreCase("change_order_status")) {
                try {
                    String state = args[2].toUpperCase();
                    orderService.updateOrderState(Integer.parseInt(args[1]), State.valueOf(state));
                } catch(Exception e) {
                    System.err.println("Invalid State: " + args[2]);
                }
            } else {
                System.out.println("Invalid Command");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Command");
        } catch (IllegalArgumentException ille) {
            System.err.println(ille.getMessage());
            System.out.println("Invalid Command");
        } catch (Exception ex) {
            System.err.println("Exception: " + ex.getMessage());
        }

    }


    private void validate(final String[] args) throws IllegalArgumentException {
        if (args == null) {
            throw new IllegalArgumentException("Please provide a valid command. Entered nothing");
        } else if (args.length == 0) {
            throw new IllegalArgumentException("Please provide a valid command. Entered nothing");
        } else if (args.length > 0) {
            String command = CommandUtil.commandLookup(args[0].trim());
            if (command == null) {
                throw new IllegalArgumentException("Invalid command");
            } else if (command.equalsIgnoreCase("list") && args.length != 1) {
                throw new IllegalArgumentException("Invalid command");
            } else if (command.equalsIgnoreCase("next_transition") && args.length != 2) {
                throw new IllegalArgumentException("Invalid command");
            } else if (command.equalsIgnoreCase("change_order_status") && args.length != 3) {
                throw new IllegalArgumentException("Invalid command");
            }
        }
    }

}
