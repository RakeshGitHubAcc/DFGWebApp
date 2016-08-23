package com.dfg.model.elements;

import org.apache.wicket.markup.html.form.IChoiceRenderer;

import com.dfg.model.elements.field.ChoiceLabeller;

public class WickedFormsChoiceRenderer {

	/**
	 * Converts a Wicked Forms {@link ChoiceLabeller} into a Wicket
	 * {@link IChoiceRenderer}.
	 * 
	 * @param <T>
	 *          the type of choice
	 * @param labeller
	 *          the Wicked Forms {@link ChoiceLabeller} to convert
	 * @return a Wicket {@link IChoiceRenderer} that wraps the given
	 *         {@link ChoiceLabeller}
	 */
	public static <T> IChoiceRenderer<T> fromChoiceLabeller(final ChoiceLabeller<T> labeller) {
		return new IChoiceRenderer<T>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Object getDisplayValue(final T object) {
				return labeller.getLabel(object);
			}

			@Override
			public String getIdValue(final T object, final int index) {
				return String.valueOf(index);
			}
		};
	}

}
