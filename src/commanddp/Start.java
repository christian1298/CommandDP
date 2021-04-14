/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commanddp;

import commanddp.View.EditorView;
import commanddp.controller.CommandController;
import commanddp.controller.UndoController;
import commanddp.controller.commands.CommandInvoker;
import commanddp.model.EditorModel;


/**
 *
 * @author Christian
 */
public class Start 
{
  public Start()
  {
  EditorView Fenster = new EditorView();
  EditorModel Model = new EditorModel();
  CommandInvoker invoker = new CommandInvoker();
  
  CommandController ctrlCommand = new CommandController(Fenster, Model, invoker);
  UndoController ctrlUndo = new UndoController(Fenster, Model);
  
  ctrlCommand.registerEvents();
  ctrlCommand.registerCommands();
  
  ctrlUndo.registerEvents();
    
  Fenster.setVisible(true);
  }

  public static void main(String[] args) 
  {
    new Start();
  }

}
