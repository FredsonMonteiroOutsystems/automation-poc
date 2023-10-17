package objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Simplifying class code with loombok annotations
@Getter
@Setter
@NoArgsConstructor
public class LoginUser {
    private String email;
    private String password;
}
