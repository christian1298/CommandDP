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
public class CommandSave implements CommandInterface
{
  private EditorView view;
  private EditorModel model;
  public CommandSave(EditorView view, EditorModel model)
  {
    this.view = view;
    this.model = model;
  }

  @Override
  public void execute()
  {
    JFileChooser fc = view.getFcOpenSave();
    int choice = fc.showOpenDialog(view);
    if(choice == JFileChooser.APPROVE_OPTION)
    {
      File f = fc.getSelectedFile();
      
      for(int i = 0; view.getEditorTable().getRowCount() > i; i++)
      {
       for(int j = 0; view.getEditorTable().getColumnCount() > j; j++)
       {
         //model.spalteHinzufuegen(view.getEditorTable().getValueAt(i, j).toString());
         model.eintragHinzufuegen();
         view.getFileLabel().setText(view.getEditorTable().getRowCount() + " " + view.getEditorTable().getColumnCount());
         //view.getFileLabel().setText(model.getRowCount() + " " + model.getColumnCount());
         //view.getEditorTable().setValueAt(model.getValueAt(i,j), i, j);
       }
      }      
      
      try
      {
        model.datenSpeichern(f);
      }
      catch (Exception ex)
      {
        view.getFileLabel().setText(ex.toString());
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
