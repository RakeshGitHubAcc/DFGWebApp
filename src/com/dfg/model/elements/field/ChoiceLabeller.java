package com.dfg.model.elements.field;

import java.io.Serializable;

public interface ChoiceLabeller<T> extends Serializable {
	public String getLabel(final T choice);
}
