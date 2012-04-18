/*
 *Fresnel Editor
 */

package cz.muni.fi.fresneleditor.common.reposconf;

import cz.muni.fi.fresneleditor.common.AppEventsManager;
import cz.muni.fi.fresneleditor.common.ContextHolder;
import cz.muni.fi.fresneleditor.common.config.AddRepositoryException;
import cz.muni.fi.fresneleditor.common.config.RepositoryConfiguration;
import cz.muni.fi.fresneleditor.common.guisupport.MessageDialog;
import cz.muni.fi.fresneleditor.common.utils.GuiUtils;
import cz.muni.fi.fresneleditor.model.IRepositoryConfiguration;

/**
 * 
 * @author Igor Zemsky (zemsky@mail.muni.cz)
 */
public class CreateNewRepositoryDialog extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates new form CreateNewRepositoryDialog */
	public CreateNewRepositoryDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		GuiUtils.centerOnScreen(this);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {

		cancelButton = new javax.swing.JButton();
		saveButton = new javax.swing.JButton();
		repositorySettingsJPanel = new cz.muni.fi.fresneleditor.common.reposconf.RepositorySettingsJPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application
				.getInstance(
						cz.muni.fi.fresneleditor.common.FresnelApplication.class)
				.getContext().getResourceMap(CreateNewRepositoryDialog.class);
		setTitle(resourceMap.getString("Form.title")); // NOI18N
		setName("Form"); // NOI18N

		cancelButton.setText(resourceMap.getString("cancelButton.text")); // NOI18N
		cancelButton.setName("cancelButton"); // NOI18N
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		saveButton.setText(resourceMap.getString("saveButton.text")); // NOI18N
		saveButton.setName("saveButton"); // NOI18N
		saveButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveButtonActionPerformed(evt);
			}
		});

		repositorySettingsJPanel.setName("repositorySettingsJPanel"); // NOI18N

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(542, Short.MAX_VALUE)
								.addComponent(cancelButton).addGap(18, 18, 18)
								.addComponent(saveButton).addContainerGap())
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(repositorySettingsJPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { cancelButton, saveButton });

		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(repositorySettingsJPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(saveButton)
												.addComponent(cancelButton))
								.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelButtonActionPerformed
		dispose();
	}// GEN-LAST:event_cancelButtonActionPerformed

	private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveButtonActionPerformed
		createNewRepository();
	}// GEN-LAST:event_saveButtonActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton cancelButton;
	private cz.muni.fi.fresneleditor.common.reposconf.RepositorySettingsJPanel repositorySettingsJPanel;
	private javax.swing.JButton saveButton;

	// End of variables declaration//GEN-END:variables

	private void createNewRepository() {
		RepositoryConfiguration conf = repositorySettingsJPanel
				.getRepositoryConfiguration();

		/*
		 * if (RepositoryType.HTTP.equals(conf.getType())) { new
		 * MessageDialog(this, "TBD",
		 * "The support for HTTP repository is not implemented yet"
		 * ).setVisible(true); return; }
		 */

		if (!validateRepositoryConfiguration(conf)) {
			// fixme igor; mark what is wrong!!
			return;
		}

		try {
			ContextHolder.getInstance().getApplicationConfiguration()
					.addRepositoryConfiguration(conf);
		} catch (AddRepositoryException e) {
			new MessageDialog(this, "Cannot create new repository",
					e.getMessage()).setVisible(true);
			return;
		}

		AppEventsManager.getInstance().fireRepositoriesChanagedEvent(this);
		dispose();
	}

	private boolean validateRepositoryConfiguration(
			IRepositoryConfiguration conf) {
		// fixme igor; mark what is wrong!!
		// TODO check the path for the repository?
		return true; // fixme igor: valid for all configurations (development
						// mode)
	}
}
