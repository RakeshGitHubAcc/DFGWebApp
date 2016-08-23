package com.dfg.model.elements.field;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.PropertyModel;

/**
 * A panel that represents a {@link TextAreaModel} in a form.
 * <p/>
 * <strong>Wicket IDs needed in the markup:</strong>
 * <ul>
 * <li><strong>label</strong>: a {@link Label} that displays the label of the
 * text field.
 * <li><strong>inputField</strong>: a {@link TextArea} that takes the user's
 * input.
 * </ul>
 * 
 * 
 */
public class TextAreaPanel extends AbstractInputFieldPanel<String> {

	private static final long serialVersionUID = 1L;
	private final TextArea<String> textField;

	public TextAreaPanel(String id, TextAreaModel model) {
		super(id, model);

		this.textField = new TextArea<String>("inputField",
				new PropertyModel<String>(model, "value"));
		this.decorateComponent(this.textField);

		if (model.getPlaceHolder() != null
				&& !"".equals(model.getPlaceHolder())) {
			this.textField.add(new AttributeModifier("placeholder", model
					.getPlaceHolder()));
		}

		this.add(this.textField);
	}

}
