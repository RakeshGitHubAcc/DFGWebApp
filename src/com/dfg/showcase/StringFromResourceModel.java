package com.dfg.showcase;

import org.apache.commons.io.IOUtils;
import org.apache.wicket.model.IModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StringFromResourceModel implements IModel<String> {

	private static final long serialVersionUID = 1L;

	private String modelObject;

	public StringFromResourceModel(Class<?> scope, String resourceName) {
		InputStream in = null;
		BufferedReader reader = null;
		try {
			in = scope.getResourceAsStream(resourceName);
			reader = new BufferedReader(
					new InputStreamReader(in));
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = reader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			this.modelObject = stringBuffer.toString();
		} catch (IOException e) {
			throw new RuntimeException("Error reading resource '"
					+ resourceName + "' from class '" + scope.getName() + "'.",
					e);
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(reader);
		}
	}

	@Override
	public void detach() {
		// do nothing
	}

	@Override
	public String getObject() {
		return this.modelObject;
	}

	@Override
	public void setObject(String object) {
		this.modelObject = object;
	}

}
