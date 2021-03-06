/*
 * Fresnel Editor
 */

package cz.muni.fi.fresneleditor.common.guisupport.dialogs;

import javax.swing.ComboBoxModel;
import javax.swing.SwingUtilities;

import cz.muni.fi.fresneleditor.common.data.AdditionalContentGuiWrapper;
import cz.muni.fi.fresneleditor.common.data.AdditionalContentType;
import cz.muni.fi.fresneleditor.common.guisupport.ExtendedDefaultComboBM;

/**
 * 
 * @author Miroslav Warchil (warmir@mail.muni.cz)
 * @version 28. 3. 2009
 */
public class AdditionalContentDialog extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private static final Logger LOG =
	// LoggerFactory.getLogger(AdditionalContentDialog.class);

	private AdditionalContentGuiWrapper additionalContent = null;

	/**
	 * Constructs Additional Content Dialog on the basis of passed additional
	 * content GUI wrapper.
	 * 
	 * @param parent
	 * @param modal
	 * @param additionalContent
	 *            additional content GUI wrapper containg all information about
	 *            content
	 */
	public AdditionalContentDialog(java.awt.Frame parent, boolean modal,
			AdditionalContentGuiWrapper additionalContent) {
		super(parent, modal);
		initComponents();
		// Initi
		this.additionalContent = additionalContent;
		loadAdditionalContent();
	}

	/**
	 *
	 */
	private void loadAdditionalContent() {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				final ComboBoxModel cmbBoxModel = new ExtendedDefaultComboBM<AdditionalContentType>(
						AdditionalContentType.values());

				typeCmbBox.setModel(cmbBoxModel);
				typeCmbBox.setSelectedItem(additionalContent.getType());

				beforeText.setText(additionalContent.getContentBefore());
				afterText.setText(additionalContent.getContentAfter());
				firstText.setText(additionalContent.getContentFirst());
				lastText.setText(additionalContent.getContentLast());
				noValueText.setText(additionalContent.getContentNoValue());
			}
		});
	}

	/**
	 * 
	 */
	private void saveAdditionalContent() {

		additionalContent.setType((AdditionalContentType) typeCmbBox
				.getSelectedItem());

		additionalContent.setContentBefore(beforeText.getText());
		additionalContent.setContentAfter(afterText.getText());
		additionalContent.setContentFirst(firstText.getText());
		additionalContent.setContentLast(lastText.getText());
		additionalContent.setContentNoValue(noValueText.getText());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {

		typeLabel = new javax.swing.JLabel();
		typeCmbBox = new javax.swing.JComboBox();
		labelBefore = new javax.swing.JLabel();
		afterLabel = new javax.swing.JLabel();
		afterScrollPane = new javax.swing.JScrollPane();
		afterText = new javax.swing.JTextArea();
		firstLabel = new javax.swing.JLabel();
		firstScrollPane = new javax.swing.JScrollPane();
		firstText = new javax.swing.JTextArea();
		lastLabel = new javax.swing.JLabel();
		lastScrollPane = new javax.swing.JScrollPane();
		lastText = new javax.swing.JTextArea();
		noValueLabel = new javax.swing.JLabel();
		noValueScrollPane = new javax.swing.JScrollPane();
		noValueText = new javax.swing.JTextArea();
		saveBtn = new javax.swing.JButton();
		cancelBtn = new javax.swing.JButton();
		beforeScrollPane = new javax.swing.JScrollPane();
		beforeText = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		java.util.ResourceBundle bundle = java.util.ResourceBundle
				.getBundle("cz/muni/fi/fresneleditor/common/guisupport/dialogs/resources/AdditionalContentDialog"); // NOI18N
		setTitle(bundle.getString("Additional_content_editor")); // NOI18N
		setModal(true);

		typeLabel.setText(bundle.getString("Additional_content_type:")); // NOI18N
		typeLabel.setName("typeLabel"); // NOI18N

		typeCmbBox.setEnabled(false);
		typeCmbBox.setName("typeCmbBox"); // NOI18N

		labelBefore.setText(bundle.getString("Content_before:")); // NOI18N
		labelBefore.setName("labelBefore"); // NOI18N

		afterLabel.setText(bundle.getString("Content_after:")); // NOI18N
		afterLabel.setName("afterLabel"); // NOI18N

		afterScrollPane.setName("afterScrollPane"); // NOI18N

		afterText.setColumns(20);
		afterText.setFont(new java.awt.Font("Monospaced", 0, 12));
		afterText.setRows(5);
		afterText.setName("afterText"); // NOI18N
		afterScrollPane.setViewportView(afterText);

		firstLabel.setText(bundle.getString("Content_first:")); // NOI18N
		firstLabel.setName("firstLabel"); // NOI18N

		firstScrollPane.setName("firstScrollPane"); // NOI18N

		firstText.setColumns(20);
		firstText.setFont(new java.awt.Font("Monospaced", 0, 12));
		firstText.setRows(5);
		firstText.setName("firstText"); // NOI18N
		firstScrollPane.setViewportView(firstText);

		lastLabel.setText(bundle.getString("Content_last:")); // NOI18N
		lastLabel.setName("lastLabel"); // NOI18N

		lastScrollPane.setName("lastScrollPane"); // NOI18N

		lastText.setColumns(20);
		lastText.setFont(new java.awt.Font("Monospaced", 0, 12));
		lastText.setRows(5);
		lastText.setName("lastText"); // NOI18N
		lastScrollPane.setViewportView(lastText);

		noValueLabel.setText(bundle.getString("Content_no_value:")); // NOI18N
		noValueLabel.setName("noValueLabel"); // NOI18N

		noValueScrollPane.setName("noValueScrollPane"); // NOI18N

		noValueText.setColumns(20);
		noValueText.setFont(new java.awt.Font("Monospaced", 0, 12));
		noValueText.setRows(5);
		noValueText.setName("noValueText"); // NOI18N
		noValueScrollPane.setViewportView(noValueText);

		saveBtn.setText(bundle.getString("Save")); // NOI18N
		saveBtn.setName("saveBtn"); // NOI18N
		saveBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveBtnActionPerformed(evt);
			}
		});

		cancelBtn.setText(bundle.getString("Cancel")); // NOI18N
		cancelBtn.setName("cancelBtn"); // NOI18N
		cancelBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelBtnActionPerformed(evt);
			}
		});

		beforeScrollPane.setName("beforeScrollPane"); // NOI18N

		beforeText.setColumns(20);
		beforeText.setFont(new java.awt.Font("Monospaced", 0, 12));
		beforeText.setRows(5);
		beforeText.setName("beforeText"); // NOI18N
		beforeScrollPane.setViewportView(beforeText);

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
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		typeLabel)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		typeCmbBox,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		162,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														labelBefore)
																												.addComponent(
																														afterLabel)
																												.addComponent(
																														firstLabel)
																												.addComponent(
																														lastLabel))
																								.addGap(13,
																										13,
																										13))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										noValueLabel)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						noValueScrollPane,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						289,
																						Short.MAX_VALUE)
																				.addComponent(
																						beforeScrollPane,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						289,
																						Short.MAX_VALUE)
																				.addComponent(
																						firstScrollPane,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						289,
																						Short.MAX_VALUE)
																				.addComponent(
																						lastScrollPane,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						289,
																						Short.MAX_VALUE)
																				.addComponent(
																						afterScrollPane,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						289,
																						Short.MAX_VALUE)))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		cancelBtn,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		77,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(5, 5, 5)
																.addComponent(
																		saveBtn,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		77,
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
												.addComponent(typeLabel)
												.addComponent(
														typeCmbBox,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(labelBefore)
												.addComponent(
														beforeScrollPane,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														afterScrollPane,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(afterLabel))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(firstLabel)
												.addComponent(
														firstScrollPane,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														lastScrollPane,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lastLabel))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		noValueScrollPane,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						cancelBtn)
																				.addComponent(
																						saveBtn)))
												.addComponent(noValueLabel))
								.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelBtnActionPerformed
		additionalContent.setUpdated(false);
		this.dispose();
	}// GEN-LAST:event_cancelBtnActionPerformed

	private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveBtnActionPerformed
		saveAdditionalContent();
		additionalContent.setUpdated(true);
		this.dispose();
	}// GEN-LAST:event_saveBtnActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel afterLabel;
	private javax.swing.JScrollPane afterScrollPane;
	private javax.swing.JTextArea afterText;
	private javax.swing.JScrollPane beforeScrollPane;
	private javax.swing.JTextArea beforeText;
	private javax.swing.JButton cancelBtn;
	private javax.swing.JLabel firstLabel;
	private javax.swing.JScrollPane firstScrollPane;
	private javax.swing.JTextArea firstText;
	private javax.swing.JLabel labelBefore;
	private javax.swing.JLabel lastLabel;
	private javax.swing.JScrollPane lastScrollPane;
	private javax.swing.JTextArea lastText;
	private javax.swing.JLabel noValueLabel;
	private javax.swing.JScrollPane noValueScrollPane;
	private javax.swing.JTextArea noValueText;
	private javax.swing.JButton saveBtn;
	private javax.swing.JComboBox typeCmbBox;
	private javax.swing.JLabel typeLabel;
	// End of variables declaration//GEN-END:variables

}
