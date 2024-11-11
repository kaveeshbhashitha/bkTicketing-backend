package com.bkticketing.bkTicketing_backend.Service;
import com.bkticketing.bkTicketing_backend.Model.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(String userId);
    User getUserNameById(String userId);
    User getUserByUserEmail(String userEmail);
    List<User> getAllUsers();
    User updateUser(String userId, User userDetails);
    void deleteUser(String userId);
    
}
