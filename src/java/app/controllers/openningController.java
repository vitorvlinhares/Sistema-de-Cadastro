package app.controllers;

import app.App;
import app.classes.Funcionario;
import app.dados.CodeValidation;
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
import java.util.EventObject;

public class openningController {

    @FXML
    private Button btCriarLogiin;

    @FXML
    private Button btEntrar;

    @FXML
    private TextField entradaCodigoCadastrado;

    @FXML
    private TextField entradaNomeCadastrado;

    @FXML
    void abrirCadastro(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("novo_cadastro.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Cadastro de Funcionários");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void abrirViewFuncionario(ActionEvent event) throws IOException {

        if(CodeValidation.validate(entradaCodigoCadastrado.getText())){
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view_list.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 500);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Lista de funcionários cadastrados");
            stage.setScene(scene);
            stage.show();
        }else {
            JOptionPane.showMessageDialog(null,"Funcionário não cadastrado!");
        }



    }


}

