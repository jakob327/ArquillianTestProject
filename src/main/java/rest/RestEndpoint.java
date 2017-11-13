package rest;

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
	public String getParams(@QueryParam("value") String params) {
		StringBuilder result = new StringBuilder();
		for (String key : uriInfo.getQueryParameters().keySet()) {
			for (String value : uriInfo.getQueryParameters().get(key)) {
				result.append(key + "=" + value);
			}
		}
		return result.toString();
	}
}
