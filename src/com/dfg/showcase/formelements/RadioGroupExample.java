package com.dfg.showcase.formelements;

import java.util.Arrays;

import com.dfg.model.FormModel;
import com.dfg.model.SectionModel;
import com.dfg.model.elements.TextModel;
import com.dfg.model.elements.field.ChoiceLabeller;
import com.dfg.model.elements.field.RadioGroupModel;

public class RadioGroupExample extends FormModel {

	private static final long serialVersionUID = 1L;

	public RadioGroupExample() {
		super("Radio Group Examples");

		this.add(new SectionModel("String selection")
				.add(new TextModel(
						"A simple radio group selecting one of a list of Strings."))
				.add(new RadioGroupModel<String>("Your favorite color", Arrays
						.asList("red", "yellow", "green"), String.class)));

		this.add(new SectionModel("Enum selection")
				.add(new TextModel(
						"Often, you will want to let the user select between one of a set of enum constants. This radio group is backed by a color enum."))
				.add(new RadioGroupModel<Color>("Your favorite color", Arrays
						.asList(Color.values()), Color.class)));

		this.add(new SectionModel("Enum selection with custom labels")
				.add(new TextModel(
						"Enums are usually all CAPITAL letters which you may want to translate in a more user friendly representation. You can do this by providing a ChoiceLabeller implementation."))
				.add(new RadioGroupModel<Color>("Your favorite color", Arrays
						.asList(Color.values()), new ColorLabeller(),
						Color.class)));

		this.add(new SectionModel("Enum selection with selected value")
				.add(new TextModel(
						"As with most form elements, you can provide a default value in the constructor."))
				.add(new RadioGroupModel<Color>("Your favorite color", Arrays
						.asList(Color.values()), new ColorLabeller(),
						Color.RED, Color.class)));

	}

	private class ColorLabeller implements ChoiceLabeller<Color> {
		private static final long serialVersionUID = 1L;

		@Override
		public String getLabel(final Color choice) {
			return choice.getLabel();
		}

	}

	private enum Color {

		RED("Red"),

		YELLOW("Yellow"),

		GREEN("Green");

		private final String label;

		private Color(final String label) {
			this.label = label;
		}

		public String getLabel() {
			return this.label;
		}
	}

}
