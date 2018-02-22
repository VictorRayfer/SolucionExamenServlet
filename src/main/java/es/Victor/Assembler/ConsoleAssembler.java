package es.Victor.Assembler;

import javax.servlet.http.HttpServletRequest;

import es.Victor.Model.Console;

public class ConsoleAssembler {

	public static Console assembleConsoleFrom(HttpServletRequest request) {
		
		Console console = new Console();
		console.setName(request.getParameter("name"));
		console.setCodCompany(Integer.parseInt(request.getParameter("company")));
		return console;
	}
}
