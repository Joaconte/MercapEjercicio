package Main.Llamadas;

import java.util.Calendar;
import java.util.Map;

public class LlamadaInternacional extends Llamada{

    protected final String ubicacionReceptor;
    private static final Map<String, Double> paises = Map.of("Chile", 1.30, "Uruguay", 1.40,
            "Brasil", 1.50, "Ecuador", 1.60, "Paraguay", 1.70);

    public LlamadaInternacional(Calendar fecha, int duracion, String ubicacionReceptor) {

        super(fecha, duracion);
        this.ubicacionReceptor = ubicacionReceptor;
        costoLlamada();
    }

    private void costoLlamada(){

        calcularCostoLlamada(paises.get(ubicacionReceptor));
    }
}
