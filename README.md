# Conversor de Monedas

Este es un conversor de monedas simple desarrollado en Java para el Challenge de Alura LATAM. Permite a los usuarios convertir entre dólares estadounidenses (USD), pesos argentinos (ARS), reales brasileños (BRL) y pesos colombianos (COP). Utiliza la API de ExchangeRate para obtener tasas de cambio en tiempo real.

## Características

- Conversión entre diferentes monedas:
    - Dólares a pesos argentinos
    - Pesos argentinos a dólares
    - Dólares a reales brasileños
    - Reales brasileños a dólares
    - Dólares a pesos colombianos
    - Pesos colombianos a dólares
- Interfaz de usuario de consola
- Acceso a tasas de cambio en tiempo real a través de una API

## Requisitos

- Java 11 o superior
- IntelliJ IDEA (u otro IDE compatible)
- Dependencia de Gson 2.10.1 o superior
- API Key de [ExchangeRate-API](https://www.exchangerate-api.com/) para acceder a las tasas de cambio

## Instalación

1. Clona el repositorio o descarga el proyecto.
2. Abre el proyecto en IntelliJ IDEA.
3. Asegúrate de tener la dependencia de Gson configurada en tu archivo `pom.xml`:

   ```xml
   <dependency>
       <groupId>com.google.code.gson</groupId>
       <artifactId>gson</artifactId>
       <version>2.10.1</version>
   </dependency>

