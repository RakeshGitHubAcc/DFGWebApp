package com.dfg.model.elements.field;

import com.dfg.model.binding.Binding;
/**
 * A checkbox that can be marked or not and thus is bound to a boolean value.
 * 
 */
public class CheckboxModel extends AbstractInputFieldModel<Boolean> {
	private static final long serialVersionUID = 1L;

	/**
	 * @see AbstractInputFieldModel(String)
	 */
	public CheckboxModel(String label) {
		super(label);
	}

	/**
	 * @see AbstractInputFieldModel#InputField(String, Boolean)
	 */
	public CheckboxModel(String label, Boolean value) {
		super(label, value);
	}

	/**
	 * @see AbstractInputFieldModel#InputField(String, Binding)
	 */
	public CheckboxModel(String label, Binding<Boolean> binding) {
		super(label, binding);
	}

	public CheckboxModel() {
		super();
	}

	@Override
	public Class<?> getModelClass() {
		return Boolean.class;
	}

}
