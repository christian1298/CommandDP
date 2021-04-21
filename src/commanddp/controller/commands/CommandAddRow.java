/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commanddp.controller.commands;

import commanddp.View.EditorView;
import commanddp.model.EditorModel;
import java.io.File;
import javax.swing.JFileChooser;

/**
 * Open File and insert data into JTable
 * @author Christian
 */
public class CommandAddRow implements CommandInterface
{
  private EditorView view;
  private EditorModel model;
  public CommandAddRow(EditorView view, EditorModel model)
  {
    this.view = view;
    this.model = model;
  }

  /**
   * Opens a File from Disc and includes data into JTable
   */
  @Override
  public void execute()
  {
    model.eintragHinzufuegen();
    
    for(int i = 0; i < model.getColumnCount(); i++)
    {
      model.setValueAt( " " , model.getRowCount()- 1 , i);
    }
    
  }

  @Override
  public void undo()
  {
    model.eintragLoeschen(model.getRowCount()-1);
  }

   /**
   * @return Returns true if function can be undone
   */
  @Override
  public boolean isUndoable()
  {
    return true;
  }
}
