package com.dfg.model.elements.field;

import java.util.List;

import com.dfg.model.binding.Binding;
/**
 * Base class for all input fields that enable a user to select one item of a
 * list of items. A single choice element binds to a single object of type T.
 * 
 * @param <T>
 *            the type of the items the user can choose from
 */
public abstract class AbstractSingleChoiceModel<T> extends
		AbstractInputFieldModel<T> {
	private static final long serialVersionUID = 1L;
	protected final List<T> choices;

	private final ChoiceLabeller<T> choiceLabeller;

	private final Class<T> modelClass;

	/**
	 * Constructor defining a {@link ChoiceLabeller}.
	 * 
	 * @param label
	 *            the label of the field.
	 * @param choices
	 *            the list of items the user can choose from.
	 * @param choiceLabeller
	 *            the labeller to use when creating the text representation of
	 *            the choices.
	 */
	public AbstractSingleChoiceModel(final String label, final List<T> choices,
			final ChoiceLabeller<T> choiceLabeller, Class<T> modelClass) {
		super(label);
		this.choices = choices;
		this.choiceLabeller = choiceLabeller;
		this.modelClass = modelClass;
	}

	/**
	 * Constructor.
	 * 
	 * @param label
	 *            the label of the field.
	 * @param choices
	 *            the list of items the user can choose from.
	 * 
	 */
	public AbstractSingleChoiceModel(final String label, final List<T> choices,
			Class<T> modelClass) {
		super(label);
		this.choices = choices;
		this.modelClass = modelClass;
		this.choiceLabeller = new ToStringChoiceLabeller<T>();
	}

	/**
	 * Constructor with initial value.
	 * 
	 * @param label
	 *            the label of the field.
	 * @param choices
	 *            the list of items the user can choose from.
	 * @param value
	 *            the initial value of the item.
	 */
	public AbstractSingleChoiceModel(final String label, final List<T> choices,
			final ChoiceLabeller<T> choiceLabeller, final T value,
			Class<T> modelClass) {
		super(label, value);
		this.choices = choices;
		this.choiceLabeller = choiceLabeller;
		this.modelClass = modelClass;
	}

	/**
	 * Constructor with binding.
	 * 
	 * @param label
	 *            the label of the field.
	 * @param choices
	 *            the list of items the user can choose from.
	 * @param binding
	 *            the binding providing the link between this input field's
	 *            value and an arbitrary java object.
	 */
	public AbstractSingleChoiceModel(final String label, final List<T> choices,
			final ChoiceLabeller<T> choiceLabeller, final Binding<T> binding,
			Class<T> modelClass) {
		super(label, binding);
		this.choices = choices;
		this.choiceLabeller = choiceLabeller;
		this.modelClass = modelClass;
	}

	public AbstractSingleChoiceModel(final List<T> choices,
			final ChoiceLabeller<T> choiceLabeller, Class<T> modelClass) {
		this.choices = choices;
		this.choiceLabeller = choiceLabeller;
		this.modelClass = modelClass;
	}

	/**
	 * Retrieves the list of elements the user can choose from.
	 * 
	 * @return the list of choices.
	 */
	public List<T> getChoices() {
		return this.choices;
	}

	public ChoiceLabeller<T> getChoiceLabeller() {
		return this.choiceLabeller;
	}

	@Override
	public Class<T> getModelClass() {
		return this.modelClass;
	}
}
