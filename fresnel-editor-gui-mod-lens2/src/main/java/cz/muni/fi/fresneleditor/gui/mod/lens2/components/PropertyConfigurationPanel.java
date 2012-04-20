/*
 * PropertyConfigurationPanel.java
 *
 * Created on 16 November 2008, 20:11
 */

package cz.muni.fi.fresneleditor.gui.mod.lens2.components;

import java.util.Collections;
import java.util.List;

import javax.swing.border.TitledBorder;

import org.openrdf.model.URI;
import org.springframework.util.Assert;

import cz.muni.fi.fresneleditor.gui.mod.lens2.PropertyVisibilityWrapper;

/**
 * 
 * @author Igor Zemsky (zemsky@mail.muni.cz)
 */
public class PropertyConfigurationPanel extends javax.swing.JPanel {

	/** Creates new form PropertyConfigurationPanel */
	public PropertyConfigurationPanel() {
		initComponents();
		((TitledBorder) getBorder()).setTitle("Property details");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		sublensesLbl = new javax.swing.JLabel();
		groupFormatsLbl = new javax.swing.JLabel();
		addSublenseBtn = new javax.swing.JButton();
		removeSublenseBtn = new javax.swing.JButton();
		maxDepthLbl = new javax.swing.JLabel();
		maxDepthSpinner = new javax.swing.JSpinner();
		configureGroupBtn = new javax.swing.JButton();
		useLabel = new cz.muni.fi.fresneleditor.gui.mod.lens2.components.FresnelUseLabel();
		sublensesScrollPane = new javax.swing.JScrollPane();
		sublensesList = new cz.muni.fi.fresneleditor.common.guisupport.components.UrisJList();

		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application
				.getInstance().getContext()
				.getResourceMap(PropertyConfigurationPanel.class);
		setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap
				.getString("Form.border.title"))); // NOI18N
		setName("Form"); // NOI18N

		sublensesLbl.setFont(resourceMap.getFont("addSublenseBtn.font")); // NOI18N
		sublensesLbl.setText(resourceMap.getString("sublensesLbl.text")); // NOI18N
		sublensesLbl.setName("sublensesLbl"); // NOI18N

		groupFormatsLbl.setFont(resourceMap.getFont("addSublenseBtn.font")); // NOI18N
		groupFormatsLbl.setText(resourceMap.getString("groupFormatsLbl.text")); // NOI18N
		groupFormatsLbl.setName("groupFormatsLbl"); // NOI18N

		addSublenseBtn.setFont(resourceMap.getFont("addSublenseBtn.font")); // NOI18N
		addSublenseBtn.setText(resourceMap.getString("addSublenseBtn.text")); // NOI18N
		addSublenseBtn.setName("addSublenseBtn"); // NOI18N
		addSublenseBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addSublenseBtnActionPerformed(evt);
			}
		});

		removeSublenseBtn.setFont(resourceMap.getFont("addSublenseBtn.font")); // NOI18N
		removeSublenseBtn.setText(resourceMap
				.getString("removeSublenseBtn.text")); // NOI18N
		removeSublenseBtn.setEnabled(false);
		removeSublenseBtn.setName("removeSublenseBtn"); // NOI18N
		removeSublenseBtn
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						removeSublenseBtnActionPerformed(evt);
					}
				});

		maxDepthLbl.setFont(resourceMap.getFont("addSublenseBtn.font")); // NOI18N
		maxDepthLbl.setText(resourceMap.getString("maxDepthLbl.text")); // NOI18N
		maxDepthLbl.setName("maxDepthLbl"); // NOI18N

		maxDepthSpinner.setName("maxDepthSpinner"); // NOI18N

		configureGroupBtn.setFont(resourceMap.getFont("addSublenseBtn.font")); // NOI18N
		configureGroupBtn.setText(resourceMap
				.getString("configureGroupBtn.text")); // NOI18N
		configureGroupBtn.setName("configureGroupBtn"); // NOI18N
		configureGroupBtn
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						configureGroupBtnActionPerformed(evt);
					}
				});

		useLabel.setFont(resourceMap.getFont("useLabel.font")); // NOI18N
		useLabel.setName("useLabel"); // NOI18N

		sublensesScrollPane.setName("sublensesScrollPane"); // NOI18N

		sublensesList.setName("sublensesList"); // NOI18N
		sublensesList
				.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							javax.swing.event.ListSelectionEvent evt) {
						sublensesListValueChanged(evt);
					}
				});
		sublensesScrollPane.setViewportView(sublensesList);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						sublensesLbl)
																				.addComponent(
																						sublensesScrollPane,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						347,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						addSublenseBtn,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						removeSublenseBtn,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						87,
																						Short.MAX_VALUE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		useLabel,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addGap(200,
																		200,
																		200))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		groupFormatsLbl)
																.addGap(10, 10,
																		10)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										maxDepthLbl)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										maxDepthSpinner,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										43,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addComponent(
																						configureGroupBtn))))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(sublensesLbl)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		addSublenseBtn)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						removeSublenseBtn)
																				.addComponent(
																						useLabel,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						22,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addComponent(
														sublensesScrollPane,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														81,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(26, 26, 26)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														groupFormatsLbl,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														14,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(configureGroupBtn))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(maxDepthLbl)
												.addComponent(
														maxDepthSpinner,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(17, Short.MAX_VALUE)));
	}// </editor-fold>//GEN-END:initComponents

	private void addSublenseBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addSublenseBtnActionPerformed
		new AddSublenseDialog(this).setVisible(true);
	}// GEN-LAST:event_addSublenseBtnActionPerformed

	private void removeSublenseBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_removeSublenseBtnActionPerformed
		URI selectedValue = sublensesList.getSelectedValueCasted();
		sublensesList.removeElement(selectedValue);
		// setEnabled(true);
	}// GEN-LAST:event_removeSublenseBtnActionPerformed

	private void configureGroupBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_configureGroupBtnActionPerformed
		new SelectGroupFormatJDialog(this).setVisible(true);
	}// GEN-LAST:event_configureGroupBtnActionPerformed

	private void sublensesListValueChanged(
			javax.swing.event.ListSelectionEvent evt) {// GEN-FIRST:event_sublensesListValueChanged
		removeSublenseBtn.setEnabled(!sublensesList.isSelectionEmpty());
	}// GEN-LAST:event_sublensesListValueChanged

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton addSublenseBtn;
	private javax.swing.JButton configureGroupBtn;
	private javax.swing.JLabel groupFormatsLbl;
	private javax.swing.JLabel maxDepthLbl;
	private javax.swing.JSpinner maxDepthSpinner;
	private javax.swing.JButton removeSublenseBtn;
	private javax.swing.JLabel sublensesLbl;
	private cz.muni.fi.fresneleditor.common.guisupport.components.UrisJList sublensesList;
	private javax.swing.JScrollPane sublensesScrollPane;
	private cz.muni.fi.fresneleditor.gui.mod.lens2.components.FresnelUseLabel useLabel;

	// End of variables declaration//GEN-END:variables

	/**
	 * Updates jPanelPropertyConfiguration based on properties of
	 * propertyVisibility param.
	 * 
	 * @param propertyVisibility
	 *            if null then clears the panel
	 */
	public void loadPropertyVisibility(
			PropertyVisibilityWrapper propertyVisibility) {

		// set panel title
		// String title;
		Object useObject;
		int maxDepth;

		List<URI> sublenses;
		if (propertyVisibility == null) {
			// title = "Property configuration"; // fixme igor: externalize this

			useObject = null;
			maxDepth = 0;
			sublenses = Collections.emptyList();
		} else {
			// title = propertyVisibility.toString() + " configuration"; //
			// fixme igor: externalize this

			// load stored configuration
			sublenses = propertyVisibility.getSublensesURIs();
			useObject = propertyVisibility.getFresnelUse();
			maxDepth = propertyVisibility.getMaxDepth();
		}

		sublensesList.setElements(sublenses);
		useLabel.setValue(useObject);
		maxDepthSpinner.setValue(maxDepth);

		// repaint because of setting title
		repaint();
	}

	public void addSublenses(List<URI> selectedValues) {
		sublensesList.addElements(selectedValues);
		// setEnabled(true);
	}

	/*
	 * @Override public void setEnabled(boolean enabled) {
	 * super.setEnabled(enabled); addSublenseBtn.setEnabled(enabled);
	 * 
	 * boolean enabledAndSelectionExists = enabled &&
	 * !sublensesList.isSelectionEmpty();
	 * removeSublenseBtn.setEnabled(enabledAndSelectionExists);
	 * 
	 * boolean enabledAndSublensExists = enabled && !sublensesList.isEmpty();
	 * configureGroupBtn.setEnabled(enabledAndSublensExists);
	 * maxDepthSpinner.setEnabled(enabledAndSublensExists); }
	 */

	public List<URI> getSublenses() {
		return sublensesList.getElements();
	}

	public void setFresnelUse(Object object) {
		useLabel.setValue(object);
	}

	public Object getFresnelUse() {
		return useLabel.getValue();
	}

	/**
	 * Sets the propertyVisibility based on current panel state.
	 * 
	 * @param propertyVisibility
	 *            cannot be null
	 */
	public void savePropertyVisibility(
			PropertyVisibilityWrapper propertyVisibility) {
		Assert.notNull(propertyVisibility);
		propertyVisibility.setMaxDepth((Integer) maxDepthSpinner.getValue());
		propertyVisibility.setSublensesURIs(sublensesList.getElements());
		propertyVisibility.setFresnelUse(useLabel.getValue());
	}

	public void enableWithChildren(boolean enabled) {
		addSublenseBtn.setEnabled(enabled);
		removeSublenseBtn.setEnabled(enabled);
		configureGroupBtn.setEnabled(enabled);
		maxDepthSpinner.setEnabled(enabled);
		sublensesList.setEnabled(enabled);
	}
}