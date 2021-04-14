/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commanddp.controller.commands;

import commanddp.View.EditorView;
import commanddp.model.EditorModel;

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
