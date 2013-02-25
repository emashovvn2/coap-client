package com.trouch.coap.messages.headers;

import java.util.ArrayList;
import java.util.List;

public class MessageType {
	
	private static List<MessageType> types = new ArrayList<MessageType>();
	
	public final static MessageType CONFIRMABLE		= new MessageType(0, "CON");
	public final static MessageType NON_CONFIRMABLE	= new MessageType(1, "NON");
	public final static MessageType ACKNOWLEDGMENT	= new MessageType(2, "ACK");
	public final static MessageType RESET			= new MessageType(3, "RST");
	
	private int type;
	private String description;
	
	private MessageType(int type, String description) {
		this.type = type;
		this.description = description;
		types.add(this);
	}
	
	public int toInt() {
		return type;
	}
	
	@Override
	public String toString() {
		return description;
	}
	
	public static MessageType fromInt(int type) {
		for (MessageType coapType : types) {
			if (coapType.toInt() == type) {
				return coapType;
			}
		}
		return null;
	}

}
