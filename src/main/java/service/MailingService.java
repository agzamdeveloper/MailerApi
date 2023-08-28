package service;

import dto.request.MailingListRequest;
import dto.request.Request;
import dto.response.Response;
import repository.MailingRepository;
import validate.CheckValid;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MailingService {
    @Inject
    MailingRepository repository;

    @Inject
    CheckValid checkValid;

    public Response<String> addMailingList(Request<MailingListRequest> request){
        CheckValid.Result result = checkValid.manualValidation(request);

        if(result.isSuccess()){
            String mailingListAdd = repository.createMailingList(request.getRequest());
            return new Response<>(mailingListAdd);
        } else {
            return Response.badRequest(result.getMessage());
        }
    }

    public Response<String> updateMailingList(int id, Request<MailingListRequest> request){
        CheckValid.Result result = checkValid.manualValidation(request);

        if(result.isSuccess()){
            String mailingListUpdate = repository.updateMailingList(id, request.getRequest());
            return new Response<>(mailingListUpdate);
        } else {
            return Response.badRequest(result.getMessage());
        }
    }

    public Response<String> deleteMailingList(int id){
        String mailingListDelete = repository.deleteMailingList(id);
        return new Response<>(mailingListDelete);
    }
}
