package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import helper.ComponentEffect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DashCustomerController {

	boolean m1;
	boolean m2;
	boolean m3;
	final private String randevu = "/fxml/dasb_customer_appmnt.fxml";
	final private String arac = "/fxml/dasb_customer_car.fxml";
	Parent page;
	Parent root;
	Scene scene;
	Stage stage;

	private void loadRandevu() throws IOException {
		page = FXMLLoader.load(getClass().getResource(randevu));
		customerBp.setCenter(page);
	}
	
	private void loadAraclar() throws IOException {
		page = FXMLLoader.load(getClass().getResource(arac));
		customerBp.setCenter(page);
	}
	
	private void pageSelection(Parent page) {
		customerBp.setCenter(page);
	}

	ComponentEffect componentEffect = new ComponentEffect();


    @FXML
    private TextField adresTxt;
    
	@FXML
	private BorderPane customerBp;

	@FXML
	private TabPane dashPage;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField adTxt;

	@FXML
	private Button dashAraclarBtn;

	@FXML
	private Button dashKisiselBtn;

	@FXML
	private Button dashRandevuBtn;

	@FXML
	private CheckBox editChk;

	@FXML
	private TextField epostaTxt;

	@FXML
	private ComboBox<String> ilceCombo;

	@FXML
	private Button kaydetBtn;

	@FXML
	private ComboBox<String> sehirCombo;

	@FXML
	private TextField soyadTxt;

	@FXML
	private TextField telTxt;

	@FXML
	void editChkAction(ActionEvent event) {
		if (editChk.isSelected()) {
			adTxt.setEditable(true);
			epostaTxt.setEditable(true);
			soyadTxt.setEditable(true);
			telTxt.setEditable(true);
			sehirCombo.setEditable(true);
			ilceCombo.setEditable(true);
			adresTxt.setEditable(true);
			kaydetBtn.setDisable(false);
		} else {
			adTxt.setEditable(false);
			epostaTxt.setEditable(false);
			soyadTxt.setEditable(false);
			telTxt.setEditable(false);
			sehirCombo.setEditable(false);
			ilceCombo.setEditable(false);
			adresTxt.setEditable(false);
			kaydetBtn.setDisable(true);
		}
	}

	@FXML
	void dashAraclarBtnClick(MouseEvent event) throws IOException {
		dashRandevuBtn.setTextFill(Color.WHITE);
		dashKisiselBtn.setTextFill(Color.WHITE);
		dashAraclarBtn.setTextFill(Color.MIDNIGHTBLUE);
		loadAraclar();
	}

	@FXML
	void dashAraclarBtnEnter(MouseEvent event) {
		componentEffect.buttonBrightnessEffect(dashAraclarBtn, 0.4);
	}

	@FXML
	void dashAraclarBtnExit(MouseEvent event) {
		componentEffect.removeButtonBrightnessEffect(dashAraclarBtn);
	}

	@FXML
	void dashKisiselBtnClick(MouseEvent event) throws IOException {
		dashRandevuBtn.setTextFill(Color.WHITE);
		dashKisiselBtn.setTextFill(Color.MIDNIGHTBLUE);
		dashAraclarBtn.setTextFill(Color.WHITE);
		root = FXMLLoader.load(getClass().getResource("/fxml/dasb_customer.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
	}

	@FXML
	void dashKisiselBtnEnter(MouseEvent event) {
		componentEffect.buttonBrightnessEffect(dashKisiselBtn, 0.4);
	}

	@FXML
	void dashKisiselBtnExit(MouseEvent event) {
		componentEffect.removeButtonBrightnessEffect(dashKisiselBtn);
	}

	@FXML
	void dashRandevuBtnClick(MouseEvent event) throws IOException {
		dashRandevuBtn.setTextFill(Color.MIDNIGHTBLUE);
		dashKisiselBtn.setTextFill(Color.WHITE);
		dashAraclarBtn.setTextFill(Color.WHITE);
		loadRandevu();
	}

	@FXML
	void dashRandevuBtnEnter(MouseEvent event) {
		componentEffect.buttonBrightnessEffect(dashRandevuBtn, 0.4);
	}

	@FXML
	void dashRandevuBtnExit(MouseEvent event) {
		componentEffect.removeButtonBrightnessEffect(dashRandevuBtn);
	}

	@FXML
	void kaydetBtnClick(MouseEvent event) {

	}

	@FXML
	void kaydetBtnEnter(MouseEvent event) {
		componentEffect.buttonBrightnessEffect(kaydetBtn, 0.4);
	}

	@FXML
	void kaydetBtnExit(MouseEvent event) {
		componentEffect.removeButtonBrightnessEffect(kaydetBtn);
	}

	@FXML
	void initialize() {
		dashKisiselBtn.setTextFill(Color.MIDNIGHTBLUE);
		adresTxt.setEditable(false);
		kaydetBtn.setDisable(true);
	}

}
