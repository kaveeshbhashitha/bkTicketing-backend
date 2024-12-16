package com.bkticketing.bkTicketing_backend.Controller;
import com.bkticketing.bkTicketing_backend.Model.User;
import com.bkticketing.bkTicketing_backend.Repository.UserRepository;
import com.bkticketing.bkTicketing_backend.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Create a new user
    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    // Get user by ID
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/getUserNameByID/{id}")
    public String getUsernameById(@PathVariable("id") String userId) {
        User user = userService.getUserNameById(userId);
        String userName=user.getFirstName();
        return userName;
    }

    @GetMapping("/getUserByEmail/{id}")
    public User getUserByEmail(@PathVariable("id") String userEmail) {
        return userService.getUserByUserEmail(userEmail);
    }

    // Get all users
    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Delete user by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User with ID " + userId + " has been deleted successfully.");
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginRequest, HttpSession session) {
        User user = userRepository.findByUserEmail(loginRequest.getUserEmail());
        if (user == null) {
            return "User not found";
        }
        // Verify the password
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return "Invalid username or password";
        }
        // Add user details to the session
        session.setAttribute("user", user);
        return "Login successful";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Logged out successfully";
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userRepository.findByUserEmail(user.getUserEmail()) != null) {
            return "User already registered as a user";
        }
        // Hash the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }

    @PostMapping("/send-code")
    public String sendRecoveryCode(@RequestBody Map<String, String> payload) {
        String userEmail = payload.get("userEmail");
        if (userEmail == null || userEmail.isBlank()) {
            throw new RuntimeException("Email cannot be empty.");
        }
        return userService.sendRecoveryCode(userEmail);
    }

    @PostMapping("/verify-code")
    public boolean verifyRecoveryCode(@RequestParam String userEmail, @RequestParam String recoveryCode) {
        return userService.verifyRecoveryCode(userEmail, recoveryCode);
    }

    @PostMapping("/update-password")
    public User updatePassword(@RequestParam String userEmail, @RequestParam String newPassword) {
        return userService.updatePassword(userEmail, newPassword);
    }
}
