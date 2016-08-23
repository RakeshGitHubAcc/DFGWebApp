package com.dfg.model.elements.field;

import com.dfg.model.binding.Binding;
/**
 * A text field that may contain a string, a number or any other type that can
 * be represented as a string. A text field binds to a single object of type T.
 * 
 * @param <T>
 *            the type of object the text field binds to.
 */
public class TextFieldModel<T> extends AbstractInputFieldModel<T> {
	private static final long serialVersionUID = 1L;
	private String placeholder;

	private final Class<T> modelClass;

	public TextFieldModel(final Class<T> modelClass) {
		super();
		this.modelClass = modelClass;
	}

	/**
	 * @see AbstractInputFieldModel#InputField(String, Binding)
	 */
	public TextFieldModel(final String label, final Binding<T> binding,
			final Class<T> modelClass) {
		super(label, binding);
		this.modelClass = modelClass;
	}

	/**
	 * @param modelClass
	 *            the class of the object this text field takes as input
	 * @see AbstractInputFieldModel#InputField(String)
	 */
	public TextFieldModel(final String label, final Class<T> modelClass) {
		super(label);
		this.modelClass = modelClass;
	}

	/**
	 * @see AbstractInputFieldModel#InputField(String, Boolean)
	 */
	public TextFieldModel(final String label, final T value,
			final Class<T> modelClass) {
		super(label, value);
		this.modelClass = modelClass;
	}

	public String getPlaceHolder() {
		return this.placeholder;
	}

	/**
	 * Sets the placeholder value that is initially displayed in the input field
	 * (if no value is set yet).
	 * 
	 * @param placeHolder
	 *            the placeholder to show initially.
	 */
	public void setPlaceHolder(final String placeHolder) {
		this.placeholder = placeHolder;
	}

	@Override
	public Class<T> getModelClass() {
		return this.modelClass;
	};

}
