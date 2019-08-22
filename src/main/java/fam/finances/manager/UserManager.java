package fam.finances.manager;

import fam.finances.entity.AuthUserDetails;
import fam.finances.entity.User;
import fam.finances.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class UserManager implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
//        User user = optionalUser.orElseThrow(() -> new UsernameNotFoundException("username or password is wrong!"));

        UserDetails userDetails = new AuthUserDetails(user);

        new AccountStatusUserDetailsChecker().check(userDetails);

        return userDetails;
    }

    public User laodUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void costThisMuch(Integer price, String username) {
        User user = laodUserByUsername(username);
        Integer remainder = laodUserByUsername(username).getRemainder();
        if (remainder != -1) {
            Integer rem = remainder - price;
            user.setRemainder(rem);
            userRepository.save(user);
        }
    }
}
