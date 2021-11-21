package Main;


import Main.Llamadas.Llamada;

import java.util.ArrayList;

public class Cliente {

    private final ArrayList<Mes> meses = new ArrayList<>();

    public Cliente() {

        for (int i=0; i<12; i++)
            meses.add(new Mes());
    }

    public void agregarLlamada (Llamada llamada){

        int mes = llamada.obtenerMes();
        meses.get(mes).agregarLlamada(llamada);
    }

    public double calcularFacturacionDeMes( int mes){
        return meses.get(mes).calcularFacturacion();
    }

    public int obtenerCantidadDeLlamadasDeMes(int mes){
        return meses.get(mes).obtenerCantidadDeLlamadas();
    }
}
