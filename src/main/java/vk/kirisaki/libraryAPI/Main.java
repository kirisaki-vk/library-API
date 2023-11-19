package vk.kirisaki.libraryAPI;

import vk.kirisaki.libraryAPI.models.Author;
import vk.kirisaki.libraryAPI.models.Sex;
import vk.kirisaki.libraryAPI.models.SubscriberAction;
import vk.kirisaki.libraryAPI.models.User;
import vk.kirisaki.libraryAPI.repository.AuthorCrudOperations;
import vk.kirisaki.libraryAPI.repository.BookCrudOperations;
import vk.kirisaki.libraryAPI.repository.SubscriberCrudOperations;
import vk.kirisaki.libraryAPI.repository.UserCrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initializing repositories
        BookCrudOperations bookRepo = new BookCrudOperations();
        AuthorCrudOperations authorRepo = new AuthorCrudOperations();
        SubscriberCrudOperations subsRepo = new SubscriberCrudOperations();

        // Author Crud Operations
        System.out.println("=========== Performing author CRUD operations ===========");
        System.out.println("Getting all authors");
        List<Author> queriedAuthors = authorRepo.findAll();

        if(queriedAuthors == null) {
            throw new Error("Failed to query all authors");
        } else {
            System.out.println("SUCCESS");
            System.out.println(queriedAuthors);
        }

        Author toSaveAuthor = new Author("Another", "ATH40004", Sex.MALE);

        System.out.println("Saving Author");
        Author savedAuthor = authorRepo.save(toSaveAuthor);

        if(savedAuthor == null) {
            throw new Error("Failed to insert new Author");
        } else {
            System.out.println("SUCCESS");
            System.out.println(toSaveAuthor);
        }

        System.out.println("Deleting Previously Created Author");
        if(authorRepo.delete(savedAuthor) == null) {
            throw new Error("Failed deleting Author");
        } else {
            System.out.println("SUCCESS");
        }

    }
}