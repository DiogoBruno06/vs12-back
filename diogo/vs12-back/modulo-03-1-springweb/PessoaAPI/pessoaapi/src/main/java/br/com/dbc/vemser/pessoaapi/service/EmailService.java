package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private final Configuration fmConfiguration;
    private String from = "Diogo Bruno <diogo.neves@dbccompany.com.br>";



    public void sendSimpleEmail() {
        SimpleMailMessage email = new SimpleMailMessage();

        email.setFrom(from);
        email.setTo("diogobruno06@outlook.com");
        email.setSubject("testando");
        email.setText("salve");
        mailSender.send(email);
    }

    public void sendMailWithAttachment() throws MessagingException {
        MimeMessage email = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(email, true);

        helper.setFrom(from);
        helper.setTo("aula.vemser@gmail.com");
        helper.setSubject("email com anexo");
        helper.setText("enviando email com anexo\npulando linha");

        File file = new File("src/main/resources/images/image.jpg");
        FileSystemResource image = new FileSystemResource(file);

        helper.addAttachment(file.getName(), image);

        mailSender.send(email);
    }

    private void sendTemplateEmail(String descricao, String conteudo) throws MessagingException {
        MimeMessage emailTemplate = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(emailTemplate, true);

        try {

            helper.setFrom(from);
            helper.setTo("diogobruno06@outlook.com");
            helper.setSubject(descricao);
            helper.setText(conteudo, true);

            mailSender.send(helper.getMimeMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getContentFromTemplate(String nome, EnderecoCreateDTO endereco) throws IOException, TemplateException {
        Map<String, String> dados = new HashMap<>();
        dados.put("nome",nome);
        dados.put("endereco", String.valueOf(endereco));
        Template template = fmConfiguration.getTemplate("email-template2.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String getContentFromTemplateDelete(String nome,Integer idPessoa, EnderecoCreateDTO endereco) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome",nome);
        dados.put("idPessoa",idPessoa);
        dados.put("endereco", endereco);
        Template template = fmConfiguration.getTemplate("delete-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }



    public void EnderecoCriado(Pessoa pessoa, EnderecoCreateDTO endereco) throws TemplateException, IOException, MessagingException {
        String descricao = "Novo endereco cadastrado";
        String conteudo = getContentFromTemplate(pessoa.getNome(),endereco);
        sendTemplateEmail(descricao,conteudo);
    }

    public void EnderecoEditado(Pessoa pessoa, EnderecoCreateDTO endereco) throws TemplateException,IOException,MessagingException{
        String descricao = "Endereco editado";
        String conteudo = getContentFromTemplate(pessoa.getNome(),endereco);
        sendTemplateEmail(descricao,conteudo);
    }

    public void EnderecoDeletar(Pessoa pessoa,Integer idPessoa, EnderecoCreateDTO endereco) throws TemplateException,IOException,MessagingException{
        String descricao = "Endereco removido";
        String conteudo = getContentFromTemplateDelete(pessoa.getNome(),idPessoa,endereco);
        sendTemplateEmail(descricao,conteudo);
    }



}
