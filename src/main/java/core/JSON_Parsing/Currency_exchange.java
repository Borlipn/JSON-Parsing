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

public class Currency_exchange {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		String csvFile = "./src/main/resources/Query_Currency_exchange.txt";
		BufferedReader br = null;
		String q_link = null;

		br = new BufferedReader(new FileReader(csvFile));
		while ((q_link = br.readLine()) != null) {
			URL url = new URL( q_link );

			final String element_01 = "Name";
			final String element_02 = "Rate";
			
		
			String element_name_01 = "Currency Code: ";
			String element_name_02 = "Currency Rate: ";
			
		

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
				System.out.println(element_name_02 + parser.getString() + "\n");
			break;

			}

		}
	}
	}
}}


