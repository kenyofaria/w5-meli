package br.com.mercadolivre.interfaces;

public class Autenticador {

	public boolean efetuaAutenticacao(UsuarioAutenticavel fera, String token) {
		if(tokeValido(token)) {
			String login = extraiLogin(token);
			String senha = extraiSenha(token);
			return fera.autentica(login, senha);
		}else {
			throw new RuntimeException("token invalido");
		}
		
	}

	private String extraiSenha(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	private String extraiLogin(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean tokeValido(String token) {
		// TODO Auto-generated method stub
		return false;
	} 
}
