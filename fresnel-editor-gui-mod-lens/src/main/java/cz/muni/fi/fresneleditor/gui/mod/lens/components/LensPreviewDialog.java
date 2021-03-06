/*
 * Fresnel Editor
 */

package cz.muni.fi.fresneleditor.gui.mod.lens.components;

import cz.muni.fi.fresneleditor.common.guisupport.dialogs.PreviewDialog;
import cz.muni.fi.fresneleditor.gui.mod.lens.utils.LensPreviewRenderer;
import fr.inria.jfresnel.sesame.SesameFormat;
import fr.inria.jfresnel.sesame.SesameLens;

/**
 * 
 * @author Miroslav Warchil (warmir@mail.muni.cz)
 * @version 30.6.2009
 */
public class LensPreviewDialog extends PreviewDialog {

	public LensPreviewDialog(java.awt.Frame parent, boolean modal, int type,
			SesameLens lens, SesameFormat format) {

		super(parent, modal, type, lens, format);
	}

	@Override
	public void renderAction() {

		LensPreviewRenderer previewRenderer = new LensPreviewRenderer();
		previewRenderer.renderLensPreview(lens, getSelectedUri(),
				getStylesheetUri());
	}
}
