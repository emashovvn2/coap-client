package com.trouch.coap.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

import com.trouch.coap.messages.CoapRequest;
import com.trouch.coap.messages.CoapResponse;

public class CoapClient {
	
	private DatagramSocket socket;
	
	public CoapClient() {
		try {
			this.socket = new DatagramSocket();
			this.socket.setSoTimeout(1000);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public CoapResponse sendRequest(CoapRequest request) throws IOException {
		byte requestData[] = request.getBytes();
		InetAddress addr = InetAddress.getByName(request.getHost());

		DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length, addr, request.getPort());
		
		ByteBuffer buff = ByteBuffer.allocate(1500);
		DatagramPacket responsePacket = new DatagramPacket(buff.array(), buff.capacity());

		int sent = 0;
		while (sent<4) {
			try { 
				socket.send(requestPacket);
				socket.receive(responsePacket);
				CoapResponse response = CoapResponse.parsePacket(responsePacket);
				return response;
			}
			catch (SocketTimeoutException e) {
				sent++;
			}
		}
		return null;
	}
}
