package JerseyClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PokeAPI {

	public static void main(String[] args) throws JSONException {
		
		// Create a client
		Client client = ClientBuilder.newClient();
		
		// Set Target to client
		WebTarget target = client.target("https://pokeapi.co/api/v2/pokemon-form");
		
		// Get response from the WS
		String response = target
				.queryParam("limit", 2000)
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);
		JSONObject jsonResponse = new JSONObject(response);
		System.out.println(response);
		
		JSONArray results = jsonResponse.getJSONArray("results");
		int count = 0;
		for(int i=0; i<results.length(); i++) {
			  JSONObject pokemon = results.getJSONObject(i);
			  String name = pokemon.getString("name");
			  String url = pokemon.getString("url");
			  if(!name.substring(0, 3).equals("uno")) {
				  System.out.printf("%d %-30s%s%n", ++count, name, url);
			  }
		}
		
	}

}
