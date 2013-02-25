package com.trouch.coap.methods;

import java.net.URISyntaxException;

import com.trouch.coap.messages.CoapRequest;
import com.trouch.coap.messages.headers.MessageType;

public class CoapPost extends CoapRequest {
	
	public CoapPost(String uri) throws URISyntaxException {
		super(MessageType.CONFIRMABLE, POST, uri);
	}

}
