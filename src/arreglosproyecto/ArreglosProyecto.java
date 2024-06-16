package arreglosproyecto;

import java.util.Scanner;

public class ArreglosProyecto {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Declaramos el arreglo que usaremos
        String[] listaContactos = new String[10];
        int contactosRegistrados = 0;

        // Usamos un ciclo while que sea el menú de acciones y termine hasta que el usuario desea salir
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("Menu de Opciones: \n1. Agregar Contactos\n2. Ver Contactos\n3. Buscar Contacto por nombre\n4. Editar Contacto\n5. Eliminar Contacto\n6. Salir\nOpcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(" --- AGREGAR CONTACTOS --- ");
                    System.out.println("Cuantos contactos deseas agregar?");
                    int cantContactos = teclado.nextInt();

                    if (cantContactos + contactosRegistrados > 12) {
                        System.out.println("Limite de contactos sobrepasado. Limite - 12. Contactos Registrados: " + contactosRegistrados);
                    } else {
                        System.out.println("Escribe Nombre y Numero (EJEMPLO:Luis 4423567891)");
                        for (int i = contactosRegistrados; i < cantContactos; i++) {
                            String contacto = teclado.next();
                            listaContactos[i] = contacto;

                        }
                        contactosRegistrados += cantContactos;
                    }
                    break;

            }
        }
    }

}
