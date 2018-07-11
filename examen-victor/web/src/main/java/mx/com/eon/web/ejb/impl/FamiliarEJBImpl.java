package mx.com.eon.web.ejb.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.eon.api.dto.FamiliarDTO;
import mx.com.eon.api.enums.FamiliarEnum;
import mx.com.eon.web.ejb.IFamiliarEJB;

@Stateless
public class FamiliarEJBImpl extends AbstractEJB implements IFamiliarEJB {

	private static final Logger LOG = Logger.getLogger("Familiar EJB");

	@Override
	public void save(FamiliarDTO t) {
		String jsonObject = null;
		try {
			jsonObject = objectToJsonString(t);
			HttpURLConnection conn = obtainConnectionPost("http://localhost:8080/services/data/familiar/save");
			
			OutputStream os = conn.getOutputStream();
			os.write(jsonObject.getBytes());
			os.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			String response = responseToString(br);
			
			if(conn.getResponseCode()!=HttpURLConnection.HTTP_FORBIDDEN) {
				LOG.info(response);
			}
			else {
				LOG.warning(response);
			}
			br.close();
			conn.disconnect();
		}
		catch(Exception e) {
			LOG.throwing("", "", e);
		}
	}

	@Override
	public void update(FamiliarDTO t) {
		String jsonObject = null;
		try {
			jsonObject = objectToJsonString(t);
			HttpURLConnection conn = obtainConnectionPost("http://localhost:8080/services/data/familiar/update");
			
			OutputStream os = conn.getOutputStream();
			os.write(jsonObject.getBytes());
			os.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			String response = responseToString(br);
			
			if(conn.getResponseCode()!=HttpURLConnection.HTTP_FORBIDDEN) {
				LOG.info(response);
			}
			else {
				LOG.warning(response);
			}
			br.close();
			conn.disconnect();
		}
		catch(Exception e) {
			LOG.throwing("", "", e);
		}
	}

	@Override
	public List<FamiliarDTO> findByName(String name) {
		List<FamiliarDTO> result = null;
		try {
			HttpURLConnection conn = obtainConnectionGet("http://localhost:8080/services/data/familiar/get/"+name);
			conn.getResponseCode();
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output = responseToString(br);
			if (conn.getResponseCode() != 403) {
				ObjectMapper mapper = new ObjectMapper();
				result = mapper.readValue(output, new TypeReference<List<FamiliarDTO>>() {
				});
			} else {
				LOG.warning(output);
			}
			br.close();
			conn.disconnect();

		} catch (Exception e) {
			LOG.throwing("", "", e);
		}
		return result;
	}

	@Override
	public List<FamiliarEnum> familiarTypeList() {
		List<FamiliarEnum> result = null;
		try {
			HttpURLConnection conn = obtainConnectionGet("http://localhost:8080/services/services/familiarType/all");
			conn.getResponseCode();
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output = responseToString(br);
			if (conn.getResponseCode() != 403) {
				ObjectMapper mapper = new ObjectMapper();
				result = mapper.readValue(output, new TypeReference<List<FamiliarEnum>>() {
				});
			} else {
				LOG.warning(output);
			}
			br.close();
			conn.disconnect();

		} catch (Exception e) {
			LOG.throwing("", "", e);
		}
		return result;
	}

}
