package com.example.challengespringboot.security;

import com.example.challengespringboot.Models.UserApp;
import com.example.challengespringboot.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServices implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApp user= userRepository.findUserByName(username);
        UserBuilder userBuilder = null;

        if(user != null){
            userBuilder = User.withUsername(username);
            userBuilder.disabled(false);
            userBuilder.password(user.getPassword());
            userBuilder.authorities(new SimpleGrantedAuthority("ROLE_USER"));

        }else{
            throw new UsernameNotFoundException("User not found");
        }

        return userBuilder.build();
    }
}
