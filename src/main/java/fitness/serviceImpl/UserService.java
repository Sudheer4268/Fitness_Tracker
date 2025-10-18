//package fitness.serviceImpl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.stereotype.Service;
//
//import fitness.models.User;
//import fitness.repository.UserRepository;
//
//@Service
//public class UserService {
//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    
//    public User registerUser(User user) {
//        User existingUser = userRepository.findByEmail(user.getEmail());
//        if (existingUser != null) {
//            throw new RuntimeException("Email already registered!");
//        }
//        return userRepository.save(user); 
//    }
//
//    
//    public User getUserByEmailAndPassword(String email, String password) {
//        User user = userRepository.findByEmail(email);
//        if (user != null && user.getPassword().equals(password)) {
//            return user;
//        }
//        return null; 
//    }
//
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public Optional<User> getUserById(Long id) {
//        return userRepository.findById(id);
//    }
//
//    public String deleteUser(Long id) {
//        if (userRepository.existsById(id)) {
//            userRepository.deleteById(id);
//            return "User deleted successfully!";
//        } else {
//            return "User not found!";
//        }
//    }
//}


package fitness.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import fitness.models.User;
import fitness.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new RuntimeException("Email already registered!");
        }
        user.setGetstarted(false); // default false on registration
        return userRepository.save(user);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public String deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted successfully!";
        } else {
            return "User not found!";
        }
    }


    public User markGetStarted(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setGetstarted(true);
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found!");
        }
    }
}

