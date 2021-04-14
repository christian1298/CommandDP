/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commanddp.controller;

import commanddp.View.EditorView;
import commanddp.controller.commands.CommandDelete;
import commanddp.controller.commands.CommandInvoker;
import commanddp.model.EditorModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Christian
 */
public class UndoController implements ActionListener
{
  private EditorView view;
  private EditorModel model;
  private CommandInvoker invoker;
  
  public UndoController(EditorView view, EditorModel model, CommandInvoker invoker)
  {
    this.view = view;
    this.model = model;
    this.invoker = invoker;
  }

  public void registerEvents()
  {
    view.getBtnUndo().addActionListener(this);
    view.getButtonUndo().addActionListener(this);
    view.getPmUndo().addActionListener(this);
  }
  
  @Override
  public void actionPerformed(ActionEvent e)
  {
    invoker.undoCommand();
  }
}
