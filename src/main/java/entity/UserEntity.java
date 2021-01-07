
package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="user")
public class UserEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String password;
    private int enabled;
    
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<CommentEntity> commentList;
    
    @ManyToOne
    @JoinColumn(name="userRoleId")
    private UserRoleEntity user_roles;
    
    @ManyToOne
    @JoinColumn(name="customerId")
    private CustomerEntity customer;

    public UserEntity() {
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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
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

    public List<CommentEntity> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentEntity> commentList) {
        this.commentList = commentList;
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
