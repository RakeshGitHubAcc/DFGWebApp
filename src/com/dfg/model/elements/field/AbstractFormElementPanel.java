package com.dfg.model.elements.field;

import org.apache.wicket.Component;
import org.apache.wicket.MetaDataKey;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;

import com.dfg.model.FormModel;
import com.dfg.model.SectionModel;
import com.dfg.model.elements.AbstractFormElementModel;
import com.dfg.model.elements.FormPanel;

/**
 * Base class for all panels that represent a form element within a form.
 * 
 */
public abstract class AbstractFormElementPanel extends Panel {
	private static final long serialVersionUID = 1L;

	/**
	 * Key for storing the ID of an {@link AbstractFormElementModel} in a Wicket
	 * component.
	 */
	public static final MetaDataKey<String> COMPONENT_ID_KEY = new MetaDataKey<String>() {
		private static final long serialVersionUID = 1L;
	};

	private final AbstractFormElementModel model;

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            the wicket id.
	 * @param model
	 *            the Wicked Charts model object that is displayed by this
	 *            panel.
	 */
	public AbstractFormElementPanel(String id, AbstractFormElementModel model) {
		super(id);
		this.model = model;
		setRenderBodyOnly(true);
		setVisible(model.isVisible());
	}

	/**
	 * Decorates a component of the form. Must be called by subclasses for each
	 * component that represents a Wicked Charts model object (e.g. a subclass
	 * panel that displays a text field must call this method with the
	 * {@link TextField} component).
	 * 
	 * @param component
	 *            the component to decorate.
	 */
	protected void decorateComponent(Component component) {
		component.setMetaData(COMPONENT_ID_KEY, model.getId());
	}

	protected AbstractFormElementModel getWickedFormModel() {
		return model;
	}

	public FormModel getParentFormModel() {
		FormPanel parentFormPanel = getParentFormPanel();
		if (parentFormPanel == null) {
			throw new IllegalStateException(
					"no FormPanel could be found in the parent hierarchy");
		} else {
			return parentFormPanel.getWickedFormModel();
		}
	}

	public FormPanel getParentFormPanel() {
		Component parent = getParent();
		while (parent != null) {
			if (parent instanceof FormPanel) {
				return (FormPanel) parent;
			}
			parent = parent.getParent();
		}
		return null;
	}

	public SectionModel getParentSectionModel() {
		SectionPanel parentSectionPanel = getParentSectionPanel();
		if (parentSectionPanel == null) {
			throw new IllegalStateException(
					"no SectionPanel could be found in the parent hierarchy");
		} else {
			return (SectionModel) parentSectionPanel.getWickedFormModel();
		}
	}

	public SectionPanel getParentSectionPanel() {
		Component parent = getParent();
		while (parent != null) {
			if (parent instanceof SectionPanel) {
				return (SectionPanel) parent;
			}
			parent = parent.getParent();
		}
		return null;
	}

}
