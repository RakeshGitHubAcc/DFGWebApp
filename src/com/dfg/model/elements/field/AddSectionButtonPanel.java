package com.dfg.model.elements.field;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.AbstractSubmitLink;
import org.apache.wicket.markup.html.form.Form;

import com.dfg.model.FormModel;
import com.dfg.model.PanelFactory;
import com.dfg.model.SectionModel;
import com.dfg.model.elements.buttons.AddSectionButtonModel;

public class AddSectionButtonPanel extends AbstractFormElementPanel {
	private static final long serialVersionUID = 1L;

	public AddSectionButtonPanel(final String id,
			final AddSectionButtonModel buttonModel, PanelFactory panelFactory) {
		super(id, buttonModel);
	}

	@Override
	protected void onConfigure() {
		// The button must be added in onConfigure, because the parent FormModel
		// can only be determined after this component's hierarchy has been set.
		if (!hasBeenRendered()) {
			AbstractSubmitLink button;
			button = createAjaxButton("button",
					(AddSectionButtonModel) getWickedFormModel());
			button.setDefaultFormProcessing(false);
			button.add(new AttributeModifier("value",
					((AddSectionButtonModel) getWickedFormModel()).getLabel()));
			add(button);
		}
	}

	/**
	 * Creates a button that adds the new section without AJAX.
	 */
	// private SubmitLink createAjaxlessButton(String wicketId, final
	// AddSectionButtonModel buttonModel) {
	// SubmitLink button = new SubmitLink(wicketId) {
	// @Override
	// public void onSubmit() {
	// addNewSection(buttonModel);
	// }
	// };
	// return button;
	// }

	/**
	 * Creates a button that adds the new section via AJAX.
	 */
	private AjaxSubmitLink createAjaxButton(String wicketId,
			final AddSectionButtonModel buttonModel) {
		AjaxSubmitLink button = new AjaxSubmitLink(wicketId) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				addNewSection(buttonModel);
				target.add(getParentSectionPanel());
			}
		};
		return button;
	}

	/**
	 * Adds the section defined by the {@link AddSectionButtonModel} to the
	 * {@link FormModel}.
	 */
	private void addNewSection(final AddSectionButtonModel buttonModel) {
		SectionModel parentSection = getParentSectionModel();
		SectionModel sectionToAdd = buttonModel.createSection();
		if (sectionToAdd != null) {
			parentSection.insertBefore(sectionToAdd, buttonModel);
		}
	}
}
