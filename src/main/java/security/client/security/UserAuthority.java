package security.client.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Mocart on 06-Sep-17.
 */
public class UserAuthority implements GrantedAuthority {
    private String authority;

    public UserAuthority(String groupName) {
        authority = groupName;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
