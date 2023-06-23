package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import helper.ComponentEffect;
import helper.DbConnection;
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
import model.Session;
import javafx.scene.Node;

public class LoginController {
	
	Parent root;
	Scene scene;
	Stage stage;
	ComponentEffect componentEffect = new ComponentEffect();
	final String customerDash = "/fxml/dasb_customer.fxml";
	final String mechanicDash = "/fxml/dasb_mechanic.fxml";
	private Session login() throws SQLException {
		int userId;
		int userTypeId;
        Session session = new Session();

		Connection conn = DbConnection.getConnection();
		String sql = "SELECT user_id, user_usertypeidfk FROM user WHERE user_username = ? AND user_password = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usernameInput.getText());
        statement.setString(2, passwordInput.getText());
        ResultSet rs = statement.executeQuery();
        
        if(rs.next()) {
            userId = rs.getInt("user_id");
            userTypeId = rs.getInt("user_usertypeidfk");
            session.setSessionUserIdFk(userId);
            session.setSessionUserTypeIdFk(userTypeId);
            session.addDbSession();
    		System.out.println("login ile session eklendi");
    		System.out.println(userId);
    		
        } else {
        	alertLabel.setText("Kullanıcı adı veya şifre hatalı!");
        }
        
        conn.close();
        return session;
	}


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
    void loginBtnClick(MouseEvent event) throws SQLException, IOException {
    	Session session = login();
    	if(session.getSessionUserTypeIdFk() == 3) {
    		System.out.println("musteri paneli acildi");
        	root = FXMLLoader.load(getClass().getResource(customerDash));
        	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        	scene = new Scene(root);
        	stage.setScene(scene);
        	stage.show();
    	} else if (session.getSessionUserTypeIdFk() == 2) {
    		System.out.println("tamirci paneli acildi");
        	root = FXMLLoader.load(getClass().getResource(mechanicDash));
        	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        	scene = new Scene(root);
        	stage.setScene(scene);
        	stage.show();
    	}
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
    	alertLabel.setText("");
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
    	alertLabel.setText("");
    }

    @FXML
    void initialize() {
    	alertLabel.setText("");
    }

}

