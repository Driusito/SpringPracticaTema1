import java.io.File;

public class Principal {

	public static void main(String[] args) {		

		ListaDeLaCompra mercadona = new ListaDeLaCompra("Mercadona");
		ListaDeLaCompra carrefour = new ListaDeLaCompra("Carrefour");

		mercadona.agregarProductoAComprar(crearArticulo("Paquete de arroz de 1 Kg", 3, "Kg"));
		mercadona.agregarProductoAComprar(crearArticulo("Leche entera", 6, "L"));
		mercadona.agregarProductoAComprar(crearArticulo("Pan de molde", 2, "U"));

		carrefour.agregarProductoAComprar(crearArticulo("Huevos camperos", 12, "U"));
		carrefour.agregarProductoAComprar(crearArticulo("Aceite de oliva virgen extra", 2, "L"));
		carrefour.agregarProductoAComprar(crearArticulo("Harina de trigo", 1, "Kg"));

		System.out.println("ANTES DE ELIMINAR");
		mostrarLista(mercadona);
		mostrarLista(carrefour);

		mercadona.eliminarArticulo("Leche entera");
		carrefour.eliminarArticulo("Harina de trigo");

		System.out.println("\nDESPUÉS DE ELIMINAR");
		mostrarLista(mercadona);
		mostrarLista(carrefour);
	}

	private static ArticuloAComprar crearArticulo(String descripcion, int cantidad, String unidad) {
		ArticuloAComprar a = new ArticuloAComprar();
		a.descripcion = descripcion;
		a.cantidad = cantidad;
		a.unidad = unidad;
		return a;
	}

	private static void mostrarLista(ListaDeLaCompra lista) {
		System.out.println("Lista: " + lista.getNombreLista());
		for (ArticuloAComprar a : lista.getArticulos()) {
			System.out.println(" - " + a.descripcion + " (" + a.cantidad + " " + a.unidad + ")");
		}
	}
}