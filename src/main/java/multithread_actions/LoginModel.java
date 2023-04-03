package multithread_actions;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginModel {
    private String login;
    private String url;
    private boolean isInUse;

}
