package login_test;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginModel {
    private String login;
    private String url;
    private boolean isInUse;

}
