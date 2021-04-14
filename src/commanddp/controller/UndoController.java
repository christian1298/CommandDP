/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commanddp.controller;

import commanddp.View.EditorView;
import commanddp.model.EditorModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Christian
 */
public class UndoController implements ActionListener
{
  EditorView view;
  EditorModel model;
  public UndoController(EditorView view, EditorModel model)
  {
    this.view = view;
    this.model = model;
  }

  public void registerEvents()
  {
  }
  
  @Override
  public void actionPerformed(ActionEvent e)
  {
    
  }
}
