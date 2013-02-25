package com.trouch.coap.methods;

import java.net.URISyntaxException;

import com.trouch.coap.messages.CoapRequest;
import com.trouch.coap.messages.headers.MessageType;

public class CoapDelete extends CoapRequest {
	
	public CoapDelete(String uri) throws URISyntaxException {
		super(MessageType.CONFIRMABLE, DELETE, uri);
	}

}
