
package dominio;

public class Vendedor extends Usuario{
    private int idVendedor;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String telefono;

    public Vendedor(int idVendedor, String nombre, String apellidoP, String apellidoM, String telefono) {
        this.idVendedor = idVendedor;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
    }
    

    public Vendedor(String nombre, String apellidoP, String apellidoM, String telefono) {
       this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
    }

    public Vendedor(int idCliente) {
        this.idVendedor = idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
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
        sb.append("Vendedor{");
        sb.append("idVendedor=").append(idVendedor);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidoP=").append(apellidoP);
        sb.append(", apellidoM=").append(apellidoM);
        sb.append(", telefono=").append(telefono);
        sb.append('}');
        return sb.toString();
    }
    

    
}
