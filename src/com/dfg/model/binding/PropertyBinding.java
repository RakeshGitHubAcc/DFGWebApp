package com.dfg.model.binding;

import org.apache.commons.beanutils.PropertyUtils;

public class PropertyBinding<T> implements Binding<T> {
	private static final long serialVersionUID = 1L;

	private final Object boundObject;
	private final String property;

	/**
	 * Constructor linking the value of form element to a specified property of
	 * a specified object.
	 * 
	 * @param boundObject
	 *            the object that contains the property that is the target of
	 *            this binding. Note that the class of the object must be
	 *            public, otherwise the binding may lead to runtime exceptions
	 *            due to reflection errors.
	 * @param property
	 *            the name of the property. Note that this property must be of
	 *            type T, otherwise a runtime exception will occur. The methods
	 *            {@link #getValue()} and {@link #setValue(Object)} will access
	 *            this property via reflection. Also, this property must be
	 *            accessible through public setter and getter complying to the
	 *            Java Beans standard.
	 */
	public PropertyBinding(Object boundObject, String property) {
		this.boundObject = boundObject;
		this.property = property;

	}

	@Override
	public void setValue(T value) {
		try {
			PropertyUtils.setSimpleProperty(boundObject, property, value);
		} catch (Exception e) {
			throw new IllegalStateException(String.format(
					"Binding error! Setting property '%s' on bound object of class %s failed!", property,
					boundObject.getClass()), e);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public T getValue() {
		try {
			return (T) PropertyUtils.getSimpleProperty(boundObject, property);
		} catch (Exception e) {
			throw new IllegalStateException(String.format(
					"Binding error! Getting property '%s' from bound object of class %s failed!", property,
					boundObject.getClass()), e);
		}
	}
}
