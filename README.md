# 💰 Conversor de Moneda Tico-Costarricense (CRC) 

Este proyecto es un **conversor de moneda** desarrollado en **Java**, utilizando la API pública de ExchangeRate-API para obtener tipos de cambio en tiempo real.  
Permite convertir montos desde **colones costarricenses (CRC)** hacia diferentes monedas internacionales.

---

## 🚀 Funcionalidades

- Conversión desde **CRC → ARS, BOB, BRL, CLP, COP, USD**
- Conexión HTTP mediante **HttpClient** y **HttpRequest**
- Procesamiento de respuestas JSON con **Gson**
- Validación de entrada de datos (solo números)
- Visualización de la fecha y hora de la consulta
- Menú interactivo
- Código estructurado con clases separadas

---

## 📦 Tecnologías utilizadas

- **Java 17+**
- **HttpClient / HttpRequest**
- **Gson** para parseo JSON
- **ExchangeRate API**
- **BigDecimal** para precisión en cálculos monetarios

---

## 🔗 API utilizada

Se utiliza la API pública: https://www.exchangerate-api.com/

Endpoint consultado: https://v6.exchangerate-api.com/v6/TU_API_KEY/latest/CRC


---

## 📁 Estructura del proyecto

```text
src/
 ├── Principal.java
 ├── ConsultaMoneda.java
 ├── Moneda.java          (record con tasa de conversión)
 └── Historial.java   (opcional, si se usa historial)
