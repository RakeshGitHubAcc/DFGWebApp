package com.dfg.model.actions;

import java.io.Serializable;
import java.util.List;

import com.dfg.model.elements.AbstractFormElementModel;
import com.dfg.model.elements.field.AbstractInputFieldModel;

public interface FormActionModel<T> extends Serializable {
	/**
	 * Returns a list of the input fields which act as trigger to this action.
	 * If the user changes the values in these fields, the action is triggered.
	 * The values the user entered into the returned input fields can be
	 * accessed within the {@link #execute()} method via {@link AbstractInputFieldModel#getUserInput().
	 * 
	 * @return list of the input fields that act as trigger to this action.
	 */
	List<AbstractInputFieldModel<?>> getTriggerInputFields();

	/**
	 * Executes the action. All elements returned by
	 * {@link #getTriggerInputFields()} have their user input values updated
	 * which can be accessed here via
	 * {@link AbstractInputFieldModel#getUserInput()}.
	 * <p/>
	 * Within this method, you can change the state of form elements within your
	 * {@link FormModel} as you wish. However, <strong>no new form elements may
	 * be added and no existing form elements may be removed</strong>! All form
	 * elements whose state has changed must be part of the result list of this
	 * method so that the interpreter knows which elements he has to re-render.
	 * 
	 * @return list of all form elements whose state has changed within this
	 *         method.
	 */
	List<AbstractFormElementModel> execute();
}
