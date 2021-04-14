/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commanddp.controller.commands;

import commanddp.View.EditorView;
import commanddp.model.EditorModel;
import java.lang.reflect.Array;
import java.util.Stack;

/**
 *
 * @author Christian
 */
public class CommandDelete implements CommandInterface
{
  private EditorView view;
  private EditorModel model;
  private Stack<Object[]> stack;
  
  public CommandDelete(EditorView view, EditorModel model)
  {
    this.view = view;
    this.model = model;
    stack = new Stack();
  }

  @Override
  public void execute()
  {
    Object[] row = new Object[model.getColumnCount()];
    int selectedRow = view.getEditorTable().getSelectedRow();
    
    for(int i = 0; i < model.getColumnCount(); i++)
    {
       row[i] = model.getValueAt(selectedRow, i);
    }
    stack.push(row);
    model.eintragLoeschen(selectedRow);
  }

  @Override
  public void undo()
  {
    Object[] row = stack.pop();
    model.eintragHinzufuegen();
    
    for(int i = 0; i < model.getColumnCount(); i++)
    {
       model.setValueAt(row[i], model.getRowCount()- 1 , i);
    }
    
  }

  @Override
  public boolean isUndoable()
  {
    return true;
  }
}
