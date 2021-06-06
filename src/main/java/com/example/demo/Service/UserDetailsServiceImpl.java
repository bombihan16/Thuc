package com.example.demo.Service;

import com.example.demo.Dao.UserRepository;
import com.example.demo.Entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }

        Set<String> roles = new HashSet<>();
        roles.add(user.getRole());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (String role: roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return new User(user.getUserName(), user.getPassWord(), grantedAuthorities);
    }
}
