package com.trouch.coap.messages.headers;

public class Option {
	
	
	private OptionName name;
	private Object value;
	
	public Option(OptionName name, Object value) {
		this.name = name;
		this.value = value;
	}

	public OptionName getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}
	
}
