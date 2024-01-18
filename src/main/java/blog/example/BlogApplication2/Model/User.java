package blog.example.BlogApplication2.Model;
import blog.example.BlogApplication2.Validation.EmailValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotEmpty
    @Size(min=3,message = "Username must be of 4 characters")
    private String name;
    @EmailValidation(message = "Email Address is not valid!!..")
    private String email;
    @NotEmpty
    @Size(min=8,message = "Invalid Password!!...")
    private String password;
    private String bio;
    private String profilepicture;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  List.of(new SimpleGrantedAuthority("user"));
    }


    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
