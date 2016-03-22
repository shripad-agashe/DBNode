package common;

public class CommandWrapper {

    private final int contentLength;
    private String commandClass;
    private byte[] command;

    static final long serialVersionUID = 1L;

    public CommandWrapper(String commandClass, byte[] command, int length) {
        this.commandClass = commandClass;
        this.contentLength = length;
        this.command = command;
    }



    public String getCommandClass() {
        return commandClass;
    }

    public byte[] getCommand() {
        return command;
    }
}
