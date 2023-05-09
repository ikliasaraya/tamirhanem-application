package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
	
	Image tamirhanemIcon = new Image(getClass().getResourceAsStream("/img/tamirhanem_logo.png"));
	
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
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
