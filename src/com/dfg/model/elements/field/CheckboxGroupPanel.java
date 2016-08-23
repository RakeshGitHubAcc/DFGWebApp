package com.dfg.model.elements.field;

import java.util.Collection;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBoxMultipleChoice;
import org.apache.wicket.model.PropertyModel;

import com.dfg.model.elements.WickedFormsChoiceRenderer;

/**
 * A panel that represents a {@link CheckboxGroupModel} in a form.
 * <p/>
 * <strong>Wicket IDs needed in the markup:</strong>
 * <ul>
 * <li><strong>label</strong>: a {@link Label} that displays the label of the
 * text field.
 * <li><strong>inputField</strong>: a {@link CheckBoxMultipleChoice} that takes
 * the user's input.
 * </ul>
 * 
 * 
 */
public class CheckboxGroupPanel<T> extends AbstractInputFieldPanel<List<T>> {
	private static final long serialVersionUID = 1L;
	private final CheckBoxMultipleChoice<T> checkgroup;

	public CheckboxGroupPanel(final String id, final CheckboxGroupModel<T> model) {
		super(id, model);

		this.checkgroup = new CheckBoxMultipleChoice<T>("inputField",
				new PropertyModel<Collection<T>>(model, "value"),
				model.getChoices());
		this.decorateComponent(this.checkgroup);
		this.checkgroup.setChoiceRenderer(WickedFormsChoiceRenderer
				.fromChoiceLabeller(model.getChoiceLabeller()));
		this.add(this.checkgroup);
	}

}
