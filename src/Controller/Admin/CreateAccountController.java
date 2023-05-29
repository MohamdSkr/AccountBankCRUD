package Controller.Admin;

import Model.Account;
import View.ViewManager;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateAccountController implements Initializable {

    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField accountNumField;
    @FXML
    private TextField balanceField;
    @FXML
    private TextField currenceyField;
    @FXML
    private Button createBtn;
    @FXML
    private Button backBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToUsersManagment();
    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

    @FXML
    private void showOperationsPage(ActionEvent event) {
    }

    @FXML
    private void createBtnHandel(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        Account account = new Account();
        account.setUsername(usernameField.getText());
        account.setAccount_number(Integer.parseInt(accountNumField.getText()));
        account.setBalance(Double.parseDouble(balanceField.getText()));
        account.setCurrency(currenceyField.getText());
        LocalDate currentDate = LocalDate.now();
        account.setCreation_date(Date.valueOf(currentDate));

        if (account.add() > 0) {
            ViewManager.adminPage.changeSceneToAccountsManagment();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Account inserted");
            alert.setContentText("Account inserted Successfully");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Account not inserted");
            alert.setContentText("Account not inserted, Some thing is wrong!");
            alert.showAndWait();
        }

    }

    @FXML
    private void backBtnHandel(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

}
