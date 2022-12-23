
package dominio;

public class Usuario {

    private int id_usuario;
    private String user;
    private String correo;
    private String contrasena;

    
    //Constructores
    public Usuario(){
        
    }

    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Usuario(String user, String correo, String contrasena){
        this.user = user;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario(int id_usuario, String user, String correo, String contrasena) {
        this.id_usuario = id_usuario;
        this.user = user;
        this.correo = correo;
        this.contrasena = contrasena;
    }
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

   
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("id_usuario=").append(id_usuario);
        sb.append(", user=").append(user);
        sb.append(", correo=").append(correo);
        sb.append(", contrasena=").append(contrasena);
        sb.append('}');
        return sb.toString();
    }
    
}
