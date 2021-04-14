/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commanddp.controller;

import commanddp.View.EditorView;
import commanddp.controller.commands.CommandInvoker;
import commanddp.controller.commands.CommandOpen;
import commanddp.controller.commands.CommandSave;
import commanddp.model.EditorModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
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

  public void registerEvents()
  {
    view.getBtnOpen().addActionListener(this);
    view.getButtonOpen().addActionListener(this);
    view.getPmOpen().addActionListener(this);
    
    view.getBtnSave().addActionListener(this);
    view.getButtonSave().addActionListener(this);
    view.getPmSave().addActionListener(this);
  }
  
  public void registerCommands()
  {
    CommandOpen cmdOpen = new CommandOpen(view,model);
    CommandSave cmdSave = new CommandSave(view,model);
    
    invoker.addCommand(view.getBtnOpen(), cmdOpen);
    invoker.addCommand(view.getButtonOpen(), cmdOpen);
    invoker.addCommand(view.getPmOpen(), cmdOpen);
    
    invoker.addCommand(view.getBtnSave(), cmdOpen);
    invoker.addCommand(view.getButtonSave(), cmdOpen);
    invoker.addCommand(view.getPmSave(), cmdOpen);
  }
  
  /**
   * Polymorphismus!! zur entscheidung welche Aktion durchgefürht wird
   * @param e evt.getSource liefert Eventquelle als key für Hashmap im invoker
   */
  
  @Override
  public void actionPerformed(ActionEvent e)
  {
    Object key = e.getSource();
    invoker.executeCommand(key);
  }
}
