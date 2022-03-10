package br.edu.infnet.appagendamentocarga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appagendamentocarga.client.IUsuarioClient;
import br.edu.infnet.appagendamentocarga.model.domain.Usuario;
import br.edu.infnet.appagendamentocarga.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private IUsuarioClient usuarioClient;

	public Usuario validar(String email, String senha) {
		
		return usuarioRepository.autenticacao(email, senha);
	}
	
	public Long obterQtd() {
		return (long) usuarioClient.obterLista().size();
	}
	
	public void incluir(Usuario usuario) {
		
		usuarioClient.incluir(usuario);
		
		//usuarioRepository.save(usuario);
	}

	public List<Usuario> obterLista() {
		
		return usuarioClient.obterLista();
		//return usuarioRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		
	}

	public Usuario obterPorId(Integer id) {
		
		for (Usuario usuario : usuarioClient.obterLista()) {
			if (usuario.getId().equals(id)) {
				return usuario;
			}
		}
		return null;
		
		//return usuarioRepository.findById(id).orElse(null);
	}

	public void excluir(Integer id) {
		
		usuarioClient.excluir(id);
		//usuarioRepository.deleteById(id);		
	}
	
	
}