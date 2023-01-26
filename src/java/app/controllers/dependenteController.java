package app.controllers;

import app.App;
import app.classes.Dependente;
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
import java.util.ArrayList;
import java.util.Objects;

public class dependenteController {
    @FXML
    private Button btVoltar;

    @FXML
    private Button btAdicionarDependente;

    @FXML
    private TextField entradaCodigo2;

    @FXML
    private TextField entradaNomeDependente;

    ArrayList<Dependente> dependentes = new ArrayList<>();

    @FXML
    void criarDependente(ActionEvent event) throws IOException {

        if (CodeValidation.validate(entradaCodigo2.getText())) {

            for (Funcionario funcionario : UsuariosList.getFuncionarios()) {
                if (Objects.equals(funcionario.getCodigo(), entradaCodigo2.getText())){
                    int index = UsuariosList.getFuncionarios().size() - 1;
                    if (dependentes.size() == UsuariosList.getFuncionarios().get(index).getDependentes() - 1) {

                        dependentes.add(new Dependente(entradaNomeDependente.getText()));

                        UsuariosList.getFuncionarios().get(index).setDependentesList(dependentes);
                        FileJSONWrite.createJSON();
                        JOptionPane.showMessageDialog(null, "Dependente Adicionado!");
                    }
                    else {

                        dependentes.add(new Dependente(entradaNomeDependente.getText()));
                        JOptionPane.showMessageDialog(null, "Dependente Adicionado!");

                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Código invalido!");
        }
}



        @FXML
        void abrirViewList (ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view_list.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 500);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Lista de funcionários cadastrados");
            stage.setScene(scene);
            stage.show();

        }

}








