package com.dfg.model.elements;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;

import com.dfg.model.FormModel;
import com.dfg.model.PanelFactory;
import com.dfg.model.elements.field.SectionPanel;
import com.dfg.model.validation.FormValidatorModel;
import com.dfg.model.validation.WickedFormValidator;

public class DynamicForm extends Form<FormModel>{
	private static final long serialVersionUID = 1L;
	private final Submittable submittable;

	public DynamicForm(final String id, final IModel<FormModel> model, PanelFactory panelFactory,
			Submittable submittable) {
		super(id, model);
		this.submittable = submittable;
		FormModel formModel = model.getObject();
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedback") {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isVisible() {
				return hasError();
			}
		};

		add(feedbackPanel);
		add(new Label("formTitle", formModel.getLabel()));
		add(new SectionPanel("sectionPanel", formModel.getMainSection(), panelFactory));

		for (FormValidatorModel formValidator : formModel.getValidators()) {
			add(new WickedFormValidator(formValidator, this));
		}
	}

	@Override
	protected void onSubmit() {
		this.submittable.onSubmit(getModelObject());
	}
}
