
package dominio;


public class Proovedor extends Usuario {
    private int idProovedor;
     private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String telefono;

    public Proovedor(int idProovedor, String nombre, String apellidoP, String apellidoM, String telefono) {
        this.idProovedor = idProovedor;
         this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;

    }

    public Proovedor(String nombre, String apellidoP, String apellidoM, String telefono) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
    }
    

    public Proovedor(int idProovedor) {
        this.idProovedor = idProovedor;
    }

    public int getIdProovedor() {
        return idProovedor;
    }

    public void setIdProovedor(int idProovedor) {
        this.idProovedor = idProovedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Proovedor{");
        sb.append("idProovedor=").append(idProovedor);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidoP=").append(apellidoP);
        sb.append(", apellidoM=").append(apellidoM);
        sb.append(", telefono=").append(telefono);
        sb.append('}');
        return sb.toString();
    }


    
    
    
    
    
    
}
