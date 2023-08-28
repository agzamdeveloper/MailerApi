package resourse;


import dto.request.ClientRequest;
import dto.request.MailingListRequest;
import dto.request.Request;
import dto.response.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import service.ClientService;
import service.MailingService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/api/mailer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Mailer {
    @Inject
    ClientService clientService;

    @Inject
    MailingService mailingService;

    @POST
    @Path("/add-client")
    public Response<String> addClient(@RequestBody @Valid ClientRequest request){
        return clientService.createClient(new Request<>(request));
    }

    @PATCH
    @Path("/{id}/update-client")
    public Response<String> updateClient(@PathParam("id") int id, @RequestBody @Valid ClientRequest request){
        return clientService.updateClient(id, new Request<>(request));
    }

    @DELETE
    @Path("/{id}/delete-client")
    public Response<String> deleteClient(@PathParam("id") int id){
        return clientService.deleteClient(id);
    }

    @POST
    @Path("/add-mailing-list")
    public Response<String> addMailingList(@RequestBody @Valid MailingListRequest request){
        return mailingService.addMailingList(new Request<>(request));
    }

    @PATCH
    @Path("/{id}/update-mailing-list")
    public Response<String> updateMailingList(@PathParam("id") int id, @RequestBody @Valid MailingListRequest request){
        return mailingService.updateMailingList(id, new Request<>(request));
    }

    @DELETE
    @Path("/{id}/delete-mailing-list")
    public Response<String> deleteMailingList(@PathParam("id") int id){
        return mailingService.deleteMailingList(id);
    }
}
