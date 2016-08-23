package com.dfg.showcase.metadata;

import com.dfg.model.FormModel;
import com.dfg.model.SectionModel;
import com.dfg.model.elements.TextModel;
import com.dfg.model.elements.field.CheckboxModel;
import com.dfg.model.elements.field.TextFieldModel;

public class LabelExample extends FormModel {

	private static final long serialVersionUID = 1L;

	public LabelExample() {
		super("Label Examples (this is the form label)");

		add(new SectionModel("Label on an input field")
				.add(new TextModel(
						"Each input field in a form should have a label. Otherwise the user won't know what to input. Most form elements accept a label String in the constructor."))
				.add(new TextFieldModel<String>("This is a text field label",
						String.class))
				.add(new CheckboxModel("This is a checkbox label")));

		add(new SectionModel("This is a section label")
				.add(new TextModel(
						"Not only input fields have labels. Each section also has a label.")));

	}

}
