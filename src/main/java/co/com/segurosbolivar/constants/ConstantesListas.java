package co.com.segurosbolivar.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstantesListas {

    public static final List<String> GENEROS = List.of("Male", "Female", "Other");
    public static final List<String> HOBBIES = List.of("Sports", "Reading", "Music");
    public static final List<String> ESTADOS = List.of("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public static final List<String> CIUDADES_NCR = List.of("Delhi", "Gurgaon", "Noida");
    public static final List<String> CIUDADES_UP = List.of("Agra", "Lucknow", "Merrut");
    public static final List<String> CIUDADES_HARYANA = List.of("Karnal", "Panipat");
    public static final List<String> CIUDADES_RAJS = List.of("Jaipur", "Jaiselmer");
    public static final List<String> MATERIAS = List.of("Maths", "English", "Physics", "Chemistry", "Biology",
            "Computer Science", "History", "Economics");

}
