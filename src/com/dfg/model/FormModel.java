package com.dfg.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dfg.model.elements.AbstractFormElementModel;
import com.dfg.model.validation.FormValidatorModel;
/**
 * This class is the starting point for creating a dynamic form. 
 * You can add one or more {@link SectionModel}s to the form, which in
 * turn contain the actual form elements.
 * <p/>
 * Forms interpreters should display the form as a HTML form that
 * captures the user's input.
 * 
 */
public class FormModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private final SectionModel mainSection = new SectionModel();
	private final List<FormValidatorModel> validators = new ArrayList<FormValidatorModel>();
	private final String label;
	/**
	 * Constructor.
	 * 
	 * @param label
	 *            the title of the form. This title should be displayed
	 *            prominently at the top of the form .
	 */
	public FormModel(final String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	/**
	 * Adds a form element to the form.
	 * 
	 * @param formElement
	 *            the form element to add.
	 * @return this object for chaining
	 */
	public FormModel add(final AbstractFormElementModel formElement) {
		getMainSection().add(formElement);
		return this;
	}

	/**
	 * Adds a form validator to the form.
	 * 
	 * @param validator
	 *            the validator to add.
	 * @return this object for chaining
	 */
	public FormModel add(final FormValidatorModel validator) {
		validators.add(validator);
		return this;
	}

	/**
	 * Retrieves the validators that have been added to the form.
	 * 
	 * @return the list of validators.
	 */
	public List<FormValidatorModel> getValidators() {
		return validators;
	}

	/**
	 * Assigns a unique ID to each form element contained in this form if it
	 * doesn't have an id yet.
	 */
	public void assignIds() {
		getMainSection().assignIds(1);
	}

	public SectionModel getMainSection() {
		return mainSection;
	}
}
