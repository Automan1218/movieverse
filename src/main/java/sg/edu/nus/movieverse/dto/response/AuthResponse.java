package sg.edu.nus.movieverse.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    String token;

    public AuthResponse(String token) {
        this.token = token;
    }
}
