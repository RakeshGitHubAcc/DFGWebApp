package com.dfg.showcase.validators;

import com.dfg.model.FormModel;
import com.dfg.model.SectionModel;
import com.dfg.model.elements.TextModel;
import com.dfg.model.elements.field.AbstractInputFieldModel;
import com.dfg.model.elements.field.StringTextFieldModel;
import com.dfg.model.validation.FieldValidatorModel;
import com.dfg.model.validation.ValidationFeedback;

public class CustomValidatorExample extends FormModel {

	private static final long serialVersionUID = 1L;

	public CustomValidatorExample() {
		super("Custom Validators");

		add(new TextModel(
				"Wicked Forms comes with a small set of ready-made validators. "
						+ "In most projects, you need your own custom-made validators. To create a custom "
						+ " validator, all you have to do is to implement the interface FieldValidatorModel."));

		add(new SectionModel("Fixed Value Validator")
				.add(new TextModel(
						"This custom-implemented validator checks if the input "
								+ "value exactly matches the string 'mercury'."))
				.add(new StringTextFieldModel("Nearest planet to the sun")
						.add(createMercuryValidator())));

	}

	private FieldValidatorModel<String> createMercuryValidator() {
		return new FieldValidatorModel<String>() {
			private static final long serialVersionUID = 1L;
			@Override
			public void validate(
					final AbstractInputFieldModel<String> inputField,
					final String value, final ValidationFeedback feedback) {
				if (!"mercury".equals(value)) {
					feedback.error(String.format(
							"Your answer to '%s' is wrong.",
							inputField.getLabel()));
				}
			}
		};
	}
}
