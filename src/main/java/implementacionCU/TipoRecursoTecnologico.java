package implementacionCU;

public class TipoRecursoTecnologico {
    private String nombre;

    public TipoRecursoTecnologico(String nombre){ this.nombre = nombre; }

    public String getNombre() { return this.nombre; }

    @Override
    public String toString() {
        return this.getNombre();
    }
    
}
