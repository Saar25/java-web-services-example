package org.saartako;

@Path("/hello")
public class HelloWorldService {
 
	@GET
	@Path("/{name}")
	public Response getMsg(@PathParam("name") String name) {
 
		String output = "Welcome   : " + name;
 
		return Response.status(200).entity(output).build();
 
	}
 
}