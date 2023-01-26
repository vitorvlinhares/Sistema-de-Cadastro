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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class cadastroController {

    @FXML
    private Button btCadastrar;

    @FXML
    private TextField entradaCargo;

    @FXML
    private TextField entradaCodigo;

    @FXML
    private TextField entradaNome;

    @FXML
    private TextField entradaQuantidade;

    @FXML
    private TextField entradaSalario;

    @FXML
    private TextField entradaSobrenome;
    private javax.swing.JOptionPane JOptionPane;

    @FXML
    void criarFuncionario(ActionEvent event) {
        try{
            if(CodeValidation.validate(entradaCodigo.getText())){
                JOptionPane.showMessageDialog(null,"Funcionário já cadastrado");
            }else {
                UsuariosList.createFuncionario(new Funcionario(
                        entradaNome.getText(),entradaSobrenome.getText()
                        ,entradaCodigo.getText()
                        ,entradaCargo.getText()
                        ,Integer.parseInt(entradaQuantidade.getText())
                        ,Float.parseFloat(entradaSalario.getText())
                ));


                FileJSONWrite.createJSON();
                JOptionPane.showMessageDialog(null,"Funcionário cadastrado!");

                if(0 == Integer.parseInt(entradaQuantidade.getText()) ){
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view_list.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 800,500);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("Lista de funcionários cadastrados");
                    stage.setScene(scene);
                    stage.show();

                } else {
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("dependente.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 400, 300);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("Adicionar Dependente");
                    stage.setScene(scene);
                    stage.show();
                }


            }
        } catch (NumberFormatException | IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.toString());
            alert.show();
        }

    }

}

