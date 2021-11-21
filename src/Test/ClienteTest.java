package Test;

import Main.Cliente;
import Main.Llamadas.LlamadaInternacional;
import Main.Llamadas.LlamadaLocal;
import Main.Llamadas.LlamadaNacional;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class ClienteTest {

    @Test
    public void test01FacturacionEnero1Llamada(){
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.DAY_OF_WEEK, 6);
        fecha.set(Calendar.MONTH, 0);
        fecha.set(Calendar.HOUR_OF_DAY, 1);
        LlamadaLocal llamada = new LlamadaLocal(fecha, 12452);

        Cliente cliente = new Cliente();
        cliente.agregarLlamada(llamada);

        Assert.assertEquals(520.75, cliente.calcularFacturacionDeMes(0), 0.0);
    }

    @Test
    public void test02FacturacionFebreroSinLlamadas(){
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.DAY_OF_WEEK, 6);
        fecha.set(Calendar.MONTH, 5);
        fecha.set(Calendar.HOUR_OF_DAY, 1);
        LlamadaLocal llamada = new LlamadaLocal(fecha, 12452);

        Cliente cliente = new Cliente();
        cliente.agregarLlamada(llamada);

        Assert.assertEquals(500, cliente.calcularFacturacionDeMes(1), 0.0);
    }


    @Test
    public void test03FacturacionMarzo4Llamadas(){
        Calendar fecha1 = Calendar.getInstance();
        fecha1.set(Calendar.DAY_OF_WEEK, 2);
        fecha1.set(Calendar.MONTH, 2);
        fecha1.set(Calendar.HOUR_OF_DAY, 6);
        LlamadaLocal llamada1 = new LlamadaLocal(fecha1, 1578);

        Calendar fecha2 = Calendar.getInstance();
        fecha2.set(Calendar.DAY_OF_WEEK, 1);
        fecha2.set(Calendar.MONTH, 2);
        fecha2.set(Calendar.HOUR_OF_DAY, 12);
        LlamadaLocal llamada2 = new LlamadaLocal(fecha2, 7888);

        Calendar fecha3 = Calendar.getInstance();
        fecha3.set(Calendar.DAY_OF_WEEK, 5);
        fecha3.set(Calendar.MONTH, 2);
        fecha3.set(Calendar.HOUR_OF_DAY, 15);
        LlamadaLocal llamada3 = new LlamadaLocal(fecha3, 3451);

        Calendar fecha4 = Calendar.getInstance();
        fecha4.set(Calendar.DAY_OF_WEEK, 7);
        fecha4.set(Calendar.MONTH, 2);
        fecha4.set(Calendar.HOUR_OF_DAY, 7);
        LlamadaLocal llamada4 = new LlamadaLocal(fecha4, 654);

        Cliente cliente = new Cliente();
        cliente.agregarLlamada(llamada1);
        cliente.agregarLlamada(llamada2);
        cliente.agregarLlamada(llamada3);
        cliente.agregarLlamada(llamada4);

        Assert.assertEquals(528.37  , cliente.calcularFacturacionDeMes(2), 0.0);
    }

    @Test
    public void test04FacturacionAbril3Llamadas2AOtrosMeses(){
        Calendar fecha1 = Calendar.getInstance();
        fecha1.set(Calendar.DAY_OF_WEEK, 2);
        fecha1.set(Calendar.MONTH, 3);
        fecha1.set(Calendar.HOUR_OF_DAY, 17);
        LlamadaLocal llamada1 = new LlamadaLocal(fecha1, 6879);

        Calendar fecha2 = Calendar.getInstance();
        fecha2.set(Calendar.DAY_OF_WEEK, 1);
        fecha2.set(Calendar.MONTH, 3);
        fecha2.set(Calendar.HOUR_OF_DAY, 12);
        LlamadaNacional llamada2 = new LlamadaNacional(fecha2, 1234, "Tierra del Fuego");

        Calendar fecha3 = Calendar.getInstance();
        fecha3.set(Calendar.DAY_OF_WEEK, 5);
        fecha3.set(Calendar.MONTH, 3);
        fecha3.set(Calendar.HOUR_OF_DAY, 15);
        LlamadaInternacional llamada3 = new LlamadaInternacional(fecha3, 4568, "Paraguay");

        Calendar fecha4 = Calendar.getInstance();
        fecha4.set(Calendar.DAY_OF_WEEK, 6);
        fecha4.set(Calendar.MONTH, 0);
        fecha4.set(Calendar.HOUR_OF_DAY, 12);
        LlamadaLocal llamada4 = new LlamadaLocal(fecha4, 7899);

        Calendar fecha5 = Calendar.getInstance();
        fecha5.set(Calendar.DAY_OF_WEEK, 2);
        fecha5.set(Calendar.MONTH, 9);
        fecha5.set(Calendar.HOUR_OF_DAY, 4);
        LlamadaLocal llamada5 = new LlamadaLocal(fecha5, 12312);

        Cliente cliente = new Cliente();
        cliente.agregarLlamada(llamada1);
        cliente.agregarLlamada(llamada2);
        cliente.agregarLlamada(llamada3);
        cliente.agregarLlamada(llamada4);
        cliente.agregarLlamada(llamada5);

        Assert.assertEquals(662.64  , cliente.calcularFacturacionDeMes(3), 0.0);
    }
}

