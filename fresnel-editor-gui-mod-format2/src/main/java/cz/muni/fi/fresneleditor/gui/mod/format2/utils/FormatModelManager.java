/**
 * Fresnel Editor
 */
package cz.muni.fi.fresneleditor.gui.mod.format2.utils;

import java.util.ArrayList;
import java.util.List;

import org.openrdf.model.Literal;
import org.openrdf.model.URI;
import org.openrdf.model.impl.LiteralImpl;
import org.openrdf.model.impl.URIImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.muni.fi.fresneleditor.common.data.AdditionalContentGuiWrapper;
import cz.muni.fi.fresneleditor.common.data.AdditionalContentType;
import cz.muni.fi.fresneleditor.common.data.CssValueType;
import cz.muni.fi.fresneleditor.common.data.DomainType;
import cz.muni.fi.fresneleditor.common.data.SelectorType;
import cz.muni.fi.fresneleditor.common.data.StyleGuiWrapper;
import cz.muni.fi.fresneleditor.common.data.StyleType;
import cz.muni.fi.fresneleditor.common.utils.AModelManager;
import cz.muni.fi.fresneleditor.gui.mod.format2.data.DomainSelectorGuiWrapper;
import cz.muni.fi.fresneleditor.gui.mod.format2.data.FormatModel;
import cz.muni.fi.fresneleditor.gui.mod.format2.data.enums.LabelType;
import cz.muni.fi.fresneleditor.gui.mod.format2.data.enums.PurposeType;
import cz.muni.fi.fresneleditor.gui.mod.format2.data.enums.ValueType;
import cz.muni.fi.fresneleditor.model.IModel;
import fr.inria.jfresnel.Constants;
import fr.inria.jfresnel.ContentFormat;
import fr.inria.jfresnel.Format;
import fr.inria.jfresnel.Group;
import fr.inria.jfresnel.fsl.FSLPath;
import fr.inria.jfresnel.sesame.SesameFormat;
import fr.inria.jfresnel.sparql.SPARQLQuery;

/**
 * Class which contains functionality for building of FormatModel on the basis
 * of JFresnel Format object.
 * 
 * @author Miroslav Warchil (warmir@mail.muni.cz)
 * @version 18.4.2009
 */
public class FormatModelManager extends AModelManager<Format> {

	private static final Logger LOG = LoggerFactory
			.getLogger(FormatModelManager.class);

	private static final String PROPERTY_FORMAT_CLASS_DOMAIN = Constants.FRESNEL_NAMESPACE_URI
			+ Constants._classFormatDomain;
	private static final String PROPERTY_FORMAT_INSTANCE_DOMAIN = Constants.FRESNEL_NAMESPACE_URI
			+ Constants._instanceFormatDomain;

