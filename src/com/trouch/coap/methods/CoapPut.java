package com.trouch.coap.methods;

import java.net.URISyntaxException;

import com.trouch.coap.messages.CoapRequest;
import com.trouch.coap.messages.headers.MessageType;

public class CoapPut extends CoapRequest {
	
	public CoapPut(String uri) throws URISyntaxException {
		super(MessageType.CONFIRMABLE, PUT, uri);
	}

}
