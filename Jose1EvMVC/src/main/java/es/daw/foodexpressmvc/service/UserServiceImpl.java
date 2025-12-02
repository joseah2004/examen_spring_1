package es.daw.foodexpressmvc.service;

import es.daw.foodexpressmvc.dto.UserRegisterDTO;
import es.daw.foodexpressmvc.entity.Role;
import es.daw.foodexpressmvc.entity.User;
import es.daw.foodexpressmvc.exception.PasswordsDoNotMatchException;
import es.daw.foodexpressmvc.exception.UsernameAlreadyExistsException;
import es.daw.foodexpressmvc.repository.RoleRepository;
import es.daw.foodexpressmvc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(UserRegisterDTO dto) {
        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }

        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            throw new PasswordsDoNotMatchException("Passwords do not match");
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Default role USER not found"));
        user.addRole(userRole);

        userRepository.save(user);
    }
}
