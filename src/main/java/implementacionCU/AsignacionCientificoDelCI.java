package implementacionCU;

import java.util.GregorianCalendar;

public class AsignacionCientificoDelCI {
    private GregorianCalendar fechaDesde;
    private GregorianCalendar fechaHasta;
    private PersonalCientifico PersonalCientifico ;

    public PersonalCientifico getPersonalCientifico() {
        return PersonalCientifico;
    }

    public AsignacionCientificoDelCI(int aD, int mD ,int dD, int aH,int mH, int dH, PersonalCientifico pc) {
        this.fechaDesde = new GregorianCalendar(aD,mD,dD) ;
        this.fechaHasta = new GregorianCalendar(aH,mH,dH) ;
        this.PersonalCientifico = pc ;
    }
    
    // metodo que verifica si determinado pc es activo
    public boolean esCientificoActivo() {
        GregorianCalendar fechaActual = new GregorianCalendar();
        return fechaHasta.after(fechaActual);
        
    }
}