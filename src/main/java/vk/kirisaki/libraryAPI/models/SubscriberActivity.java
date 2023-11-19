package vk.kirisaki.libraryAPI.models;

public class SubscriberActivity {
    final Integer id;
    private final Subsciber subsciber;
    private final Book book;
    private final SubscriberAction action;

    public SubscriberActivity(Subsciber subsciber, Book book, SubscriberAction action) {
        this.id = null;
        this.subsciber = subsciber;
        this.book = book;
        this.action = action;
    }

    public SubscriberActivity(Integer id, Subsciber subsciber, Book book, SubscriberAction action) {
        this.id = id;
        this.subsciber = subsciber;
        this.book = book;
        this.action = action;
    }

    @Override
    public String toString() {
        return "SubscriberActivity{" +
                "id=" + id +
                ", subsciber=" + subsciber +
                ", book=" + book +
                ", action=" + action +
                '}';
    }
}
