package dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import validate.CheckTimeZone;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {
    @NotBlank(message = "telephone number must not be empty")
    @Pattern(regexp = "[0-9]{7}", message = "phone number must be contains from 7 numbers")
    @JsonProperty("telephone_number")
    private String telNumber;

    @Pattern(regexp = "^\\+998[0-9]{2}", message = "operator code must be in format '+998..'")
    @JsonProperty("operator_code")
    private String operatorCode;

    @NotBlank(message = "tag not be empty")
    @JsonProperty("tag")
    private String tag;

    @CheckTimeZone
    @JsonProperty("time_zone")
    private String timeZone;

}
