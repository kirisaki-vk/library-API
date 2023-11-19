package vk.kirisaki.libraryAPI.models;


public class User {
    private final Integer id;
    private String name;
    private String reference;
    private final Sex sex;

    public User(String name, String reference, Sex sex) {
        this.id = null;
        this.name = name;
        this.reference = reference;
        this.sex = sex;
    }

    public User(String name, Sex sex) {
        this.id = null;
        this.name = name;
        this.sex = sex;
    }

    public User(Integer id, String name, Sex sex) {
        this.id = id;
        this.name = name;
        this.reference = null;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public Sex getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
