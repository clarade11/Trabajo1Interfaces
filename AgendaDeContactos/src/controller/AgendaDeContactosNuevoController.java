package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	public void volver() throws IOException {
		File ruta = new File("./docs/PersonaParaAnadir.txt");

		BufferedWriter fichero = new BufferedWriter(new FileWriter(ruta));
		try {

			
			fichero.write(tfNombre.getText());
			fichero.newLine();
			fichero.write(tfApellido.getText());
			fichero.newLine();
			fichero.write(tfCalle.getText());
			fichero.newLine();
			fichero.write(tfCiudad.getText());
			fichero.newLine();
			fichero.write(tfCodigoPostal.getText());
			fichero.newLine();
			fichero.write(tfFecha.getText());
			fichero.newLine();
			fichero.write(tfTelefono.getText());
			fichero.newLine();
			fichero.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
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
