package org.pmov.reminderapp.cliente.consola;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class App {
	public static final int PUERTO = 1234;

	public static void main(String[] args) throws IOException {
		// Declaro un Socket
		Socket socket = null;
		// Declaro scaner para leer comandos
		Scanner sc = new Scanner(System.in);
		String leido = "ERROR";
		// Creamos un while para estar leyendo las conexiones que puedan hacerse
		while (true) {
			// leemos una linea
			System.out.println("Missatge a enviar:");
			String cadena = sc.nextLine();
			
			if(cadena.equals("exit")) return;
			
			// Nuevo ServerSocket
			socket = new Socket("localhost", PUERTO);
			OutputStream salida = socket.getOutputStream();
			InputStream entrada = socket.getInputStream();
			
			// la enviamos por el socket
			IO.escribeLinea(cadena, salida);
			// leemos la respuesta
			leido = IO.leeLinea(entrada);
			// mostramos la respuesta
			System.out.println(leido);
			socket.close();
		}
	}

}
