package com.dfg.model.elements.field;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.model.PropertyModel;

/**
 * A panel that represents a {@link CheckboxModel_TEMP} in a form.
 * <p/>
 * <strong>Wicket IDs needed in the markup:</strong>
 * <ul>
 * <li><strong>label</strong>: a {@link Label} that displays the label of the
 * text field.
 * <li><strong>inputField</strong>: a {@link CheckBox} that takes the user's
 * input.
 * </ul>
 * 
 * 
 */
public class CheckboxPanel extends AbstractInputFieldPanel<Boolean> {
	private static final long serialVersionUID = 1L;
	private final CheckBox checkbox;

	public CheckboxPanel(String id, CheckboxModel model) {
		super(id, model);

		this.checkbox = new CheckBox("inputField", new PropertyModel<Boolean>(
				model, "value"));
		this.decorateComponent(this.checkbox);
		this.add(this.checkbox);
	}

}
