package sg.edu.nus.movieverse.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import sg.edu.nus.movieverse.Interface.IUserService;
import sg.edu.nus.movieverse.dto.request.RegisterUserRequest;
import sg.edu.nus.movieverse.dto.response.AuthResponse;
import sg.edu.nus.movieverse.entity.Role;
import sg.edu.nus.movieverse.entity.User;
import sg.edu.nus.movieverse.mapper.UserMapper;
import sg.edu.nus.movieverse.repository.RoleRepository;
import sg.edu.nus.movieverse.repository.UserRepository;
import sg.edu.nus.movieverse.utility.JwtUtility;
import sg.edu.nus.movieverse.utility.PasswordHashingUtility;

import java.util.UUID;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtUtility jwtUtility;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, JwtUtility jwtUtility) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.jwtUtility = jwtUtility;
    }

    @Override
    public boolean verifyToken(String token, String usernameJson) {
        // Remove the "Bearer " prefix from the token
        token = token.replace("Bearer ", "");

        try {
            // Convert the JSON string to extract the actual username
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(usernameJson);

            // Extract the "username" field from the JSON
            String username = jsonNode.get("username").asText();

            // Check if the token is valid using the extracted username
            return jwtUtility.isTokenValid(token, username);
        } catch (Exception e) {
            throw new RuntimeException("Failed to extract username from JSON", e);
        }
    }

    @Override
    public User getUserFromToken(String token) {
        // Remove the "Bearer " prefix from the token
        token = token.replace("Bearer ", "");

        // Get the username from the token
        String username = jwtUtility.extractUsername(token);

        // Find the user by username
        return userRepository.findByUsername(username);
    }

    @Override
    public User getUserById(UUID id) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public AuthResponse registerUser(RegisterUserRequest registerUserRequest) {
        // Hash the password before saving it to the database

        registerUserRequest.setPassword(PasswordHashingUtility.hashPassword(registerUserRequest.getPassword()));

        // Map the RegisterUserRequest to a User entity
        User user = UserMapper.fromRegisterUserRequest(registerUserRequest);

        // Fetch the role from the role service
        Role role = roleRepository.findByName("User");
        user.setRole(role);

        // Save the user to the database
        userRepository.save(user);

        // Generate JSON Web Token
        String token = jwtUtility.generateToken(user.getUsername());

        // Return the AuthResponse object with the token
        return new AuthResponse(token);
    }
}
