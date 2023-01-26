package app.controllers;

import app.App;
import app.classes.Funcionario;
import app.dados.CodeValidation;
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

public class deleteController {

    @FXML
    private Button btApagarFuncionario;

    @FXML
    private TextField entradaCodigo;

    @FXML
    void deletarFuncionario(ActionEvent event) throws IOException {
        if (CodeValidation.validate(entradaCodigo.getText())) {

            for (Funcionario funcionario : UsuariosList.getFuncionarios()) {
                if (Objects.equals(funcionario.getCodigo(), entradaCodigo.getText())) {
                    UsuariosList.deleteFuncionario(funcionario);
                    FileJSONWrite.createJSON();
                    JOptionPane.showMessageDialog(null,"Funcionário apagado com sucesso!");
                    break;

                }


            }
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view_list.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 500);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Lista de funcionários cadastrados");
            stage.setScene(scene);
            stage.show();

        }
        else{
            JOptionPane.showMessageDialog(null,"Funcionário inexistente.");
        }

    }
}



