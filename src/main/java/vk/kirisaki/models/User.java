package vk.kirisaki.models;

import java.util.UUID;

public class User {
    final UUID id = UUID.randomUUID();
    private String name;
    private String reference;
    private final Sex sex;

    public User(String name, String reference, Sex sex) {
        this.name = name;
        this.reference = reference;
        this.sex = sex;
    }

    public UUID getId() {
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
