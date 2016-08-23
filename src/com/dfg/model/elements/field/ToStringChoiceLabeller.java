package com.dfg.model.elements.field;
/**
 * The simplest possible implementation of the {@link ChoiceLabeller} interface.
 * It simply calls the toString() method to create the label of an object.
 * 
 */
public class ToStringChoiceLabeller<T> implements ChoiceLabeller<T> {
	private static final long serialVersionUID = 1L;

	@Override
	public String getLabel(final T choice) {
		return choice.toString();
	}

}
