package com.dfg.model.elements;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.PackageResourceReference;

import com.dfg.model.DefaultPanelFactory;
import com.dfg.model.FormModel;
import com.dfg.model.PanelFactory;

public abstract class FormPanel extends Panel implements Submittable {
	private static final long serialVersionUID = 1L;
	private final PanelFactory panelFactory;

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            the wicket id this panel should bind to.
	 * @param model
	 *            the form model that describes the contents of the form.
	 */
	public FormPanel(final String id, final IModel<FormModel> model) {
		super(id, model);
		model.getObject().assignIds();
		this.panelFactory = new DefaultPanelFactory();
		add(new DynamicForm("form", model, panelFactory, this));
		mountResources();
	}

	@SuppressWarnings("unchecked")
	public FormPanel(final String id, final FormModel formModel) {
		super(id, Model.of(formModel));
		formModel.assignIds();
		this.panelFactory = new DefaultPanelFactory();
		add(new DynamicForm("form", (IModel<FormModel>) getDefaultModel(),
				panelFactory, this));
		mountResources();
	}

	/**
	 * Constructor defining a {@link PanelFactory}. The {@link PanelFactory} is
	 * responsible for creating the sub panels that each contain an element of
	 * the form (i.e. a text field, a checkbox, ...). By providing a custom
	 * {@link PanelFactory}, you can define your own panels with their own HTML
	 * markup to be used and thus override the default look & feel.
	 * 
	 * @param id
	 *            the wicket id this panel should bind to.
	 * @param model
	 *            the form model that describes the contents of the form.
	 * @param panelFactory
	 *            the factory to use for creating the sub panels that each
	 *            contain a form element (text field, checkbox, ...).
	 */
	public FormPanel(final String id, final IModel<FormModel> model,
			final PanelFactory panelFactory) {
		super(id, model);
		model.getObject().assignIds();
		this.panelFactory = panelFactory;
		add(new DynamicForm("form", model, panelFactory, this));
		mountResources();
	}

	/**
	 * Retrieves all {@link HeaderItem}s like Javascript files and CSS files
	 * that should be included in each page that contains a {@link FormPanel}.
	 * Override this method to provide different CSS.
	 * 
	 * @return all {@link HeaderItem}s to add to the page.
	 */
	protected List<HeaderItem> getHeaderItems() {
		List<HeaderItem> headerItems = new ArrayList<HeaderItem>();
		headerItems.add(CssHeaderItem
				.forReference(new PackageResourceReference(FormPanel.class,
						"FormPanel.css")));
		return headerItems;
	}

	private void mountResources() {
		WebApplication application = ((WebApplication) getApplication());
		application.mountResource("wickedforms/invalid.png",
				new PackageResourceReference(FormPanel.class, "invalid.png"));
		application.mountResource("wickedforms/red_asterisk.png",
				new PackageResourceReference(FormPanel.class,
						"red_asterisk.png"));
		application.mountResource("wickedforms/valid.png",
				new PackageResourceReference(FormPanel.class, "valid.png"));
	}

	/**
	 * Executed when the form is submitted.
	 * 
	 * @param submittedData
	 *            the {@link FormModel} object containing the state of the form
	 *            at submit time. If you have used Bindings and implemented
	 *            {@link AbstractFormElementModel#onDiscard} to clean up after
	 *            discarded elements, the user input will be bound to the target
	 *            objects by now and you will not actually need to evaluate this
	 *            parameter.
	 *            <p/>
	 *            If you need to evaluate this parameter, be aware that elements
	 *            that were marked as "discarded" while the user worked with the
	 *            form, are still contained. Call
	 *            {@link AbstractFormElementModel#isDiscarded()} on each element
	 *            before evaluating it.
	 */
	@Override
	public abstract void onSubmit(final FormModel submittedData);

	@Override
	public void renderHead(final IHeaderResponse response) {
		for (HeaderItem headerItem : getHeaderItems()) {
			response.render(headerItem);
		}
	}

	public FormModel getWickedFormModel() {
		return (FormModel) getDefaultModelObject();
	}
}
