package co.com.segurosbolivar.utils;

import co.com.segurosbolivar.models.UsuarioPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import static co.com.segurosbolivar.constants.Constantes.*;
import static co.com.segurosbolivar.constants.ConstantesListas.*;
import static co.com.segurosbolivar.constants.ConstantesRutas.PATH_API;
import static co.com.segurosbolivar.constants.ConstantesRutas.PATH_IMAGEN;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GeneradorUsuarios {

    private static final Faker faker = new Faker();

    public static UsuarioPojo datosAleatorios() {

        UsuarioPojo usuario = new UsuarioPojo();
        String estado = obtenerAleatorio(ESTADOS);
        String ciudad = obtenerCiudadPorEstado(estado);
        SimpleDateFormat formato = new SimpleDateFormat(PATRON_FECHA, Locale.ENGLISH);
        String fecha = formato.format(faker.date().birthday(EDAD_MINIMA, EDAD_MAXIMA));

        usuario.setNombre(faker.name().firstName());
        usuario.setApellido(faker.name().lastName());
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setGenero(obtenerAleatorio(GENEROS));
        usuario.setTelefono(faker.number().digits(10));
        usuario.setFechaNacimiento(fecha);
        usuario.setMaterias(obtenerAleatorio(MATERIAS));
        usuario.setHobby(obtenerAleatorio(HOBBIES));
        usuario.setImagen(PATH_IMAGEN);
        usuario.setDireccion(faker.address().fullAddress());
        usuario.setEstado(estado);
        usuario.setCiudad(ciudad);

        return usuario;
    }

    public static UsuarioPojo sinNombreYApellido() {
        UsuarioPojo usuario = datosAleatorios();
        usuario.setNombre("");
        usuario.setApellido("");
        return usuario;
    }

    public static UsuarioPojo conEmailInvalido(String emailInvalido) {
        UsuarioPojo usuario = datosAleatorios();
        usuario.setEmail(emailInvalido);
        return usuario;
    }

    public static UsuarioPojo conTelefonoInvalido(String telefonoInvalido) {
        UsuarioPojo usuario = datosAleatorios();
        usuario.setTelefono(telefonoInvalido);
        return usuario;
    }

    public static UsuarioPojo sinGenero() {
        UsuarioPojo usuario = datosAleatorios();
        usuario.setGenero("");
        return usuario;
    }

    public static UsuarioPojo conDatosCombinados(String genero, String hobby, String estado, String ciudad) {
        UsuarioPojo usuario = datosAleatorios();
        usuario.setGenero(genero);
        usuario.setHobby(hobby);
        usuario.setEstado(estado);
        usuario.setCiudad(ciudad);
        return usuario;
    }

    private static String obtenerAleatorio(List<String> lista) {
        return lista.get(ThreadLocalRandom.current().nextInt(lista.size()));
    }

    private static String obtenerCiudadPorEstado(String estado) {
        return switch (estado) {
            case "NCR" -> obtenerAleatorio(CIUDADES_NCR);
            case "Uttar Pradesh" -> obtenerAleatorio(CIUDADES_UP);
            case "Haryana" -> obtenerAleatorio(CIUDADES_HARYANA);
            case "Rajasthan" -> obtenerAleatorio(CIUDADES_RAJS);
            default -> throw new IllegalArgumentException(ESTADO_NO_RECONOCIDO + estado);
        };
    }

    @SneakyThrows
    public static UsuarioPojo datosDesdeAPI() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(Paths.get(PATH_API).toFile(), UsuarioPojo.class);

    }
}
