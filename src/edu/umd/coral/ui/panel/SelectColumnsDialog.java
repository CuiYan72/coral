/*******************************************************************************
 * Copyright (c) 2012 Darya Filippova.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Darya Filippova - initial API and implementation
 ******************************************************************************/
package edu.umd.coral.ui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Group;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.umd.coral.model.DataModel;
import edu.umd.coral.ui.table.ClusteringCompareTableModel;
import edu.umd.coral.ui.table.Vertex2VertexTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SelectColumnsDialog.java
 *
 * Created on Nov 6, 2011, 6:39:44 PM
 */

/**
 * 
 * @author lynxoid
 */
public class SelectColumnsDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 5381034022442137695L;

	private DataModel model;
	
	String tableName;
	
	ArrayList<String> selectedColumns;
	
	ArrayList<JCheckBox> checkboxes =  new ArrayList<JCheckBox>();
	
	/** Creates new form SelectColumnsDialog */
	public SelectColumnsDialog(DataModel model, ArrayList<String> columns, String tableName) {
		this.model = model;
		this.tableName = tableName;
		selectedColumns = getColumnNames(tableName);
//		selectedColumns = new ArrayList<String>();
		initComponents(columns);
	}
	
	private ArrayList<String> getColumnNames(String tableName) {
		if (tableName.equals(Vertex2VertexTableModel.V2V_TABLE)) {
			return model.getVertexTableColumns();
		}
		else if (tableName.equals(ClusteringCompareTableModel.C2C_TABLE)) {
			return model.getModuleTableColumns();
		}
		return new ArrayList<String>();
	}
	
	private void setColumnNames(String tableName, ArrayList<String> names) {
		if (tableName.equals(Vertex2VertexTableModel.V2V_TABLE)) {
			model.setVertexTableColumns(names);
		}
		else if (tableName.equals(ClusteringCompareTableModel.C2C_TABLE)) {
			model.setModuleTableColumns(names);
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 * @param columnNames 
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents(ArrayList<String> columns) {

		jLabel1 = new JLabel();
		
		jButton1 = new JButton();
		jButton2 = new JButton();
		
		JCheckBox checkbox;
		for (String s : columns) {
			checkbox = new JCheckBox();
			checkbox.setText(s);
			if (this.selectedColumns.contains(s))
				checkbox.setSelected(true);
			checkbox.addActionListener(this);
			checkboxes.add(checkbox);
		}

		
//		jScrollPane1 = new JScrollPane();

		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		jLabel1.setText("Select columns to show in a table:");		

		jButton1.setText("Show");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Cancel");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(layout
			.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(
				layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(createInsideParalleGroup(layout))
						.addContainerGap()));
		
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(createSequentialGroup(layout)));

		pack();
	}// </editor-fold>

	private Group createSequentialGroup(GroupLayout layout) {		
		SequentialGroup sg = layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jLabel1);
		
		for (JCheckBox c : checkboxes)
			sg.addPreferredGap(
				LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(c);
				
				sg.addGap(18, 18, 18)
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE)
								.addComponent(jButton1)
								.addComponent(jButton2))
				.addPreferredGap(
						LayoutStyle.ComponentPlacement.UNRELATED)
//				.addComponent(jScrollPane1,
//						GroupLayout.PREFERRED_SIZE,
//						275,
//						GroupLayout.PREFERRED_SIZE)
				.addContainerGap(
						GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE);
				
		return sg;
	}

	private ParallelGroup createInsideParalleGroup(GroupLayout layout) {
		ParallelGroup pg = layout.createParallelGroup(
		GroupLayout.Alignment.LEADING)
		.addComponent(jLabel1);
	
	for (JCheckBox c : checkboxes)
		pg.addComponent(c);

		pg.addGroup(
			GroupLayout.Alignment.TRAILING,
			layout.createSequentialGroup()
			.addComponent(
													jButton2)
											.addGap(18, 18,
													18)
											.addComponent(
													jButton1));
//							.addComponent(
//									jScrollPane1,
//									GroupLayout.Alignment.TRAILING,
//									GroupLayout.DEFAULT_SIZE,
//									376, Short.MAX_VALUE);
		return pg;
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		setColumnNames(tableName, selectedColumns);
		close();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// close the window
		close();
	}
	
	private void close() {
		super.setVisible(false);
		this.dispose();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(
					SelectColumnsDialog.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(
					SelectColumnsDialog.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(
					SelectColumnsDialog.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(
					SelectColumnsDialog.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				ArrayList<String> list = new ArrayList<String>();
				list.add("a");list.add("b");list.add("c");
				list.add("d");list.add("e");list.add("f");
				new SelectColumnsDialog(null, list, "").setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private JButton jButton1;
	private JButton jButton2;
//	private JCheckBox jCheckBox1;
//	private JCheckBox jCheckBox2;
	private JLabel jLabel1;
	// End of variables declaration

	
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() instanceof JCheckBox) {
			JCheckBox check = (JCheckBox)evt.getSource();
			if (check.isSelected() )
				this.selectedColumns.add(check.getText());
			else
				this.selectedColumns.remove(check.getText());
			
			//System.out.println(selectedColumns);
		}
	}
}