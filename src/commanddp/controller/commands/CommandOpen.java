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
 *
 * @author Christian
 */
public class CommandOpen implements CommandInterface
{
  private EditorView view;
  private EditorModel model;
  public CommandOpen(EditorView view, EditorModel model)
  {
    this.view = view;
    this.model = model;
  }

  @Override
  public void execute()
  {
    //Preferences
    JFileChooser fc = view.getFcOpenSave();
    int choice = fc.showOpenDialog(view);
    if(choice == JFileChooser.APPROVE_OPTION)
    {
      File f = fc.getSelectedFile();
      view.getFileLabel().setText("File: " + f.getAbsolutePath());
      
      try
      {
        model.datenLesen(f);
      }
      catch (Exception ex)
      {
        view.getFileLabel().setText(ex.toString());
      }
      
      for(int i = 0; model.getRowCount() > i; i++)
      {
       for(int j = 0; model.getColumnCount() > j; j++)
       {
         view.getFileLabel().setText(model.getRowCount() + " " + model.getColumnCount());
         view.getEditorTable().setValueAt(model.getValueAt(i,j), i, j);
         
       }
      }
    }
  }

  @Override
  public void undo()
  {
  }

  @Override
  public boolean isUndoable()
  {
    return false;
  }
}
