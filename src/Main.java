import models.*;

import java.util.Scanner;

public class Main {
    public static Biblioteca inventario = new Biblioteca();

    public static Biblioteca getInventario() {
        return inventario;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean salida = true;
        do {
            System.out.println();
            System.out.println("--------------Bienvenido a la Biblioteca---------------");
            System.out.println();
            System.out.println("Seleccione una opción:");
            System.out.println("1. Iniciar sesión como usuario");
            System.out.println("2. Iniciar sesión como bibliotecario");
            System.out.println("3. Salir");

            int opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion){
                case 1:
                    boolean salidaUsuario = true;
                    do {
                        System.out.println("----------Bienvenido usuario----------");
                        System.out.println("1. Registrarse");
                        System.out.println("2. Iniciar sesión");
                        System.out.println("3. Volver");
                        System.out.println("Seleccione");

                        int seleccion = entrada.nextInt();
                        entrada.nextLine();

                        switch (seleccion) {
                            case 1:
                                System.out.println("------------------------------------------------");
                                System.out.println("Agregue nombre de usuario: ");
                                String nameUser = entrada.nextLine();
                                System.out.println("Agregue contraseña: ");
                                String contra = entrada.nextLine();
                                Usuario nuevoUsuario = new Usuario(nameUser, contra);

                                boolean usuarioExistente = false;
                                for (Usuario usuario : getInventario().getListaUsuarios()) {
                                    if (nameUser.equals(usuario.getNameUser())) {
                                        System.out.println("No se permite agregar usuarios repetidos.");
                                        usuarioExistente = true;
                                        break;
                                    }
                                }
                                if (!usuarioExistente) {
                                    getInventario().agregarUsuario(nuevoUsuario);
                                    System.out.println("Usuario añadido correctamente.");
                                    System.out.println("------------------------------------------------");
                                }
                                break;
                            case 2:
                                System.out.println("-------------------------------------------------");
                                System.out.println("Ingrese nombre de usuario: ");
                                String usuario = entrada.nextLine();
                                System.out.println("Ingrese contraseña: ");
                                String password = entrada.nextLine();
                                boolean usuarioValido = false;
                                for (Usuario usuario1 : inventario.getListaUsuarios()) {
                                    if (usuario1.getNameUser().equals(usuario) && usuario1.getContraUser().equals(password)) {
                                        usuarioValido = true;
                                        System.out.println("¡Bienvenido " + usuario+"!");
                                        System.out.println("El día de hoy le presentamos los siguientes libros: ");
                                        int t=0;
                                        for (Libro recorrerLibros : getInventario().getListaLibros()) {
                                            System.out.println((t+1)+recorrerLibros.getNombreLibro());
                                            t++;
                                        }
                                    }
                                }
                                if (!usuarioValido) {
                                    System.out.println("Usuario no válido o no existente.");
                                }
                                break;
                            case 3:
                                // Volver al menú principal
                                System.out.println("Volviendo al menú principal.....");
                                salidaUsuario = false;
                                break;
                        }
                    } while (salidaUsuario);
                    break;
                case 2:
                    Usuario bibliotecario=new Usuario("biblio","biblio123");
                    getInventario().agregarUsuario(bibliotecario);
                    System.out.println("__________________________________________-");
                    System.out.println("Iniciar sesión como bibliotecario: ");
                    System.out.println("Ingrese su usuario: ");
                    String nameAdmin = entrada.nextLine();
                    System.out.println("Ingrese su contraseña: ");
                    String passwordAdmin = entrada.nextLine();
                    boolean bibliotecarioValido = false;
                    if (bibliotecario.getNameUser().equals(nameAdmin) && bibliotecario.getContraUser().equals(passwordAdmin)) {
                        bibliotecarioValido = true;

                        boolean salidaBibliotecario = true;
                        System.out.println("------Bienvenido------");
                        do {
                            // Opciones para el bibliotecario
                            System.out.println("¿Qué desea hacer hoy?");
                            System.out.println("1. Agregar libros/dar de alta.");
                            System.out.println("2. Imprimir inventario de libros.");
                            System.out.println("3. Registrar préstamo de libros.");
                            System.out.println("4. Imprimir lista de libros prestados.");
                            System.out.println("5. Registrar devolución de libros.");
                            System.out.println("6. Imprimir lista de libros devueltos.");
                            System.out.println("7. Volver al menú principal.");

                            int seleccion = entrada.nextInt();
                            entrada.nextLine();
                            switch (seleccion) {
                                case 1:
                                    // Agregar libros al inventario
                                    boolean salidaAgregarLibros = true;
                                    do {
                                        System.out.println("Ingrese los datos del libro: ");
                                        System.out.println("Ingrese el título: ");
                                        String title = entrada.nextLine();
                                        System.out.println("Ingrese la editorial: ");
                                        String editorial = entrada.nextLine();
                                        System.out.println("Ingrese el autor: ");
                                        String autor = entrada.nextLine();

                                        boolean libroExistente = false;
                                        for (Libro libro : getInventario().getListaLibros()) {
                                            if (libro.getNombreLibro().equalsIgnoreCase(title)
                                                    && libro.getEditorial().equalsIgnoreCase(editorial)
                                                    && libro.getNombreAutor().equalsIgnoreCase(autor)) {
                                                libroExistente = true;
                                                break;
                                            }
                                        }

                                        if (libroExistente) {
                                            System.out.println("Este libro ya está en el inventario. No se permiten libros duplicados.");
                                        } else {

                                            Libro nuevoLibro = new Libro(title, editorial, autor);
                                            getInventario().agregarLibro(nuevoLibro);
                                            System.out.println("¡El libro se ha agregado exitosamente!");
                                        }

                                        System.out.println("¿Desea agregar otro libro? (s/n)");
                                        String respuesta = entrada.nextLine();
                                        if (respuesta.equalsIgnoreCase("n")) {
                                            System.out.println("Volviendo al menú del bibliotecario...");
                                            salidaAgregarLibros = false;
                                            System.out.println();
                                        }
                                    } while (salidaAgregarLibros);
                                    break;
                                case 2:
                                    System.out.println("Inventario: ");

                                    int i = 0;
                                    for (Libro librosEnBiblioteca : getInventario().getListaLibros()){
                                        System.out.println((i+1) + ".-"+ librosEnBiblioteca.getNombreLibro());
                                        i++;
                                    }
                                    System.out.println();
                                    System.out.println();
                                    break;
                                case 3:
                                    boolean salidaPrestamoLibros = true;
                                    System.out.println("Ingrese el nombre del prestatario: ");
                                    String nameUser = entrada.nextLine();
                                    do {
                                        System.out.println("Ingrese el título del libro a solicitar: ");
                                        String nameBook = entrada.nextLine();

                                        Usuario usuarioPrestamo = null;
                                        for (Usuario usuario : inventario.getListaUsuarios()) {
                                            if (usuario.getNameUser().equals(nameUser)) {
                                                usuarioPrestamo = usuario;
                                            }
                                        }
                                        Libro libroPrestamo = null;
                                        for (Libro libro : getInventario().getListaLibros()) {
                                            if (libro.getNombreLibro().equals(nameBook)) {
                                                libroPrestamo = libro;
                                                break;
                                            }
                                        }
                                        if (usuarioPrestamo != null && libroPrestamo != null) {
                                            Prestamo libroPrestado = new Prestamo(nameUser, nameBook);
                                            getInventario().registrarPrestamo(libroPrestado);
                                            getInventario().getListaLibros().remove(libroPrestado);
                                            System.out.println("¡Préstamo registrado con éxito!");
                                        } else {
                                            System.out.println("No hay libros disponibles");
                                        }
                                        System.out.println("¿Desea solicitar otro libro? s/n");
                                        String respuesta = entrada.nextLine();
                                        if (respuesta.equalsIgnoreCase("n")) {
                                            System.out.println("¡Gracias por su preferencia!");
                                            salidaPrestamoLibros = false;
                                        }
                                    } while (salidaPrestamoLibros);
                                    break;
                                case 4:
                                    int k = 0;
                                    System.out.println("Los libros prestados son: ");
                                    for (Prestamo recorridoLibrosPrestados : getInventario().getRegistroLibrosSolicitados()) {
                                        System.out.println((k + 1) + ". " + recorridoLibrosPrestados.getNameBook());
                                        k++;
                                    }
                                    System.out.println();
                                    System.out.println();
                                    break;
                                case 5:
                                    boolean salidaDevolverLibro = true;
                                    System.out.println("Ingrese el nombre del usuario que prestó el libro:");
                                    String nameUsersoli = entrada.nextLine();
                                    do {
                                        System.out.println("Título del libro a devolver");
                                        String tituloBook = entrada.nextLine();

                                        Prestamo prestamoDevolucion = null;
                                        for (Prestamo prestamo : getInventario().getRegistroLibrosSolicitados()) {
                                            if (prestamo.getNameUser().equals(nameUsersoli) && prestamo.getNameBook().equals(tituloBook)) {
                                                prestamoDevolucion = prestamo;
                                                break;
                                            }
                                        }

                                        if (prestamoDevolucion != null) {
                                            getInventario().getRegistroLibrosSolicitados().remove(prestamoDevolucion);
                                            Libro libroDevolucion = null;
                                            for (Libro libro : getInventario().getListaLibros()) {
                                                if (libro.getNombreLibro().equals(tituloBook)) {
                                                    libroDevolucion = libro;
                                                    break;
                                                }
                                            }
                                            boolean libroEncontrado = false;
                                            for (Libro libro : getInventario().getListaLibros()) {
                                                if (libro.getNombreLibro().equals(tituloBook)) {
                                                    libroEncontrado = true;
                                                    break;
                                                }
                                            }
                                            if (!libroEncontrado) {
                                                libroDevolucion = new Libro(tituloBook, "", "");
                                                getInventario().getListaLibros().add(libroDevolucion);
                                            }


                                            // Agregar el libro a la lista de devolución
                                            getInventario().getRegistroLibrosDevueltos().add(prestamoDevolucion);

                                            System.out.println("Devolución registrada con éxito.");
                                        } else {
                                            System.out.println("No se encontró el préstamo.");
                                        }
                                        System.out.println("¿Desea devolver otro libro? s/n");
                                        String resDevolver = entrada.nextLine();
                                        if (resDevolver.equalsIgnoreCase("n")) {
                                            salidaDevolverLibro = false;
                                        }
                                    } while (salidaDevolverLibro);
                                    break;
                                case 6:
                                    int j = 0;
                                    System.out.println("Los libros devueltos son:");
                                    for (Prestamo recorridoLibrosDevueltos : getInventario().getRegistroLibrosDevueltos()) {
                                        System.out.println((j + 1) + ". " + recorridoLibrosDevueltos.getNameBook());
                                        j++;
                                    }
                                    System.out.println();
                                    break;
                                case 7:
                                    System.out.println("Saliendo al menú principal....");
                                    salidaBibliotecario= false;
                                    break;
                            }
                        } while (salidaBibliotecario);
                    } else if (!bibliotecarioValido) {
                        System.out.println("Usuario o contraseña inválida. Vuelva a intentarlo");
                    }
                    break;
                case 3:
                    // Salir del programa
                    System.out.println("Gracias por visitar la Biblioteca. ¡Hasta luego!");
                    salida = false;
                    break;
            }
        } while (salida);


    }
}









