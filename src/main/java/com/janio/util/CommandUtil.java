package com.janio.util;


import com.janio.model.CommandModel;

import java.util.ArrayList;
import java.util.List;

public class CommandUtil {

    private static List<CommandModel> commands;

   static  {
       commands = new ArrayList<>();
       commands.add(new CommandModel("list", "l", "List all orders"));
       commands.add(new CommandModel("change_order_status", "cos", "Change the status of order. cos <order_id> approved e.g cos 1 approved"));
       commands.add(new CommandModel("next_transition", "nt", "Print the next possible transition for an order. nt <order_id> e.g nt 1"));
       commands.add(new CommandModel("Help", "h", "Print Help"));
       commands.add(new CommandModel("exit", "e", "Exit the application"));
   }

    public static String commandLookup(String command) {

        for(CommandModel  cmd: commands) {
            if(cmd.getCommand().equalsIgnoreCase(command) || cmd.getCommandAlias().equalsIgnoreCase(command)) {
                return cmd.getCommand();
           }
        }
        return null;
    }

    public static void printHelp() {
        String format = "%1s%-50s%1s%-10s%1s%-60s%1s\n";
        System.out.printf(format, "+", "==================================================", "+", "==========", "+", "============================================================", "+");
        System.out.printf(format, "|", "Command", "|", "Alias", "|", "Description", "|");
        System.out.printf(format, "+", "==================================================", "+", "==========", "+", "============================================================", "+");
        commands.forEach( (comamnd) -> {
            System.out.printf(format, "|", comamnd.getCommand(), "|", comamnd.getCommandAlias(), "|", comamnd.getDesc(), "|");
            System.out.printf(format, "+", "--------------------------------------------------", "+", "----------", "+", "------------------------------------------------------------", "+");
        });
       // System.out.printf(format, "+", "--------------------------------------------------", "+", "----------", "+", "------------------------------------------------------------", "+");
    }
}
