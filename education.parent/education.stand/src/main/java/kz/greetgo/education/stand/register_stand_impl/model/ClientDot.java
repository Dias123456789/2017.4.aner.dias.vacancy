package kz.greetgo.education.stand.register_stand_impl.model;


public class ClientDot {
    public String id;
    public String name;
    public String surname;
    public String patr;
    public String age;

    public ClientDot(String id, String name, String surname, String patr, String age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patr = patr;
        this.age = age;
    }

    public ClientDot(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatr() {
        return patr;
    }

    public void setPatr(String patr) {
        this.patr = patr;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
