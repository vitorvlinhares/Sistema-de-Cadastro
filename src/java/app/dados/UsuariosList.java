package app.dados;

import app.classes.Funcionario;


import java.util.ArrayList;

public class UsuariosList {

    public static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public static ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }


    public static void addFuncionario(Funcionario funcionario){

        funcionarios.add(funcionario);


    }

    public static void createFuncionario(Funcionario funcionario) {

        if(app.dados.CodeValidation.validate(funcionario))
        {
            System.out.println("Colocar Warning de nao pode criar");
        }
        else
        {
            System.out.println("Funcionário criado com sucesso");
            addFuncionario(funcionario);
        }
    }

    public static void deleteFuncionario(Funcionario funcionario)
    {
        funcionarios.remove(funcionario);
    }
}


