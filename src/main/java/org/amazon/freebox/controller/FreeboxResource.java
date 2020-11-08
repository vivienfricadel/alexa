package org.amazon.freebox.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.amazon.freebox.model.AuthorizeRequest;
import org.amazon.freebox.model.FreeboxResponse;
import org.amazon.freebox.model.SessionRequest;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("api/v4")
@RegisterRestClient(configKey = "freebox-api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface FreeboxResource {

    @POST
    @Path("login/authorize")
    public FreeboxResponse authorize(AuthorizeRequest request);

    @GET
    @Path("login")
    public FreeboxResponse login();

    @POST
    @Path("login/session")
    public FreeboxResponse session(SessionRequest request);

    @POST
    @Path("downloads/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public FreeboxResponse addDownloadUrl(@HeaderParam(value = "X-Fbx-App-Auth") String sessionToken, @FormParam(value = "download_url") String request);

}