package com.sectionbuilder.consopen.adpt.jboss.endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import com.ftse.sectionbuilder.consopen.core.SectionBuilderService;
import com.ftse.sectionbuilder.consopen.core.SectionBuilderService.SectionBuilderRs;

@Path("/")
public class SectionBuilderController {

	private static ObjectMapper objectMapper = new ObjectMapper();
	
	@Inject
	private SectionBuilderService sectionBuilderService;

	public SectionBuilderController() {
		System.out.println("################## Creating New SectionBuilderController #################");
	}

	@GET
	@Path("/buildsection/{prefix}")
	@Produces({ "application/json" })
	public Response buildSection(@PathParam("prefix") String prefix) {
		try {
			// Call POJO service
			SectionBuilderRs rs = sectionBuilderService.buildSection(prefix);

			// Http Transform.
			String jsonRs = objectMapper.writeValueAsString(rs);
			return Response.ok(jsonRs).build();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
