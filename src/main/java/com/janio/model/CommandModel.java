package com.janio.model;

public class CommandModel {

    private String command;
    private String commandAlias;

    public CommandModel(String command, String commandAlias, String desc) {
        this.command = command;
        this.commandAlias = commandAlias;
        this.desc = desc;
    }

    private String desc;



    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommandAlias() {
        return commandAlias;
    }

    public void setCommandAlias(String commandAlias) {
        this.commandAlias = commandAlias;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
