package com.sectionbuilder.consopen.adpt.jboss.endpoint;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

public class ResponseUtils {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static Response getJson(Object obj) {
		try {
			// Http Transform.
			String jsonRs = objectMapper.writeValueAsString(obj);
			return Response.ok(jsonRs).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}