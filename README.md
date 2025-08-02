# Conversor de Divisas en Java

## Descripción

Conversor de Divisas es una aplicación de consola desarrollada en Java que permite realizar conversiones precisas y actualizadas entre diferentes monedas: dólares estadounidenses (USD), pesos argentinos (ARS), reales brasileños (BRL) y pesos colombianos (COP). 

El proyecto integra una API externa para obtener las tasas de cambio en tiempo real, garantizando que las conversiones reflejen las condiciones del mercado actual. Esta solución es ideal para usuarios que buscan una herramienta sencilla pero eficaz para manejar múltiples divisas sin necesidad de interfaces gráficas complejas.

---

## Características Principales

- **Integración en tiempo real** con ExchangeRate-API para obtener tasas de cambio actualizadas.
- **Soporte bidireccional** para conversiones entre USD, ARS, BRL y COP.
- **Interfaz intuitiva basada en consola**, con menú claro y validación de entradas para evitar errores.
- **Manejo de excepciones robusto**, que asegura la estabilidad de la aplicación ante fallos en la conexión o entradas inválidas.
- **Diseño modular y limpio**, que facilita futuras extensiones o integración en proyectos más complejos.

---

## Tecnologías y Herramientas Utilizadas

- **Java 17+**: Lenguaje principal de desarrollo.
- **Gson**: Librería de Google para el manejo de JSON y deserialización de respuestas API.
- **ExchangeRate-API**: Servicio público que provee tasas de cambio actualizadas para múltiples divisas.
- **Git & GitHub**: Control de versiones y hospedaje remoto del código fuente.

---

## Instrucciones de Uso

### Clonación y preparación del entorno

```bash
git clone https://github.com/AlanSAndovalLoZA/conversor-divisas.git
cd conversor-divisas/src
