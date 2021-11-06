package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
	private Button botonActualizar;

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

		// para ver lado derecho
		tableView.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> mostrarDatosDerecho(newValue));

		// para seleccionar bloque
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}

	// metodo para ver los datos en el lado derecho
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

	@FXML 
	private void actualizar() {
		// cogemos los datos
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		String nombre;
		String apellido;
		String calle;
		String ciudad;
		Integer codigoPostal;
		String fechaP;
		Integer telefono;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			File fic = new File("./docs/PersonaParaAnadir.txt");

			BufferedReader fichero = new BufferedReader(new FileReader(fic));

			nombre = fichero.readLine();
			apellido = fichero.readLine();
			calle = fichero.readLine();
			ciudad = fichero.readLine();
			codigoPostal = Integer.parseInt(fichero.readLine());
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			 fechaP = fichero.readLine();
			telefono = Integer.parseInt(fichero.readLine());

			
			tableView.getItems().add(new Persona(nombre, apellido, calle, ciudad, codigoPostal, LocalDate.parse(fechaP, formatter), telefono));
			
			fichero.close();

		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	// ---------------------BOTONES---------------------------

	// funcionamiento para borrar por bloques e individual
	@FXML
	private void borrar() {
		ObservableList<Persona> selectedIndex = tableView.getSelectionModel().getSelectedItems();
		tableView.getItems().removeAll(selectedIndex);
	}

	@FXML
	private void crear(ActionEvent e) throws Exception {
		Stage stage = new Stage();
		BorderPane root = FXMLLoader.load(getClass().getResource("/application/Nuevo.fxml"));
		Scene scene = new Scene(root);
		stage = new Stage(StageStyle.DECORATED);
		stage.setScene(scene);
		stage.show();
		
//		//alerta
//		Alert alert = new Alert(AlertType.CONFIRMATION,"Alerta modal");
//		alert.showAndWait();
//		if(alert.getResult().YES != null) {
//			actualizar();
//		}

	}

	@FXML
	private void editar() {

	}

}
