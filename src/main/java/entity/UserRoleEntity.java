

package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="user_roles")
public class UserRoleEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int userRoleId;
    private String role;
    private String  username;

    
    @OneToMany(mappedBy = "user_roles")
    private List<UserEntity> user;

    public UserRoleEntity() {
    }

   

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    

    public List<UserEntity> getUser() {
        return user;
    }

    public void setUser(List<UserEntity> user) {
        this.user = user;
    }

    

    

    
}