	/**
	 * {@inheritDoc}
	 */
	public FormatModel buildModel(Format format) {

		FormatModel formatModel = new FormatModel();

		if (format == null) {
			LOG.error("Null Fresnel Format passed build format model method!");
			throw new NullPointerException("format");
		}

		URI formatUri = new URIImpl(format.getURI());

		formatModel.setUri(format.getURI());
		formatModel.setLabel(format.getLabel());
		formatModel.setComment(format.getComment());
		formatModel.setFresnelFormat(format);

		formatModel.getDomainSelectors().clear();

		// PROPERTY DOMAINS LOADING
		if (format.getBasicPropertyDomains() != null) {
			for (String domain : format.getBasicPropertyDomains()) {

				DomainSelectorGuiWrapper domainSelector = new DomainSelectorGuiWrapper(
						DomainType.PROPERTY, SelectorType.SIMPLE, domain);
				formatModel.getDomainSelectors().add(domainSelector);
			}
		}

		if (format.getFSLPropertyDomains() != null) {
			for (FSLPath fslPath : format.getFSLPropertyDomains()) {

				DomainSelectorGuiWrapper domainSelector = new DomainSelectorGuiWrapper(
						DomainType.PROPERTY, SelectorType.FSL,
						fslPath.toString());
				formatModel.getDomainSelectors().add(domainSelector);
			}
		}

		if (format.getSPARQLPropertyDomains() != null) {
			for (SPARQLQuery sparqlQuery : format.getSPARQLPropertyDomains()) {

				DomainSelectorGuiWrapper domainSelector = new DomainSelectorGuiWrapper(
						DomainType.PROPERTY, SelectorType.SPARQL,
						sparqlQuery.toString());
				formatModel.getDomainSelectors().add(domainSelector);
			}
		}

		// CLASS DOMAINS LOADING
		formatModel.getDomainSelectors().addAll(getFormatClassDomains(format));

		// INSTANCE DOMAINS LOADING
		formatModel.getDomainSelectors().addAll(
				getFormatInstanceDomains(format));

		// LABEL LOADING
		if (format.getValueLabelPolicy() == Format.LABEL_POLICY_NOT_SPECIFIED) {
			formatModel.setLabelType(LabelType.NOT_SPECIFIED);
		}else if (format.getValueLabelPolicy() == Format.LABEL_POLICY_NONE) {
			formatModel.setLabelType(LabelType.NONE);
		}else{
			formatModel.setLabelType(LabelType.SHOW);
			formatModel.setLiteralLabelValue(format.getValueLabel());
		}
		// FIXME: How to map LabelType.NONE?

		// VALUE TYPES LOADING
		switch (format.getValueType()) {
		case Format.VALUE_TYPE_NOT_SPECIFIED:
			formatModel.setValueType(ValueType.DEFAULT);
			break;
		case Format.VALUE_TYPE_NONE:
			formatModel.setValueType(ValueType.NONE);
			break;
		case Format.VALUE_TYPE_IMAGE:
			formatModel.setValueType(ValueType.IMAGE);
			break;
		case Format.VALUE_TYPE_EXTERNAL_LINK:
			formatModel.setValueType(ValueType.EXTERNAL_LINK);
			break;
		case Format.VALUE_TYPE_URI:
			formatModel.setValueType(ValueType.URI);
			break;
		/* Format value types (extended vocabulary) */
		case Format.VALUE_TYPE_VIDEO:
			formatModel.setValueType(ValueType.VIDEO);
			break;
		case Format.VALUE_TYPE_AUDIO:
			formatModel.setValueType(ValueType.AUDIO);
			break;
		case Format.VALUE_TYPE_ANIMATION:
			formatModel.setValueType(ValueType.ANIMATION);
			break;
		case Format.VALUE_TYPE_HTML:
			formatModel.setValueType(ValueType.HTML);
			break;
		case Format.VALUE_TYPE_TEXT:
			formatModel.setValueType(ValueType.TEXT);
			break;
		case Format.VALUE_TYPE_TEXTSTREAM:
			formatModel.setValueType(ValueType.TEXTSTREAM);
			break;
		default:
			formatModel.setValueType(ValueType.DEFAULT);
			break;
		}
		
		// 
		switch (format.getPurposeType()) {
		case Format.PURPOSE_TYPE_NOT_SPECIFIED:
			formatModel.setPurposeType(PurposeType.DEFAULT);
			break;
		case Format.PURPOSE_TYPE_PRINT:
			formatModel.setPurposeType(PurposeType.PRINT);
			break;
		case Format.PURPOSE_TYPE_PROJECTION:
			formatModel.setPurposeType(PurposeType.PROJECTION);
			break;
		case Format.PURPOSE_TYPE_SCREEN:
			formatModel.setPurposeType(PurposeType.SCREEN);
			break;
		}
		
		// STYLES LOADING
		if (format.getLabelStyle() != null) {
			StyleGuiWrapper labelStyle = new StyleGuiWrapper(StyleType.LABEL);
			labelStyle.setValue(format.getLabelStyle());
			// FIXME
			labelStyle.setValueType(CssValueType.CLASS);
			formatModel.getStyles().add(labelStyle);
		}

		if (format.getValueStyle() != null) {
			StyleGuiWrapper valueStyle = new StyleGuiWrapper(StyleType.VALUE);
			valueStyle.setValue(format.getValueStyle());
			// FIXME
			valueStyle.setValueType(CssValueType.CLASS);
			formatModel.getStyles().add(valueStyle);
		}

		if (format.getPropertyStyle() != null) {
			StyleGuiWrapper propertyStyle = new StyleGuiWrapper(
					StyleType.PROPERTY);
			propertyStyle.setValue(format.getPropertyStyle());
			// FIXME
			propertyStyle.setValueType(CssValueType.CLASS);
			formatModel.getStyles().add(propertyStyle);
		}

		// Resource style loading (needs special handling - not covered by
		// JFresnel)
		StyleGuiWrapper resourceStyle = getResourceStyle(formatUri);
		if (resourceStyle != null) {
			formatModel.getStyles().add(resourceStyle);
		}

		// CONTENT TYPES LOADING
		ContentFormat labelFormat = format.getLabelFormattingInstructions();
		formatModel.getAdditionalContents().add(
				createAdditionalContentGuiWrapper(AdditionalContentType.LABEL,
						labelFormat));

		ContentFormat valueFormat = format.getValueFormattingInstructions();
		formatModel.getAdditionalContents().add(
				createAdditionalContentGuiWrapper(AdditionalContentType.VALUE,
						valueFormat));

		ContentFormat propertyFormat = format
				.getPropertyFormattingInstructions();
		formatModel.getAdditionalContents().add(
				createAdditionalContentGuiWrapper(
						AdditionalContentType.PROPERTY, propertyFormat));

		ContentFormat resourceFormat = format
				.getResourceFormattingInstructions();
		formatModel.getAdditionalContents().add(
				createAdditionalContentGuiWrapper(
						AdditionalContentType.RESOURCE, resourceFormat));

		for (Group group : format.getAssociatedGroups()) {
			formatModel.getAssociatedGroupURIs().add(
					new URIImpl(group.getURI()));
		}

		return formatModel;
	}

