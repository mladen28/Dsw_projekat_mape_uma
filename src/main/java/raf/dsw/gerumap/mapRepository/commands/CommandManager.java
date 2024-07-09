package raf.dsw.gerumap.mapRepository.commands;

import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.util.ArrayList;

public class CommandManager {

    private ArrayList<AbstractCommand> commands = new ArrayList<AbstractCommand>();
    private int currentCommand = 0;


    public void addCommand(AbstractCommand command) {
        while(currentCommand < commands.size())
            commands.remove(currentCommand);
        commands.add(command);
        doCommand();
    }


    public void doCommand() {
        if(currentCommand < commands.size()){
            commands.get(currentCommand++).doCommand();
            MainFrame.getInstance().getActionManager().getUndoCommandAction().setEnabled(true);
        }
        if(currentCommand==commands.size()){
            MainFrame.getInstance().getActionManager().getRedoCommandAction().setEnabled(false);
        }
    }

    public void undoCommand() {
        if(currentCommand > 0){
            MainFrame.getInstance().getActionManager().getRedoCommandAction().setEnabled(true);
            commands.get(--currentCommand).undoCommand();
        }
        if(currentCommand==0){
            MainFrame.getInstance().getActionManager().getUndoCommandAction().setEnabled(false);
        }
    }
}
