import java.math.BigDecimal;
import java.util.Scanner;

public class Consola {

    public static void convertir(ConsultaMoneda consulta, Scanner scanner, String codigo, String nombre) {
        System.out.println("-------------------------------");
        System.out.println("CRC => " + codigo + " - " + nombre);
        System.out.println("Ingrese el monto a convertir: ");

        String input = scanner.next();

        // --- VALIDACIÓN ---
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                System.out.println(" Error: Debe ingresar solo números.");
                return; // vuelve al menú
            }
        }

        BigDecimal monto = new BigDecimal(input);
        BigDecimal resultado = consulta.convertirCRC(codigo, monto);
        System.out.println("Resultado: " + resultado + " " + codigo);
    }
}
