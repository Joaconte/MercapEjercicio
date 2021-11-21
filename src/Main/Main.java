package Main;

import Main.Llamadas.LlamadaInternacional;
import Main.Llamadas.LlamadaLocal;
import Main.Llamadas.LlamadaNacional;

import java.text.DateFormatSymbols;
import java.util.*;

import static java.lang.Thread.sleep;

public class Main {

    private static Cliente cliente;

    public static void main (String[] args) throws InterruptedException {

        cliente = new Cliente();

        registrarLlamadaLocal(1, 2, 12, 3459);
        registrarLlamadaLocal(6, 4, 11, 1234);
        registrarLlamadaLocal(23, 0, 23, 4567);
        registrarLlamadaLocal(14, 2, 14, 4517);
        registrarLlamadaNacional(6, 4, 12, 5321, "Misiones");
        registrarLlamadaNacional(1, 0, 24, 7548, "Cordoba");
        registrarLlamadaNacional(3, 0, 17, 324, "Cordoba");
        registrarLlamadaNacional(1, 6, 5, 987, "Tierra del Fuego");
        registrarLlamadaInternacional(6, 2, 3, 4675, "Brasil");
        registrarLlamadaInternacional(7, 6, 18, 3214, "Brasil");
        registrarLlamadaInternacional(3, 11, 23, 1234, "Uruguay");
        registrarLlamadaInternacional(1, 0, 12, 1578, "Chile");

        mostrarFacturas();

    }

    private static void mostrarFacturas() throws InterruptedException {

        String nombreMes;
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();

        for (int i=0; i<12; i++) {

            if (cliente.calcularFacturacionDeMes(i) != 500) {

                nombreMes = months[i];
                nombreMes = nombreMes.toUpperCase();
                int cantLlamadas = cliente.obtenerCantidadDeLlamadasDeMes(i);
                double facturacionMes = cliente.calcularFacturacionDeMes(i);
                double costoLlamadasSinRedondear = facturacionMes - 500;
                double costoLlamadasRedondeado = Math.round(costoLlamadasSinRedondear * 100.0) / 100.0;

                System.out.println(
                        "\n" + """
                                                        
                        [Nombre de la compañia]                                       FACTURA
                            
                            
                        [Dirección de la calle]
                        [Ciudad, Estado Código postal]
                        Teléfono: (000) 000-0000                           FACTURA#                  MES
                        """ +
                        "                                                     XXXX                    " + nombreMes +
                        """
                            
                                        
                        FACTURAR A                                IDENTIFICACIÓN DEL CLIENTE       TÉRMINOS
                        [Nombre]                                              XXX
                        [Dirección de la calle]
                        [Teléfono]
                        [Dirección de correo electrónico]
                                        
                        Descripción                                          Cant                    Monto
                                        
                        Abono Mensual                                                                500$
                        """ +
                        "Llamadas                                              " + cantLlamadas + "                      " + costoLlamadasRedondeado + "$\n\n" +

                        "TOTAL                                                                        " + facturacionMes + "$\n\n" +
                        "--------------------------------------------------------------------------------------------"

                );
                sleep(5000);
            }
        }

    }

    private static void registrarLlamadaLocal(int diaDeLaSemana, int mes, int hora, int duracion) {

        Calendar fecha = Calendar.getInstance();
        inicializarFecha(fecha, diaDeLaSemana, mes, hora);

        LlamadaLocal llamada = new LlamadaLocal(fecha, duracion);
        cliente.agregarLlamada(llamada);
    }


    private static void registrarLlamadaNacional(int diaDeLaSemana, int mes, int hora, int duracion, String ubicacionReceptor ) {

        Calendar fecha = Calendar.getInstance();
        inicializarFecha(fecha, diaDeLaSemana, mes, hora);

        LlamadaNacional llamada = new LlamadaNacional(fecha, duracion, ubicacionReceptor);
        cliente.agregarLlamada(llamada);
    }

    private static void registrarLlamadaInternacional(int diaDeLaSemana, int mes, int hora, int duracion, String ubicacionReceptor ) {

        Calendar fecha = Calendar.getInstance();
        inicializarFecha(fecha, diaDeLaSemana, mes, hora);

        LlamadaInternacional llamada = new LlamadaInternacional(fecha, duracion, ubicacionReceptor);
        cliente.agregarLlamada(llamada);
    }

    private static void inicializarFecha(Calendar fecha, int diaDeLaSemana, int mes, int hora) {

        fecha.set(Calendar.DAY_OF_WEEK, diaDeLaSemana);
        fecha.set(Calendar.MONTH, mes);
        fecha.set(Calendar.HOUR_OF_DAY, hora);
    }

}
