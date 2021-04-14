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
      
      view.getEditorTable().setModel(model);
      
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
