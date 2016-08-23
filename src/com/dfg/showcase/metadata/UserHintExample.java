package com.dfg.showcase.metadata;

import com.dfg.model.FormModel;
import com.dfg.model.SectionModel;
import com.dfg.model.elements.TextModel;
import com.dfg.model.elements.field.TextFieldModel;

public class UserHintExample extends FormModel {

	private static final long serialVersionUID = 1L;

	public UserHintExample() {
		super("User Hint Examples");

		add(new SectionModel("User Hint")
				.add(new TextModel(
						"For most input elements you can provide a user hint that by default pops"
								+ " up when you focus the field. Focus the following input field and see what"
								+ " happens. You can change the behavior of the user hint by modifying the CSS."))
				.add(new TextFieldModel<String>("Your name", String.class)
						.setHint("Please enter your first name only.")));

	}

}
