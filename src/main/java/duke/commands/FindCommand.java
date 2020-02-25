package duke.commands;

import duke.task.Task;

import static duke.Duke.tasks;

import java.util.ArrayList;

public class FindCommand extends Command {
    
    public static final String COMMAND_WORD = "find";
    private static final String COMMAND_FIND_DESC = "Finds the list of tasks using a specific keyword";
    private static final String COMMAND_FIND_PARAMETER = "KEYWORD";
    private static final String COMMAND_FIND_EXAMPLE = COMMAND_WORD + " book";
    
    public static final String MESSAGE_USAGE =
            String.format(MESSAGE_COMMAND_HELP, COMMAND_WORD, COMMAND_FIND_DESC) + LS +
                    String.format(MESSAGE_COMMAND_HELP_PARAMETER, COMMAND_FIND_PARAMETER) + LS +
                    String.format(MESSAGE_COMMAND_HELP_EXAMPLE, COMMAND_FIND_EXAMPLE) + LS;
    
    private static final String COMMAND_FIND_MESSAGE = "Here are the matching tasks in your list:";
    
    private static final String COMMAND_NO_FIND_MESSAGE = "There are no matching tasks in your list:";
    
    private String description;
    
    private ArrayList<Task> foundList = new ArrayList<>();
    
    public FindCommand(String description) {
        this.description = description;
    }
    
    @Override
    public CommandResult execute() {
        for (int i = 0; i < tasks.size(); ++i) {
            if (tasks.get(i).toString().contains(description)) {
                foundList.add(tasks.get(i));
            }
        }
        
        if (foundList.isEmpty()) {
            return new CommandResult(DIVIDER + LS + COMMAND_NO_FIND_MESSAGE + LS + DIVIDER);
        }
        StringBuilder output = new StringBuilder();
        output.append(LS).append(COMMAND_FIND_MESSAGE).append(LS);
        for (int i = 0; i < foundList.size(); ++i) {
            output.append(i + 1).append(".").append(foundList.get(i)).append(LS);
        }
        return new CommandResult(DIVIDER + output + DIVIDER);
        
    }
    
}