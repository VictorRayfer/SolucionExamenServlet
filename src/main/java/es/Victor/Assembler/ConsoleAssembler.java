package es.Victor.Assembler;

import javax.servlet.http.HttpServletRequest;

import es.Victor.Model.Console;

public class ConsoleAssembler {

	public static Console assembleConsoleFrom(HttpServletRequest request) {
		
		Console console = new Console();
		
		int cod = Integer.parseInt(request.getParameter("CodCompany"));
		console.setName(request.getParameter("Name"));
		console.setCodCompany(cod);
		return console;
	}
}
