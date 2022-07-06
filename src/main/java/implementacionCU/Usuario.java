package implementacionCU;

public class Usuario {
    private String usuario;
    private String clave;

    public Usuario(String u, String c) {
        this.usuario = u ;
        this.clave = c ;
    }

    public String getUsuario() { return this.usuario; }
    public String getClave() {return this.clave ;}    
}
