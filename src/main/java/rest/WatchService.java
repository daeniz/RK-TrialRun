/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entity.SamaritWatch;
import facades.WatchFacade;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import util.WatchConverter;

/**
 * REST Web Service
 *
 * @author dennisschmock
 */
@Path("watch")

public class WatchService {

    @Context
    private UriInfo context;
    private static WatchConverter wc = new WatchConverter();
    private static Gson gson = new Gson();
    private static WatchFacade wf = new WatchFacade();

    /**
     * Creates a new instance of WatchService
     */
    public WatchService() {
    }

    /**
     * Retrieves representation of an instance of rest.WatchService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getWatches() {
        return gson.toJson("test");
    }

    /**
     * This method takes a POST restcall with a
     *
     * @param id
     * @param sWatch
     */
    @Path("{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void setUnAvailWatch(@PathParam("id") String id, String sWatch) {

        SamaritWatch sw;
        sw = gson.fromJson(sWatch, SamaritWatch.class);
        System.out.println("qweWTF!");

        wf.addUnavailForWatch(sw);

    }

    ;
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getWatchesForSamarit(@PathParam("id") String id) {

        return "";
    }

}