	/**
	 * {@inheritDoc}
	 */
	public FormatModel buildNewModel() {

		FormatModel formatModel = new FormatModel();

		formatModel.getAdditionalContents().add(
				new AdditionalContentGuiWrapper(AdditionalContentType.LABEL));
		formatModel.getAdditionalContents().add(
				new AdditionalContentGuiWrapper(AdditionalContentType.VALUE));
		formatModel.getAdditionalContents()
				.add(new AdditionalContentGuiWrapper(
						AdditionalContentType.PROPERTY));
		formatModel.getAdditionalContents()
				.add(new AdditionalContentGuiWrapper(
						AdditionalContentType.RESOURCE));

		return formatModel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SesameFormat convertModel2JFresnel(IModel model) {

		FormatModel formatModel = (FormatModel) model;
		SesameFormat format = new SesameFormat(formatModel.getModelUri(), "");

		for (DomainSelectorGuiWrapper selector : formatModel
				.getDomainSelectors()) {
			// Convert property format domains
			if (selector.getDomainType().equals(DomainType.PROPERTY)) {
				if (selector.getSelectorType().equals(SelectorType.SIMPLE)) {
					format.addPropertyDomain(selector.getSelectorString(),
							Constants._BASIC_SELECTOR);
				} else if (selector.getSelectorType().equals(
						SelectorType.SPARQL)) {
					format.addPropertyDomain(selector.getSelectorString(),
							Constants._SPARQL_SELECTOR);
				} else if (selector.getSelectorType().equals(SelectorType.FSL)) {
					format.addPropertyDomain(selector.getSelectorString(),
							Constants._FSL_SELECTOR);
				} else {
					throw new IllegalArgumentException(
							"Invalid selector type value: "
									+ selector.getSelectorType() + "!");
				}
			}
			// TODO Convert instance format domains - not supported by JFresnel
			// 0.3.2
			// TODO Convert class format domains - not supported by JFresnel
			// 0.3.2
		}

		// Value type
		if (formatModel.getValueType() != ValueType.DEFAULT) {
			format.setValueType(formatModel.getValueType().getURI().toString());
		}

		// Value label
		if (formatModel.getLabelType().equals(LabelType.SHOW) && formatModel.getLiteralLabelValue() != null) {
			format.setValueLabel(new LiteralImpl(formatModel
					.getLiteralLabelValue()));
		}

		// Styles
		for (StyleGuiWrapper style : formatModel.getStyles()) {
			switch (style.getType()) {
			case LABEL:
				if (style.getType().equals(StyleType.LABEL)) {
					format.setLabelStyle(style.getValue());
				}
				break;
			case VALUE:
				if (style.getType().equals(StyleType.VALUE)) {
					format.setValueStyle(style.getValue());
				}
				break;
			case PROPERTY:
				if (style.getType().equals(StyleType.PROPERTY)) {
					format.setPropertyStyle(style.getValue());
				}
				break;
			case RESOURCE:
				if (style.getType().equals(StyleType.RESOURCE)) {
					// Resource style not supported by JFresnel 0.3.2
				}
				break;
			default:
				throw new IllegalArgumentException("Style type: "
						+ style.getType());
			}
		}

		// Additional contents
		for (AdditionalContentGuiWrapper addContent : formatModel
				.getAdditionalContents()) {
			ContentFormat contentFormat = convertAdditionalContent2JFresnel(addContent);
			switch (addContent.getType()) {
			case LABEL:
				format.setLabelFormattingInstructions(contentFormat);
				break;
			case VALUE:
				format.setValueFormattingInstructions(contentFormat);
				break;
			case PROPERTY:
				format.setPropertyFormattingInstructions(contentFormat);
				break;
			case RESOURCE:
				format.setResourceFormattingInstructions(contentFormat);
				break;
			default:
			}
		}

		return format;
	}

	private ContentFormat convertAdditionalContent2JFresnel(
			AdditionalContentGuiWrapper addContent) {
		ContentFormat contentFormat = new ContentFormat();

		contentFormat.setContentFirst(addContent.getContentFirst());
		contentFormat.setContentLast(addContent.getContentLast());
		contentFormat.setContentBefore(addContent.getContentBefore());
		contentFormat.setContentAfter(addContent.getContentAfter());
		contentFormat.setContentNoValue(addContent.getContentNoValue());

		return contentFormat;
	}

	/**
	 * 
	 * @param format
	 * @return
	 */
	private List<DomainSelectorGuiWrapper> getFormatClassDomains(Format format) {

		return getFormatDomains(format, DomainType.CLASS,
				PROPERTY_FORMAT_CLASS_DOMAIN);
	}

	/**
	 * 
	 * @param format
	 * @return
	 */
	private List<DomainSelectorGuiWrapper> getFormatInstanceDomains(
			Format format) {

		return getFormatDomains(format, DomainType.INSTANCE,
				PROPERTY_FORMAT_INSTANCE_DOMAIN);
	}

	/**
	 * 
	 * @param format
	 * @param type
	 * @param propertyUri
	 * @return
	 */
	private List<DomainSelectorGuiWrapper> getFormatDomains(Format format,
			DomainType type, String propertyUri) {

		List<DomainSelectorGuiWrapper> domainSelectors = new ArrayList<DomainSelectorGuiWrapper>();

		List<Literal> domainLiterals = getResourceStringProperties(new URIImpl(
				format.getURI()), propertyUri);
		List<String> domainStrings = new ArrayList<String>();

		for (Literal literal : domainLiterals) {
			if (!"".equals(literal.getLabel())) {
				domainStrings.add(literal.toString());
			}
		}

		for (String domainString : domainStrings) {

			if (domainString != null && !("".equals(domainString))) {

				DomainSelectorGuiWrapper domainSelector = getFormatDomainSelector(
						type, domainString);

				if (domainSelector != null) {
					domainSelectors.add(domainSelector);
				}
			}
		}

		return domainSelectors;
	}

	// FIXME: This method is not ok - it parses directly string representation
	// of RDF literal. It would be much
	// better to get Literal instance directly from SPARQL query -> needs
	// extension of BaseRepositoryDao.
	private DomainSelectorGuiWrapper getFormatDomainSelector(
			DomainType domainType, String domainString) {

		DomainSelectorGuiWrapper domainSelector = new DomainSelectorGuiWrapper(
				domainType);

		String[] elements = parseLiteralWithDatatype(domainString);

		domainSelector.setSelectorString(elements[0]);

		if (Constants._fslSelector.equals(elements[1])) {
			domainSelector.setSelectorType(SelectorType.FSL);
		} else if (Constants._sparqlSelector.equals(elements[1])) {
			domainSelector.setSelectorType(SelectorType.SPARQL);
		} else {
			LOG.warn(
					"Format domain selector {} not processed - invalid literal datatype {}.",
					domainString, elements[1]);
			return null;
		}

		return domainSelector;
	}
}
