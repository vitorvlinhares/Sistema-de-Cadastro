package app.controllers;

import app.App;
import app.classes.Dependente;
import app.classes.Funcionario;
import app.dados.CodeValidation;
import app.dados.FileJSONWrite;
import app.dados.UsuariosList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class viewListController implements Initializable {

    @FXML
    private Button btApagarFuncionario;

    @FXML
    private Button btNovoFuncionario;

    @FXML
    private Button btAtualizar;

    @FXML
    private TableColumn<?, ?> colunaCodigo;

    @FXML
    private TableColumn<?, ?> colunaNome;

    @FXML
    private TableColumn<?, ?> colunaNumeroDependente;

    @FXML
    private TableColumn<?, ?> colunaSalario;

    @FXML
    private TableColumn<?, ?> colunaSobrenome;

    @FXML
    private TableView<Funcionario> viewFuncionario;

    private ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resources) {
        funcionarios.addAll(UsuariosList.getFuncionarios());

        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaNumeroDependente.setCellValueFactory(new PropertyValueFactory<>("dependentes"));
        colunaSalario.setCellValueFactory(new PropertyValueFactory<>("bonus"));
        colunaSobrenome.setCellValueFactory(new PropertyValueFactory<>("sobrenome"));

        viewFuncionario.setItems(funcionarios);
    }


    @FXML
    void abrirCadastro(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("novo_cadastro.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Cadastro de funcionários");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void apagarFuncionario(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("deleteInterface.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 300);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Apagar Funcionário");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void atualizarLista(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("salarioInterface.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Alterar Salário");
        stage.setScene(scene);
        stage.show();



    }
}

