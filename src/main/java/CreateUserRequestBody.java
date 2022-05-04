import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class CreateUserRequestBody {
private String firstName;
private String lastName;
private String email;
}