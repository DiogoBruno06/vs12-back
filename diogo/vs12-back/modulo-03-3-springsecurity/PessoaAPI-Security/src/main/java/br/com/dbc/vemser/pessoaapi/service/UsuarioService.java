package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.LoginCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.CargoEntity;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.CargoRepository;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final CargoService cargoService;
    private final CargoRepository cargoRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public LoginCreateDTO create(LoginCreateDTO loginCreateDTO) {
        UsuarioEntity usuario = objectMapper.convertValue(loginCreateDTO, UsuarioEntity.class);
        Set<CargoEntity> cargos = new HashSet<>();
        for (Integer roleId : loginCreateDTO.getCargos()) {

            CargoEntity cargo = cargoRepository.getById(roleId);
            if (cargo != null) {
                cargos.add(cargo);
            }
        }
        usuario.setCargos(cargos);
        usuario.setSenha(passwordEncoder().encode(usuario.getSenha()));
        return objectMapper.convertValue(usuarioRepository.save(usuario), LoginCreateDTO.class);
    }

    public Integer getIdLoggedUser() {
        Integer findUserId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return findUserId;
    }

    public LoginDTO getLoggedUser() throws RegraDeNegocioException {
        LoginDTO loginDTO = objectMapper.convertValue(findById(getIdLoggedUser()), LoginDTO.class);
        return loginDTO;
    }

    public UsuarioEntity findById(Integer idUsuario) throws RegraDeNegocioException {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() ->
                        new RegraDeNegocioException("Usuário não encontrado!"));
    }

    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }

}