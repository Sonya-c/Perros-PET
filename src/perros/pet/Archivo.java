package perros.pet;

import java.io.File;
import java.io.IOException;

public class Archivo {
	public String[] campos;

	public String rutaDir = "C:\\PerrosPet";
	public String ruta = "C:\\PerrosPet";
	public String fileName;
	public File dir;
	public File archivo;

	/**
	 * Maneja el control de archivos TXT
	 * 
	 * @param campos los campos del archivo
	 */
	public Archivo(String nombre, String[] campos) {
		// Crear carpeta
		this.dir = new File(rutaDir);
		this.fileName = nombre; // Nombre archivo
		this.archivo = new File(ruta, fileName);

		if (!archivo.exists()) { // No existe el archivo
			dir.mkdir();
			try {
				archivo.createNewFile();
			} catch (IOException ex) {
				System.out.println("Error");
			}
		}
	}

	/**
	 * Le un registro
	 * 
	 * @return cadena con los campos de un registro
	 */
	public String[] leerRegistro() {
		return null;
	}

	/**
	 * Recibe la lista de objetos y actualiza el archivo (secuencial) si el elemento
	 * es null
	 */
	public void actualizarRegistro() {

	}
}
