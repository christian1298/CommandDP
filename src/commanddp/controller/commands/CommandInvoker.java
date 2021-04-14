/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commanddp.controller.commands;

import java.util.HashMap;
import java.util.Stack;

/**
 *  Map Event sources to functions
 * @author Christian
 */
public class CommandInvoker 
{
  private HashMap<Object, CommandInterface> commands;
  private Stack<CommandInterface> undoStack;
  
  public CommandInvoker()
  {
    commands = new HashMap<>();
    undoStack = new Stack();
  }
  
  /**
   * Add function to the database of functions
   * @param key Event Source
   * @param value Function to be executed on event trigger
   */
  public void addCommand(Object key, CommandInterface value)
  {
    commands.put(key, value);
  }
  
  /**
   * Execute function
   * @param key function to be executed
   */
  public void executeCommand(Object key)
  {
    commands.get(key).execute();
    if(commands.get(key).isUndoable())
    {
      undoStack.push(commands.get(key));
    }
  }
  
  /**
   * Pop undoStack and undo last function
   */
  public void undoCommand()
  {
    
    if(!undoStack.empty())
    {
      undoStack.pop().undo();
    }
    
  }
}
