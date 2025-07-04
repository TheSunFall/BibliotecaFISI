import com.BibliotecaFISI.lib.ArbolBinario;
import com.BibliotecaFISI.lib.Ejemplar;
import java.util.List;

public class ArbolBinarioTest {
    public static void main(String[] args) {
        // Crear un árbol binario
        ArbolBinario arbol = new ArbolBinario();

        // Insertar algunos ejemplares
        arbol.Insertar(new Ejemplar(12345, "Java para Principiantes"));
        arbol.Insertar(new Ejemplar(67890, "Algoritmos y Estructuras de Datos"));
        arbol.Insertar(new Ejemplar(11223, "Patrones de Diseño en Java"));

        // Mostrar los ejemplares en orden
        System.out.println("Ejemplares en orden (Inorden):");
        arbol.recorrerInorden();

        // Guardar los ejemplares en un archivo
        String archivo = "ejemplares.txt";
        arbol.guardarEnArchivo(archivo);

        // Crear un nuevo árbol y leer los ejemplares desde el archivo
        ArbolBinario arbolLeido = new ArbolBinario();
        arbolLeido.leerDesdeArchivo(archivo);

        // Mostrar los ejemplares leídos desde el archivo
        System.out.println("\nEjemplares leídos desde el archivo:");
        arbolLeido.recorrerInorden();
        
        System.out.println("buscando ejemplares: \"Java\"");
        List<Ejemplar> res = arbol.buscarPorTitulo("Java");
        for (Ejemplar e : res) {
            System.out.println(e.titulo + e.ISBN);
        }
    }
}
