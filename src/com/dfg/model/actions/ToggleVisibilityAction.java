
package com.dfg.model.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dfg.model.elements.AbstractFormElementModel;
import com.dfg.model.elements.field.AbstractInputFieldModel;

/**
 * This action allows an input field to get visible or disappear depending on a user
 * input in a specified trigger input field.
 * 
 * 
 * @param <T>
 *            the type of object that the trigger input field is bound to.
 */
public class ToggleVisibilityAction<T> implements FormActionModel<T> {
	private static final long serialVersionUID = 1L;

	private final AbstractInputFieldModel<T> triggerInputField;

	private final T visibleValue;

	private final List<AbstractInputFieldModel<?>> targetElements;
	
	/**
	 * Constructs a new instance.
	 * 
	 * @param triggerInputField
	 *            The input field that serves as trigger for this action. If the
	 *            user changes the value of this input field, the action is
	 *            triggered.
	 * @param enabledValue
	 *            If the user enters this value into the trigger input field,
	 *            the target input fields are enabled.
	 * @param targetInputFields
	 *            The input fields that are the target of this action.
	 */
	public ToggleVisibilityAction(AbstractInputFieldModel<T> triggerInputField, T visibleValue, T disabledValue,
			List<AbstractInputFieldModel<?>> targetInputFields) {
		this.triggerInputField = triggerInputField;
		this.visibleValue = visibleValue;
		this.targetElements = targetInputFields;
	}

	/**
	 * Constructs a new instance.
	 * 
	 * @param triggerInputField
	 *            The input field that serves as trigger for this action. If the
	 *            user changes the value of this input field, the action is
	 *            triggered.
	 * @param enabledValue
	 *            If the user enters this value into the trigger input field,
	 *            the target input fields are enabled.
	 * @param targetInputFields
	 *            The input fields that are the target of this action.
	 */
	public ToggleVisibilityAction(AbstractInputFieldModel<T> triggerInputField, T visibleValue, 
			AbstractInputFieldModel<?>... targetInputFields) {
		this.triggerInputField = triggerInputField;
		this.visibleValue = visibleValue;
		
		this.targetElements = Arrays.asList(targetInputFields);
	}

	@Override
	public List<AbstractInputFieldModel<?>> getTriggerInputFields() {
		List<AbstractInputFieldModel<?>> list = new ArrayList<AbstractInputFieldModel<?>>();
		list.add(this.triggerInputField);
		return list;
	}

	@Override
	public List<AbstractFormElementModel> execute() {
		List<AbstractFormElementModel> list = new ArrayList<AbstractFormElementModel>();
		if (this.visibleValue.equals(this.triggerInputField.getUserInput())) {
			for (AbstractInputFieldModel<?> targetElement : this.targetElements) {
				targetElement.setVisible(true);
				list.add(targetElement);
			}
		} else {
			for (AbstractInputFieldModel<?> targetElement : this.targetElements) {
				targetElement.setVisible(false);
				list.add(targetElement);
			}
		}
		return list;
	}
}
