package com.dfg.showcase.advanced;

import com.dfg.model.FormModel;
import com.dfg.model.SectionModel;
import com.dfg.model.actions.ToggleVisibilityAction;
import com.dfg.model.elements.TextModel;
import com.dfg.model.elements.field.CheckboxModel;
import com.dfg.model.elements.field.StringTextFieldModel;

public class ConditionalVisibilityExample extends FormModel {
	private static final long serialVersionUID = 1L;

	public ConditionalVisibilityExample() {
		super("Conditional Visibility of Input Fields");
		this.add(new TextModel(
				"Sometimes, forms have to adapt to the user input. Wicked Forms supports "
						+ "hiding or showing certain form elements when the user enters some pre-defined value. You "
						+ "simply have to add a ToggleVisibilityAction to the input field that shall serve as trigger."));
		this.add(createVisibleCheckboxSection());
	}

	private SectionModel createVisibleCheckboxSection() {

		StringTextFieldModel visibleField = new StringTextFieldModel(
				"Your Toggle");
		visibleField.setVisible(true);
		CheckboxModel triggerVisibleCheckbox = new CheckboxModel(
				"check to hide the Textfield below!");
		triggerVisibleCheckbox.add(new ToggleVisibilityAction<Boolean>(
				triggerVisibleCheckbox, Boolean.FALSE, visibleField));

		return new SectionModel("Checkbox Visible Trigger")
				.add(new TextModel(
						"A checkbox can serve as trigger for toggling the visibility of another form element. Mark and unmark the checkbox to see what happens."))
				.add(triggerVisibleCheckbox).add(visibleField);
	}

}
