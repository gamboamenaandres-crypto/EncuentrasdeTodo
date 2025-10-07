package Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name ="tbl_usuarios")
public class Usuario {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id_usuario")
	private int id_usuario;

	@Column(name="identificacion_usuario", unique=true)
	private String identificacion;
	
	@Column(name="nombre_usuario")
	private String nombre_usuario;
	
	@Column(name="apellido_usuario")
	private String apellido_usuario;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="correo", unique=true)
	private String correo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_genero")
    private Genero genero;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "id_municipio")
    private Municipio direccion;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "id_tipo_usuario")
    private tipo_usuario roles;


    public Usuario() {

    }

    public Usuario(String identificacion, String nombre_usuario, String apellido_usuario, String telefono, String correo, Genero genero, Municipio direccion, tipo_usuario roles) {
        this.identificacion = identificacion;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.telefono = telefono;
        this.correo = correo;
        this.genero = genero;
        this.direccion = direccion;
        this.roles = roles;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Municipio getDireccion() {
        return direccion;
    }

    public void setDireccion(Municipio direccion) {
        this.direccion = direccion;
    }

    public tipo_usuario getRoles() {
        return roles;
    }

    public void setRoles(tipo_usuario roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id_usuario == usuario.id_usuario && Objects.equals(identificacion, usuario.identificacion) && Objects.equals(nombre_usuario, usuario.nombre_usuario) && Objects.equals(apellido_usuario, usuario.apellido_usuario) && Objects.equals(telefono, usuario.telefono) && Objects.equals(correo, usuario.correo) && Objects.equals(genero, usuario.genero) && Objects.equals(direccion, usuario.direccion) && Objects.equals(roles, usuario.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_usuario, identificacion, nombre_usuario, apellido_usuario, telefono, correo, genero, direccion, roles);
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", identificacion='" + identificacion + '\'' +
                ", nombre_usuario='" + nombre_usuario + '\'' +
                // ... otros campos
                // EXCLUIR O SOLO MOSTRAR EL ID PARA EVITAR CARGAR ENTIDADES LAZY
                ", genero=" + (genero.getDes_genero()) + // <-- Asumiendo que Genero tiene un getId()
                ", municipio=" + (direccion.getNom_municipio()) + // <-- Asumiendo que Municipio tiene un getId()
                ", rol=" + (roles.getDes_tipo_usuario()) + // <-- Asumiendo que tipo_usuario tiene un getId()
                '}';
    }
}
