package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import helper.ComponentEffect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;


//componentEffect.buttonBrightnessEffect(switchCustomerBtn, 0.2);
//componentEffect.buttonShadowEffect(switchCustomerBtn, 0, 1, 5, Color.WHITE);

public class SigninController {

	private Parent root;
	private ComponentEffect componentEffect = new ComponentEffect();
	private final String customerFormPath = "/fxml/signin_customer.fxml";
	private final String mechanicFormPath = "/fxml/signin_mechanic.fxml";
	
	
	private void loadCustomerForm() throws IOException {
		root = FXMLLoader.load(getClass().getResource(customerFormPath));
		signinBp.setCenter(root);
	}

	private void loadMechanicForm() throws IOException {
		root = FXMLLoader.load(getClass().getResource(mechanicFormPath));
		signinBp.setCenter(root);
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private BorderPane signinBp;

	@FXML
	private Button switchCustomerBtn;

	@FXML
	private Button switchMechanicBtn;

	@FXML
	void switchCustomerBtnClick(MouseEvent event) throws IOException {
		loadCustomerForm();
		componentEffect.buttonBrightnessEffect(switchCustomerBtn, 0.2);
		componentEffect.removeButtonBrightnessEffect(switchMechanicBtn);
	}

	@FXML
	void switchCustomerBtnEnter(MouseEvent event) {
	}

	@FXML
	void switchCustomerBtnExit(MouseEvent event) {
	}

	@FXML
	void switchMechanicBtnClick(MouseEvent event) throws IOException {
		loadMechanicForm();
		componentEffect.buttonBrightnessEffect(switchMechanicBtn, 0.2);
		componentEffect.removeButtonBrightnessEffect(switchCustomerBtn);
	}

	@FXML
	void switchMechanicBtnExit(MouseEvent event) {
	}

	@FXML
    void switchMechanicBtnEnter(MouseEvent event) throws IOException {
	}

	@FXML
	void initialize() throws IOException {
		loadCustomerForm();
		componentEffect.buttonBrightnessEffect(switchCustomerBtn, 0.2);

	}

}
