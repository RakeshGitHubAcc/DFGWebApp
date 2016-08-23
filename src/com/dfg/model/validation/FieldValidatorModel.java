package com.dfg.model.validation;

import java.io.Serializable;

import com.dfg.model.elements.field.AbstractInputFieldModel;

public interface FieldValidatorModel<T> extends Serializable {
	/**
	 * Implements the validation rule represented by this
	 * {@link FieldValidatorModel}.
	 * 
	 * @param inputField
	 *          the input field that is validated. Can for example be used to read
	 *          out the label to use in the validation message.
	 * @param value
	 *          the value of the input field that is to be validated.
	 * @param feedback
	 *          this feedback object can be used to propagate error messages if
	 *          the validation fails. If the validation is successful, the method
	 *          can simply return and leave the feedback object alone.
	 */
	void validate(final AbstractInputFieldModel<T> inputField, final T value, final ValidationFeedback feedback);
}
