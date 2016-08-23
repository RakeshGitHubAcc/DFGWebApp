package com.dfg.showcase.formelements;

import com.dfg.model.FormModel;
import com.dfg.model.SectionModel;
import com.dfg.model.elements.TextModel;
import com.dfg.model.elements.field.StringTextFieldModel;

public class RequiredExample extends FormModel {
	private static final long serialVersionUID = 1L;

	public RequiredExample() {
		super("Required Input Field Examples");

		add(new SectionModel("Optional Text Field")
				.add(new TextModel(
						"This is a field that the user does not need to fill out. This is the default behavior."))
				.add(new StringTextFieldModel("Optional Field")));

		add(new SectionModel("Required Text Field")
				.add(new TextModel(
						"This is a field that the user is required to fill out. Try to submit the form without entering text in this field."))
				.add(new StringTextFieldModel("Required Field")
						.setRequired(true)));

	}

}
