package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import helper.ComponentEffect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;

public class LoginController {
	
	Parent root;
	Scene scene;
	Stage stage;
	ComponentEffect componentEffect = new ComponentEffect();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label alertLabel;

    @FXML
    private Button loginBtn;
    
    @FXML
    private ImageView loginImage;
    
    @FXML
    private VBox loginVbox;

    @FXML
    private PasswordField passwordInput;
    
    @FXML
    private VBox signinVbox;
    
    @FXML
    private ImageView signinImage;

    @FXML
    private Button switchLoginBtn;

    @FXML
    private Button switchSigninBtn;

    @FXML
    private TextField usernameInput;
    

    
    @FXML
    void loginBtnClick(MouseEvent event) {

    }
    
    @FXML
    void loginImageEnter(MouseEvent event) {
    }
    
    @FXML
    void loginImageExit(MouseEvent event) {
    }

    @FXML
    void loginBtnEnter(MouseEvent event) {
    	componentEffect.buttonBrightnessEffect(loginBtn, 0.2);
    }

    @FXML
    void loginBtnExit(MouseEvent event) {
    	componentEffect.removeButtonBrightnessEffect(loginBtn);
    }
    
    @FXML
    void loginVboxEnter(MouseEvent event) {
    	componentEffect.imageViewPopup(loginImage, 15);
    }

    @FXML
    void loginVboxExit(MouseEvent event) {
    	componentEffect.imageViewClearPopup(loginImage,100);
    }

    @FXML
    void passwordInputClick(MouseEvent event) {

    }

    @FXML
    void passwordInputKeytype(KeyEvent event) {

    }
    
    @FXML
    void signinImageEnter(MouseEvent event) {
    }

    @FXML
    void signinImageExit(MouseEvent event) {
    }
    
    @FXML 
    void signinImageClick(MouseEvent event) throws IOException{
    }
    
    @FXML
    void signinVboxEnter(MouseEvent event) {
    	componentEffect.imageViewPopup(signinImage, 15);
    }

    @FXML
    void signinVboxExit(MouseEvent event) {
    	componentEffect.imageViewClearPopup(signinImage,100);
    }
    
    @FXML
    void signinVboxClick(MouseEvent event) throws IOException {

    }

    @FXML
    void switchLoginBtnClick(MouseEvent event) {

    }
    
    @FXML
    void switchLoginBtnEnter(MouseEvent event) {
    }

    @FXML
    void switchLoginBtnExit(MouseEvent event) {
    }

    @FXML
    void switchSigninBtnClick(MouseEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("/fxml/signin_page.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();	
    }

    @FXML
    void switchSigninBtnEnter(MouseEvent event) {

    }

    @FXML
    void switchSigninBtnExit(MouseEvent event) {

    }

    @FXML
    void usernameInputClick(MouseEvent event) {

    }

    @FXML
    void usernameInputKeytype(KeyEvent event) {

    }

    @FXML
    void initialize() {
    }

}

