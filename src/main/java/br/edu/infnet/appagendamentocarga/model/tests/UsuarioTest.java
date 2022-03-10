package br.edu.infnet.appagendamentocarga.model.tests;

import br.edu.infnet.appagendamentocarga.service.UsuarioService;

public class UsuarioTest {

	static UsuarioService user = new UsuarioService();

public static void main(String[] args) {
		
		
	System.out.println(user.obterLista());

}

}
