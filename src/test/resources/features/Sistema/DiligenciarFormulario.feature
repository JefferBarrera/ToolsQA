#language: es
Característica: Formulario de registro de usuarios

    Como analista de automatizacion de pruebas
    Quiero probar el formulario de registro de estudiantes de la aplicacion
    Para validar la calidad de la aplicacion

    Antecedentes:
        Dado que el usuario ingreso al formulario de registro

    @TC01
    Escenario: Registro completo con datos validos
        Cuando diligencia el formulario con datos validos
        Entonces deberia mostrarse el mensaje de envio exitoso junto con los datos ingresados

    @TC02
    Escenario: Validar error al dejar nombre y apellido en blanco
        Cuando diligencia solo los campos obligatorios dejando nombre y apellido en blanco
        Entonces debe mostrarse el icono de advertencia indicando que el nombre y apellido son requeridos

    @TC03
    Esquema del escenario: Validar error al ingresar diferentes combinaciones de email invalido
        Cuando diligencia todos los campos con datos aleatorios excepto el email "<email>"
        Entonces debe mostrarse el icono de advertencia indicando que el email es invalido
        Ejemplos:
            | email          |
            | juan.perez.com |
            | @              |
            | test@.com      |

    @TC04
    Esquema del escenario: Validar error al ingresar telefono movil invalido
        Cuando diligencia todos los campos con datos aleatorios excepto el telefono "<telefono>"
        Entonces debe mostrarse el icono de advertencia indicando que el telefono movil es invalido
        Ejemplos:
            | telefono   |
            | abc123     |
            | 12345      |
            | ABCDEFGHIJ |
