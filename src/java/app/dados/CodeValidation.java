package app.dados;

import app.classes.Funcionario;

import java.util.concurrent.atomic.AtomicBoolean;

public class CodeValidation {

    public static boolean validate(Funcionario funcionarios)
    {
        AtomicBoolean isExist = new AtomicBoolean(false);

        UsuariosList.funcionarios.forEach(funcionario -> {
            if(funcionario.getCodigo().equalsIgnoreCase(funcionarios.getCodigo())){
                isExist.set(true);
            }
        });

        return isExist.get();
    }

    public static boolean validate(String code){

        AtomicBoolean isExist = new AtomicBoolean(false);

        UsuariosList.funcionarios.forEach(funcionario -> {
            if(funcionario.getCodigo().equalsIgnoreCase(code)){
                isExist.set(true);
            }
        });

        return isExist.get();

    }

}