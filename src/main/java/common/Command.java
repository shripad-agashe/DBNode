package common;

public class Command {

    private String commandClass;

    static final long serialVersionUID = 1L;
    public Command(String commandClass, byte[] command) {
        this.commandClass = commandClass;
        this.command = command;
    }

    private byte[] command;

    public String getCommandClass() {
        return commandClass;
    }

    public byte[] getCommand() {
        return command;
    }
}
