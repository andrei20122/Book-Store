package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book implements IPublishingArtifact{
    int ID;
    String name;
    String subtitle;
    int pageCount;
    int languageID;
    String ISBN;
    List <String> keywords;
    Date createdOn;
    List <Author> authors;

    @Override
    public String Publish() {
       String s = "";

        s+= "<xml>\n";
        s += "\t<title>" + name + "</title>\n";
        s +="\t<subtitle>" + subtitle + "</subtitle>\n";
        s +="\t<isbn>" + ISBN + "</isbn>\n";
        s +="\t<pageCount>" + pageCount + "</pageCount>\n";
        s +="\t<keywords>" + keywords + "</keywords>\n";
        s +="\t<languageID>" + languageID + "</languageID>\n";
        s +="\t<createdOn>" + (new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")).format(createdOn) + "</createdOn>\n";
        s +="\t<authors>" + authors + "</authors>\n";
        s +="</xml>\n";

        return  s;
    }

    public Book() {
        this.keywords = new ArrayList<String>();
        this.authors = new ArrayList<Author>();
    }

    public Book(int ID, String name, String subtitle, int pageCount, int languageID, String ISBN, Date createdOn) {
        this.ID = ID;
        this.name = name;
        this.subtitle = subtitle;
        this.pageCount = pageCount;
        this.languageID = languageID;
        this.ISBN = ISBN;
        this.keywords = new ArrayList<String>();
        this.createdOn = createdOn;
        this.authors = new ArrayList<Author>();
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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getLanguageID() {
        return languageID;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void addKeywords(String keywords) {
        this.keywords.add(keywords);
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthors(Author authors) {
        this.authors.add(authors);
    }
}
