### TC01 - Registro completo con datos válidos

**Precondición:** El usuario accede al formulario de registro

**Pasos:**
1. Ingresar nombre válido
2. Ingresar apellido válido
3. Ingresar email válido
4. Ingresar teléfono válido
5. Seleccionar género
6. Seleccionar al menos un hobby
7. Seleccionar país, estado y ciudad válidos
8. Hacer clic en el botón 'Enviar'

**Datos de entrada:** Datos válidos y aleatorios generados dinámicamente

**Resultado esperado:** Se muestra un mensaje de éxito junto con los datos ingresados

---

### TC02 - Validar error al dejar nombre y apellido en blanco

**Precondición:** El usuario accede al formulario de registro

**Pasos:**
1. Dejar en blanco los campos 'Nombre' y 'Apellido'
2. Rellenar los demás campos obligatorios con datos válidos
3. Hacer clic en el botón 'Enviar'

**Datos de entrada:** Campos 'Nombre' y 'Apellido' vacíos; los demás con datos válidos

**Resultado esperado:** Iconos de advertencia visibles en los campos 'Nombre' y 'Apellido' indicando que son requeridos

---

### TC03 - Validar error con email inválido

**Precondición:** El usuario accede al formulario de registro

**Pasos:**
1. Ingresar datos válidos en todos los campos excepto el email
2. Ingresar email inválido (<email>)
3. Hacer clic en 'Enviar'

**Datos de entrada:** Emails inválidos: juan.perez.com, @, test@.com

**Resultado esperado:** Se muestra advertencia en el campo email indicando formato inválido

---

### TC04 - Validar error con teléfono móvil inválido

**Precondición:** El usuario accede al formulario de registro

**Pasos:**
1. Ingresar datos válidos en todos los campos excepto el teléfono
2. Ingresar número inválido en el campo teléfono (<telefono>)
3. Hacer clic en 'Enviar'

**Datos de entrada:** Teléfonos inválidos: abc123, 12345, ABCDEFGHIJ

**Resultado esperado:** Se muestra advertencia en el campo de teléfono

---

### TC05 - Validar error al no seleccionar género

**Precondición:** El usuario accede al formulario de registro

**Pasos:**
1. Completar todos los campos obligatorios excepto el género
2. Hacer clic en 'Enviar'

**Datos de entrada:** Todos los campos válidos excepto género no seleccionado

**Resultado esperado:** Advertencia visible indicando que se debe seleccionar un género

---

### TC06 - Registro válido con combinaciones de género, hobbies y ciudad

**Precondición:** El usuario accede al formulario de registro

**Pasos:**
1. Completar los campos obligatorios
2. Seleccionar la combinación de género, hobby, estado y ciudad correspondiente
3. Hacer clic en 'Enviar'

**Datos de entrada:**
- Male, Reading, NCR, Delhi
- Female, Sports, Uttar Pradesh, Lucknow
- Other, Music, Haryana, Karnal

**Resultado esperado:** Se muestra mensaje de éxito con los datos ingresados

---

### TC07 - Registro completo con datos válidos desde la API

**Precondición:** El usuario accede al formulario de registro

**Pasos:**
1. Generar datos válidos mediante una API
2. Completar el formulario usando los datos obtenidos
3. Hacer clic en 'Enviar'

**Datos de entrada:** Datos obtenidos dinámicamente desde API o librería como Java Faker

**Resultado esperado:** Se muestra mensaje de envío exitoso junto con los datos obtenidos desde la API

---