package application;

import java.io.IOException;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Persona;

public class AgendaDeContactos extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		VBox vbox = (VBox)FXMLLoader.load(getClass().getResource("Principal.fxml"));
		Scene scene = new Scene(vbox);

		

		primaryStage.setScene(scene);
		primaryStage.setTitle("Agenda");
		primaryStage.show();
		
	}


	
}
