package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	Image tamirhanemIcon = new Image(getClass().getResourceAsStream("/img/tamirhanem_logo.png"));

	public void logout(Stage stage) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("ÇIKIŞ");
		alert.setHeaderText("Çıkış yapıyorsunuz!");
		alert.setContentText("Çıkış yapılsın mı?");

		if (alert.showAndWait().get() == ButtonType.OK) {
			stage.close();
		}
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/login_page.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("tamirhanem application");
			primaryStage.getIcons().add(tamirhanemIcon);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setOnCloseRequest(event -> {
				event.consume();
				logout(primaryStage);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
