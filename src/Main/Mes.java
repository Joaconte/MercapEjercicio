package Main;

import Main.Llamadas.Llamada;
import java.util.ArrayList;

public class Mes {

    private static final int abonoMensual = 500;
    private ArrayList<Llamada> llamadas = new ArrayList<>();

    public double calcularFacturacion() {

        double facturacion = abonoMensual;
        for (Llamada llamada: llamadas)
            facturacion += llamada.obtenerCostoLlamada();
        return Math.round(facturacion*100.0)/100.0;        //redondea a dos decimales
    }

    public void agregarLlamada(Llamada llamada){
        llamadas.add(llamada);
    }

    public int obtenerCantidadDeLlamadas(){
        return llamadas.size();
    }
}
