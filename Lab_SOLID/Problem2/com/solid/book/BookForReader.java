package com.solid.book;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BookForReader extends Book{
	
	public BookForReader(String title, List<String> pages) {
		super(title, pages);
	}

	public void printToScreen() {
        Book book = this;
        do {
            System.out.println(book.getCurrentPage());
        } while (book.turnToNextPage());
    }
}
