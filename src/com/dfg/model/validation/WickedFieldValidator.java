package com.dfg.model.validation;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

import com.dfg.model.elements.field.AbstractInputFieldModel;

public class WickedFieldValidator<T> implements IValidator<T> {
	private static final long serialVersionUID = 1L;
	private final AbstractInputFieldModel<T> field;

	public WickedFieldValidator(final AbstractInputFieldModel<T> field) {
		this.field = field;
	}

	@Override
	public void validate(final IValidatable<T> validatable) {
		for (FieldValidatorModel<T> v : this.field.getValidators()) {
			v.validate(this.field, validatable.getValue(), new WicketValidationFeedback<T>(validatable));
		}
	}

	class WicketValidationFeedback<T> implements ValidationFeedback {

		private final IValidatable<T> validatable;

		public WicketValidationFeedback(final IValidatable<T> validatable) {
			this.validatable = validatable;
		}

		@Override
		public void error(final String message) {
			this.validatable.error(new ValidationError(message));
		}

	}

}
