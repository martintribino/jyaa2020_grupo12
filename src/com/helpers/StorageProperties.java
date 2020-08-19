package com.helpers;

import java.util.Properties;

public class StorageProperties extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 686868687053683609L;

	private String location =  "upload-dir";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
