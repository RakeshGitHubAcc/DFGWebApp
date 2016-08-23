package com.dfg.model.elements.field;

import com.dfg.model.binding.Binding;

public class TextAreaModel extends AbstractInputFieldModel<String> {
	private static final long serialVersionUID = 1L;
	
	private String placeholder;
	/**
	 * @see AbstractInputFieldModel#InputField(String)
	 */
	public TextAreaModel(String label) {
		super(label);
	}

	/**
	 * @see AbstractInputFieldModel#InputField(String, Boolean)
	 */
	public TextAreaModel(String label, String value) {
		super(label, value);
	}

	public TextAreaModel() {
		super();
	}

	/**
	 * @see AbstractInputFieldModel#InputField(String, Binding)
	 */
	public TextAreaModel(String label, Binding<String> binding) {
		super(label, binding);
	}

	/**
	 * Sets the placeholder value that is initially displayed in the input field
	 * (if no value is set yet).
	 * 
	 * @param placeHolder
	 *            the placeholder to show initially.
	 */
	public void setPlaceHolder(String placeHolder) {
		this.placeholder = placeHolder;
	}

	public String getPlaceHolder() {
		return this.placeholder;
	}

	@Override
	public Class<?> getModelClass() {
		return String.class;
	}
}
