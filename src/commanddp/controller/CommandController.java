/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commanddp.controller;

import commanddp.View.EditorView;
import commanddp.controller.commands.CommandDelete;
import commanddp.controller.commands.CommandInvoker;
import commanddp.controller.commands.CommandOpen;
import commanddp.controller.commands.CommandSave;
import commanddp.model.EditorModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Register Button listeners
 * @author Christian
 */
public class CommandController implements ActionListener
{
  private EditorView view;
  private EditorModel model;
  private CommandInvoker invoker;
  
  public CommandController(EditorView view, EditorModel model, CommandInvoker invoker)
  {
    this.view = view;
    this.model = model;
    this.invoker = invoker;
  }

  /**
   * Add EventListener to buttons
   */
  public void registerEvents()
  {
    view.getBtnOpen().addActionListener(this);
    view.getButtonOpen().addActionListener(this);
    view.getPmOpen().addActionListener(this);
    
    view.getBtnSave().addActionListener(this);
    view.getButtonSave().addActionListener(this);
    view.getPmSave().addActionListener(this);
    
    view.getPmDelete().addActionListener(this);
  }
  
  /**
   * Create Mapping from event source to executable function
   */
  public void registerCommands()
  {
    CommandOpen cmdOpen = new CommandOpen(view,model);
    CommandSave cmdSave = new CommandSave(view,model);
    CommandDelete cmdDelete = new CommandDelete(view,model);
    
    invoker.addCommand(view.getBtnOpen(), cmdOpen);
    invoker.addCommand(view.getButtonOpen(), cmdOpen);
    invoker.addCommand(view.getPmOpen(), cmdOpen);
    
    invoker.addCommand(view.getBtnSave(), cmdSave);
    invoker.addCommand(view.getButtonSave(), cmdSave);
    invoker.addCommand(view.getPmSave(), cmdSave);
    
    invoker.addCommand(view.getPmDelete(), cmdDelete);
  }
  
  /**
   * Execute function corresponding event source
   * @param e evt.getSource is the event source
   */
  
  @Override
  public void actionPerformed(ActionEvent e)
  {
    Object key = e.getSource();
    invoker.executeCommand(key);
  }
}
