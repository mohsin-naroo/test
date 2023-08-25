package com.redmath.news.user;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid user: " + userName);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), true,
                true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));
    }
}
