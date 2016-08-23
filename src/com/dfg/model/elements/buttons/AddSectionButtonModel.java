package com.dfg.model.elements.buttons;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.dfg.model.SectionModel;
import com.dfg.model.elements.AbstractFormElementModel;
/**
 * Use this model to add a button to a form that allows to add a new section to
 * the form.
 * 
 */
public abstract class AddSectionButtonModel extends AbstractFormElementModel {
	private static final long serialVersionUID = 1L;
	private String label;

	public AddSectionButtonModel(String label) {
		this.label = label;
	}

	public void setLabel(final String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	/**
	 * Creates the section that is to be added to the form when the button is
	 * clicked. This section will be added directly ABOVE the section the button
	 * is part of.
	 * 
	 * @return the section to be added to the form. May be null if no section is
	 *         to be added.
	 */
	public abstract SectionModel createSection();

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
