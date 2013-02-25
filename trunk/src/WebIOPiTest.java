import com.trouch.coap.client.CoapClient;
import com.trouch.coap.messages.CoapResponse;
import com.trouch.coap.methods.CoapGet;
import com.trouch.coap.methods.CoapPost;

public class WebIOPiTest {
	public static void main(String[] args) {

		try {
			CoapClient coap = new CoapClient();
			CoapResponse res = coap.sendRequest(new CoapGet("coap://raspberrypi/devices/temp0/temperature/c"));
			System.out.println("Temperature: " + res.getPayload() + "¡C");

			boolean value = false;
			int loop = 10;
			for (int i=0; i<loop; i++) {
				value = !value;
				CoapPost request = new CoapPost("coap://raspberrypi/devices/gpio2/12/value/" + (value ? "1" : "0"));
				System.out.println("CoAP Request:\n" + request);

				CoapResponse response = coap.sendRequest(request);
				System.out.println("CoAP Response:\n" + response);

				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
