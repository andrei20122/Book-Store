package com.company;

import java.util.ArrayList;
import java.util.List;

public class PublishingBrand implements IPublishingArtifact {
    int ID;
    String name;
    List <Book> books;

    @Override
    public String Publish() {
        String s = "";

        s += "<xml>\n";
        s +="\t <publishingBrand>\n";
        s +="\t\t<ID>" + ID + "</ID>\n";
        s +="\t\t<Name>" + name + "</Name>\n";
        s +="\t</editorialGroup>\n";
        s +="\t<books>\n";
        for(Book book : books)
        {
            s +="\t\t<book>\n";
            s +="\t\t\t<title>" + book.getName() + "</title>\n";
            s +="\t\t\t<subtitle>" + book.getSubtitle() + "</subtitle>\n";
            s +="\t\t\t<isbn>" + book.getISBN() + "</isbn>\n";
            s +="\t\t\t<pageCount>" + book.getPageCount() + "</pageCount>\n";
            s +="\t\t\t<keywords>" + book.getKeywords() + "</keywords>\n";
            s +="\t\t\t<languageID>" + book.getLanguageID() + "</languageID>\n";
            s +="\t\t\t<createdOn>" + book.getCreatedOn() + "</createdOn>\n";
            s += "\t\t\t<authors>" + book.getAuthors() + "</authors>\n";
            s += "\t\t</book>\n";
        }
        s += "\t</books>\n";
        s += "</xml>\n";

        return s;
    }

    public PublishingBrand() {
        this.books = new ArrayList<Book>();
    }

    public PublishingBrand(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.books = new ArrayList<Book>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBooks(Book books) {
        this.books.add(books);
    }
}
