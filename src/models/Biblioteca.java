package models;

import java.util.ArrayList;

public class Biblioteca {
 private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
 private ArrayList <Libro> listaLibros = new ArrayList<>();
private ArrayList<Prestamo> registroLibrosSolicitados = new ArrayList<>();
private ArrayList<Prestamo> registroLibrosDevueltos = new ArrayList<>();



 public void agregarUsuario(Usuario usuario) {
  listaUsuarios.add(usuario);
 }

 public void agregarLibro(Libro libro) {
  listaLibros.add(libro);
 }


 public void registrarPrestamo(Prestamo prestamo) {
  registroLibrosSolicitados.add(prestamo);
 }

 public void registrarDevolucion(Prestamo prestamo) {
  registroLibrosDevueltos.add(prestamo);
 }

 public ArrayList<Usuario> getListaUsuarios() {
  return listaUsuarios;
 }

 public ArrayList<Libro> getListaLibros() {
  return listaLibros;
 }

 public ArrayList<Prestamo> getRegistroLibrosSolicitados() {
  return registroLibrosSolicitados;
 }

 public ArrayList<Prestamo> getRegistroLibrosDevueltos() {
  return registroLibrosDevueltos;
 }
}
