package com.bkticketing.bkTicketing_backend.ServiceImplementation;
import com.bkticketing.bkTicketing_backend.Model.User;
import com.bkticketing.bkTicketing_backend.Repository.UserRepository;
import com.bkticketing.bkTicketing_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get user by ID
    public User getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }
    public User getUserNameById(String userId) {
        return userRepository.findUsernameByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }
    public User getUserByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }
    
    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Update user by ID
    public User updateUser(String userId, User userDetails) {
        return userRepository.findById(userId).map(user -> {
            user.setUserEmail(userDetails.getUserEmail());
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setPassword(userDetails.getPassword());
            user.setUserRole(userDetails.getUserRole());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }

    // Delete user by ID
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
