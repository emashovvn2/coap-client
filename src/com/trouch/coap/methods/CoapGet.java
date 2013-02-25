package com.trouch.coap.methods;

import java.net.URISyntaxException;

import com.trouch.coap.messages.CoapRequest;
import com.trouch.coap.messages.headers.MessageType;

public class CoapGet extends CoapRequest {
	
	public CoapGet(String uri) throws URISyntaxException {
		super(MessageType.CONFIRMABLE, GET, uri);
	}

}
