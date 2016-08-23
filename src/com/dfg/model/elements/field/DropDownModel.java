package com.dfg.model.elements.field;

import java.util.List;

import com.dfg.model.binding.Binding;
/**
 * A drop down field that enables a user to select one of a set of objects. It
 * is bound to single object of type T.
 * 
 * @param <T>
 *            the type of the items that can be selected by the drop down field.
 */
public class DropDownModel<T> extends AbstractSingleChoiceModel<T> {
	private static final long serialVersionUID = 1L;

	public DropDownModel(final String label, final List<T> choices, Class<T> modelClass) {
		super(label, choices, modelClass);
	}

	/**
	 * @see AbstractSingleChoiceModel#SingleChoice(String, List)
	 */
	public DropDownModel(final String label, final List<T> choices, final ChoiceLabeller<T> choiceLabeller,
			Class<T> modelClass) {
		super(label, choices, choiceLabeller, modelClass);
	}

	/**
	 * @see AbstractSingleChoiceModel#SingleChoice(String, List, Object)
	 */
	public DropDownModel(final String label, final List<T> choices, final ChoiceLabeller<T> choiceLabeller,
			final T selectedValue, Class<T> modelClass) {
		super(label, choices, choiceLabeller, selectedValue, modelClass);
	}

	/**
	 * @see AbstractSingleChoiceModel#SingleChoice(String, List, Binding)
	 */
	public DropDownModel(final String label, final List<T> choices, final ChoiceLabeller<T> choiceLabeller,
			final Binding<T> binding, Class<T> modelClass) {
		super(label, choices, choiceLabeller, binding, modelClass);
	}
}
