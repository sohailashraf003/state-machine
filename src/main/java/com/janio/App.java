package com.janio;

import com.janio.service.OrderService;
import com.janio.util.CommandUtil;

import java.util.Scanner;

public class App {

    private static CommandExecutor commandExecutor;
    public static void main(String[] args) {

        commandExecutor = new CommandExecutor(new OrderService());
        CommandUtil.printHelp();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your command");
        while(true) {
            String command = scanner.nextLine();
            if(command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("e")) {
                System.exit(0);
            } else if(command.equalsIgnoreCase("help") || command.equalsIgnoreCase("h")) {
                CommandUtil.printHelp();
            } else {
                String[] commandArgs = command.split(" ");
                try{
                    commandExecutor.execute(commandArgs);
                } catch(Exception e) {

                }

            }
            System.out.println();
            System.out.println("Please enter your command");
        }

    }
}
