package no.ntnu.berg.loadeddwarvendice.server;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.Context;

/**
 *
 * @author Alexander Eilert Berg
 */
@Path("auth")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class AuthService
{

    @Path("login")
    @GET
    public Response login(@Context SecurityContext sc, @Context HttpServletRequest request)
    {
        request.getSession(true);
        return Response.ok(request.getUserPrincipal().getName()).build();
    }
    
    

}
