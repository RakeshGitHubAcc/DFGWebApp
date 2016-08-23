package com.dfg.model.elements;

import com.dfg.model.FormModel;

public interface Submittable {
	void onSubmit(final FormModel submittedData);
}
