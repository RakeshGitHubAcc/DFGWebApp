package com.dfg.model.validation;

import com.dfg.model.elements.field.AbstractInputFieldModel;

public class UrlValidatorModel implements FieldValidatorModel<String> {

	private static final long serialVersionUID = 1L;

	@Override
	public void validate(final AbstractInputFieldModel<String> inputField,
			final String value, final ValidationFeedback feedback) {
		if (!value
				.matches("(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?")) {
			feedback.error(String.format(
					"The value for '%s' is not a valid URL!",
					inputField.getLabel()));
		}

	}

}
