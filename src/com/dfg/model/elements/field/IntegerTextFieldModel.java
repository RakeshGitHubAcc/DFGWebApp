package com.dfg.model.elements.field;

import com.dfg.model.binding.Binding;

public class IntegerTextFieldModel extends TextFieldModel<Integer> {
	private static final long serialVersionUID = 1L;

	public IntegerTextFieldModel() {
		super(Integer.class);
	}

	public IntegerTextFieldModel(final String label) {
		super(label, Integer.class);
	}

	public IntegerTextFieldModel(final String label,
			final Binding<Integer> binding) {
		super(label, binding, Integer.class);
	}

	public IntegerTextFieldModel(final String label, final Integer value) {
		super(label, value, Integer.class);
	}

	@Override
	public Class<Integer> getModelClass() {
		return Integer.class;
	}
}
