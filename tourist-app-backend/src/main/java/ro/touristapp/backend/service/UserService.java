package ro.touristapp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.touristapp.backend.model.Role;
import ro.touristapp.backend.model.RoleName;
import ro.touristapp.backend.model.TouristUser;
import ro.touristapp.backend.model.Users;
import ro.touristapp.backend.model.dto.UserInformationDto;
import ro.touristapp.backend.repository.RoleRepository;
import ro.touristapp.backend.repository.TouristUserRepository;
import ro.touristapp.backend.repository.UsersRepository;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserService {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UsersRepository userRepository;

    @Autowired
    TouristUserRepository touristUserRepository;

    public void createAccount(UserInformationDto userInformationDto) {
        TouristUser touristUser = new TouristUser(userInformationDto.getLastName(), userInformationDto.getFirstName()
                ,userInformationDto.getEmail(),userInformationDto.getBirthDate());
        Users user = new Users(userInformationDto.getUsername(),encoder.encode(userInformationDto.getPassword()),touristUser);

        Set<String> strRoles = userInformationDto.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                default:
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not found."));
                    roles.add(userRole);
            }
        });
        user.setRoles(roles);
        touristUserRepository.save(touristUser);
        userRepository.save(user);
    }
}
