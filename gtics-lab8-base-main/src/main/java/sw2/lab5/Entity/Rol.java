package sw2.lab5.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "role")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private int idrol;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    // Implémentation de GrantedAuthority pour Spring Security
    @Override
    public String getAuthority() {
        return nombre;
    }

    // Getters et Setters
    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
