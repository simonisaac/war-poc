package com.sectionbuilder.consopen.adpt.jboss.endpoint;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import com.ftse.eodinterface.api.cacheaccess.CacheAccessIf;
import com.ftse.eodinterface.model.entities.Cacheable;

@Path("/")
public class CacheAccessController {

	private static ObjectMapper objectMapper = new ObjectMapper();

	@Inject
	private CacheAccessIf cache;

	public CacheAccessController() {
		System.out.println("################## Creating New CacheAccessController #################");
	}

	@GET
	@Path("/hello")
	@Produces({ "application/json" })
	public String getHelloWorldJSON() {
		System.out.println(cache.getName());
		return "{\"result\":\"" + "Hello" + "\"}";
	}

	@GET
	@Path("/cacheable/{key}")
	@Produces({ "application/json" })
	public Response getCacheable(@PathParam("key") String key) {
		System.out.println("Getting Cacheable for key [" + key + "]");
		Cacheable cacheable = cache.get(key);
		return ResponseUtils.getJson(cacheable);
	}

	@POST
	@Path("/cacheable")
	@Consumes({ MediaType.TEXT_PLAIN })
	public Response putCacheable(String string) {
		System.out.println("Putting string [" + string + "]");
		String[] sArray = string.split(":");
		if (sArray.length == 2) {
			cache.put(sArray[0], new Cacheable(sArray[0], sArray[1]));
		}
		return ResponseUtils.getJson(cache.cacheState());
	}
}
