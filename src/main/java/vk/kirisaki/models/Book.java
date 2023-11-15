package vk.kirisaki.models;

import java.sql.Date;
import java.util.UUID;

public class Book {
    private final UUID id = UUID.randomUUID();
    private String title;
    private Integer page;
    private Date releaseDate;
    private final Author author;
    private Topic topic;
    private Boolean available;

    public Book(String title, Integer page, Date releaseDate, Author author, Topic topic) {
        this.title = title;
        this.page = page;
        this.releaseDate = releaseDate;
        this.author = author;
        this.topic = topic;
        this.available = true;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Author getAuthor() {
        return author;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}