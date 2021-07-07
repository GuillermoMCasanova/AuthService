package ec.edu.espe.mc.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "auth_user_permission")
public class UserPermission implements Serializable {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "permission_id")
    private Permission permission;

    public UserPermission() {
    }

    public UserPermission(User user, Permission permission) {
        this.user = user;
        this.permission = permission;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPermission that = (UserPermission) o;
        return user.equals(that.user) && permission.equals(that.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, permission);
    }
}
