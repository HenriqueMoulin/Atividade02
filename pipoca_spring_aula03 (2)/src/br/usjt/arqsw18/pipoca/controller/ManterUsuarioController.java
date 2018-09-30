package br.usjt.arqsw18.pipoca.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw18.pipoca.model.entity.Usuario;
import br.usjt.arqsw18.pipoca.model.service.UsuarioService;

@Controller
public class ManterUsuarioController {

	private UsuarioService uService;
	
	@Autowired
	public ManterUsuarioController (UsuarioService uService) {
		this.uService = uService;
	}
	
	@RequestMapping("loginForm")
	public String loginForm(){
		return "Login";
	}
			
	@RequestMapping("fazer_login")
	public String fazerLogin(Usuario usuario, HttpSession session){
		try {			
			if(uService.validarUsuario(usuario)){
				session.setAttribute("LOGADO", usuario);
				return "index";
			}
		} catch (IOException e) {		
			e.printStackTrace();
			return "Erro";			
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.setAttribute("LOGADO", null);
		return "index";
	}
	
}
