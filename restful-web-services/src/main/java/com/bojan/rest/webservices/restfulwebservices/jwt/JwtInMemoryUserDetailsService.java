package com.bojan.rest.webservices.restfulwebservices.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "bojan",
        "$2a$10$ZbbPi5utijx2i1ajGz0pPeatCkkLffOceenr4.eC7UJ.IkPEH0x9y", "ROLE_USER_2"));
    inMemoryUserList.add(new JwtUserDetails(2L, "ranga",
                                            "$2a$10$n8icClWPsLS2KpXRBulw2uHuKt898SM9Y5UkxSBfZvXntrUmaO142", "ROLE_USER_2"));
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}

