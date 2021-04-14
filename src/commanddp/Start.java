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
 * Die Startklasse realisiert das DP "Builder"
 */
public class Start 
{
  public Start()
  {
  EditorView fenster = new EditorView();
  EditorModel model = new EditorModel();
  CommandInvoker invoker = new CommandInvoker();
  
  fenster.getEditorTable().setModel(model);
  CommandController ctrlCommand = new CommandController(fenster, model, invoker);
  UndoController ctrlUndo = new UndoController(fenster, model, invoker);
  
  ctrlCommand.registerEvents();
  ctrlCommand.registerCommands();
  
  ctrlUndo.registerEvents();
    
  fenster.setVisible(true);
  }

  public static void main(String[] args) 
  {
    new Start();
  }

}
