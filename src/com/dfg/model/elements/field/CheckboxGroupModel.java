package com.dfg.model.elements.field;

import java.util.List;

import com.dfg.model.binding.Binding;

/**
 * A group of checkboxes that belong together. A checkbox group is bound to a
 * list of objects since more than one checkbox may be marked by a user.
 * 
 * @param <T>
 *            the type of object that is each represented by one checkbox
 */
public class CheckboxGroupModel<T> extends AbstractMultiChoiceModel<T> {
	private static final long serialVersionUID = 1L;

	public CheckboxGroupModel(final String label, final List<T> choices) {
		super(label, choices);
	}

	/**
	 * @see AbstractMultiChoiceModel#MultiChoice(String, List)
	 */
	public CheckboxGroupModel(final String label, final List<T> choices,
			final ChoiceLabeller<T> choiceLabeller) {
		super(label, choices, choiceLabeller);
	}

	/**
	 * @see AbstractMultiChoiceModel#MultiChoice(String, List, List)
	 */
	public CheckboxGroupModel(final String label, final List<T> choices,
			final ChoiceLabeller<T> choiceLabeller, final List<T> value) {
		super(label, choices, choiceLabeller, value);
	}

	/**
	 * @see AbstractMultiChoiceModel#MultiChoice(String, List, Binding)
	 */
	public CheckboxGroupModel(final String label, final List<T> choices,
			final ChoiceLabeller<T> choiceLabeller,
			final Binding<List<T>> binding) {
		super(label, choices, choiceLabeller, binding);
	}

	public CheckboxGroupModel(final List<T> choices,
			final ChoiceLabeller<T> choiceLabeller) {
		super(choices, choiceLabeller);
	}
}
