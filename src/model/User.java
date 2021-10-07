package model;
//clase abstracta
public abstract class User {
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "\nUsuario" +
                "\nId: " + id +
                "\nNombre: " + name +
                "\nEmail: " + email +
                "\nDirección: " + address  +
                "\nNumero de celular: " + phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length()>10){
            System.out.println("El numero telefonico debe ser de 10 digitos maximo");
        }else  if(phoneNumber.length()==10){
            this.phoneNumber = phoneNumber;
        }

    }
    //metodo abstracto
    public abstract void showDataUser();
}
