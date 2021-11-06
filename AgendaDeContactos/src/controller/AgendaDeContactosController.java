package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Persona;

public class AgendaDeContactosController {
	public static ObservableList<Persona> personas;
	public static int posicionPersonaEnTabla;
	public static boolean mod=false;
	
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
		personas = FXCollections.observableArrayList();
		
		// para ver la persona creada en tableview----y creacion de la persona
		personas.add(new Persona("John", "Judi", "sdfa", "vvvv", 0, LocalDate.of(2010, 2, 2), 0));
		personas.add(new Persona("Jane", "Saenz", "sfa", "vv", 5, LocalDate.of(2010, 4, 2), 45));
		personas.add(new Persona("Pepe", "ASD", "fff", "sss", 2, LocalDate.of(2010, 3, 2), 10));
		personas.add(new Persona("Hola", "ola", "as", "ssss", 4, LocalDate.of(2010, 2, 2), 0));
		
        tableView.setItems(personas);

		final ObservableList<Persona> tablaPersonaSel = tableView.getSelectionModel().getSelectedItems();
		tablaPersonaSel.addListener(selectorTablaPersonas);

		// para seleccionar bloque
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}

	private final ListChangeListener<Persona> selectorTablaPersonas = new ListChangeListener<Persona>() {
		@Override
		public void onChanged(ListChangeListener.Change<? extends Persona> c) {
			mostrarDatosDerecho();
		}
	};

	public Persona gettableSeleccionada() {
		if (tableView != null) {
			List<Persona> tabla = tableView.getSelectionModel().getSelectedItems();
			if (tabla.size() == 1) {
				final Persona competicionSeleccionada = tabla.get(0);
				return competicionSeleccionada;
			}
		}
		return null;
	}

	// metodo para ver los datos en el lado derecho
	private void mostrarDatosDerecho() {
		final Persona persona = gettableSeleccionada();
		posicionPersonaEnTabla = personas.indexOf(persona);
		if (persona != null) {
			lNombre.setText(persona.getFirstName());
			lApellido.setText(persona.getLastName());
			lCalle.setText(persona.getStreet());
			lCiudad.setText(persona.getCity());
			lCodigoPostal.setText(Integer.toString(persona.getPostalCode()));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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

	

	// ---------------------BOTONES---------------------------

	// funcionamiento para borrar por bloques e individual
	@FXML
	private void borrar() {
		ObservableList<Persona> selectedIndex = tableView.getSelectionModel().getSelectedItems();
		tableView.getItems().removeAll(selectedIndex);
	}

	@FXML
	private void crear(ActionEvent e) throws Exception {
		ventana();

	}
	
	@FXML
	private void editar() throws IOException {
		mod=true;
		ventana();
		
	}
	
	
	public void ventana() throws IOException {
		Stage stage = new Stage();
		BorderPane root = FXMLLoader.load(getClass().getResource("/application/Nuevo.fxml"));
		Scene scene = new Scene(root);
		stage = new Stage(StageStyle.DECORATED);
		stage.setScene(scene);
		stage.show();
	}
	

}
