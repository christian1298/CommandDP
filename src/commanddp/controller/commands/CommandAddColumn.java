/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commanddp.controller.commands;

import commanddp.View.EditorView;
import commanddp.model.EditorModel;
import javax.swing.table.TableColumn;

/**
 * Open File and insert data into JTable
 * @author Christian
 */
public class CommandAddColumn implements CommandInterface
{
  private EditorView view;
  private EditorModel model;
  public CommandAddColumn(EditorView view, EditorModel model)
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
    
    view.getEditorTable().addColumn(new TableColumn());
    
    
    view.getEditorTable().getColumnModel().getColumn(view.getEditorTable().getColumnCount() - 1).setHeaderValue(" ");
    
    for(int i = 1; i < model.getRowCount(); i++)
    {
      model.setValueAt( " " , i, view.getEditorTable().getColumnCount()-1);
    }
  }

  @Override
  public void undo()
  {
    /*
    model.eintragLoeschen(model.getRowCount()-1);
    */
  }

   /**
   * @return Returns true if function can be undone
   */
  @Override
  public boolean isUndoable()
  {
    return false;
  }
}
