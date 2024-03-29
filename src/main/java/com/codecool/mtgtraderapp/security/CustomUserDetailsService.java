package com.codecool.mtgtraderapp.security;

import com.codecool.mtgtraderapp.entity.AppUser;
import com.codecool.mtgtraderapp.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/*
 There must be a class that implements UserDetailsService otherwise Spring will create a default
 UserDetailsService (an instance of InMemoryUserDetailsManager, see UserDetailsServiceAutoConfiguration) that does not
 know where to find users for authentication.
*/
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository users;

    public CustomUserDetailsService(UserRepository users) {
        this.users = users;
    }

    /**
     * Loads the user from the DB and converts it to Spring Security's internal User oobject
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = users.findByName(username)
            .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));

        return new User(user.getName(), user.getPassword(),
                user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }
}
