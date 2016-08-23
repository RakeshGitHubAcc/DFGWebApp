/**
 *   Copyright 2013 Wicked Forms (https://github.com/thombergs/wicked-forms)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.dfg.model.elements;

import org.apache.wicket.AttributeModifier;

/**
 * Adds a html5 "pattern" attribute to an html input field.
 * 
 * 
 */
public class PatternAttributeModifier extends AttributeModifier {
	private static final long serialVersionUID = 1L;

	public PatternAttributeModifier(final String pattern) {
		super("pattern", pattern);
	}

}
