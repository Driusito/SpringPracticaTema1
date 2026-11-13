import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaDeLaCompra {
	private String nombre;

	public ListaDeLaCompra(String nombre) {
		this.nombre = nombre;
	}
	
	public ListaDeLaCompra() {
		
	}
	
	public String getNombreLista() {
		return this.nombre;
	}
	
	public void setNombreLista(String nombreLista) {
		nombre=nombreLista;
	}
	
	public void agregarProductoAComprar(ArticuloAComprar articulo) {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(getNombreLista() + ".txt", true))) {
			bw.write(articulo.descripcion + ";" + articulo.cantidad + ";" + articulo.unidad);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public void eliminarArticulo(String descripcionArticulo) {
		List<ArticuloAComprar> articulos = getArticulos();
		boolean encontrado=false;
		for (int i = 0;!encontrado && i < articulos.size(); i++) {
			if (articulos.get(i).descripcion.equals(descripcionArticulo)) {
				articulos.remove(i);
				encontrado=true;
			}
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(getNombreLista() + ".txt"))) {
			for (ArticuloAComprar a : articulos) {
				bw.write(a.descripcion + ";" + a.cantidad + ";" + a.unidad);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<ArticuloAComprar> getArticulos() {
		List<ArticuloAComprar> articulos = new ArrayList<>();
		File fichero = new File(getNombreLista() + ".txt");
		if (!fichero.exists()) {
			return articulos;
		}
		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split(";");
				ArticuloAComprar a = new ArticuloAComprar();
				a.descripcion = campos[0];
				a.cantidad = Integer.parseInt(campos[1]);
				a.unidad = campos[2];
				articulos.add(a);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return articulos;
	}

}
