package fi.haagahelia.bookstore;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.haagahelia.bookstore.model.AppUser;
import fi.haagahelia.bookstore.model.AppUserRepository;

@Service
public class UserDetailServicempl implements UserDetailsService {
    private final AppUserRepository repository;

    public UserDetailServicempl(AppUserRepository repository) {
        this.repository = repository;
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        AppUser curruser = repository.findByUsername(username);
        
        if (curruser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
		UserDetails user = new org.springframework.security.core.userdetails.User(
            curruser.getUsername(),
            curruser.getPassword(),
		AuthorityUtils.createAuthorityList(curruser.getRole())
    
    );
		return user;
	}
}
