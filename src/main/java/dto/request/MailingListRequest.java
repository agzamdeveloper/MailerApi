package dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import validate.CheckDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailingListRequest {
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|[3][01]) ([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]",
            message = "Start time must be in format yyyy-mm-dd hh:mm:ss")
    @JsonProperty("start_time")
    private String startTime;

    @NotBlank(message = "text of message should not be empty")
    @JsonProperty("message_text")
    private String messageText;

    @Pattern(regexp = "^\\+998[0-9]{2}", message = "filter of operator code must be in format +998..")
    @JsonProperty("filter_send")
    private String filterSend;

    @Pattern(regexp = "\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|[3][01]) ([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]",
            message = "Start time must be in format yyyy-mm-dd hh:mm:ss")
    @JsonProperty("end_time")
    private String endTime;
}
