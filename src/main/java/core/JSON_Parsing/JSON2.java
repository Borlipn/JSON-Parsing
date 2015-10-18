package core.JSON_Parsing;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class JSON2 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.geoplugin.net/json.gp?ip=216.113.169.239");

		final String element_01 = "geoplugin_city";
		final String element_02 = "geoplugin_region";
		final String element_03 = "geoplugin_latitude";
		final String element_04 = "geoplugin_longitude";

		String element_name_01 = "City: ";
		String element_name_02 = "State: ";
		String element_name_03 = "Latitude: ";
		String element_name_04 = "Longitude: ";

		InputStream is = url.openStream();
		JsonParser parser = Json.createParser(is);

		while (parser.hasNext()) {

		Event e = parser.next();

		if (e == Event.KEY_NAME) {

			switch (parser.getString()) {

			case element_01:
				parser.next();
				System.out.println(element_name_01 + parser.getString());
			break;

			case element_02:
				parser.next();
				System.out.println(element_name_02 + parser.getString());
			break;
			
			case element_03:
				parser.next();
				System.out.println(element_name_03 + parser.getString());
			break;
			
			case element_04:
				parser.next();
				System.out.println(element_name_04 + parser.getString());
			break;
			}

		}
	}
	}
}

