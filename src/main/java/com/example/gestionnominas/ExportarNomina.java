    package com.example.gestionnominas;
import java.io.FileWriter;
import java.io.IOException;

public class ExportarNomina {

    public static void exportar(Empleado empleado, String bancoSeleccionado) {
        if (bancoSeleccionado.equals("BanReservas")) {
            exportarBanReservas(empleado);
        } else if (bancoSeleccionado.equals("BHD")) {
            exportarBHD(empleado);
        }
    }

    private static void exportarBanReservas(Empleado empleado) {
        try (FileWriter writer = new FileWriter("empleados_banreservas.json")) {
            String cuenta = "CC,DOP," + empleado.getSalario();
            String data = "{\"cuenta\":\"" + cuenta + "\",\"concepto\":\"NOMINA\"}";
            writer.write(data);
        } catch (IOException ex) {
        }
    }

    private static void exportarBHD(Empleado empleado) {
        try (FileWriter writer = new FileWriter("empleados_bhd.json")) {
            String data = String.format("{\"tipoCuenta\":\"%s\",\"nombre\":\"%s\",\"referencia\":\"%s\",\"monto\":%.2f,\"concepto\":\"NOMINA\"}",
                    empleado.getBanco(),
                    empleado.getNombre(),
                    empleado.getCedula(),
                    empleado.getSalarioNeto()
            );
            writer.write(data);
        } catch (IOException ex) {
        }
    }
}
