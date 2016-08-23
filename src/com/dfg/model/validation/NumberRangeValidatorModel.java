package com.dfg.model.validation;

import com.dfg.model.elements.field.AbstractInputFieldModel;
/**
 * A simple validator that checks if a value is within a defined threshold.
 * 
 * @param <T>
 *          the type of Number to be validates
 */
public class NumberRangeValidatorModel<T extends Number> implements
		FieldValidatorModel<T> {
	private static final long serialVersionUID = 1L;

	private final T min;
	private final T max;

	/**
	 * Constructs a {@link NumberRangeValidatorModel} with the given thresholds.
	 * 
	 * @param min
	 *            the minimum threshold to validate against. May be null. In
	 *            this case, the input value is not checked against a lower
	 *            threshold.
	 * @param max
	 *            the maximum threshold to validate against. May be null. In
	 *            this case, the input value is not checked against an upper
	 *            threshold.
	 */
	public NumberRangeValidatorModel(final T min, final T max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public void validate(final AbstractInputFieldModel<T> inputField,
			final T value, final ValidationFeedback feedback) {

		if (this.min != null && value != null
				&& value.doubleValue() < this.min.doubleValue()) {
			feedback.error(String.format(
					"The value for '%s' is below the minimum of %s",
					inputField.getLabel(), this.min));
		}
		if (this.max != null && value != null
				&& value.doubleValue() > this.max.doubleValue()) {
			feedback.error(String.format(
					"The value for '%s' is above the maximum of %s",
					inputField.getLabel(), this.max));
		}

	}

}
