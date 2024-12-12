package com.bkticketing.bkTicketing_backend.Service;
import com.bkticketing.bkTicketing_backend.Model.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(String userId);
    User getUserNameById(String userId);
    User getUserByUserEmail(String userEmail);
    List<User> getAllUsers();
    void deleteUser(String userId);
    String sendRecoveryCode(String userEmail);
    boolean verifyRecoveryCode(String userEmail, String recoveryCode);
    User updatePassword(String userEmail, String newPassword);
    
}
