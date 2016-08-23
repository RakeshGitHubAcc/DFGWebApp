package com.dfg.model.elements.field;

import com.dfg.model.binding.Binding;

public class StringTextFieldModel extends TextFieldModel<String> {
	private static final long serialVersionUID = 1L;

	public StringTextFieldModel() {
		super(String.class);
	}

	public StringTextFieldModel(final String label) {
		super(label, String.class);
	}

	public StringTextFieldModel(final String label,
			final Binding<String> binding) {
		super(label, binding, String.class);
	}

	public StringTextFieldModel(final String label, final String value) {
		super(label, value, String.class);
	}

	@Override
	public Class<String> getModelClass() {
		return String.class;
	}
}
