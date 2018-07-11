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

import mx.com.eon.api.dto.WorkPartnerDTO;
import mx.com.eon.web.ejb.IWorkEJB;

@Stateless
public class WorkEJBImpl extends AbstractEJB implements IWorkEJB {
	
	private static final Logger LOG = Logger.getLogger("Work EJB");

	@Override
	public void save(WorkPartnerDTO t) {
		
		String jsonObject = null;
		try {
			jsonObject = objectToJsonString(t);
			HttpURLConnection conn = obtainConnectionPost("http://localhost:8080/services/data/workPartner/save");
			
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
	public void update(WorkPartnerDTO t) {
		
		String jsonObject = null;
		try {
			jsonObject = objectToJsonString(t);
			HttpURLConnection conn = obtainConnectionPost("http://localhost:8080/services/data/workPartner/update");
			
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
	public List<WorkPartnerDTO> findByName(String name) {
		List<WorkPartnerDTO> result = null;
		try {
			HttpURLConnection conn = obtainConnectionGet("http://localhost:8080/services/data/workPartner/get/"+name);
			conn.getResponseCode();
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output = responseToString(br);
			if (conn.getResponseCode() != 403) {
				ObjectMapper mapper = new ObjectMapper();
				result = mapper.readValue(output, new TypeReference<List<WorkPartnerDTO>>() {
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
