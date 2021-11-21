package Test;
import Main.Llamadas.LlamadaInternacional;
import Main.Llamadas.LlamadaNacional;
import org.junit.Assert;
import org.junit.Test;

import Main.Llamadas.LlamadaLocal;

import java.util.Calendar;

public class LlamadaTest {

    @Test
    public void test01CostoLlamadaLocalDiaHabil14Hs(){
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.DAY_OF_WEEK, 3);              //Martes
        fecha.set(Calendar.HOUR_OF_DAY, 14);
        LlamadaLocal llamada = new LlamadaLocal(fecha, 1500);
        Assert.assertEquals(5, llamada.obtenerCostoLlamada(), 0.0);
    }

    @Test
    public void test02CostoLlamadaLocalDiaHabil6Hs(){
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.DAY_OF_WEEK, 4);              //Miercoles
        fecha.set(Calendar.HOUR_OF_DAY, 6);
        LlamadaLocal llamada = new LlamadaLocal(fecha, 700);
        Assert.assertEquals(1.17, llamada.obtenerCostoLlamada(), 0.0);
    }

    @Test
    public void test03CostoLlamadaLocalFinDeSemana11Hs(){
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.DAY_OF_WEEK, 1);              //Domingo
        fecha.set(Calendar.HOUR_OF_DAY, 11);
        LlamadaLocal llamada = new LlamadaLocal(fecha, 2300);
        Assert.assertEquals(3.83, llamada.obtenerCostoLlamada(), 0.0);
    }

    @Test
    public void test04CostoLlamadaLocalFinDeSemana24Hs(){
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.DAY_OF_WEEK, 7);               //Sabado
        fecha.set(Calendar.HOUR_OF_DAY, 24);
        LlamadaLocal llamada = new LlamadaLocal(fecha, 40);
        Assert.assertEquals(0.07, llamada.obtenerCostoLlamada(), 0.0);
    }

    @Test
    public void test05CostoLlamadaNacionalAMisiones(){
        Calendar fecha = Calendar.getInstance();
        LlamadaNacional llamada = new LlamadaNacional(fecha, 4000, "Misiones");
        Assert.assertEquals(20, llamada.obtenerCostoLlamada(), 0.0);
    }


    @Test
    public void test06CostoLlamadaInternacionalAChile(){
        Calendar fecha = Calendar.getInstance();
        LlamadaInternacional llamada = new LlamadaInternacional(fecha, 3154, "Chile");
        Assert.assertEquals(68.34, llamada.obtenerCostoLlamada(), 0.0);
    }

    @Test
    public void test07CostoLlamadaInternacionalABrasilConDiaYHora(){
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.DAY_OF_WEEK, 3);
        fecha.set(Calendar.HOUR_OF_DAY, 5);
        LlamadaInternacional llamada = new LlamadaInternacional(fecha, 987, "Brasil");
        Assert.assertEquals(24.68, llamada.obtenerCostoLlamada(), 0.0);
    }

}
