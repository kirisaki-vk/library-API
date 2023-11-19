package vk.kirisaki.libraryAPI.models;

import java.util.List;

public class Subsciber extends User {
    private final Integer id;
    public Subsciber(String name, String reference, Sex sex) {
        super(name, reference, sex);
        this.id = null;
    }

    public Subsciber(String name, String reference, Sex sex, Integer id) {
        super(name, reference, sex);
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
