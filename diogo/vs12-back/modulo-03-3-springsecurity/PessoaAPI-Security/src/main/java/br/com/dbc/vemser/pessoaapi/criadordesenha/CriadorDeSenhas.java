package br.com.dbc.vemser.pessoaapi.criadordesenha;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriadorDeSenhas {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senha = bCryptPasswordEncoder.encode("456");
        System.out.println(senha);

//        String minhaSenhaCript = "$2a$10$7MLRM4pjc6QU3KPWdypEaOdQ6mu6nVEXb4tA1o.5lCSQ7SPbJXXkq";
//        boolean matches = bCryptPasswordEncoder.matches("1234",minhaSenhaCript);
//        System.out.println(matches);
    }
}
