package controller;

import application.AgendaDeContactos;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Persona;

public class AgendaDeContactosController {
	@FXML
	private TableView<Persona> personTable;
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

	private AgendaDeContactos AgendaDeContactos;
	
	public AgendaDeContactosController(){
		
	}
	@FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        tcNombre.setCellValueFactory(cellData -> cellData.getValue().firstNameP());
        tcApellido.setCellValueFactory(cellData -> cellData.getValue().lastNameP());
    }
	
	public void setMainApp(AgendaDeContactos AgendaDeContactos) {
        this.AgendaDeContactos = AgendaDeContactos;

        personTable.setItems(AgendaDeContactos.getDatoPersona());
    }
}
