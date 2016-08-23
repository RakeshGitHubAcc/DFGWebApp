package com.dfg.showcase.formelements;

import com.dfg.model.FormModel;
import com.dfg.model.SectionModel;
import com.dfg.model.elements.TextModel;
import com.dfg.model.elements.field.TextFieldModel;

public class TextFieldExample extends FormModel {
	private static final long serialVersionUID = 1L;

	public TextFieldExample() {
		super("Text Field Examples");

		add(new SectionModel("Simple Text Field")
				.add(new TextModel(
						"The basic elements in each form are text fields. Nothing fancy."))
				.add(new TextFieldModel<String>("Your name", String.class)));

		add(new SectionModel("Integer Text Field")
				.add(new TextModel(
						"Some text fields require valid integer numbers as input. Try to input something else and hit the submit button."))
				.add(new TextFieldModel<Integer>("Your age", Integer.class)));

		add(new SectionModel("Decimal Text Field")
				.add(new TextModel(
						"Same goes for Float, BigDecimal and Double numbers. Wicked Forms takes advantage of the browser's HTML5 capabilities for client side validation, if possible."))
				.add(new TextFieldModel<Float>("Your monthly income",
						Float.class)));

	}

}
