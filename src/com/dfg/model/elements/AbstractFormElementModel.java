package com.dfg.model.elements;

import java.io.Serializable;

import com.dfg.model.SectionModel;

public abstract class AbstractFormElementModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Integer index;
	private SectionModel parentSection;
	private boolean discarded = false;
	private boolean visible = true;

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Returns the ID of this form element. An ID must be unique within a form.
	 * 
	 * @return the ID of this form element.
	 */
	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		if (this.id == null) {
			return 0;
		} else {
			return this.id.hashCode();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractFormElementModel)) {
			return false;
		}
		if (this.id == null) {
			return false;
		}
		AbstractFormElementModel that = (AbstractFormElementModel) obj;
		return this.id.equals(that.id);
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getIndex() {
		return index;
	}

	public void setParentSection(SectionModel parentSection) {
		this.parentSection = parentSection;
	}

	public SectionModel getParentSection() {
		return parentSection;
	}

	/**
	 * Marks this form element as "discarded", meaning that the user did
	 * something with the consequence that the input from this form element must
	 * not be evaluated at form submission.
	 * <p/>
	 * A use case for discarding a form element is when a user clicks on a
	 * "remove this section" button. The section is not actually removed from
	 * the FormModel but instead marked "discarded", so that frameworks that
	 * work with list indices still function. Elements marked as "discarded"
	 * should not be evaluated in the form's onSubmit method!
	 * <p/>
	 * Note that you should implement {@link #onDiscard()} when you plan to call
	 * this method.
	 */
	public void discard() {
		this.discarded = true;
		onDiscard();
	}

	public boolean isDiscarded() {
		return discarded;
	}
	/**
	 * This method can be implemented by subclasses to clean up after a form
	 * element has been discarded.
	 * <p/>
	 * This clean up is needed when the user input of a discarded form element
	 * is bound to another java object. The bound object should then be removed
	 * from the object tree so it will not be processed on form submission.
	 */
	protected void onDiscard() {
		// do nothing by default
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}

}
