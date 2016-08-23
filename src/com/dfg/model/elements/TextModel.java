package com.dfg.model.elements;

import com.dfg.model.binding.Binding;
/**
 * A form element that simply displays a text. It should be treated as read only
 * by an interpreter.
 * 
 */
public class TextModel extends AbstractBoundFieldModel<String> {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param text
	 *            the text that should be displayed by this form element.
	 */
	public TextModel(String text) {
		super(text);
	}

	/**
	 * Constructor with binding.
	 * 
	 * @param binding
	 *            the binding to back this form element.
	 * @see AbstractFormElementModel#FormElement(Binding)
	 */
	public TextModel(Binding<String> binding) {
		super(binding);
	}
}
