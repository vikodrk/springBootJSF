package mx.com.eon.web.ejb.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractEJB {

	private static final Logger LOG = Logger.getLogger("Abstract EJB");

	protected HttpURLConnection obtainConnectionPost(String uri) throws IOException {
		HttpURLConnection conn = null;

		URL url = new URL(uri);
		conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		return conn;

	}

	protected HttpURLConnection obtainConnectionGet(String uri) throws IOException {
		HttpURLConnection conn = null;

		URL url = new URL(uri);
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "*/*");

		return conn;

	}
	
	protected HttpURLConnection obtainConnectionDelete(String uri) throws IOException {
		HttpURLConnection conn = null;

		URL url = new URL(uri);
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("DELETE");
		conn.setRequestProperty("Accept", "*/*");

		return conn;

	}

	public void delete(Long id) {

		try {
			HttpURLConnection conn = obtainConnectionDelete("http://localhost:8080/services/data/delete/" + id);
			LOG.info("Response from Delete: " + conn.getResponseCode());
			conn.disconnect();
		} catch (Exception e) {
			LOG.throwing("", "", e);
		}

	}

	protected String responseToString(BufferedReader br) throws IOException {

		StringBuilder builder = new StringBuilder();
		
		String output=null;
		while ( (output=br.readLine())!=null ) {
			builder.append(output);
		}

		return builder.toString();

	}

	protected Object stringToObject(String jsonString, Class<?> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		Object obj = null;
		ObjectMapper mapper = new ObjectMapper();
		obj = mapper.readValue(jsonString, clazz);
		return obj;
	}

	protected String objectToJsonString(Object obj) throws JsonProcessingException {
		String jsonString = null;
		ObjectMapper mapper = new ObjectMapper();
		jsonString = mapper.writeValueAsString(obj);
		return jsonString;
	}

}
