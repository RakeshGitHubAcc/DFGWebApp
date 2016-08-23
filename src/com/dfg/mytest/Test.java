package com.dfg.mytest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) {
		InputStream in = null;
		BufferedReader reader = null;
		try {
			Class<?> cls = Class.forName("Test");
			// returns the ClassLoader object associated with this Class
			ClassLoader cLoader = cls.getClassLoader();
			// in = Test.class.getResourceAsStream("./Test.java");
			in = cLoader.getResourceAsStream("Test.java");
			if (null != in) {
				reader = new BufferedReader(new InputStreamReader(in));
				StringBuffer stringBuffer = new StringBuffer();
				String line;
				while ((line = reader.readLine()) != null) {
					stringBuffer.append(line);
					stringBuffer.append("\n");
				}
				System.out.println("conetent: " + stringBuffer.toString());
			}
		} catch (IOException e) {
			System.out.println("Error reading resource: IOException" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Error reading resource: ClassNotFoundException" + e.getMessage());
		}
	}
}