import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime dateTime = LocalDateTime.now();

        List<Historial> historial = new ArrayList<>();

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
                        7. Ver historial
                        8. SALIR
                        
                   Digite una opción válida: """);

            while (true) {
                opcion = scanner.next();

                // Validaciones
                if (opcion == null || opcion.isEmpty()) {
                    System.out.println("Debe elegir una opción.");
                    continue;
                }

                boolean esNumero = true;
                for (char c : opcion.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        esNumero = false;
                        break;
                    }
                }

                if (!esNumero) {
                    System.out.println(" Error: Debe ingresar solo números. Elija nuevamente una opción válida.");
                    continue; // vuelve al menú
                }
                break;
            }

            switch (opcion) {
                case "1": consola.convertir(consultaMoneda, scanner, dateTime, historial, "ARS", "Peso argentino");
                    break;

                case "2": consola.convertir(consultaMoneda, scanner, dateTime, historial, "BOB", "Boliviano ");
                    break;

                case "3": consola.convertir(consultaMoneda, scanner, dateTime, historial, "BRL", "Real brasileño");
                    break;

                case "4": consola.convertir(consultaMoneda, scanner, dateTime, historial, "CLP", "Peso chileno");
                    break;

                case "5": consola.convertir(consultaMoneda, scanner, dateTime, historial, "COP", "Peso colombiano");
                    break;

                case "6": consola.convertir(consultaMoneda, scanner, dateTime, historial, "USD", "Dólar estadounidense");
                    break;

                case "7":
                    if (historial.isEmpty()) {
                        System.out.println("Aún no hay conversiones registradas.");
                    } else {
                        System.out.println("----- HISTORIAL DE CONVERSIONES -----");
                        for (Historial h : historial) {
                            System.out.println(h);
                        }
                        System.out.println("-------------------------------------");
                    }
                    break;

                case "8": System.out.println("Hasta pronto....");
                    break;

                default: System.out.println("Opción incorrecta.");
            }
        } while (!opcion.equals("7"));
    }
}
