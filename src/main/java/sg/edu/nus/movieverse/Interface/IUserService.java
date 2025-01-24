package sg.edu.nus.movieverse.Interface;

import sg.edu.nus.movieverse.dto.request.RegisterUserRequest;
import sg.edu.nus.movieverse.dto.response.AuthResponse;
import sg.edu.nus.movieverse.entity.User;

import java.util.UUID;

public interface IUserService {
    boolean verifyToken(String token, String username);
    User getUserFromToken(String token);
    User getUserById(UUID id);
    User getUserByUsername(String username);
    AuthResponse registerUser(RegisterUserRequest registerUserRequest);
//    boolean registerAdmin(RegisterAdminRequest registerAdminRequest);
//    AuthResponse loginUser(LoginUserRequest loginUserRequest);
//    boolean loginAdmin(LoginAdminRequest loginAdminRequest);
}
