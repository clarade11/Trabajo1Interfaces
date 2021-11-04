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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Persona;

public class AgendaDeContactos extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		// creamos el gridpane y loader para conexion
		FXMLLoader loader = new FXMLLoader(AgendaDeContactos.class.getResource("Principal.fxml"));
		AnchorPane anchorPane = (AnchorPane) loader.load();

		TableView tableView = new TableView();

		TableColumn<Persona, String> column1 = new TableColumn<>("Nombre");
		column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

		TableColumn<Persona, String> column2 = new TableColumn<>("Apellido");
		column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));

		tableView.getColumns().add(column1);
		tableView.getColumns().add(column2);

		tableView.getItems().add(new Persona("Antonio", "Fernandez", "Calle Macarena Bailaora", "Sevilla", 420135,
				LocalDate.now(), 612453987));
		tableView.getItems().add(new Persona("Pepe", "Octobre", "Calle adsf ajses", "Zaragoza", 253647,
				LocalDate.of(2000, 2, 26), 6333251));
		tableView.getItems().add(new Persona("Clara", "Pepita", "Calle Feria", "Constantina", 41450,
				LocalDate.of(2000, 3, 27), 617515298));

		VBox vbox = new VBox(anchorPane);
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
