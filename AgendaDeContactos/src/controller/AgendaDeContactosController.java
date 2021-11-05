package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import application.AgendaDeContactos;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Persona;

public class AgendaDeContactosController {
	@FXML
	private TableView<Persona> tableView;
	@FXML
	private TableColumn<Persona, String> tcNombre;
	@FXML
	private TableColumn<Persona, String> tcApellido;

	@FXML
	private Label lNombre;

	@FXML
	private Label lApellido;

	@FXML
	private Label lCalle;

	@FXML
	private Label lCiudad;

	@FXML
	private Label lCodigoPostal;

	@FXML
	private Label lCumpleaños;

	@FXML
	private Label lTelefono;

	@FXML
	private Button botonBorrar;

	@FXML
	private Button botonEditar;

	@FXML
	private Button botonNuevo;


	@FXML
	private void initialize() {
		// columnas
		tcNombre.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		tcApellido.setCellValueFactory(new PropertyValueFactory<>("lastName"));

		// para ver la persona creada en tableview----y creacion de la persona
		tableView.getItems().add(new Persona("John", "Judi", "sdfa", "vvvv", 0, LocalDate.of(2010, 2, 2), 0));
		tableView.getItems().add(new Persona("Jane", "Saenz", "sfa", "vv", 5, LocalDate.of(2010, 4, 2), 45));
		tableView.getItems().add(new Persona("Pepe", "ASD", "fff", "sss", 2, LocalDate.of(2010, 3, 2), 10));
		tableView.getItems().add(new Persona("Hola", "ola", "as", "ssss", 4, LocalDate.of(2010, 2, 2), 0));

		mostrarDatosDerecho(null);

		//para ver lado derecho
		tableView.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> mostrarDatosDerecho(newValue));

		//para seleccionar bloque
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	//metodo para ver los datos en el lado derecho
	private void mostrarDatosDerecho(Persona persona) {
		if (persona != null) {
			lNombre.setText(persona.getFirstName());
			lApellido.setText(persona.getLastName());
			lCalle.setText(persona.getStreet());
			lCiudad.setText(persona.getCity());
			lCodigoPostal.setText(Integer.toString(persona.getPostalCode()));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
			String formattedString = persona.getBirthday().format(formatter);
			lCumpleaños.setText(formattedString);
			lTelefono.setText(Integer.toString(persona.getPhone()));

		} else {
			lNombre.setText("");
			lApellido.setText("");
			lCalle.setText("");
			lCiudad.setText("");
			lCodigoPostal.setText("");
			lCumpleaños.setText("");
			lTelefono.setText("");
		}
	}

	//funcionamiento para borrar por bloques e individual
	@FXML
	private void borrar() {
		ObservableList<Persona> selectedIndex = tableView.getSelectionModel().getSelectedItems();
		tableView.getItems().removeAll(selectedIndex);
	}

	@FXML
	private void crear() {

	}

	@FXML
	private void editar() {

	}

}
