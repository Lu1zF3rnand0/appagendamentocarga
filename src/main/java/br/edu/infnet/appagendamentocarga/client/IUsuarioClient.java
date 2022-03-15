package br.edu.infnet.appagendamentocarga.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appagendamentocarga.model.domain.Usuario;

@FeignClient(url = "localhost:8086/api/usuario", name = "usuarioClient")
public interface IUsuarioClient {

	@GetMapping(value = "/listar")
	public List<Usuario> obterLista();

	@PostMapping(value = "/incluir")
	public void incluir(Usuario usuario);
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable int id);
	
	@PostMapping(value = "/{email}/{senha}/validar")
	public Usuario validar(@PathVariable String email, @PathVariable String senha); 
	
}
