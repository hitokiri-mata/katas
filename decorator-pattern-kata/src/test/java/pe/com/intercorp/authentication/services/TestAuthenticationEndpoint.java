package pe.com.intercorp.authentication.services;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class TestAuthenticationEndpoint extends JerseyTest {

    @Override
    protected Application configure() {
	return new ResourceConfig(AuthenticationEndpoint.class);
    }

    @Test
    public void sussesfullyAuthentication() {
	Form loginForm = new Form();
	loginForm.param("target", "google");
	loginForm.param("username", "cmatdeav");
	loginForm.param("password", "12345");
	Response response = target("/authentication").request()
		.post(Entity.entity(loginForm, MediaType.APPLICATION_FORM_URLENCODED));
	assertEquals("Should return status 200", Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void badCredentialAuthentication() {
	Form loginForm = new Form();
	loginForm.param("target", "google");
	loginForm.param("username", "cmatdeav");
	loginForm.param("password", "78910");
	Response response = target("/authentication").request()
		.post(Entity.entity(loginForm, MediaType.APPLICATION_FORM_URLENCODED));
	assertEquals("Should return status 404", Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

}
