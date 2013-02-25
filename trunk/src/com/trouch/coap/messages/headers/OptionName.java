package com.trouch.coap.messages.headers;

import java.util.ArrayList;
import java.util.List;

public class OptionName {

	private static List<OptionName> options = new ArrayList<OptionName>();
	
	public enum DataType {OPAQUE, INTEGER, STRING};
	
	public final static OptionName IF_MATCH			= new OptionName(1,  DataType.OPAQUE,  "If-Match");
	public final static OptionName URI_HOST			= new OptionName(3,  DataType.STRING,  "Uri-Host");
	public final static OptionName ETAG				= new OptionName(4,  DataType.OPAQUE,  "ETag");
	public final static OptionName IF_NONE_MATCH	= new OptionName(5,  DataType.STRING,  "If-None-Match");
	public final static OptionName URI_PORT			= new OptionName(7,  DataType.INTEGER, "Uri-Port");
	public final static OptionName LOCATION_PATH	= new OptionName(8,  DataType.STRING,  "Location-Path");
	public final static OptionName URI_PATH			= new OptionName(11, DataType.STRING,  "Uri-Path");
	public final static OptionName CONTENT_FORMAT	= new OptionName(12, DataType.INTEGER, "Content-Format");
	public final static OptionName MAX_AGE			= new OptionName(14, DataType.INTEGER, "Max-Age");
	public final static OptionName URI_QUERY		= new OptionName(15, DataType.STRING,  "Uri-Query");
	public final static OptionName ACCEPT			= new OptionName(16, DataType.INTEGER, "Accept");
	public final static OptionName LOCATION_QUERY	= new OptionName(20, DataType.STRING,  "Location-Query");
	public final static OptionName PROXY_URI		= new OptionName(35, DataType.STRING,  "Proxy-Uri");
	public final static OptionName PROXY_SCHEME		= new OptionName(39, DataType.STRING,  "Proxy-Scheme");
	
	private int number;
	private DataType type;
	private String description;
	
	private OptionName(int number, DataType type, String description) {
		this.number = number;
		this.type = type;
		this.description = description;
		options.add(this);
	}
	
	public int getInt() {
		return number;
	}
	
	public DataType getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return description;
	}
	
	public static OptionName fromInt(int number) {
		for (OptionName coapOption : options) {
			if (coapOption.getInt() == number) {
				return coapOption;
			}
		}
		
		System.err.println("Option not found " + number);
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof OptionName) {
			OptionName name = (OptionName) obj;
			return name.getInt() == this.getInt();
		}
		return false;
	}
	
	

}
