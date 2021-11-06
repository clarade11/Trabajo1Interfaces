package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Persona;

public class AgendaDeContactosNuevoController {

	@FXML
	private Button botonAnadir;
	@FXML
	private Button botonCancelar;
	@FXML
	private TextField tfNombre;
	@FXML
	private TextField tfApellido;
	@FXML
	private TextField tfCalle;
	@FXML
	private TextField tfCiudad;
	@FXML
	private TextField tfCodigoPostal;
	@FXML
	private TextField tfFecha;
	@FXML
	private TextField tfTelefono;

	@FXML
	private void initialize() {
		if (AgendaDeContactosController.mod) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			Persona personaNueva = AgendaDeContactosController.personas.get(AgendaDeContactosController.posicionPersonaEnTabla);
			tfNombre.setText(personaNueva.getFirstName());
			tfApellido.setText(personaNueva.getLastName());
			tfCalle.setText(personaNueva.getStreet());
			tfCiudad.setText(personaNueva.getCity());
			tfCodigoPostal.setText(String.valueOf(personaNueva.getPostalCode()));
			tfFecha.setText(personaNueva.getBirthday().format(formatter));
			tfTelefono.setText(String.valueOf(personaNueva.getPhone()));
		}
	}
	
	// boton añadir
	@FXML
	public void volver() throws IOException {

		Persona personaNueva = new Persona();
		personaNueva.setFirstName(tfNombre.getText());
		personaNueva.setLastName(tfApellido.getText());
		personaNueva.setStreet(tfCalle.getText());
		personaNueva.setCity(tfCiudad.getText());
		personaNueva.setPostalCode(Integer.parseInt(tfCodigoPostal.getText()));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		personaNueva.setBirthday(LocalDate.parse(tfFecha.getText(), formatter));
		personaNueva.setPhone(Integer.parseInt(tfCodigoPostal.getText()));
		if (AgendaDeContactosController.mod) {
			AgendaDeContactosController.personas.set(AgendaDeContactosController.posicionPersonaEnTabla, personaNueva);
		} else  {
			AgendaDeContactosController.personas.add(personaNueva);
		}

		Stage stage = (Stage) this.botonAnadir.getScene().getWindow();
		stage.close();

	}

	@FXML
	private void cancelar(ActionEvent e) {
		Stage stage = (Stage) this.botonCancelar.getScene().getWindow();
		stage.close();
	}

}
