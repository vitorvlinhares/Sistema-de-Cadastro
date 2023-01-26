package app.controllers;

import app.App;
import app.dados.FileJSONWrite;
import app.dados.UsuariosList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class salarioController {

    @FXML
    private Button btAlterar;

    @FXML
    private TextField entradaCodigo;

    @FXML
    private TextField entradaSalario;

    @FXML
    void alterarSalario(ActionEvent event) throws IOException {
        for (int i = 0; i < UsuariosList.getFuncionarios().size(); i++) {
            if (Objects.equals(UsuariosList.getFuncionarios().get(i).getCodigo(), entradaCodigo.getText())) {
                UsuariosList.getFuncionarios().get(i).setSalario(Float.parseFloat(entradaSalario.getText()));
                FileJSONWrite.createJSON();
                JOptionPane.showMessageDialog(null, "Salário atualizado!");
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view_list.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 500);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Lista de funcionários Atualizada.");
                stage.setScene(scene);
                stage.show();
                break;

            }else {
                JOptionPane.showMessageDialog(null, "Funcionário Inexistente!");
                break;

            }
        }
    }

}



