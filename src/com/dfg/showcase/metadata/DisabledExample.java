package com.dfg.showcase.metadata;

import com.dfg.model.FormModel;
import com.dfg.model.SectionModel;
import com.dfg.model.elements.TextModel;
import com.dfg.model.elements.field.TextFieldModel;

public class DisabledExample extends FormModel {

	private static final long serialVersionUID = 1L;

	public DisabledExample() {
		super("Enabled / Disabled Examples");

		add(new SectionModel("Enabled Field").add(
				new TextModel("All fields are enabled by default.")).add(
				new TextFieldModel<String>("Enabled Text Field", String.class)));

		add(new SectionModel("Disabled Field")
				.add(new TextModel(
						"You can disable a field by calling setEnabled(false)."))
				.add(new TextFieldModel<String>("Disabled Text Field",
						String.class).setEnabled(false)));

	}

}
