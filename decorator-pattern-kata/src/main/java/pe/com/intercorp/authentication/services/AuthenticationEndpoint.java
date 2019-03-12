package pe.com.intercorp.authentication.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/authentication")
public class AuthenticationEndpoint {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("username") String username, @FormParam("password") String password) {
	Status httpStatus;
	String securityToken = new String();
	try {
	    // Authenticate the user using the credentials provided
	    authenticate(username, password);
	    // Issue a token for the user
	    securityToken = issueToken(username);
	    // Return the HTTP 200 status into response
	    httpStatus = Status.OK;
	} catch (Exception e) {
	    httpStatus = Status.UNAUTHORIZED;
	}
	return Response.status(httpStatus).entity(securityToken).build();
    }

    private void authenticate(String username, String password) throws Exception {
	if (!"cmatdeav".equals(username) || !"12345".equals(password)) {
	    throw new NotAuthorizedException();
	}
    }

    private String issueToken(String username) {
	// Issue a token (can be a random String persisted to a database or a JWT token)
	// The issued token must be associated to a user
	// Return the issued token
	return "12345678";
    }
}