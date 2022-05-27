package cl.aiep.java.cms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.aiep.java.cms.model.Usuario;
import cl.aiep.java.cms.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private PasswordEncoder codificadorContraseña;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
public long cantidadUsuarios() 
{
	return usuarioRepository.count();
}
	

	public Optional<Usuario> buscarPorEmail(String email) 
{
	return usuarioRepository.findByEmail(email);
}

	public Usuario crearUsuario(Usuario usuario) 
	{
		String contrasenaCodificada = 
		codificadorContraseña.encode(usuario.getPassword());
		usuario.setPassword(contrasenaCodificada);
		return usuarioRepository.saveAndFlush(usuario);
	}

}
