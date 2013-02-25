package com.trouch.coap.messages;

import java.net.URISyntaxException;
import java.util.Random;

import com.trouch.coap.messages.headers.MessageCode;
import com.trouch.coap.messages.headers.MessageType;

public class CoapRequest extends CoapMessage {
	
	public final static MessageCode GET  = MessageCode.GET;
	public final static MessageCode POST = MessageCode.POST;
	public final static MessageCode PUT  = MessageCode.PUT;
	public final static MessageCode DELETE = MessageCode.DELETE;
	
	private final static Random random = new Random(System.currentTimeMillis());
	private final static int randomMax = (int) Math.pow(2, 16);
	
	public CoapRequest(MessageType type, MessageCode code, String uri) throws URISyntaxException {
		super(type, code, uri);
		setId(random.nextInt(randomMax));
	}
	
	public MessageCode getMethodCode() {
		return getCode();
	}
	
	public void setMethodCode(MessageCode code) {
		setCode(code);
	}

}
