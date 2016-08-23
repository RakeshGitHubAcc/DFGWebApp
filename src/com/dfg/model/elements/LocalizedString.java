package com.dfg.model.elements;

public enum LocalizedString {

	REMOVE_BUTTON_LABEL("removeButton.label");

	private final String resourceKey;

	private LocalizedString(String resourceKey) {
		this.resourceKey = resourceKey;
	}

	public String getResourceKey() {
		return resourceKey;
	}

}
