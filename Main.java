package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List <Book> bookList = new ArrayList<Book>();
        List <Author> authorList = new ArrayList<Author>();
        List <EditorialGroup> editorialGroupList = new ArrayList<EditorialGroup>();
        List <PublishingBrand> publishingBrandList = new ArrayList<PublishingBrand>();
        List <PublishingRetailer> publishingRetailerList = new ArrayList<PublishingRetailer>();
        List <Country> countryList = new ArrayList<Country>();
        List <Language> languageList= new ArrayList<Language>();


        try (BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\init\\books.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                Book x = new Book();
                String[] vec = line.split("###");
                //returneaza un sir de string uri
                x.setID(Integer.parseInt(vec[0]));//transforma un string in int
                x.setName(vec[1]);
                x.setSubtitle(vec[2]);
                x.setISBN(vec[3]);
                x.setPageCount(Integer.parseInt(vec[4]));
                for(String s:vec[5].split("; "))
                    x.addKeywords(s);
                x.setLanguageID(Integer.parseInt(vec[6]));
                x.setCreatedOn( (new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")).parse(vec[7]));
                bookList.add(x);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\init\\authors.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                Author y = new Author();
                String[] vec = line.split("###");
                //returneaza un sir de string uri
                y.setID(Integer.parseInt(vec[0]));//transforma un string in int
                y.setFirstName(vec[1]);
                y.setLastName(vec[2]);
                authorList.add(y);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\init\\languages.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                Language z = new Language();
                String[] vec = line.split("###");
                z.setID(Integer.parseInt(vec[0]));
                z.setCode(vec[1]);
                z.setName(vec[2]);
                languageList.add(z);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\init\\books-authors.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {

                Book z = new Book();
                Author d = new Author();
                String[] vec = line.split("###");
                for(Book aux : bookList)
                {
                    if(aux.getID() == Integer.parseInt(vec[0]))
                    {
                        z=aux;
                        break;
                    }
                }
                for(Author aux2 : authorList)
                {
                    if(aux2.getID() == Integer.parseInt(vec[1]))
                    {
                        d=aux2;
                        break;
                    }
                }
                z.addAuthors(d);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\init\\countries.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                Country w = new Country();
                String[] vec = line.split("###");
                w.setID(Integer.parseInt(vec[0]));
                w.setCountryCode(vec[1]);
                countryList.add(w);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\init\\editorial-groups.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                EditorialGroup f = new EditorialGroup();
                String[] vec = line.split("###");
                f.setID(Integer.parseInt(vec[0]));
                f.setName(vec[1]);
                editorialGroupList.add(f);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\init\\publishing-brands.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                PublishingBrand pb = new PublishingBrand();
                String[] vec = line.split("###");
                pb.setID(Integer.parseInt(vec[0]));
                pb.setName(vec[1]);
                publishingBrandList.add(pb);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\init\\publishing-retailers.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                PublishingRetailer pr = new PublishingRetailer();
                String[] vec = line.split("###");
                pr.setID(Integer.parseInt(vec[0]));
                pr.setName(vec[1]);
                publishingRetailerList.add(pr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\init\\editorial-groups-books.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                EditorialGroup q = new EditorialGroup();
                Book w = new Book();
                String[] vec = line.split("###");
                for(EditorialGroup aux2 : editorialGroupList)
                {
                    if(aux2.getID() == Integer.parseInt(vec[0]))
                    {
                        q=aux2;
                        break;
                    }
                }
                for(Book aux : bookList)
                {
                    if(aux.getID() == Integer.parseInt(vec[1]))
                    {
                        w = aux;
                        break;
                    }
                }
                q.addBooks(w);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\init\\publishing-brands-books.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                PublishingBrand i = new PublishingBrand();
                Book w = new Book();
                String[] vec = line.split("###");
                for(PublishingBrand aux2 : publishingBrandList)
                {
                    if(aux2.getID() == Integer.parseInt(vec[0]))
                    {
                        i = aux2;
                        break;
                    }
                }
                for(Book aux : bookList)
                {
                    if(aux.getID() == Integer.parseInt(vec[1]))
                    {
                        w = aux;
                        break;
                    }
                }
                i.addBooks(w);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\init\\publishing-retailers-books.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
               PublishingRetailer k = new PublishingRetailer();
                Book w = new Book();
                String[] vec = line.split("###");
                for(PublishingRetailer aux2 : publishingRetailerList)
                {
                    if(aux2.getID() == Integer.parseInt(vec[0]))
                    {
                        k = aux2;
                        break;
                    }
                }
                for(Book aux : bookList)
                {
                    if(aux.getID() == Integer.parseInt(vec[1]))
                    {
                        w = aux;
                        break;
                    }
                }

                k.addPublishingArtifacts(w);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\init\\publishing-retailers-countries.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                PublishingRetailer p1 = new PublishingRetailer();
                Country c1 = new Country();
                String[] vec = line.split("###");
                for(PublishingRetailer aux2 : publishingRetailerList)
                {
                    if(aux2.getID() == Integer.parseInt(vec[0]))
                    {
                        p1 = aux2;
                        break;
                    }
                }
                for(Country aux : countryList)
                {
                    if(aux.getID() == Integer.parseInt(vec[1]))
                    {
                        c1 = aux;
                        break;
                    }
                }
                p1.addCountries(c1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\init\\publishing-retailers-editorial-groups.in"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                PublishingRetailer p1 = new PublishingRetailer();
                EditorialGroup edg = new EditorialGroup();
                String[] vec = line.split("###");
                for(PublishingRetailer aux2 : publishingRetailerList)
                {
                    if(aux2.getID() == Integer.parseInt(vec[0]))
                    {
                        p1 = aux2;
                        break;
                    }
                }
                for(EditorialGroup aux : editorialGroupList)
                {
                    if(aux.getID() == Integer.parseInt(vec[1]))
                    {
                        edg = aux;
                        break;
                    }
                }
                p1.addPublishingArtifacts(edg);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\init\\publishing-retailers-publishing-brands.in"))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {

                PublishingRetailer p1 = new PublishingRetailer();
                PublishingBrand pb1 = new PublishingBrand();
                String[] vec = line.split("###");
                for(PublishingRetailer aux2 : publishingRetailerList)
                {
                    if(aux2.getID() == Integer.parseInt(vec[0]))
                    {
                        p1 = aux2;
                        break;
                    }
                }
                for(PublishingBrand aux : publishingBrandList)
                {
                    if(aux.getID() == Integer.parseInt(vec[1]))
                    {
                        pb1 = aux;
                        break;
                    }
                }
                p1.addPublishingArtifacts(pb1);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
     public static List<Book> getBooksForPublishingRetailerID(int prID, List<PublishingRetailer> publishingRetailers){
         List <Book> bookList = new ArrayList<Book>();
         PublishingRetailer retailer=null;
        for (PublishingRetailer publishingRetailer : publishingRetailers )
                if (publishingRetailer.getID() == prID)
                {
                    retailer = publishingRetailer;
                    break;
                }
        for (IPublishingArtifact iPublishingArtifact : retailer.getPublishingArtifacts())
        { if(iPublishingArtifact instanceof  Book)
            {
                if(bookList.stream().filter(orice -> orice.getID() == ((Book)iPublishingArtifact).getID()).findAny().isPresent() == false)
                  bookList.add((Book)iPublishingArtifact);
            }
            if(iPublishingArtifact instanceof EditorialGroup)
            {
                for(Book b1 : ((EditorialGroup)iPublishingArtifact).getBooks())
                {   if(bookList.stream().filter(orice1 -> orice1.getID() == ((EditorialGroup)iPublishingArtifact).getID()).findAny().isPresent() == false)
                        bookList.add(b1);
                }
            }
            if(iPublishingArtifact instanceof PublishingBrand)
            {
                for(Book b2 : ((PublishingBrand)iPublishingArtifact).getBooks())
                {
                    if(bookList.stream().filter(orice2 -> orice2.getID() == ((PublishingBrand)iPublishingArtifact).getID()).findAny().isPresent() == false)
                            bookList.add(b2);
                }
            }
        }

        return  bookList;
     }

     public static List <Country> getCountriesForBookID(int id_book,List <PublishingRetailer> retailers)
     {
         List <Country> countries = new ArrayList<>();
         for(PublishingRetailer retailer : retailers)
             for(IPublishingArtifact artifact : retailer.getPublishingArtifacts())
             {
                if(artifact instanceof Book && ((Book)artifact).getID() == id_book)
                {
                    for(Country country : retailer.getCountries())
                        if(countries.stream().filter(orice3 -> orice3.getID() == country.getID()).findAny().isPresent() == false)
                            countries.add(country);
                }
                 if(artifact instanceof EditorialGroup)
                 {
                     for(Book b3 : ((EditorialGroup)artifact).getBooks())
                        if(b3.getID()==id_book)
                            for(Country country : retailer.getCountries())
                                if(countries.stream().filter(orice4 -> orice4.getID() == country.getID()).findAny().isPresent() == false)
                                    countries.add(country);
                 }
                 if(artifact instanceof PublishingBrand)
                 {
                     for(Book b3 : ((EditorialGroup)artifact).getBooks())
                         if(b3.getID()==id_book)
                             for(Country country : retailer.getCountries())
                                 if(countries.stream().filter(orice4 -> orice4.getID() == country.getID()).findAny().isPresent() == false)
                                     countries.add(country);
                 }
             }
         return countries;
     }



public static List<Book>getCommonBooksForRetailerIDs(int prId1,int prId2, List<PublishingRetailer> publishingRetailers){
        List<Book> commonbooks = new ArrayList<>();
        List<Book>books1 = getBooksForPublishingRetailerID(prId1,publishingRetailers);
        List<Book>books2 = getBooksForPublishingRetailerID(prId2,publishingRetailers);

        for(Book lb1 : books1)
        {
            for(Book lb2 : books2)
            {
                if(lb1.getID() == lb2.getID())
                    commonbooks.add(lb1);
            }
        }

        return  commonbooks;
}

public  static  List<Book>getAllBooksForRetailerIDs(int prId1,int prId2,List<PublishingRetailer> publishingRetailers){
        List <Book>allbooks = new ArrayList<>();
        List<Book>books1 = getBooksForPublishingRetailerID(prId1,publishingRetailers);
        List<Book>books2 = getBooksForPublishingRetailerID(prId2,publishingRetailers);

        allbooks.addAll(books1);
        allbooks.addAll(books2);
        allbooks = allbooks.stream().distinct().collect(Collectors.toList());//elimina cartile la fel

        return allbooks;
}

public static List <Integer>getLanguagesForPublishingRetailerID(int prID,List<PublishingRetailer> publishingRetailers){
        List <Integer> languages = new ArrayList<>();
        PublishingRetailer retailer=null;
    for (PublishingRetailer publishingRetailer : publishingRetailers )
        if (publishingRetailer.getID() == prID)
        {
            retailer = publishingRetailer;
            break;
        }
    for (IPublishingArtifact iPublishingArtifact : retailer.getPublishingArtifacts())
    { if(iPublishingArtifact instanceof  Book)
        {
            if(languages.stream().filter(orice ->orice == ((Book)iPublishingArtifact).getLanguageID()).findAny().isPresent() == false)
                languages.add(((Book)iPublishingArtifact).getLanguageID());
         }
        if(iPublishingArtifact instanceof EditorialGroup)
        {
            for(Book b1 : ((EditorialGroup)iPublishingArtifact).getBooks())
            {   if(languages.stream().filter(orice1 -> orice1 == (b1.getLanguageID())).findAny().isPresent() == false)
                languages.add(b1.getLanguageID());
            }
        }
        if(iPublishingArtifact instanceof PublishingBrand)
        {
            for(Book b2 : ((PublishingBrand)iPublishingArtifact).getBooks())
            {
                if(languages.stream().filter(orice2 -> orice2 == b2.getLanguageID()).findAny().isPresent() == false)
                    languages.add(b2.getLanguageID());
            }
        }
    }



        return languages;
}



}
