package com.dfg.model.validation;

import java.text.MessageFormat;

import org.apache.wicket.validation.INullAcceptingValidator;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.ValidationError;

import com.dfg.model.elements.field.AbstractInputFieldModel;

public class WickedRequiredValidator<T> implements INullAcceptingValidator<T> {
	private static final long serialVersionUID = 1L;
	private final AbstractInputFieldModel<T> field;

	public WickedRequiredValidator(AbstractInputFieldModel<T> field) {
		this.field = field;
	}

	@Override
	public void validate(IValidatable<T> validatable) {
		if (validatable.getValue() == null) {
			ValidationError error = new ValidationError(getMessage());
			validatable.error(error);
		}
	}

	private String getMessage() {
		if (field.getRequiredMessage() != null) {
			return field.getRequiredMessage();
		} else {
			return MessageFormat.format("Please fill out the required field ''{0}''.", field.getLabel());
		}
	}
}
