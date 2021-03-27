package marco.umg.com.proyectochat.Entidades.Firebase2;

import com.google.firebase.database.ServerValue;

/**
 * Created by user on 19/02/2018. 19
 */

public class Usuario {

    private String fotoPerfilURL;
    private String nombre;
    private String correo;
    private Object createdTimestamp;

    public Usuario() {
        createdTimestamp = ServerValue.TIMESTAMP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFotoPerfilURL() {
        return fotoPerfilURL;
    }

    public void setFotoPerfilURL(String fotoPerfilURL) {
        this.fotoPerfilURL = fotoPerfilURL;
    }

    public Object getCreatedTimestamp() {
        return createdTimestamp;
    }

}
