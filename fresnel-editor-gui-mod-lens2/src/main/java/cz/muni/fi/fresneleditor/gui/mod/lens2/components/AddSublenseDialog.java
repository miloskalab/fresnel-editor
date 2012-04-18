/*
 * Fresnel Editor
 */

package cz.muni.fi.fresneleditor.gui.mod.lens2.components;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openrdf.model.URI;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import cz.muni.fi.fresneleditor.common.ContextHolder;
import cz.muni.fi.fresneleditor.common.utils.GuiUtils;

/**
 * 
 * 
 * @author Igor Zemsky (zemsky@mail.muni.cz)
 */
public class AddSublenseDialog extends javax.swing.JDialog {

	private PropertyConfigurationPanel confPanel;

	/**
	 * Creates new form AddSublenseDialog
	 */
	public AddSublenseDialog(PropertyConfigurationPanel confPanel) {
		super(GuiUtils.getOwnerFrame(confPanel), true); // always create a modal
														// dialog
		initComponents();
		this.confPanel = confPanel;
		refreshSublensesList();
		GuiUtils.centerOnScreen(this);
	}

	/**
	 * Load available lenses from repository
	 */
	private void refreshSublensesList() {
		List<URI> lenses = ContextHolder.getInstance()
				.getFresnelRepositoryDao().getLensURIs();

		final Set<URI> alreadyUsedLenses = new HashSet<URI>(
				confPanel.getSublenses());

		// do not display lenses that are already assigned to this configuration
		List<URI> notUsedLenses = new ArrayList<URI>(Collections2.filter(
				lenses, new Predicate<URI>() {
					@Override
					public boolean apply(URI input) {
						return !alreadyUsedLenses.contains(input);
					}
				}));
		lensesJList.setElements(notUsedLenses);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {

		addBtn = new javax.swing.JButton();
		cancelBtn = new javax.swing.JButton();
		sublensesJPanel = new javax.swing.JPanel();
		sublensesJScrollPane = new javax.swing.JScrollPane();
		lensesJList = new cz.muni.fi.fresneleditor.common.guisupport.components.UrisJList();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application
				.getInstance().getContext()
				.getResourceMap(AddSublenseDialog.class);
		setTitle(resourceMap.getString("Form.title")); // NOI18N
		setModal(true);
		setName("Form"); // NOI18N

		addBtn.setText(resourceMap.getString("addBtn.text")); // NOI18N
		addBtn.setName("addBtn"); // NOI18N
		addBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addBtnActionPerformed(evt);
			}
		});

		cancelBtn.setText(resourceMap.getString("cancelBtn.text")); // NOI18N
		cancelBtn.setName("cancelBtn"); // NOI18N
		cancelBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelBtnActionPerformed(evt);
			}
		});

		sublensesJPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder(resourceMap
						.getString("sublensesJPanel.border.title"))); // NOI18N
		sublensesJPanel.setName("sublensesJPanel"); // NOI18N

		sublensesJScrollPane.setName("sublensesJScrollPane"); // NOI18N

		lensesJList.setFont(resourceMap.getFont("lensesJList.font")); // NOI18N
		lensesJList.setName("lensesJList"); // NOI18N
		sublensesJScrollPane.setViewportView(lensesJList);

		javax.swing.GroupLayout sublensesJPanelLayout = new javax.swing.GroupLayout(
				sublensesJPanel);
		sublensesJPanel.setLayout(sublensesJPanelLayout);
		sublensesJPanelLayout
				.setHorizontalGroup(sublensesJPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								sublensesJPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												sublensesJScrollPane,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												385, Short.MAX_VALUE)
										.addContainerGap()));
		sublensesJPanelLayout
				.setVerticalGroup(sublensesJPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								sublensesJPanelLayout
										.createSequentialGroup()
										.addComponent(
												sublensesJScrollPane,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												138, Short.MAX_VALUE)
										.addContainerGap()));

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
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(
														sublensesJPanel,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		cancelBtn,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		74,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		addBtn,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		74,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(6, 6, 6)
								.addComponent(sublensesJPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(11, 11, 11)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(cancelBtn)
												.addComponent(addBtn))
								.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelBtnActionPerformed
		// hide the dialog only
		userClose();
	}// GEN-LAST:event_cancelBtnActionPerformed

	private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addBtnActionPerformed
		confPanel.addSublenses(lensesJList.getSelectedValuesCasted());
		userClose();
	}// GEN-LAST:event_addBtnActionPerformed

	private void userClose() {
		dispose();
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton addBtn;
	private javax.swing.JButton cancelBtn;
	private cz.muni.fi.fresneleditor.common.guisupport.components.UrisJList lensesJList;
	private javax.swing.JPanel sublensesJPanel;
	private javax.swing.JScrollPane sublensesJScrollPane;
	// End of variables declaration//GEN-END:variables

}
