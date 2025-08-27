package com.primerapirest.primerapirest.services;

import com.primerapirest.primerapirest.entities.Role;
import com.primerapirest.primerapirest.entities.User;
import com.primerapirest.primerapirest.repositories.RoleRepository;
import com.primerapirest.primerapirest.repositories.UserRepository;
import com.primerapirest.primerapirest.security.SpringSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder; // Nos permite encriptar las contraseñas de los usuarios.

  @Transactional(readOnly = true)
  @Override
  public List<User> findAll() {
    return (List<User>) userRepository.findAll();
  }

  @Transactional
  @Override
  public User save(User user) {

    // Por default va a tener siempre el role user.
    Optional<Role> optionalRoleUser = roleRepository.findByName("ROLE_USER");
    List<Role> roles = new ArrayList<>();

    optionalRoleUser.ifPresent(roles::add);

    // Si tiene él role admin lo va a guardar y va a quedar con ambos roles.
    if (user.getAdmin() != null && user.getAdmin() == true){
      Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
      optionalRoleAdmin.ifPresent(roles::add);
    }

    user.setRoles(roles); // Guardamos los roles.
    user.setPassword(passwordEncoder.encode(user.getPassword())); // Esto nos permite encriptar la contraseña y guardarla.
    return userRepository.save(user);
  }

  @Override
  public Boolean existsByUsername(String username) {
    return userRepository.existsByUsername(username);
  }
}
