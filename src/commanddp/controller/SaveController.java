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
public class SaveController implements ActionListener
{
  EditorView view;
  EditorModel model;
  public SaveController(EditorView view, EditorModel model)
  {
    this.view = view;
    this.model = model;
    
    
  }

  public void registerEvents()
  {
    view.getBtnSave().addActionListener(this);
    view.getButtonSave().addActionListener(this);
    view.getPmSave().addActionListener(this);
  }
  
  @Override
  public void actionPerformed(ActionEvent e)
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
}
