package sg.edu.nus.movieverse.mapper;

import sg.edu.nus.movieverse.dto.request.RegisterUserRequest;
import sg.edu.nus.movieverse.entity.User;

public class UserMapper {
    public static User fromRegisterUserRequest(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setUsername(registerUserRequest.getUsername());
        user.setPassword(registerUserRequest.getPassword());
        return user;
    }

//    public static User fromRegisterAdminRequest(RegisterAdminRequest registerAdminRequest) {
//        User user = new User();
//        user.setUsername(registerAdminRequest.getUsername());
//        user.setPassword(registerAdminRequest.getPassword());
//        return user;
//    }
}
