package core.JSON_Parsing;

import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class Currency2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		String csvFile = "./src/main/resources/ip.csv";
		BufferedReader br = null;
		String ip_address = null;

		br = new BufferedReader(new FileReader(csvFile));
		while ((ip_address = br.readLine()) != null) {
			URL url = new URL("http://www.geoplugin.net/json.gp?ip=" + ip_address);

			final String element_01 = "geoplugin_countryName";
			final String element_02 = "geoplugin_currencyCode";
			final String element_03 = "geoplugin_currencyConverter";
		
			String element_name_01 = "Country Name: ";
			String element_name_02 = "Currency Code: ";
			String element_name_03 = "Currency Converter: ";
		

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
				System.out.println(element_name_03 + parser.getString() + "\n");
			break;
			}

		}
	}
	}
}}


