package ec.edu.espe.mc.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "auth_role_permission")
public class RolePermission implements Serializable {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "permission_id")
    private Permission permission;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    public RolePermission() {

    }

    public RolePermission(Permission permission, Role role) {
        this.permission = permission;
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePermission that = (RolePermission) o;
        return permission.equals(that.permission) && role.equals(that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permission, role);
    }
}
