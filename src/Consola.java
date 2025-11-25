import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Consola {

    public static void convertir(ConsultaMoneda consulta, Scanner scanner, LocalDateTime dateTime, List<Historial> historial, String codigo, String nombre) {
        boolean repetir = true;

        while (repetir) {
            System.out.println("-------------------------------");
            System.out.println("CRC => " + codigo + " - " + nombre);
            System.out.println("Ingrese el monto a convertir: ");

            String input = scanner.next();

            if (!input.matches("\\d+(\\.\\d+)?")) {
                System.out.println("Error: Debe ingresar un número válido.");
                continue;
            }

            BigDecimal monto = new BigDecimal(input);
            BigDecimal resultado = consulta.convertirCRC(codigo, monto);

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String fecha = dateTime.format(formato);

            System.out.println("Resultado: " + resultado + " " + codigo);
            System.out.println("Tipo de cambio consultado el: " + fecha);

            Historial item = new Historial(codigo, monto, resultado, dateTime);
            historial.add(item);


            System.out.println("-------------------------------");
            System.out.println("Desea hacer una nueva conversion de moneda en " + nombre + "? 1. Si | 2. No");

            String opcion = scanner.next();

            for (char c : opcion.toCharArray()) {
                if (!Character.isDigit(c)) {
                    System.out.println(" Error: Debe ingresar solo números.");
                    return;
                }
            }

            if (!opcion.equals("1")) {
                repetir = false;
            }

        }
    }
}
