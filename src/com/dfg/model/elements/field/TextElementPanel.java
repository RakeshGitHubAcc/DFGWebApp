package com.dfg.model.elements.field;

import org.apache.wicket.markup.html.basic.Label;

import com.dfg.model.elements.TextModel;

/**
 * A panel that represents a {@link TextModel} in a form.
 * <p/>
 * <strong>Wicket IDs needed in the markup:</strong>
 * <ul>
 * <li><strong>text</strong>: a {@link Label} that displays the text.
 * </ul>
 * 
 * @author Tom Hombergs (tom.hombergs@gmail.com)
 * 
 */
public class TextElementPanel extends AbstractFormElementPanel {

	private static final long serialVersionUID = 1L;

	public TextElementPanel(String id, TextModel model) {
		super(id, model);
		Label label = new Label("text", model.getValue());
		add(label);
	}

}
