package com.company;

import java.util.ArrayList;
import java.util.List;

public class PublishingRetailer {
    int ID;
    String name;
    List <IPublishingArtifact> publishingArtifacts;
    List <Country> countries;

    public PublishingRetailer() {
        this.publishingArtifacts = new ArrayList<>();
        this.countries = new ArrayList<>();
    }

    public PublishingRetailer(int ID, String name, List<IPublishingArtifact> publishingArtifacts, List<Country> countries) {
        this.ID = ID;
        this.name = name;
        this.publishingArtifacts = publishingArtifacts;
        this.countries = countries;
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

    public List<IPublishingArtifact> getPublishingArtifacts() {
        return publishingArtifacts;
    }

    public void addPublishingArtifacts(IPublishingArtifact publishingArtifacts) {
        this.publishingArtifacts.add(publishingArtifacts);
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void addCountries(Country countries) {
        this.countries.add(countries);
    }
}
