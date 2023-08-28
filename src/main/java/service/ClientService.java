package service;

import dto.request.ClientRequest;
import dto.request.Request;
import dto.response.Response;
import repository.ClientRepository;
import validate.CheckValid;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ClientService {
    @Inject
    ClientRepository repository;

    @Inject
    CheckValid checkValid;

    public Response<String> createClient(Request<ClientRequest> request){
        CheckValid.Result result = checkValid.manualValidation(request);

        if(result.isSuccess()){
            String clientAdd = repository.createClient(request.getRequest());
            return new Response<>(clientAdd);
        } else {
            return Response.badRequest(result.getMessage());
        }
    }

    public Response<String> updateClient(int id, Request<ClientRequest> request){
        CheckValid.Result result = checkValid.manualValidation(request);

        if (result.isSuccess()){
            String clientUpdate = repository.updateClient(id, request.getRequest());
            return new Response<>(clientUpdate);
        } else {
            return Response.badRequest(result.getMessage());
        }
    }

    public Response<String> deleteClient(int id){
        String clientDelete = repository.deleteClient(id);
        return new Response<>(clientDelete);
    }
}
