package com.vdzon.contactdb.authenticatie;

import com.vdzon.contactdb.authenticatie.data.User;
import com.vdzon.contactdb.authenticatie.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    @Inject
    UserRepository userService;

    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
        User user = userService.findOne(username);
        if (user == null) throw new UsernameNotFoundException("user not found");

        Set<GrantedAuthority> setAuths = new HashSet<>();
        String permissions = user.getPermissions();
        for (String permission : permissions.split(",")) {
            setAuths.add(new SimpleGrantedAuthority(permission));
        }
        UserDetails userDetails = new AuthUser(setAuths, user.getId(), user.getPasswd(), username);
        return userDetails;
    }
}