package com.dfg.model;

import java.io.Serializable;

import org.apache.wicket.markup.html.panel.Panel;

import com.dfg.model.elements.AbstractFormElementModel;
/**
 * A PanelFactory is responsible for creating a Wicket {@link Panel} for each
 * {@link AbstractFormElementModel}.
 * <p/>
 * By providing a custom implementation (that extends
 * {@link DefaultPanelFactory}, you can add your own form elements.
 * 
 * 
 */
public interface PanelFactory extends Serializable{
	/**
	 * Creates a panel that contains a form element that is described by the given
	 * subtype of {@link AbstractFormElementModel}.
	 * 
	 * @param wicketId
	 *          the Wicket ID of the panel that is to be created.
	 * @param element
	 *          the model of the form element to create the panel for.
	 * @return
	 */
	Panel createFormElementPanel(final String wicketId, final AbstractFormElementModel element);
}
