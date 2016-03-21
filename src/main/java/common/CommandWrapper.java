package common;

public class CommandWrapper {

    private String commandClass;

    static final long serialVersionUID = 1L;
    public CommandWrapper(String commandClass, byte[] command, int length) {
        this.commandClass = commandClass;
        this.contentLength = length;
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
