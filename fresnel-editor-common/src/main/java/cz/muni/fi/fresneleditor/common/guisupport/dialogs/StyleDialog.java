/*
 * Fresnel Editor
 */

package cz.muni.fi.fresneleditor.common.guisupport.dialogs;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.muni.fi.fresneleditor.common.data.CssValueType;
import cz.muni.fi.fresneleditor.common.data.StyleGuiWrapper;
import cz.muni.fi.fresneleditor.common.data.StyleType;
import cz.muni.fi.fresneleditor.common.guisupport.ExtendedDefaultComboBM;

/**
 * 
 * @author Miroslav Warchil (warmir@mail.muni.cz)
 * @version 21. 3. 2009
 */
public class StyleDialog extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory
			.getLogger(StyleDialog.class);

	private StyleGuiWrapper style = null;
	private List<StyleType> styleTypes = null;

	/**
	 * Creates new Style Dialog.
	 * 
	 * @param parent
	 *            parent frame
	 * @param modal
	 *            true if dialog is modal, false otherwise
	 * @param style
	 *            style to be edited in given dialog
	 */
	public StyleDialog(java.awt.Frame parent, boolean modal,
			StyleGuiWrapper style, List<StyleType> possibleStyleTypes) {

		super(parent, modal);
		initComponents();
		// Load style into dialog components
		this.style = style;
		this.styleTypes = possibleStyleTypes;
		loadStyle();
	}

	/**
	 * TODO
	 */
	private void loadStyle() {

		final boolean isEdit = styleTypes.isEmpty();

		switch (style.getValueType()) {
		case CLASS:
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					cssClassNameRadio.setSelected(true);
					styleClassNameText.setText(style.getValue());
				}
			});
			break;
		case SNIPPET:
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					cssSnippetRadio.setSelected(true);
					cssSnippetCmbBox.setSelectedItem(style.getValue());
				}
			});
			break;
		default:
			// FIXME
			break;
		}

		// Fill type combo box with possible values
		ComboBoxModel tempCmbBoxModel = null;
		if (isEdit) {
			tempCmbBoxModel = new ExtendedDefaultComboBM<StyleType>(
					StyleType.values());
		} else {
			tempCmbBoxModel = new ExtendedDefaultComboBM<StyleType>(styleTypes);
		}

		final ComboBoxModel cmbBoxModel = tempCmbBoxModel;

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				styleTypeCmbBox.setModel(cmbBoxModel);
				styleTypeCmbBox.setSelectedItem(style.getType());
				if (isEdit) {
					styleTypeCmbBox.setEnabled(false);
				}
				cssSnippetRadio.setEnabled(false);
				cssSnippetCmbBox.setEnabled(false);
				// Loading of possible CSS snippets from ContextHolder
				// FIXME: Uncomment after integration
				// ProjectConfiguration projectConfiguration =
				// ContextHolder.getInstance().getProjectConfiguration();
				// Set<String> cssSnippetsSet =
				// projectConfiguration.getCssSnippets().keySet();
				// List<String> cssSnippetsList = new ArrayList<String>();
				// cssSnippetsList.addAll(cssSnippetsSet);
				// ComboBoxModel cmbBoxModel = new
				// ExtendedDefaultComboBM<String>(cssSnippetsList);
				// cssSnippetCmbBox.setModel(cmbBoxModel);
				// cssSnippetCmbBox.setSelectedItem(style.getValue());
			}
		});
	}

	private void saveStyle() {

		boolean isEdit = styleTypes.isEmpty();

		if (isEdit) {
			style.setType(StyleType.values()[styleTypeCmbBox.getSelectedIndex()]);
		} else {
			style.setType(styleTypes.get(styleTypeCmbBox.getSelectedIndex()));
		}

		if (cssClassNameRadio.isSelected()) {
			style.setValueType(CssValueType.CLASS);
			style.setValue(styleClassNameText.getText());
		} else if (cssSnippetRadio.isSelected()) {
			style.setValueType(CssValueType.SNIPPET);
			style.setValue(cssSnippetCmbBox.getSelectedItem().toString());
		} else {
			LOG.error(java.util.ResourceBundle
					.getBundle(
							"cz/muni/fi/fresneleditor/common/guisupport/dialogs/resources/StyleDialog")
					.getString("No_radio_button_selected!"));
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {

		cssButtonGroup = new javax.swing.ButtonGroup();
		styleTypeLabel = new javax.swing.JLabel();
		styleTypeCmbBox = new javax.swing.JComboBox();
		cssClassNameRadio = new javax.swing.JRadioButton();
		styleClassNameText = new javax.swing.JTextField();
		cssSnippetRadio = new javax.swing.JRadioButton();
		cssSnippetCmbBox = new javax.swing.JComboBox();
		saveStyleBtn = new javax.swing.JButton();
		cancelBtn = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		java.util.ResourceBundle bundle = java.util.ResourceBundle
				.getBundle("cz/muni/fi/fresneleditor/common/guisupport/dialogs/resources/StyleDialog"); // NOI18N
		setTitle(bundle.getString("Style_editor")); // NOI18N

		styleTypeLabel.setText(bundle.getString("Style_type:")); // NOI18N
		styleTypeLabel.setName("styleTypeLabel"); // NOI18N

		styleTypeCmbBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Property style", "Label style", "Value style",
						"Resource style" }));
		styleTypeCmbBox.setName("styleTypeCmbBox"); // NOI18N

		cssButtonGroup.add(cssClassNameRadio);
		cssClassNameRadio.setSelected(true);
		cssClassNameRadio.setText(bundle.getString("CSS_class_name:")); // NOI18N
		cssClassNameRadio.setName("cssClassNameRadio"); // NOI18N

		styleClassNameText.setName("styleClassNameText"); // NOI18N
		styleClassNameText.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				styleClassNameTextKeyPressed(evt);
			}
		});

		cssButtonGroup.add(cssSnippetRadio);
		cssSnippetRadio.setText(bundle.getString("CSS_snippet_name:")); // NOI18N
		cssSnippetRadio.setName("cssSnippetRadio"); // NOI18N

		cssSnippetCmbBox.setName("cssSnippetCmbBox"); // NOI18N
		cssSnippetCmbBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cssSnippetCmbBoxActionPerformed(evt);
			}
		});

		saveStyleBtn.setText(bundle.getString("Save")); // NOI18N
		saveStyleBtn.setName("saveStyleBtn"); // NOI18N
		saveStyleBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveStyleBtnActionPerformed(evt);
			}
		});

		cancelBtn.setText(bundle.getString("Cancel")); // NOI18N
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
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		styleTypeLabel))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGap(14, 14,
																		14)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										cssSnippetRadio)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										cssSnippetCmbBox,
																										0,
																										164,
																										Short.MAX_VALUE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										cssClassNameRadio)
																								.addGap(18,
																										18,
																										18)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														styleTypeCmbBox,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														styleClassNameText,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														164,
																														javax.swing.GroupLayout.PREFERRED_SIZE)))))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		cancelBtn,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		80,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		saveStyleBtn,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		80,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(styleTypeLabel)
												.addComponent(
														styleTypeCmbBox,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(14, 14, 14)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(cssClassNameRadio)
												.addComponent(
														styleClassNameText,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(cssSnippetRadio)
												.addComponent(
														cssSnippetCmbBox,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(saveStyleBtn)
												.addComponent(cancelBtn))
								.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void saveStyleBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveStyleBtnActionPerformed
		saveStyle();
		style.setUpdated(true);
		this.dispose();
	}// GEN-LAST:event_saveStyleBtnActionPerformed

	private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelBtnActionPerformed
		style.setUpdated(false);
		this.dispose();
	}// GEN-LAST:event_cancelBtnActionPerformed

	private void cssSnippetCmbBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cssSnippetCmbBoxActionPerformed
		if (!cssSnippetRadio.isSelected()) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					cssSnippetRadio.setSelected(true);
				}
			});
		}
	}// GEN-LAST:event_cssSnippetCmbBoxActionPerformed

	private void styleClassNameTextKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_styleClassNameTextKeyPressed
		if (!cssClassNameRadio.isSelected()) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					cssClassNameRadio.setSelected(true);
				}
			});
		}
	}// GEN-LAST:event_styleClassNameTextKeyPressed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton cancelBtn;
	private javax.swing.ButtonGroup cssButtonGroup;
	private javax.swing.JRadioButton cssClassNameRadio;
	private javax.swing.JComboBox cssSnippetCmbBox;
	private javax.swing.JRadioButton cssSnippetRadio;
	private javax.swing.JButton saveStyleBtn;
	private javax.swing.JTextField styleClassNameText;
	private javax.swing.JComboBox styleTypeCmbBox;
	private javax.swing.JLabel styleTypeLabel;
	// End of variables declaration//GEN-END:variables

}