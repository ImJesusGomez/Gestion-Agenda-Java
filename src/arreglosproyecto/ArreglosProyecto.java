package arreglosproyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArreglosProyecto {

    public static void main(String[] args) throws IOException {

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        // Declaramos el arreglo que usaremos
        String[] listaContactos = new String[10];
        int contactosRegistrados = 0, cantContactos = 0;

        // Usamos un ciclo while que sea el menú de acciones y termine hasta que el usuario desea salir
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("Menu de Opciones: \n1. Agregar Contactos\n2. Ver Contactos\n3. Buscar Contacto por nombre\n4. Editar Contacto\n5. Eliminar Contacto\n6. Salir\nOpcion: ");
            opcion = Integer.parseInt(teclado.readLine());

            switch (opcion) {
                // Agregar contactos
                case 1:
                    System.out.println(" --- AGREGAR CONTACTOS --- ");
                    System.out.println("Cuantos contactos deseas agregar?");
                    cantContactos = Integer.parseInt(teclado.readLine());

                    if (cantContactos + contactosRegistrados > 12) {
                        System.out.println("Limite de contactos sobrepasado. Limite - 12. Contactos Registrados: " + contactosRegistrados);
                    } else {
                        System.out.println("Escribe Nombre y Numero (EJEMPLO: Luis 4423567891)");
                        for (int i = 0; i < cantContactos; i++) {
                            String contacto = teclado.readLine();
                            listaContactos[contactosRegistrados] = contacto;
                            contactosRegistrados += 1;
                        }
                    }
                    break;
                // Ver Contactos
                case 2:
                    System.out.println(" --- LISTA DE CONTACTOS --- ");

                    // ordenamos alfabeticamente la lista de contactos
                    int total = contactosRegistrados;
                    for (int i = 0; i < total; i++) {
                        for (int j = 0; j < total - 1 - i; j++) {
                            if (((Comparable) listaContactos[j + 1]).compareTo(listaContactos[j]) < 0) {
                                String auxiliar = listaContactos[j];
                                listaContactos[j] = listaContactos[j + 1];
                                listaContactos[j + 1] = auxiliar;
                            }
                        }
                    }

                    // Imprimimos la lista de contactos
                    for (int i = 0; i < listaContactos.length; i++) {
                        System.out.println((i + 1) + ": " + listaContactos[i]);
                    }

                    System.out.println();
                    break;
                // Buscar contacto
                case 3:
                    System.out.println("Introduce el nombre: ");
                    String nombreContacto = teclado.readLine();
                    String nombre = "";
                    String numero = "";
                    total = contactosRegistrados;

                    boolean contactoEncontrado = false;
                    for (int i = 0; i < total; i++) {
                        String[] partes = listaContactos[i].split(" ");

                        if (partes[0].equalsIgnoreCase(nombreContacto)) {
                            contactoEncontrado = true;
                            nombre = partes[0];
                            numero = partes[1];
                            break;
                        } else {
                            contactoEncontrado = false;

                        }
                    }

                    if (contactoEncontrado) {
                        System.out.println("\nContacto Encontrado!!");
                        System.out.println("Nombre: " + nombre + "\nTelefono: " + numero);
                    } else {
                        System.out.println("\nContacto NO Encontrado!!");
                    }

                    System.out.println();

                    break;
                // Editar contacto
                case 4:
                    System.out.println("Introduce el nombre: ");
                    nombreContacto = teclado.readLine();
                    contactoEncontrado = false;
                    int posicionContacto = 0;
                    total = contactosRegistrados;
                    
                    for (int i = 0; i < total; i++) {
                        String[] partes = listaContactos[i].split(" ");

                        if (partes[0].equalsIgnoreCase(nombreContacto)) {
                            posicionContacto = i;
                            contactoEncontrado = true;
                            break;
                        } else {
                            contactoEncontrado = false;

                        }
                    }

                    if (contactoEncontrado) {
                        System.out.println("\nContacto Encontrado!!");
                        System.out.println("Ingresa los nuevos datos: ");
                        listaContactos[posicionContacto] = teclado.readLine();
                    } else {
                        System.out.println("\nContacto NO Encontrado!!");
                    }

                    System.out.println();

                    break;

            }
        }
    }

}
