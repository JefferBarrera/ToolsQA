
## Estrategia de Pruebas

La estrategia de pruebas adoptada para la validación del formulario de registro de estudiantes se basa en técnicas de 
diseño de pruebas funcionales orientadas a criterios de caja negra. Estas técnicas permitieron asegurar la cobertura de 
caminos críticos, condiciones de entrada válidas e inválidas, y combinaciones de datos. 
A continuación, se detalla cómo se aplicaron las principales técnicas en el diseño de los escenarios automatizados:

### 1. Partición de equivalencia
Se identificaron clases de equivalencia para datos válidos e inválidos. Por ejemplo:
- Para el campo de **correo electrónico**, se probaron entradas válidas en un caso exitoso y entradas inválidas (como `juan.perez.com`, `@`, `test@.com`) en escenarios negativos.
- Para el **teléfono móvil**, se probaron valores alfabéticos y numéricos inválidos (`abc123`, `12345`, `ABCDEFGHIJ`) como clases de equivalencia no válidas.

### 2. Valores Límite
Aunque el formulario no requería validaciones numéricas con límites específicos (como edades o montos), los valores extremos y vacíos se simularon en campos como:
- **Nombre y Apellido en blanco** para validar mensajes de error.
- Omisión de selección en campos tipo **radio** como "Género".

### 3. Combinación de Datos
Se empleó un **Scenario Outline** para probar combinaciones válidas en campos dependientes como:
- Género, hobbies, estado y ciudad (TC06), lo cual permitió validar el comportamiento con diferentes perfiles de usuario.

### 4. Pruebas Positivas y Negativas
- Las pruebas **positivas** (como en TC01, TC06 y TC07) aseguran que el sistema responde correctamente ante datos completos y válidos.
- Las pruebas **negativas** (como TC02 a TC05) validan que el sistema identifica y rechaza entradas inválidas, mostrando advertencias o errores apropiados.

### 5. Fuente de Datos Externa
En el escenario **TC07**, se integró una técnica de generación de datos desde una API, con el fin de simular datos dinámicos, aumentar la variabilidad y validar la robustez del sistema frente a entradas generadas externamente.

### 6. Cobertura de Reglas de Negocio
Cada escenario está alineado con una regla de negocio relevante para el formulario, como:
- Campos obligatorios requeridos.
- Validación de formato de email y teléfono.
- Dependencias entre campos (estado-ciudad).
- Visualización del mensaje de confirmación tras un envío exitoso.
