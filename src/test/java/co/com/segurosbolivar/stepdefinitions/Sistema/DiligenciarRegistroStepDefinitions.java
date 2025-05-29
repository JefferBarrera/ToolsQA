package co.com.segurosbolivar.stepdefinitions.Sistema;

import co.com.segurosbolivar.questions.ColorLabel;
import co.com.segurosbolivar.questions.EsInvalido;
import co.com.segurosbolivar.questions.TextoModal;
import co.com.segurosbolivar.tasks.DiligenciarRegistroTask;
import co.com.segurosbolivar.tasks.Navegar;
import co.com.segurosbolivar.utils.GeneradorUsuarios;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.segurosbolivar.constants.ConstantesRutas.URL_QA;
import static co.com.segurosbolivar.constants.ConstantesValidaciones.COLOR_ADVERTENCIA;
import static co.com.segurosbolivar.constants.ConstantesValidaciones.MENSAJE_ENVIO_EXITOSO;
import static co.com.segurosbolivar.userinterfaces.PracticeFormUI.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class DiligenciarRegistroStepDefinitions {

    @Dado("que el usuario ingreso al formulario de registro")
    public void queElUsuarioIngresoAlFormularioDeRegistro() {
        theActorInTheSpotlight().wasAbleTo(
                Navegar.en(URL_QA)
        );
    }

    @Cuando("diligencia el formulario con datos validos")
    public void diligenciaElFormularioConDatosValidos() {
        theActorInTheSpotlight().attemptsTo(
                DiligenciarRegistroTask.conUsuario(GeneradorUsuarios.datosAleatorios())
        );
    }

    @Entonces("deberia mostrarse el mensaje de envio exitoso junto con los datos ingresados")
    public void deberiaMostrarseElMensajeDeEnvioExitosoJuntoConLosDatosIngresados() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(TextoModal.es()).contains(MENSAJE_ENVIO_EXITOSO)
        );
    }

    @Cuando("diligencia solo los campos obligatorios dejando nombre y apellido en blanco")
    public void diligenciaSoloLosCamposObligatoriosDejandoNombreYApellidoEnBlanco() {
        theActorInTheSpotlight().attemptsTo(
                DiligenciarRegistroTask.conUsuario(GeneradorUsuarios.sinNombreYApellido())
        );
    }

    @Entonces("debe mostrarse el icono de advertencia indicando que el nombre y apellido son requeridos")
    public void debeMostrarseElIconoDeAdvertenciaIndicandoQueElNombreYApellidoSonRequeridos() {
        theActorInTheSpotlight().should(
                seeThat(EsInvalido.elCampo(TXT_FIRST_NAME), equalTo(true)),
                seeThat(EsInvalido.elCampo(TXT_LAST_NAME), equalTo(true))
        );
    }

    @Cuando("diligencia todos los campos con datos aleatorios excepto el email {string}")
    public void diligenciaTodosLosCamposConDatosAleatoriosExceptoElEmail(String emailInvalido) {
        theActorInTheSpotlight().attemptsTo(
                DiligenciarRegistroTask.conUsuario(GeneradorUsuarios.conEmailInvalido(emailInvalido))
        );
    }

    @Entonces("debe mostrarse el icono de advertencia indicando que el email es invalido")
    public void debeMostrarseElIconoDeAdvertenciaIndicandoQueElEmailEsInvalido() {
        theActorInTheSpotlight().should(
                seeThat(EsInvalido.elCampo(TXT_EMAIL), equalTo(true))
        );
    }

    @Cuando("diligencia todos los campos con datos aleatorios excepto el telefono {string}")
    public void diligenciaTodosLosCamposConDatosAleatoriosExceptoElTelefono(String telefonoInvalido) {
        theActorInTheSpotlight().attemptsTo(
                DiligenciarRegistroTask.conUsuario(GeneradorUsuarios.conTelefonoInvalido(telefonoInvalido))
        );
    }

    @Entonces("debe mostrarse el icono de advertencia indicando que el telefono movil es invalido")
    public void debeMostrarseElIconoDeAdvertenciaIndicandoQueElTelefonoMovilEsInvalido() {
        theActorInTheSpotlight().should(
                seeThat(EsInvalido.elCampo(TXT_PHONE), equalTo(true))
        );
    }

    @Cuando("completa todos los campos obligatorios excepto el genero")
    public void completaTodosLosCamposObligatoriosExceptoElGenero() {
        theActorInTheSpotlight().attemptsTo(
                DiligenciarRegistroTask.conUsuario(GeneradorUsuarios.sinGenero())
        );
    }

    @Entonces("debe mostrarse el icono de advertencia indicando que el genero es requerido")
    public void debeMostrarseElIconoDeAdvertenciaIndicandoQueElGeneroEsRequerido() {
        theActorInTheSpotlight().should(
                seeThat(ColorLabel.delElemento(LBL_GENDER), equalTo(COLOR_ADVERTENCIA))
        );
    }

    @Cuando("completa todos los campos obligatorios con genero {string}, hobby {string}, estado {string} y ciudad {string}")
    public void completaTodosLosCamposObligatoriosConGeneroHobbyEstadoYCiudad(String genero, String hobby, String estado, String ciudad) {
        theActorInTheSpotlight().attemptsTo(
                DiligenciarRegistroTask.conUsuario(GeneradorUsuarios.conDatosCombinados(genero, hobby, estado, ciudad))
        );
    }

    @Cuando("diligencia el formulario con datos validos desde la API")
    public void diligenciaElFormularioConDatosValidosDesdeLaAPI() {
        theActorInTheSpotlight().attemptsTo(
                DiligenciarRegistroTask.conUsuario(GeneradorUsuarios.datosDesdeAPI())
        );

    }

}
