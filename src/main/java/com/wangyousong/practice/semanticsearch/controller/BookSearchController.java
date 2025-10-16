package com.wangyousong.practice.semanticsearch.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/books")
@RestController
class BookSearchController {
    final VectorStore vectorStore;
    final ChatClient chatClient;

    BookSearchController(VectorStore vectorStore, ChatClient.Builder chatClientBuilder) {
        this.vectorStore = vectorStore;
        this.chatClient = chatClientBuilder.build();
    }

    @PostMapping("/search")
    List<String> semanticSearch(@RequestBody String query) {
        return vectorStore.similaritySearch(SearchRequest.builder()
                        .query(query)
                        .topK(3)
                        .build())
                .stream()
                .map(Document::getText)
                .toList();
    }
}