package implementacionCU;

public class PersonalCientifico {
    private int legajo; 
    private String nombre;
    private String apellido;
    private int numeroDocumento;
    private String correoElectronicoInstitucional;
    private String correoElectronicoPersonal ;
    private int telefonoCelular;
    private Usuario usuario;

    public PersonalCientifico(int l, String n, String a, int nroDoc, String correoI, String correoP, int t, Usuario u) {
        this.legajo = l ;
        this.nombre = n ;
        this.apellido = a ;
        this.numeroDocumento = nroDoc;
        this.correoElectronicoInstitucional = correoI;
        this.correoElectronicoPersonal = correoP ;
        this.telefonoCelular = t ;
        this.usuario = u ;
    }

    public int getLegajo() { return this.legajo ; }
    public String getNombre() { return this.nombre ; }
    public String getApellido() { return this.apellido; }
    public int getNumeroDocumento() { return this.numeroDocumento ; }
    public String getCorreoInstitucional() { return this.correoElectronicoInstitucional ; }
    public String getCorreoPersonal() { return this.correoElectronicoPersonal ; }
    public int getTelefonoCelular() { return this.telefonoCelular ; }
    public Usuario getUsuario() { return this.usuario ; }

    public boolean esTuUsuario(Usuario u) {
        return u.equals(this.usuario);
    }

    // devuelve los datos del usuario
    public String conocerDatosPC() {
        return  "legajo: " + this.legajo + "\n" +
                "nombre: " + this.nombre + "\n" +
                "apellido: " + this.apellido + "\n" +
                "numero documento: " + this.numeroDocumento + "\n" +
                "correo institucional: " + this.correoElectronicoInstitucional + "\n" +
                "correo personal: " + this.correoElectronicoPersonal + "\n" +
                "telefono celular: " + this.telefonoCelular + "\n" +
                "usuario: " + this.usuario ;
    }
    
}
