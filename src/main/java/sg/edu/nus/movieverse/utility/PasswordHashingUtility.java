package sg.edu.nus.movieverse.utility;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordHashingUtility {
    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(12));
    }

    // Check that an unhashed password matches one that has been hashed
    public static boolean verifyPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}
