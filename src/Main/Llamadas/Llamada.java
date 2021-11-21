package Main.Llamadas;

import java.util.Calendar;

public abstract class Llamada {

    protected final Calendar fecha;
    protected final int duracion; //segundos
    protected double costo;

    Llamada (Calendar fecha,  int duracion){

        this.fecha = fecha;
        this.duracion = duracion;
    }

    protected void calcularCostoLlamada(double precioLlamadaXMinuto) {

        double costoSinRedondear = ( duracion * precioLlamadaXMinuto / 60 );
        costo = Math.round(costoSinRedondear*100.0)/100.0;       //redondea a dos decimales
    }

    public double obtenerCostoLlamada(){
        return costo;
    }

    public int obtenerMes(){
        return fecha.get(Calendar.MONTH);
    }

}
