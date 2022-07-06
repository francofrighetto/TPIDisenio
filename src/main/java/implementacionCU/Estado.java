package implementacionCU;

public class Estado {
    private String nombre;
    private String ambito;
    private boolean esReservable;
    
	public Estado(String nombre, String ambito, boolean esReservable) {
		this.nombre = nombre;
		this.ambito = ambito;
		this.esReservable = esReservable;
	}
	
	public boolean esAmbitoCambioEstadoRT() {
		return (this.ambito.equals("RecursoTecnologico")) ;
	}

	public boolean esAmbitoCambioEstadoTurno() {
            return (this.ambito.equals("Turno")) ;
	}

	public boolean esReservable() { return esReservable; }

	public String getNombre() { return nombre;}
	public String getAmbito() { return ambito; }

	public boolean esReservado() {
		return (this.nombre.equals("Reservado")) ;
	}
 
}
