package com.dfg.model.validation;

import java.io.Serializable;
import java.util.List;

import com.dfg.model.elements.field.AbstractInputFieldModel;

public interface FormValidatorModel extends Serializable{
	/**
	 * Returns a list of the input fields that are relevant to this form
	 * validator. This list must contain all input fields whose values are
	 * validated in the {@link #validate(ValidationFeedback)} method.
	 * 
	 * @return list of the relevant input fields.
	 */
	List<AbstractInputFieldModel<?>> getRelevantInputFields();

	/**
	 * Implements the actual validation rule. Only input fields that are
	 * included in {@link #getRelevantInputFields()} may be accessed in this
	 * method.
	 * <p/>
	 * The values of the input field that are to be validated must be accessed
	 * by calling {@link AbstractInputFieldModel#getUserInput()} and
	 * <strong>NOT</strong> by {@link AbstractFormElementModel#getValue()}, since the
	 * real value is only updated after validation has succeeded.
	 * 
	 * @param feedback
	 *            this feedback object can be used to propagate error messages
	 *            if the validation fails. If the validation is successful, the
	 *            method can simply return and leave the feedback object alone.
	 */
	void validate(ValidationFeedback feedback);
}
