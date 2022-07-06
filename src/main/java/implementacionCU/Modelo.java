package implementacionCU;

public class Modelo {
    private String nombre;
    private Marca marca;
    
    //contructor
    public Modelo(String n, Marca marca) {
        this.nombre = n;
        this.marca =  marca;
    }
    //getter
    public String getModelo(){
        return this.nombre;
    }
    public String getMarca(){
        return this.marca.getNombre();

    }
}
