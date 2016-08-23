package com.dfg.model.validation;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.validation.IFormValidator;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;

import com.dfg.model.elements.field.AbstractFormElementPanel;
import com.dfg.model.elements.field.AbstractInputFieldModel;

public class WickedFormValidator implements IFormValidator {
	private static final long serialVersionUID = 1L;

	private final FormValidatorModel validatorModel;

	/**
	 * List of the Wicket form components that are relevant for this form
	 * validator.
	 */
	private List<FormComponent<?>> formComponents;

	private final Form<?> form;

	public WickedFormValidator(FormValidatorModel validatorModel, Form<?> form) {
		this.validatorModel = validatorModel;
		this.form = form;
	}

	/**
	 * Returns the input field model attached to this validator with the given
	 * id.
	 * 
	 * @param id
	 *            the id to look for.
	 * @return the input field model with the given id, or null if no input
	 *         field model with this id is attached to this validator.
	 */
	private AbstractInputFieldModel getFieldModelWithId(String id) {
		for (AbstractInputFieldModel<?> field : validatorModel.getRelevantInputFields()) {
			if (field.getId().equals(id)) {
				return field;
			}
		}
		return null;
	}

	@Override
	public FormComponent<?>[] getDependentFormComponents() {
		updateFormComponents();
		return formComponents.toArray(new FormComponent<?>[] {});
	}

	@Override
	public void validate(Form<?> form) {
		updateFormComponents();
		validatorModel.validate(new WicketFormValidationFeedback(form));
	}

	private void updateFormComponents() {
		formComponents = new ArrayList<FormComponent<?>>();
		form.visitFormComponents(new IVisitor<FormComponent<?>, Void>() {
			@Override
			public void component(FormComponent<?> component, IVisit<Void> visit) {
				String id = component.getMetaData(AbstractFormElementPanel.COMPONENT_ID_KEY);
				AbstractInputFieldModel inputFieldModel = getFieldModelWithId(id);
				if (inputFieldModel != null) {
					formComponents.add(component);
					inputFieldModel.setUserInput(component.getConvertedInput());
				}
			}
		});
	}

	class WicketFormValidationFeedback implements ValidationFeedback {

		private final Form<?> form;

		public WicketFormValidationFeedback(Form<?> form) {
			this.form = form;
		}

		@Override
		public void error(String message) {
			this.form.error(message);
		}

	}
}
