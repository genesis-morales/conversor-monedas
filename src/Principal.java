import java.math.BigDecimal;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        Consola consola = new Consola();

        String opcion;

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

            opcion = scanner.next();

            if (opcion == null) {
                System.out.println("Debe elegir una opción");
                return;
            }
            for (char c : opcion.toCharArray()) {
                if (!Character.isDigit(c)) {
                    System.out.println(" Error: Debe ingresar solo números.");
                    return; // vuelve al menú
                }
            }

            switch (opcion) {
                case "1": consola.convertir(consultaMoneda, scanner, "ARS", "Peso argentino");
                    break;

                case "2": consola.convertir(consultaMoneda, scanner, "BOB", "Boliviano ");
                    break;

                case "3": consola.convertir(consultaMoneda, scanner, "BRL", "Real brasileño");
                    break;

                case "4": consola.convertir(consultaMoneda, scanner, "CLP", "Peso chileno");
                    break;

                case "5": consola.convertir(consultaMoneda, scanner, "COP", "Peso colombiano");
                    break;

                case "6": consola.convertir(consultaMoneda, scanner, "USD", "Dólar estadounidense");
                    break;

                case "7": System.out.println("Hasta pronto....");
                    break;

                default: System.out.println("Opción incorrecta.");
            }
        } while (!opcion.equals("7"));
    }
}
