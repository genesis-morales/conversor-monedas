import java.math.BigDecimal;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        int opcion;
        BigDecimal monto;

        do {
            System.out.println("""
                    
                    *****************************************************
                    Bienvenido al Conversor de Moneda Tico-Costarricense! 
                    *****************************************************
                
                        1. CRC => ARS - Peso argentino 
                        2. CRC => BOB - Boliviano  
                        3. CRC => BRL - Real brasileño
                        4. CRC => CLP - Peso chileno 
                        5. CRC => COP - Peso colombiano  
                        6. CRC => USD - Dólar estadounidense 
                        7. SALIR
                        
                   Digite el numero de coversión que desea hacer: """);

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1: convertir(consultaMoneda, scanner, "ARS", "Peso argentino");
                    break;

                case 2: convertir(consultaMoneda, scanner, "BOB", "Boliviano ");
                    break;

                case 3: convertir(consultaMoneda, scanner, "BRL", "Real brasileño");
                    break;

                case 4: convertir(consultaMoneda, scanner, "CLP", "Peso chileno");
                    break;

                case 5: convertir(consultaMoneda, scanner, "COP", "Peso colombiano");
                    break;

                case 6: convertir(consultaMoneda, scanner, "USD", "Dólar estadounidense");
                    break;

                case 7: System.out.println("Hasta pronto....");
                    break;

                default: System.out.println("Opción incorrecta.");
            }
        } while (opcion != 7);
    }

    private static void convertir(ConsultaMoneda consulta, Scanner scanner, String codigo, String nombre) {
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
