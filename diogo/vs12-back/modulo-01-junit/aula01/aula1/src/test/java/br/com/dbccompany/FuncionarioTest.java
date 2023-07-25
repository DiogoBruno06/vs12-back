package br.com.dbccompany;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    Funcionario funcionario = new Funcionario("Diogo","2004-10-06","2022-06-07",800);
    @Test
    @DisplayName("Deveria retornar 18 se o usuario nasceu em 06/10/2004")
    void calcularIdade() {
        int idadeFuncTest = funcionario.calcularIdade();
        Assertions.assertEquals(18,idadeFuncTest);
    }

    @Test
    @DisplayName("Deveria retornar 18 se o usuario foi contratado 07/06/2022")
    void calcularTempoDeEmpresa() {
    }
}