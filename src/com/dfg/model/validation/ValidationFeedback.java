package com.dfg.model.validation;
/**
 * This interface defines a means to propagate messages for validation errors to
 * the actual framework that is responsible for displaying a form. This
 * interface must be implemented for each view technology that wants to support
 * Wicked Charts.
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 */
public interface ValidationFeedback {
	/**
	 * This method is called when a validation of an input field fails. An
	 * implementation of this interface must forward this message to the
	 * framework responsible for displaying the validation messages on the
	 * screen.
	 * 
	 * @param message
	 *            the error message explaining what validation failed. This
	 *            message is to be displayed to the user so it should provide an
	 *            understandable explanation.
	 */
	void error(String message);
}
