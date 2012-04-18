/*
 * Fresnel Editor
 */

package cz.muni.fi.fresneleditor.common.reposconf;

import java.awt.Frame;

import cz.muni.fi.fresneleditor.common.reposconf.DataManipulationJPanel.DataManipulationType;
import cz.muni.fi.fresneleditor.common.utils.GuiUtils;
import cz.muni.fi.fresneleditor.model.BaseRepositoryDao;

/**
 * 
 * @author Igor Zemsky (zemsky@mail.muni.cz)
 */
public class DataManipulationJDialog extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final BaseRepositoryDao repositoryDao;
	private final DataManipulationType dataManipulationType;

	public DataManipulationJDialog(Frame ownerFrame, boolean modal,
			BaseRepositoryDao repository, DataManipulationType type) {
		super(ownerFrame, modal);
		this.repositoryDao = repository;
		this.dataManipulationType = type;

		initComponents();

		GuiUtils.centerOnScreen(this);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// set correct label
		String action = "";
		switch (type) {
		case DELETE:
			action = " delete data";
			break;
		case EXPORT:
			action = " export data";
			break;
		case IMPORT:
			action = " import data";
			break;
		default:
			throw new ArrayIndexOutOfBoundsException();
		}
		setTitle(repository.getName() + action);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {

		dataManipulationJPanel = new cz.muni.fi.fresneleditor.common.reposconf.DataManipulationJPanel(
				repositoryDao, dataManipulationType);

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setModal(true);
		setName("Form"); // NOI18N
		setResizable(false);

		dataManipulationJPanel.setName("dataManipulationJPanel"); // NOI18N

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				dataManipulationJPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				dataManipulationJPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private cz.muni.fi.fresneleditor.common.reposconf.DataManipulationJPanel dataManipulationJPanel;
	// End of variables declaration//GEN-END:variables

}
