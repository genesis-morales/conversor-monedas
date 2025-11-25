import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Historial {
    private String monedaDestino;
    private BigDecimal monto;
    private BigDecimal resultado;
    private LocalDateTime fecha;

    public Historial(String monedaDestino, BigDecimal monto, BigDecimal resultado, LocalDateTime fecha) {
        this.monedaDestino = monedaDestino;
        this.monto = monto;
        this.resultado = resultado;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "CRC => " + monedaDestino +
                " | Monto: " + monto +
                " | Resultado: " + resultado +
                " | Fecha: " + fecha.format(formato);
    }
}
