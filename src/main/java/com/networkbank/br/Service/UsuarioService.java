package com.networkbank.br.Service;

import com.networkbank.br.Entity.Usuario;
import com.networkbank.br.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    @Autowired protected UsuarioRepository usuarioRepo;

    public Usuario salvar(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }
}

