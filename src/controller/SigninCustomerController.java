package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import helper.ComponentEffect;
import helper.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SigninCustomerController {

	Parent root;
	Stage stage;
	Scene scene;
	ComponentEffect ce = new ComponentEffect();

	public void setCity() throws SQLException {
		String query = "SELECT city.city_name FROM tamirhanemdb.city;";
		Connection connection = DbConnection.getConnection();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);

		ObservableList<String> ol = FXCollections.observableArrayList();
		while (rs.next()) {
			ol.add(rs.getString("city.city_name"));
		}
		if (cityCombo.getItems().containsAll(ol) == false) {
			cityCombo.getItems().addAll(ol);
		}
		;
		connection.close();
	}

	public int getCity() throws SQLException {
		String query = "SELECT city.city_id FROM tamirhanemdb.city where city.city_name = '"
				+ cityCombo.getSelectionModel().getSelectedItem() + "' ;";
		Connection connection = DbConnection.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		rs.next();
		int selectedCityId = rs.getInt(1);
		connection.close();
		return selectedCityId;
	}

	public void setDistrict() throws SQLException {
		districtCombo.getItems().clear();
		getCity();
		String query = "SELECT district.district_name FROM tamirhanemdb.district WHERE district_cityidfk = ?;";
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, this.getCity());
		ResultSet rs = ps.executeQuery();
		ObservableList<String> ol = FXCollections.observableArrayList();
		while (rs.next()) {
			ol.add(rs.getString("district.district_name"));
		}
		if (districtCombo.getItems().containsAll(ol) == false) {
			districtCombo.getItems().addAll(ol);
		}
		;
		connection.close();
	}

	public int getDistrict() throws SQLException {
		String query = "SELECT district.district_id FROM tamirhanemdb.district WHERE district_name = ?;";
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, districtCombo.getSelectionModel().getSelectedItem());
		ResultSet rs = ps.executeQuery();
		rs.next();
		int selectedDistrictId = rs.getInt("district.district_id");
		connection.close();
		return selectedDistrictId;
	}

	private void clearForm() {
		mailInput.clear();
		usernameInput.clear();
		passwordInput.clear();
		nameInput.clear();
		surnameInput.clear();
		phoneInput.clear();
		districtCombo.getItems().clear();
		districtCombo.setButtonCell(new ListCell<String>() {
			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("İLÇE SEÇİNİZ");
				} else {
					setText(item);
				}
			}
		});

		cityCombo.getItems().clear();
		cityCombo.setButtonCell(new ListCell<String>() {
			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("ŞEHİR SEÇİNİZ");
				} else {
					setText(item);
				}
			}
		});
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label cityAlert;

	@FXML
	private ComboBox<String> cityCombo;

	@FXML
	private Button clearForm;

	@FXML
	private Label districtAlert;

	@FXML
	private ComboBox<String> districtCombo;

	@FXML
	private Label mailAlert;

	@FXML
	private TextField mailInput;

	@FXML
	private Label mainAlert;

	@FXML
	private Label nameAlert;

	@FXML
	private TextField nameInput;

	@FXML
	private Label passwordAlert;

	@FXML
	private TextField passwordInput;

	@FXML
	private Label phoneAlert;

	@FXML
	private TextField phoneInput;

	@FXML
	private Button returnLogin;

	@FXML
	private Button signinBtn;

	@FXML
	private Label surnameAlert;

	@FXML
	private TextField surnameInput;

	@FXML
	private Label usernameAlert;

	@FXML
	private TextField usernameInput;

	@FXML
	void cityComboAction(ActionEvent event) throws SQLException {
		getCity();
		System.out.println(getCity());
	}

	@FXML
	void cityComboClick(MouseEvent event) throws SQLException {
		setCity();
	}

	@FXML
	void districtComboAction(ActionEvent event) throws SQLException {
		getDistrict();
		System.out.println(getDistrict());
	}

	@FXML
	void districtComboClick(MouseEvent event) throws SQLException {
		setDistrict();
	}

	@FXML
	void clearFormClick(MouseEvent event) {
		clearForm();
	}

	@FXML
	void clearFormEnter(MouseEvent event) {
		ce.buttonBrightnessEffect(clearForm, 0.2);
	}

	@FXML
	void clearFormExit(MouseEvent event) {
		ce.removeButtonBrightnessEffect(clearForm);
	}

	@FXML
	void returnLoginClick(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/fxml/login_page.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void returnLoginEnter(MouseEvent event) {
		ce.buttonBrightnessEffect(returnLogin, 0.2);
	}

	@FXML
	void returnLoginExit(MouseEvent event) {
		ce.removeButtonBrightnessEffect(returnLogin);
	}

	@FXML
	void signinBtnClick(MouseEvent event) {

	}

	@FXML
	void signinBtnEnter(MouseEvent event) {
		ce.buttonBrightnessEffect(signinBtn, 0.2);
	}

	@FXML
	void signinBtnExit(MouseEvent event) {
		ce.removeButtonBrightnessEffect(signinBtn);
	}

	@FXML
	void initialize() {
		cityCombo.setVisibleRowCount(10);
		clearForm();
	}

}
