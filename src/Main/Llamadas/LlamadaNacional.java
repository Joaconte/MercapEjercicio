package Main.Llamadas;

import java.util.Calendar;
import java.util.Map;

public class LlamadaNacional extends Llamada {

    protected final String ubicacionReceptor;
    private static final Map<String, Double> localidades = Map.of("Misiones", 0.30, "Entre Rios", 0.40,
            "Tierra del Fuego", 0.50, "Cordoba", 0.60, "Santa Cruz", 0.70);

    public LlamadaNacional(Calendar fecha, int duracion, String ubicacionReceptor) {

        super(fecha, duracion);
        this.ubicacionReceptor = ubicacionReceptor;
        costoLlamada();
    }

    private void costoLlamada(){

        calcularCostoLlamada(localidades.get(ubicacionReceptor));
    }
}
