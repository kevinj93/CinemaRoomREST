package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {

    private final String message;

    public Error(String message) {
        this.message = message;
    }
    @JsonProperty("error")
    public String getMessage() {
        return message;
    }
}
