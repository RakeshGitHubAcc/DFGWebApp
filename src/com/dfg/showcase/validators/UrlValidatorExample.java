package com.dfg.showcase.validators;

import com.dfg.model.FormModel;
import com.dfg.model.elements.TextModel;
import com.dfg.model.elements.field.StringTextFieldModel;
import com.dfg.model.validation.UrlValidatorModel;

public class UrlValidatorExample extends FormModel {

	private static final long serialVersionUID = 1L;

	public UrlValidatorExample() {
		super("URL Validator");

		add(
				new TextModel(
						"This validator checks against a regular expression"
								+ " if the input value is a valid URL including the "
								+ "protocol prefix (i.e. 'http://'). Type in an invalid URL and submit the form."))
				.add(new StringTextFieldModel("Your web site URL")
						.add(new UrlValidatorModel()));

	}
}
