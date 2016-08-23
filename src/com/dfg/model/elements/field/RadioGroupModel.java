package com.dfg.model.elements.field;

import java.util.List;

import com.dfg.model.binding.Binding;

/**
 * A group of radio buttons of which the user may select exactly one. A radio
 * group is bound to a single object of type T.
 * 
 * @param <T>
 *            type of the objects that the user may select from.
 */
public class RadioGroupModel<T> extends AbstractSingleChoiceModel<T> {
	private static final long serialVersionUID = 1L;

	public RadioGroupModel(final String label, final List<T> choices,
			Class<T> modelClass) {
		super(label, choices, modelClass);
	}

	/**
	 * @see AbstractSingleChoiceModel#SingleChoice(String, List)
	 */
	public RadioGroupModel(final String label, final List<T> choices,
			final ChoiceLabeller<T> choiceLabeller, Class<T> modelClass) {
		super(label, choices, choiceLabeller, modelClass);
	}

	/**
	 * @see AbstractSingleChoiceModel#SingleChoice(String, List, Object)
	 */
	public RadioGroupModel(final String label, final List<T> choices,
			final ChoiceLabeller<T> choiceLabeller, final T selectedValue,
			Class<T> modelClass) {
		super(label, choices, choiceLabeller, selectedValue, modelClass);
	}

	/**
	 * @see AbstractSingleChoiceModel#SingleChoice(String, List, Binding)
	 */
	public RadioGroupModel(final String label, final List<T> choices,
			final ChoiceLabeller<T> choiceLabeller, final Binding<T> binding,
			Class<T> modelClass) {
		super(label, choices, choiceLabeller, binding, modelClass);
	}

	public RadioGroupModel(final List<T> choices,
			final ChoiceLabeller<T> choiceLabeller, Class<T> modelClass) {
		super(choices, choiceLabeller, modelClass);
	}
}
