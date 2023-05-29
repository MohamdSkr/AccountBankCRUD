package Controller.Admin;

import Model.Account;
import View.ViewManager;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UpdateAccountController implements Initializable {

    private Account account;

    @FXML
    private TextField usernameField;
    @FXML
    private TextField accountNumField;
    @FXML
    private TextField balanceField;
    @FXML
    private TextField currenceyField;
    @FXML
    private Button updateBtn;
    @FXML
    private Button backBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.account = AccountsManagmentController.updateAccount;
        usernameField.setText(account.getUsername());
        accountNumField.setText(String.valueOf(account.getAccount_number()));
        balanceField.setText(String.valueOf(account.getBalance()));
        currenceyField.setText(account.getCurrency());

    }

    @FXML
    private void updateBtnHandel(ActionEvent event) throws SQLException, ClassNotFoundException {

        account.setUsername(usernameField.getText());
        account.setAccount_number(Integer.parseInt(accountNumField.getText()));
        account.setCurrency(currenceyField.getText());
        account.setBalance(Double.parseDouble(balanceField.getText()));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Account Update");
        if (account.update() > 0) {
            alert.setContentText("Account updated Successfully");
        } else {
            alert.setContentText("Account not updated, Some thing is wrong!");
        }
        alert.showAndWait();

    }

    @FXML
    private void backBtnHandel(ActionEvent event) {
        AccountsManagmentController.updateStage.close();
    }

}
