
# Conversor de Moneda

Este es un simple conversor de moneda desarrollado en Java que utiliza la API de ExchangeRate-API para obtener las tasas de cambio en tiempo real.

## Monedas Soportadas

- USD: United States Dollar
- ARS: Argentine Peso
- BRL: Brazilian Real
- COP: Colombian Peso
- CLP: Chilean Peso

## Funcionalidades

- Actualización automática de las tasas de cambio al iniciar la aplicación.
- Conversión entre diferentes monedas.
- Mostrar la tasa de cambio del par de monedas seleccionado.
- Respuesta con las cantidades convertidas y las tasas de cambio.

## Requisitos

- Java 8 o superior.
- Dependencias: Gson (para manejar JSON).

## Uso

1. Clona el repositorio.
2. Abre el proyecto en tu IDE preferido (se recomienda IntelliJ IDEA).
3. Antes de ejecutar la aplicación, necesitas obtener una clave de API gratuita en [ExchangeRate-API](https://www.exchangerate-api.com/). Reemplaza la variable `API_KEY` en la clase `CurrencyConverter` con tu propia clave de API.

```java
private static final String API_KEY = "TU_API_KEY";
```

4. Ejecuta la aplicación desde la clase `Main`.

## Ejemplo de Uso

Al ejecutar la aplicación, verás un menú con las opciones disponibles para la conversión de moneda. Por ejemplo, si deseas convertir 100 USD a ARS, selecciona la opción correspondiente en el menú e ingresa la cantidad a convertir. La aplicación mostrará la cantidad equivalente en ARS y la tasa de cambio utilizada.

## Contribución

Si quieres contribuir a este proyecto, ¡no dudes en enviar un pull request!

## Autor

[Autor del proyecto](https://github.com/yrdnoel)
