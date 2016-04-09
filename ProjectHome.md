CoAP-Client is a Java Client for CoAP protocol inspired by Apache HttpClient
  * [draft-14](http://tools.ietf.org/html/draft-ietf-core-coap-14) support
  * Written by Eric PTAK for [WebIOPi](https://code.google.com/p/webiopi/)

```
CoapClient coap = new CoapClient();
CoapResponse res = coap.sendRequest(new CoapGet("coap://raspberrypi/devices/temp0/temperature/c"));
System.out.println("Temperature: " + res.getPayload() + "°C");
```