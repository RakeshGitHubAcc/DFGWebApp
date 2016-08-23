package com.dfg.model.binding;

import java.io.Serializable;
/**
 * This interface defines a binding / a link between a {@link com.dfg.model.elements.AbstractFormElementModel} and
 * an arbitrary Java object. Form elements like input fields will then display
 * the value of the bound java object. If the user enters a value into the form
 * element, it will in turn be stored into the bound object.
 * <p/>
 * The concept of the this interface is inspired by the model concept of Apache
 * Wicket.
 * 
 * @param <T>
 *            the type of the bound object.
 */
public interface Binding<T> extends Serializable {
	void setValue(T value);
	T getValue();
}
