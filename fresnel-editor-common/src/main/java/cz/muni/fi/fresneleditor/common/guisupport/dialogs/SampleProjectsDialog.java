/*
 * Fresnel Editor
 */

package cz.muni.fi.fresneleditor.common.guisupport.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cz.muni.fi.fresneleditor.common.guisupport.ExtendedJList;
import cz.muni.fi.fresneleditor.common.guisupport.MessageDialog;
import cz.muni.fi.fresneleditor.common.utils.SampleProjectsInitializer;
import javax.swing.JDialog;

/**
 * Dialog displays list of available sample projects and allows the user to load
 * one of them and try it out.
 * 
 * @author Miroslav Warchil (warmir@mail.muni.cz)
 */
public class SampleProjectsDialog extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form SampleProjectsDialog
	 */
	public SampleProjectsDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		initSampleProjectsList();
		self = this;
	}

	private void initSampleProjectsList() {

		ExtendedJList<String> projectsList = (ExtendedJList<String>) sampleProjectsList;

		projectsList.addElements(SampleProjectsInitializer
				.getAvailableSampleProjects());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {

		sampleProjectsLbl = new javax.swing.JLabel();
		sampleProjectsScrollPane = new javax.swing.JScrollPane();
		sampleProjectsList = new ExtendedJList<String>();
		openBtn = new javax.swing.JButton();
		cancelBtn = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application
				.getInstance(
						cz.muni.fi.fresneleditor.common.FresnelApplication.class)
				.getContext().getResourceMap(SampleProjectsDialog.class);
		setTitle(resourceMap.getString("Form.title")); // NOI18N
		setName("Form"); // NOI18N

		sampleProjectsLbl.setText(resourceMap
				.getString("sampleProjectsLbl.text")); // NOI18N
		sampleProjectsLbl.setName("sampleProjectsLbl"); // NOI18N

		sampleProjectsScrollPane.setName("sampleProjectsScrollPane"); // NOI18N

		sampleProjectsList.setName("sampleProjectsList"); // NOI18N
		sampleProjectsScrollPane.setViewportView(sampleProjectsList);

		openBtn.setText(resourceMap.getString("openBtn.text")); // NOI18N
		openBtn.setName("openBtn"); // NOI18N
		openBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				openBtnActionPerformed(evt);
			}
		});

		cancelBtn.setText(resourceMap.getString("cancelBtn.text")); // NOI18N
		cancelBtn.setName("cancelBtn"); // NOI18N
		cancelBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(sampleProjectsLbl)
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
																.addGroup(
																		layout.createSequentialGroup()
																				.addComponent(
																						cancelBtn,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						86,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(
																						openBtn,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						89,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addComponent(
																		sampleProjectsScrollPane,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		323,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(sampleProjectsLbl)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(sampleProjectsScrollPane,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(openBtn)
												.addComponent(cancelBtn))
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelBtnActionPerformed
		// Just close this dialog
		this.dispose();
	}// GEN-LAST:event_cancelBtnActionPerformed

	private void openBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_openBtnActionPerformed
		handleOpenSampleProjectAction();
	}// GEN-LAST:event_openBtnActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton cancelBtn;
	private javax.swing.JButton openBtn;
	private javax.swing.JLabel sampleProjectsLbl;
	private javax.swing.JList sampleProjectsList;
	private javax.swing.JScrollPane sampleProjectsScrollPane;
	// End of variables declaration//GEN-END:variables

	/**
	 * Another reference to "this" instance;
	 */
	private JDialog self = null;

	/**
	 * Action listeners which triggers openning of sample project after
	 * confirmation from the user.
	 */
	private class OpenSampleProjectActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			SampleProjectsInitializer.openProject((String) sampleProjectsList
					.getSelectedValue());
			self.dispose();
		}
	}

	private void handleOpenSampleProjectAction() {

		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application
				.getInstance(
						cz.muni.fi.fresneleditor.common.FresnelApplication.class)
				.getContext().getResourceMap(SampleProjectsDialog.class);

		// Check that some sample project was selected
		if (!sampleProjectsList.isSelectionEmpty()) {

			// Display confirmation message dialog
			MessageDialog messageDialog = new MessageDialog(this,
					resourceMap.getString("Confirmation"),
					resourceMap.getString("Confirmation_text"),
					new OpenSampleProjectActionListener());

			messageDialog.setVisible(true);
		}
	}
}
