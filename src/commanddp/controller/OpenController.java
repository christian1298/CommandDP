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
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author Christian
 */
public class OpenController implements ActionListener
{
  EditorView view;
  EditorModel model;
  public OpenController(EditorView view, EditorModel model)
  {
    this.view = view;
    this.model = model;
    
    
  }

  public void registerEvents()
  {
    view.getBtnOpen().addActionListener(this);
    view.getButtonOpen().addActionListener(this);
    view.getPmOpen().addActionListener(this);
  }
  
  @Override
  public void actionPerformed(ActionEvent e)
  {
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
      /*
      for(int i = 0; model.getRowCount() > i; i++)
      {
       for(int j = 0; model.getColumnCount() > j; j++)
       {
         
         if(model.getColumnCount() > view.getEditorTable().getColumnCount())
         {
           view.getEditorTable().addColumn(new TableColumn(j));
         }
         
         if(model.getRowCount() > view.getEditorTable().getRowCount())
        {
          view.getEditorTable().addRowSelectionInterval(j, i);
        }
        
         for(int k = 0 ; model.getColumnCount() > k ; k++)
         {
         view.getEditorTable().getTableHeader().getColumnModel().getColumn(k).setHeaderValue(model.getColumnName(k));
         }
         
         //view.getFileLabel().setText(model.getRowCount() + " " + model.getColumnCount());
         //view.getEditorTable().setValueAt(model.getValueAt(i,j), i, j);
         
       }
      }
      */
    }
  }
}
