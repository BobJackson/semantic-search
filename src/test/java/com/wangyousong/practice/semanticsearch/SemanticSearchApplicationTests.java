package com.wangyousong.practice.semanticsearch;

import com.wangyousong.practice.semanticsearch.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SemanticSearchApplicationTests {

    @Autowired
    VectorStore vectorStore;

    @Test
    void contextLoads() {
        run();
    }

    void run() {
        var books = List.of(
                new Book("The Great Gatsby", "F. Scott Fitzgerald", "The Great Gatsby is a 1925 novel by American writer F. Scott Fitzgerald. Set in the Jazz Age on Long Island, near New York City, the novel depicts first-person narrator Nick Carraway's interactions with mysterious millionaire Jay Gatsby and Gatsby's obsession to reunite with his former lover, Daisy Buchanan."),
                new Book("To Kill a Mockingbird", "Harper Lee", "To Kill a Mockingbird is a novel by the American author Harper Lee. It was published in 1960 and was instantly successful. In the United States, it is widely read in high schools and middle schools."),
                new Book("1984", "George Orwell", "Nineteen Eighty-Four: A Novel, often referred to as 1984, is a dystopian social science fiction novel by the English novelist George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime."),
                new Book("The Catcher in the Rye", "J. D. Salinger", "The Catcher in the Rye is a novel by J. D. Salinger, partially published in serial form in 1945–1946 and as a novel in 1951. It was originally intended for adults but is often read by adolescents for its themes of angst, alienation, and as a critique on superficiality in society."),
                new Book("Lord of the Flies", "William Golding", "Lord of the Flies is a 1954 novel by Nobel Prize-winning British author William Golding. The book focuses on a group of British")
        );

        List<Document> documents = books.stream()
                .map(book -> new Document(book.toString()))
                .toList();

        vectorStore.add(documents);
    }

}
