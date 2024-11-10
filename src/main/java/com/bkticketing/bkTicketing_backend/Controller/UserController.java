package com.bkticketing.bkTicketing_backend.Controller;
import com.bkticketing.bkTicketing_backend.Model.User;
import com.bkticketing.bkTicketing_backend.Repository.UserRepository;
import com.bkticketing.bkTicketing_backend.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

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

    @GetMapping("/getUserByEmail/{id}")
    public User getUserByEmail(@PathVariable("id") String userEmail) {
        return userService.getUserByUserEmail(userEmail);
    }

    // Get all users
    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Update user by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String userId, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(userId, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete user by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User with ID " + userId + " has been deleted successfully.");
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session) {
        User existingUser = userRepository.findByUserEmail(user.getUserEmail());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("user", user);
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
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
        userRepository.save(user);
        return "User registered successfully";
    }
}
