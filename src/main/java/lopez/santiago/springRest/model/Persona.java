package lopez.santiago.springRest.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @org.springframework.data.annotation.Id
    private Long id_persona;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;


    public Persona() {
        super();
    }

    public Persona(Long id_persona, @NotBlank String nombre, @NotBlank String apellido) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}