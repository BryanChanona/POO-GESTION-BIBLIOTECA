package models;

public class Prestamo {
    private String nameUser;
    private String nameBook;

    public Prestamo(String nameUser, String nameBook) {
        this.nameUser = nameUser;
        this.nameBook = nameBook;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getNameBook() {
        return nameBook;
    }

}
