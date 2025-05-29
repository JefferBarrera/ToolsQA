#language: es
Característica: Formulario de registro de usuarios

    Como analista de automatizacion de pruebas
    Quiero probar el formulario de registro de estudiantes de la aplicacion
    Para validar la calidad de la aplicacion

    Antecedentes:
        Dado que el usuario ingreso al formulario de registro

    @TC05
    Escenario: Validar error al no seleccionar el genero
        Cuando completa todos los campos obligatorios excepto el genero
        Entonces debe mostrarse el icono de advertencia indicando que el genero es requerido

    @TC06
    Esquema del escenario: Registro válido con combinaciones de género, hobbies y ciudad
        Cuando completa todos los campos obligatorios con genero "<genero>", hobby "<hobby>", estado "<estado>" y ciudad "<ciudad>"
        Entonces deberia mostrarse el mensaje de envio exitoso junto con los datos ingresados
        Ejemplos:
            | genero | hobby   | estado        | ciudad  |
            | Male   | Reading | NCR           | Delhi   |
            | Female | Sports  | Uttar Pradesh | Lucknow |
            | Other  | Music   | Haryana       | Karnal  |

    @TC07
    Escenario: Registro completo con datos validos desde la API
        Cuando diligencia el formulario con datos validos desde la API
        Entonces deberia mostrarse el mensaje de envio exitoso junto con los datos ingresados