package com.dfg.model.elements.field;

import java.util.List;

import com.dfg.model.binding.Binding;
/**
 * Abstract base class for all input fields that allow a user to select one or
 * more items from a specified selection of items. An input field of this type
 * binds to a list of objects of type T.
 * 
 * @param <T>
 *          the type of an item that can be selected by the user.
 */
public class AbstractMultiChoiceModel<T> extends
		AbstractInputFieldModel<List<T>> {
	private static final long serialVersionUID = 1L;

	protected final List<T> choices;

	private final ChoiceLabeller<T> choiceLabeller;

	public AbstractMultiChoiceModel(final String label, final List<T> choices) {
		super(label);
		this.choices = choices;
		this.choiceLabeller = new ToStringChoiceLabeller<T>();
	}

	/**
	 * Constructor.
	 * 
	 * @param label
	 *            the label of the input field.
	 * @param choices
	 *            the list of choices that are displayed to the user and of
	 *            which the user may select one or more.
	 */
	public AbstractMultiChoiceModel(final String label, final List<T> choices,
			final ChoiceLabeller<T> choiceLabeller) {
		super(label);
		this.choices = choices;
		this.choiceLabeller = choiceLabeller;
	}

	/**
	 * Constructor with initial value.
	 * 
	 * @param label
	 *            the label of the input field.
	 * @param choices
	 *            the list of choices that are displayed to the user and of
	 *            which the user may select one or more.
	 * @param value
	 *            the list of items that are initially selected.
	 */
	public AbstractMultiChoiceModel(final String label, final List<T> choices,
			final ChoiceLabeller<T> choiceLabeller, final List<T> value) {
		super(label, value);
		this.choices = choices;
		this.choiceLabeller = choiceLabeller;
	}

	/**
	 * Constructor with binding.
	 * 
	 * @param label
	 *            the label of the input field.
	 * @param choices
	 *            the list of choices that are displayed to the user and of
	 *            which the user may select one or more.
	 * @param binding
	 *            the binding between this input field and an arbitrary object.
	 */
	public AbstractMultiChoiceModel(final String label, final List<T> choices,
			final ChoiceLabeller<T> choiceLabeller,
			final Binding<List<T>> binding) {
		super(label, binding);
		this.choices = choices;
		this.choiceLabeller = choiceLabeller;
	}

	public AbstractMultiChoiceModel(final List<T> choices,
			final ChoiceLabeller<T> choiceLabeller) {
		this.choices = choices;
		this.choiceLabeller = choiceLabeller;
	}

	/**
	 * Retrieves the choices that are to be displayed to the user.
	 * 
	 * @return the list of choices.
	 */
	public List<T> getChoices() {
		return this.choices;
	}

	public ChoiceLabeller<T> getChoiceLabeller() {
		return this.choiceLabeller;
	}
}
