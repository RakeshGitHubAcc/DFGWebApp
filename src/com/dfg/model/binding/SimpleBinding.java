package com.dfg.model.binding;
/**
 * Simplest possible implementation of a {@link Binding}. It simply redirects
 * the interface calls to an instance variable of type T.
 * <p/>
 * Please note that this implementation defies the actual aim of the
 * {@link Binding} interface to act as a mediator between external objects and
 * form elements. It should therefore only be used as a default if no binding
 * was specified.
 * 
 * @param <T>
 *            the type of the bound object.
 */
public class SimpleBinding<T> implements Binding<T> {
	private static final long serialVersionUID = 1L;
	private T value;

	public SimpleBinding(T value) {
		this.value = value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return this.value;
	}
}
