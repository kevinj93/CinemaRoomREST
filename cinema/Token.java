package cinema;

import java.util.UUID;

public class Token {

    private String token;


    public Token() {
        token = String.valueOf(UUID.randomUUID());
    }

//    public Token(String token) {
//        this.token = token;
//    }
    public String getToken() {
        return token;
    }

//    public void setToken(String token) {
//        this.token = token;
//    }
}
