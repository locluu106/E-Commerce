
package entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name="user")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int userId;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    
   @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registerDate;
   @NotNull
    private int enabled;
    
    
    
    @ManyToOne
    @JoinColumn(name="userRoleId")
    private UserRoleEntity user_roles;
    
    @ManyToOne
    @JoinColumn(name="customerId")
    private CustomerEntity customer;

    public UserEntity() {
    }

    public UserEntity(int userId, String username, String password, LocalDate registerDate, int enabled, UserRoleEntity user_roles, CustomerEntity customer) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.registerDate = registerDate;
        this.enabled = enabled;
        this.user_roles = user_roles;
        this.customer = customer;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public UserRoleEntity getUser_roles() {
        return user_roles;
    }

    public void setUser_roles(UserRoleEntity user_roles) {
        this.user_roles = user_roles;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }    
    
    
}
