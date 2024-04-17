package models;

public class Usuario {
    private String nameUser;
    private String contraUser;

    public Usuario(String nameUser, String contraUser) {
        this.nameUser = nameUser;
        this.contraUser = contraUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getContraUser() {
        return contraUser;
    }
}
