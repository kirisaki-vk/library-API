package vk.kirisaki.libraryAPI.models;

import java.sql.Date;

public class CrupdateBook {
    private String name;
    private Integer pageNumbers;
    private Date releaseDate;

    public CrupdateBook(String name, Integer pageNumbers, Date releaseDate) {
        this.name = name;
        this.pageNumbers = pageNumbers;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "CrupdateBook{" +
                "name='" + name + '\'' +
                ", pageNumbers=" + pageNumbers +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
