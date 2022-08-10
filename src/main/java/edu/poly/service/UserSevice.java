package edu.poly.service;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import edu.poly.entities.Account;

@Service
public class UserSevice implements UserDetailsService {

	@Autowired
	AccountService accountService;

	@Autowired
	BCryptPasswordEncoder pe;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Account account = accountService.findById(username).get();
			String password = pe.encode(account.getPassword());
//			System.out.println(account.getAuthorities().get(0).getRole().getId());
//			String[] roles2 = account.getAuthorities().stream()
//					.map(user -> user.getRole())
//					.collect(Collectors.toList()).toArray(String[] :: new);
//			System.out.println(account.getAuthorities().get(0).getRole().getId());
			String[] roles = new String[account.getAuthorities().size()];
			for (int i = 0; i < account.getAuthorities().size(); i++) {
				roles[i] = account.getAuthorities().get(i).getRole().getId();
			}
//			System.out.println(roles[0]);
			return User.withUsername(username).password(password).roles(roles).build();

		} catch (NoSuchElementException e) {
			// TODO: handle exception
			throw new UsernameNotFoundException(username + " not found!");
		}
	}
	
//	public void loginFormOAuth2(OAuth2AuthenticationToken oauth2) {
////		String fullname = oauth2.getPrincipal().getAttribute("name");
//		String email = oauth2.getPrincipal().getAttribute("");
//		String password = Long.toHexString(System.currentTimeMillis());
//		
//		UserDetails user = User.withUsername(email)
//							.password(pe.encode(password))
//							.roles("GUEST")
//							.build();
//		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//		SecurityContextHolder.getContext().setAuthentication(auth);
//		
//	}
	
}
