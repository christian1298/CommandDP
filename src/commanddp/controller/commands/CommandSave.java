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
 * Save JTable data on disc
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

  /**
   * Saves data from a JTable into a file on disc
   */
  @Override
  public void execute()
  {
    JFileChooser fc = view.getFcOpenSave();
    int choice = fc.showSaveDialog(view);
    if(choice == JFileChooser.APPROVE_OPTION)
    {
      File f = fc.getSelectedFile();
      
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

   /**
   * @return Returns true if function can be undone
   */
  @Override
  public boolean isUndoable()
  {
    return false;
  }
}
