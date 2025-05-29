package co.com.segurosbolivar.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PracticeFormUI extends PageObject {

    public static final Target TXT_FIRST_NAME = Target.the("caja de texto primer nombre")
            .located(By.id("firstName"));
    public static final Target TXT_LAST_NAME = Target.the("caja de texto apellido")
            .located(By.id("lastName"));
    public static final Target TXT_EMAIL = Target.the("caja de texto email")
            .located(By.id("userEmail"));
    public static final Target TXT_PHONE = Target.the("caja de texto telefono")
            .located(By.id("userNumber"));
    public static final Target TXT_DATE_OF_BIRTH = Target.the("caja de texto fecha de nacimiento")
            .located(By.id("dateOfBirthInput"));
    public static final Target SELECT_MONTH = Target.the("selector de mes")
            .located(By.className("react-datepicker__month-select"));
    public static final Target SELECT_YEAR = Target.the("selector de año")
            .located(By.className("react-datepicker__year-select"));
    public static final Target LBL_DAY = Target.the("etiqueta de dia")
            .locatedBy("//div[contains(@class, 'react-datepicker__day--0%s') and not(contains(@class, 'react-datepicker__day--outside-month'))]");
    public static final Target RDB_GENDER = Target.the("radio button genero")
            .locatedBy("//div[input[(contains(@id, 'gender-radio'))]]/label[text()='%s']");
    public static final Target LBL_GENDER = Target.the("label genero")
            .locatedBy("//div[input[(contains(@id, 'gender-radio'))]]/label[text()='Male']");
    public static final Target TXT_SUBJECTS = Target.the("caja de texto para seleccionar materias")
            .located(By.id("subjectsInput"));
    public static final Target LST_SUBJECTS = Target.the("lista desplegable de materias")
            .located(By.id("react-select-2-option-0"));
    public static final Target CHK_HOBBIES = Target.the("checkbox hobbies")
            .locatedBy("//div[input[(contains(@id, 'hobbies-checkbox'))]]/label[text()='%s']");
    public static final Target BTN_UPLOAD_IMAGE = Target.the("boton para subir imagen")
            .located(By.id("uploadPicture"));
    public static final Target TXT_ADDRESS = Target.the("caja de texto direccion")
            .located(By.id("currentAddress"));
    public static final Target LST_STATE = Target.the("lista desplegable de estado")
            .located(By.id("state"));
    public static final Target LBL_STATE = Target.the("etiqueta de estado")
            .locatedBy("//div[contains(@id, 'react-select-3-option') and text()='%s']");
    public static final Target LST_CITY = Target.the("lista desplegable de ciudad")
            .located(By.id("city"));
    public static final Target LBL_CITY = Target.the("etiqueta de ciudad")
            .locatedBy("//div[contains(@id, 'react-select-4-option') and text()='%s']");
    public static final Target BTN_SUBMIT = Target.the("boton de enviar formulario")
            .located(By.id("submit"));
    public static final Target TXT_CONFIRMATION_MESSAGE = Target.the("mensaje de confirmacion")
            .located(By.id("example-modal-sizes-title-lg"));

}
