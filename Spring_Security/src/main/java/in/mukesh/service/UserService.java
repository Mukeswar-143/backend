package in.mukesh.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import in.mukesh.entity.Userss;
import in.mukesh.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserRepo repo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Userss register(Userss user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

    public String verify(Userss user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
   if (authentication.isAuthenticated()) {
         return jwtService.generateToken(user.getUsername())  ;
        } else {
            return "fail";
        }
    }
}
