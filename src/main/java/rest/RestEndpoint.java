package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/hello")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RestEndpoint {

	@Context
	UriInfo uriInfo;

	@GET
	@Path("/params")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getParams(@QueryParam("value") String params) {
		List<String> result = new ArrayList<>();
		for (String key : uriInfo.getQueryParameters().keySet()) {
			for (String value : uriInfo.getQueryParameters().get(key)) {
				result.add(key + "=" + value);
			}
		}
		return result;
	}

	@GET
	@Path("/world")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld() {
		return "Hello World";
	}
}
