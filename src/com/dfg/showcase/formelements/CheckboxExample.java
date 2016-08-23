package com.dfg.showcase.formelements;

import com.dfg.model.FormModel;
import com.dfg.model.SectionModel;
import com.dfg.model.elements.TextModel;
import com.dfg.model.elements.field.CheckboxModel;

public class CheckboxExample extends FormModel {

	private static final long serialVersionUID = 1L;

	public CheckboxExample() {
		super("Checkbox Examples");

		add(new SectionModel("Simple Checkbox").add(
				new TextModel("A simple checkbox. Wow!")).add(
				new CheckboxModel("Subscribe Newsletter?")));

		add(new SectionModel("Selected Checkbox").add(
				new TextModel("A selected checkbox.")).add(
				new CheckboxModel("Subscribe Newsletter?", true)));

		add(new SectionModel("Disabled Checkbox")
				.add(new TextModel(
						"Most form elements support the method setEnabled() to enable or disable them. "))
				.add(new CheckboxModel("Did you read the terms and conditions?")
						.setEnabled(false).setValue(true)));

	}

}
