package implementacionCU;

public class Sesion {
    private Usuario logeado ;

    public Sesion (Usuario u) { this.logeado = u ; }

    public Usuario getUsuarioLogeado() { return this.logeado ; }
}
