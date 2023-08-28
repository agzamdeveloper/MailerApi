package restClient;

import dto.response.MessageResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;


@ApplicationScoped
public class MessengerClient {
    public MessageResponse sendMessage(){
        Jsonb jsonb = JsonbBuilder.create();
        String uri = String.format("");
         return null;
    }
}
