package com.dfg.model;

import org.apache.wicket.markup.html.panel.Panel;

import com.dfg.model.elements.AbstractFormElementModel;
import com.dfg.model.elements.FormElementType;
import com.dfg.model.elements.TextModel;
import com.dfg.model.elements.buttons.AddSectionButtonModel;
import com.dfg.model.elements.field.AddSectionButtonPanel;
import com.dfg.model.elements.field.CheckboxGroupModel;
import com.dfg.model.elements.field.CheckboxGroupPanel;
import com.dfg.model.elements.field.CheckboxModel;
import com.dfg.model.elements.field.CheckboxPanel;
import com.dfg.model.elements.field.DropDownModel;
import com.dfg.model.elements.field.DropDownPanel;
import com.dfg.model.elements.field.RadioGroupModel;
import com.dfg.model.elements.field.RadioGroupPanel;
import com.dfg.model.elements.field.SectionPanel;
import com.dfg.model.elements.field.TextAreaModel;
import com.dfg.model.elements.field.TextAreaPanel;
import com.dfg.model.elements.field.TextElementPanel;
import com.dfg.model.elements.field.TextFieldModel;
import com.dfg.model.elements.field.TextFieldPanel;

/**
 * Default implementation of {@link PanelFactory}. This factory creates the
 * matching {@link Panel}s for each of the form element models that ship with
 * Wicked Forms.
 * <p/>
 * You can extend this factory to add your own custom form elements like this:
 * 
 * <pre>
 * public class MyPanelFactory extends DefaultPanelFactory {
 * 
 * 	public Panel createFormElementPanel(final String wicketId,
 * 			final AbstractFormElementModel element) {
 * 		if (element instanceof MyVeryOwnFormElement) {
 * 			// if the element is an instance of one of your custom
 * 			// form elements, handle the Panel creation yourself
 * 			return new MyVeryOwnFormElementPanel(wicketId,
 * 					(MyVeryOwnFormElement) element);
 * 		}
 * 
 * 		// if the element is not an instance of one of your custom
 * 		// form elements, let the DefaultPanelFactory handle it
 * 		return super.createFormElementPanel(wicketId, element);
 * 	}
 * 
 * }
 * </pre>
 * 
 * 
 */
public class DefaultPanelFactory implements PanelFactory {
	private static final long serialVersionUID = 1L;

	private <T> CheckboxGroupPanel<T> createCheckboxGroupPanel(
			final String wicketId, final CheckboxGroupModel<T> model) {
		return new CheckboxGroupPanel<T>(wicketId, model);
	}

	private CheckboxPanel createCheckboxPanel(final String wicketId,
			final CheckboxModel model) {
		return new CheckboxPanel(wicketId, model);
	}

	private <T> DropDownPanel<T> createDropDownPanel(final String wicketId,
			final DropDownModel<T> model) {
		return new DropDownPanel<T>(wicketId, model);
	}

	@Override
	public Panel createFormElementPanel(final String wicketId,
			final AbstractFormElementModel element) {
		FormElementType elementType = FormElementType.ofObject(element);

		if (elementType == null) {
			throw new IllegalArgumentException(
					"Unknown Dynamic Forms element: " + elementType);
		}

		switch (elementType) {
		case CHECKBOX:
			return createCheckboxPanel(wicketId, (CheckboxModel) element);
		case TEXT:
			return createTextElementPanel(wicketId, (TextModel) element);
		case TEXTFIELD:
		case TEXTFIELD_STRING:
		case TEXTFIELD_INTEGER:
			return createTextFieldPanel(wicketId, (TextFieldModel) element);
		case DROPDOWN:
			return createDropDownPanel(wicketId, (DropDownModel) element);
		case RADIO:
			return createRadioGroupPanel(wicketId, (RadioGroupModel) element);
		case CHECKBOXGROUP:
			return createCheckboxGroupPanel(wicketId,
					(CheckboxGroupModel) element);
		case TEXTAREA:
			return createTextAreaPanel(wicketId, (TextAreaModel) element);
		case SECTION:
			return createSectionPanel(wicketId, (SectionModel) element);
		case ADDSECTIONBUTTON:
			return createAddSectionButtonPanel(wicketId,
					(AddSectionButtonModel) element);
		default:
			throw new IllegalArgumentException("Unknown Wicked Forms element: "
					+ elementType);
		}
	}

	private Panel createAddSectionButtonPanel(String wicketId,
			AddSectionButtonModel element) {
		return new AddSectionButtonPanel(wicketId, element, this);
	}

	private <T> RadioGroupPanel<T> createRadioGroupPanel(final String wicketId,
			final RadioGroupModel<T> model) {
		return new RadioGroupPanel<T>(wicketId, model);
	}

	private SectionPanel createSectionPanel(final String wicketId,
			final SectionModel model) {
		return new SectionPanel(wicketId, model, this);
	}

	private TextAreaPanel createTextAreaPanel(final String wicketId,
			final TextAreaModel model) {
		return new TextAreaPanel(wicketId, model);
	}

	private TextElementPanel createTextElementPanel(final String wicketId,
			final TextModel model) {
		return new TextElementPanel(wicketId, model);
	}

	private <T> TextFieldPanel<T> createTextFieldPanel(final String wicketId,
			final TextFieldModel<T> model) {
		return new TextFieldPanel<T>(wicketId, model, model.getModelClass());
	}
}
