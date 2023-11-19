package vk.kirisaki.libraryAPI.models;

public class Author extends User {
    private final Integer id;
    public Author(String name, String reference, Sex sex) {
        super(name, reference, sex);
        this.id = null;
    }

    public Author(String name, String reference, Sex sex, Integer id) {
        super(name, reference, sex);
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
