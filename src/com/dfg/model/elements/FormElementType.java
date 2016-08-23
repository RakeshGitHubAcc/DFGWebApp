package com.dfg.model.elements;

import com.dfg.model.SectionModel;
import com.dfg.model.elements.buttons.AddSectionButtonModel;
import com.dfg.model.elements.field.CheckboxGroupModel;
import com.dfg.model.elements.field.CheckboxModel;
import com.dfg.model.elements.field.DropDownModel;
import com.dfg.model.elements.field.IntegerTextFieldModel;
import com.dfg.model.elements.field.RadioGroupModel;
import com.dfg.model.elements.field.StringTextFieldModel;
import com.dfg.model.elements.field.TextAreaModel;
import com.dfg.model.elements.field.TextFieldModel;

/**
 * Enumeration to map the different Wicked Forms models to an enumeration
 * constant each.
 * <p/>
 * By calling {@link #forClass(Class)}, this enumeration can be used to avoid
 * ugly instanceof comparisons.
 * 
 */
public enum FormElementType {
	TEXT(TextModel.class),

	CHECKBOX(CheckboxModel.class),

	TEXTFIELD(TextFieldModel.class),

	DROPDOWN(DropDownModel.class),

	RADIO(RadioGroupModel.class),

	CHECKBOXGROUP(CheckboxGroupModel.class),

	TEXTAREA(TextAreaModel.class),

	SECTION(SectionModel.class),

	ADDSECTIONBUTTON(AddSectionButtonModel.class),

	TEXTFIELD_STRING(StringTextFieldModel.class),

	TEXTFIELD_INTEGER(IntegerTextFieldModel.class);
	public static <T extends AbstractFormElementModel> FormElementType ofObject(AbstractFormElementModel formElement) {
		for (FormElementType elementType : FormElementType.values()) {
			if (elementType.getElementClass().isInstance(formElement)) {
				return elementType;
			}
		}
		return null;
	}

	private final Class<? extends AbstractFormElementModel> elementClass;

	private FormElementType(final Class<? extends AbstractFormElementModel> elementClass) {
		this.elementClass = elementClass;
	}

	public Class<? extends AbstractFormElementModel> getElementClass() {
		return this.elementClass;
	}
}
