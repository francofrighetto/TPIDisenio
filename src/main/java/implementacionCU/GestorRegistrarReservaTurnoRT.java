package implementacionCU ; // despues vemos el tema de las carpetas

import interfazNotificacion.IObservadorReservaTurnoRT;
import interfazNotificacion.ISujeto;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GestorRegistrarReservaTurnoRT implements ISujeto{
    private List<TipoRecursoTecnologico> listaTiposRT = new ArrayList<>() ;
    private TipoRecursoTecnologico seleccionTipoRecurso ;
    private List<CentroDeInvestigacion> centros = new ArrayList<>() ;
    private List<RecursoTecnologico> listaRT = new ArrayList<>() ;
    private RecursoTecnologico seleccionRecursoTecnologico;
    private Sesion actualS;
    private Usuario usuarioLogeado;
    private CentroDeInvestigacion  seleccionadoCentro;
    private PersonalCientifico personalCientificoLogeado ;
    private GregorianCalendar fechaHoraActual ;
    private List<Turno> listaTurnos = new ArrayList<>() ;
    private Turno seleccionTurno;
    private IObservadorReservaTurnoRT seleccionTipoNotificacion;
    private Object RTxCI [][];
    private String fechaSeleccionadaTurno;
    private List<Turno> turnosPorFechaSel=new ArrayList<>();
    private List<Estado> estados = new ArrayList<>();
    private ArrayList<String> contactos = new ArrayList<>();
    
    // observadores (patron)
    private List<IObservadorReservaTurnoRT> observadores = new ArrayList<>();

        
        


    public GestorRegistrarReservaTurnoRT() {
        this.iniciar() ;
    }

    // metodos
    public List<TipoRecursoTecnologico> nuevaReservaTurnoRT(){
        return this.buscarTipoRecursoTecnologico();
        
    }
    
    // metodos implementados de ISujeto
    @Override
    public void notificar() {
        for (IObservadorReservaTurnoRT ob : observadores){
            ob.enviarNotificacion(fechaSeleccionadaTurno, fechaHoraActual, contactos);
        }
    }

    @Override
    public void suscribir(IObservadorReservaTurnoRT ob) {
        this.observadores.add(ob);
    }

    @Override
    public void quitar(IObservadorReservaTurnoRT ob) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // le paso una lista con todas las direcciones de memoria de cada tipo
    // en la interfaz, se mostrara el nombre de cada tipo de rt
    private List<TipoRecursoTecnologico> buscarTipoRecursoTecnologico( ){
        return listaTiposRT;
    }

    // la pantalla tomar la seleccion del tipo de recurso y se la pasa al gestor
    public List<RecursoTecnologico>  tomarSeleccionTipoRecursoTecnologico(TipoRecursoTecnologico t){
        //this.seleccionTipoRecurso = t;
        return this.buscarRecursosTecnologicos(t);
    }

    private List<RecursoTecnologico> buscarRecursosTecnologicos(TipoRecursoTecnologico t){
        for (CentroDeInvestigacion centro : centros){
            if (centro.estaActivo() == true){
                listaRT = (centro.mostrarRT(t));
            }
        }
        return listaRT;
    } 

    public CentroDeInvestigacion ordenarRTporCI(RecursoTecnologico seleccionado){
        for (CentroDeInvestigacion centro: centros){
            if(centro.esMiRT(seleccionado)){
                //this.seleccionadoCentro = centro;
                return centro;
            }
        }
        return null;
    }
    public void tomarSeleccionRT(RecursoTecnologico rT){
        this.seleccionRecursoTecnologico = rT;
        this.buscarUsuarioLogeado();
    }
    private void buscarUsuarioLogeado(){
        usuarioLogeado = actualS.getUsuarioLogeado();
        this.validarPersonalCientifico();
    }
    
    private void validarPersonalCientifico(){
        
        /*
        seleccionadoCentro.misCientificosActivos();
        this.personalCientificoLogeado = seleccionadoCentro.getPersonalLogeado(this.usuarioLogeado); 
        */
        
        seleccionadoCentro=ordenarRTporCI(seleccionRecursoTecnologico);
        seleccionadoCentro.misCientificosActivos();
        personalCientificoLogeado= seleccionadoCentro.getPersonalLogeado(usuarioLogeado);

        if (personalCientificoLogeado != null){
            this.tomarFechaHoraActual();
        }
        
}
    
    private void tomarFechaHoraActual(){
        this.fechaHoraActual = new GregorianCalendar();
        listaTurnos= seleccionRecursoTecnologico.misTurnoDisponibles(fechaHoraActual);
    }
    
    private void agruparYOrdenarTurnos(){
        // [Turno{fechaHoraInicio=Tue Jul 05 15:30:00 ART 2022, fechaHoraFin=Sat Jul 09 16:00:00 ART 2022, actual=implementacionCU.CambioEstadoTurno@2416c5aa}]
        for (Turno t : listaTurnos){
            if (t.getFechaHoraInicio().equals(fechaSeleccionadaTurno)){
                turnosPorFechaSel.add(t);
            }
        }
        
    }
    
    public List<Turno> getTurnosPorFechaSel(){
        return turnosPorFechaSel;
    }
    
    
    public void tomarSeleccionTurno(Turno turno){
        this.seleccionTurno=turno;
        this.tomarConfirmacionTurno();
    }
    public void setFechaSeleccionadaTurno(Date fecha){
        String fechaFormateada= ""+fecha;
        this.fechaSeleccionadaTurno= fechaFormateada.substring(8, 10)+"-"+fechaFormateada.substring(4,7);
        this.agruparYOrdenarTurnos();
    }
    private void tomarConfirmacionTurno(
            
    ){}
    public Turno getSeleccionTurno(){
        return this.seleccionTurno;
    }

    public RecursoTecnologico getSeleccionRecursoTecnologico() {
        return seleccionRecursoTecnologico;
    }
    
    public CentroDeInvestigacion getSeleccionadoCentro(){
        return this.seleccionadoCentro;
    }
    
    
    public void pedirConfirmacionReservaTurno(){
        
    }
    
    public void tomarSeleccionTipoNotificacion(IObservadorReservaTurnoRT tipo){
        this.seleccionTipoNotificacion=tipo;
    }
    
    public void mandarNotificacion(){
        
        this.contactos = this.personalCientificoLogeado.conocerContactosPC();
        this.suscribir(seleccionTipoNotificacion);

        this.notificar();
        
        
        /*
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Mensaje enviado por "+this.seleccionTipoNotificacion);
        */
    }
    
    
    
    public void registrarReservaTurnoDeRT(){
        Estado estadoRegistrar=null;
        for (Estado e: estados){
            if ( e.esAmbitoCambioEstadoTurno()){
                if (e.esReservado()){
                    estadoRegistrar = e;
                }
            }
        }
        seleccionRecursoTecnologico.actualizarEstadoTurno(estadoRegistrar);
        System.out.println(seleccionRecursoTecnologico.getActual().getEstado());
        this.mandarNotificacion();
        this.finCU();
        
    }
    public void finCU(){
        System.exit(0);
    }

    public void iniciar() {
        // creamos usuarios
        Usuario u1 = new Usuario("pindu", "123456789") ;
        Usuario u2 = new Usuario("gabb", "987654321") ;
        Usuario u3 = new Usuario("paopao", "112233") ;

        // creamos personal cientifico
        PersonalCientifico pc1 = new PersonalCientifico(01010, "Luciano", "Parruccia", 20000000, "lucianoParr@gmail.edu", "lucianoParr@gmail.com", "154000000", u1) ;
        PersonalCientifico pc2 = new PersonalCientifico(22333, "Gabriel", "Bruno", 20000000, "gabBruno009@gmail.edu", "gabBruno009@gmail.com", "154000000", u2) ;
        PersonalCientifico pc3 = new PersonalCientifico(01010, "Paola", "Simielli", 20000000, "paoSimielli@gmail.edu", "paoSimielli@gmail.edu", "154000000", u3) ;

        // creamos asignaciones de cientificos
        AsignacionCientificoDelCI a1 = new AsignacionCientificoDelCI(2000, 0, 1,2025, 0, 1, pc1) ;
        AsignacionCientificoDelCI a2 = new AsignacionCientificoDelCI(2010, 0, 1,2025, 0, 1, pc2) ;
        AsignacionCientificoDelCI a3 = new AsignacionCientificoDelCI(2005, 0, 1,2030, 0, 1, pc3) ;
        
        // agregamos las asignaciones al centro activo
        //ci1.getNombre();
        
        //creamos 1 sesion
        Sesion s1 = new Sesion(u1);
        actualS = s1;
        // creamos tipos de recursos tecnologicos
        TipoRecursoTecnologico tipo1 = new TipoRecursoTecnologico("tipo1") ;
        TipoRecursoTecnologico tipo2 = new TipoRecursoTecnologico("tipo2") ;
        TipoRecursoTecnologico tipo3 = new TipoRecursoTecnologico("tipo3") ;

        // creamos una lista para tener todos los tipos de recursos
        listaTiposRT.add(tipo1) ;
        listaTiposRT.add(tipo2) ;
        listaTiposRT.add(tipo3) ;

        // creamos dos centros de investigacion, uno activo y el otro no
        CentroDeInvestigacion ci1 = new CentroDeInvestigacion("AAA", 2019, 0, 1, 2030, 0, 1) ;
        CentroDeInvestigacion ci2 = new CentroDeInvestigacion("BBB", 2020, 5, 15, 2022, 6, 1) ;
        
        // estados
        Estado e1 = new Estado("disponible", "RecursoTecnologico", true) ;
        Estado e2 = new Estado("en mantenimiento", "RecursoTecnologico", true) ;
        Estado e3 = new Estado("en mantenimento correctivo", "RecursoTecnologico", true) ;

        // cambio de estado rt actual con estado=disponible
        GregorianCalendar f = new GregorianCalendar() ;
        CambioEstadoRT cambio1 = new CambioEstadoRT(f, e1) ;
        CambioEstadoRT cambio2 = new CambioEstadoRT(f, e2);
        CambioEstadoRT cambio3 = new CambioEstadoRT(f, e3);

        //creamos marcas
        Marca marca1 = new Marca("marca1");
        Marca marca2 = new Marca("marca2");
        
        //creamos modelos
        Modelo modelo1 = new Modelo("modelo1",marca1);
        Modelo modelo2 = new Modelo("modelo2",marca1);
        
        // creamos recursos tecnologicos
        RecursoTecnologico rt1 = new RecursoTecnologico(111, 1, 1, 2022, tipo1, false, cambio1, modelo1) ;
        RecursoTecnologico rt2 = new RecursoTecnologico(555, 10, 1, 2022, tipo1, false, cambio2, modelo2) ;
        RecursoTecnologico rt3 = new RecursoTecnologico(565, 10, 1, 2022, tipo1, false, cambio3, modelo2) ;

        // agregamos los recursos a un centro
        centros.add(ci1);
        centros.add(ci2);
        ci1.agregarRT(rt1);
        ci1.agregarRT(rt2);
        ci1.agregarRT(rt3);
        ci1.agregarCientifico(a1);
        usuarioLogeado = u1;
        
        //crear estados, cambiosestados y turnos y asignarlos a los recursos
                
        Estado e4 = new Estado("disponible", "Turno", true) ;
        Estado e5 = new Estado("con reserva pendiente de confirmación", "Turno", false) ;
        Estado e6 = new Estado("Reservado", "Turno", false) ;
        
        estados.add(e1);
        estados.add(e2);
        estados.add(e3);
        estados.add(e4);
        estados.add(e5);
        estados.add(e6);
        
        
        GregorianCalendar ff = new GregorianCalendar(2022,0,14);
        CambioEstadoTurno c4 = new CambioEstadoTurno(ff,e4);
        
        // 8 de julio del 2022
        Turno t1 = new Turno(2022, 10, 20,15,30,0,16,0,0,2022,10,21,c4);
        rt1.agregarTurno(t1);
       
}

    
}