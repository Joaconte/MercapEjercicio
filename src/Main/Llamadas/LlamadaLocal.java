package Main.Llamadas;

import java.util.Calendar;
import java.util.Objects;

public class LlamadaLocal extends Llamada {

    private static final double precioLlamadaCaroXMinuto = 0.20;       //Dia Habil 8 a 20 Hs
    private static final double precioLlamadaBaratoXMinuto = 0.10;     //Fin de semana

    public LlamadaLocal(Calendar fecha, int duracion) {
        super(fecha, duracion);
        costoLlamada();
    }

    private void costoLlamada(){

        double precioLlamadaXMinuto = calcularPrecioSegunHorarioYDia();
        calcularCostoLlamada(precioLlamadaXMinuto);
    }

    private double calcularPrecioSegunHorarioYDia(){

        int horario = fecha.get(Calendar.HOUR_OF_DAY);
        if ( ( horario > 8 ) && ( horario < 20 ) )
            return calcularPrecioSegunDia();
        return precioLlamadaBaratoXMinuto;
    }

    private double calcularPrecioSegunDia(){

        int diaDeLaSemana = fecha.get(Calendar.DAY_OF_WEEK);
        if ( (diaDeLaSemana == 1) || (diaDeLaSemana == 7)  )
            return precioLlamadaBaratoXMinuto;
        return precioLlamadaCaroXMinuto;
    }


}
