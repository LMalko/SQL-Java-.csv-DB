package Java.Model;


public class Book{

    private String isbn;
    private String author;
    private String title;
    private String publisher;
    private int publication_year;
    private String price;
    private int type;

    public Book(String isbn, String author, String title, String publisher, int publication_year, String price, int type){
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.publication_year = publication_year;
        this.price = price;
        this.type = type;
    }

    public String getISBN(){
        return this.isbn;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getTitle(){
        return this.title;
    }

    public String getPublisher(){
        return this.publisher;
    }

    public int publication_year(){
        return this.publication_year;
    }

    public String price(){
        return this.price;
    }

    public int getType(){
        return this.type;
    }

    @Override
    public String toString(){
        return String.format("ISBN: %s, AUTHOR: %s, TITLE: %s, PUBLISHER: %s, PUBLICATION_YEAR: %d, PRICE: %s, TYPE: %d",
        this.isbn, this.author, this.title, this.publisher, this.publication_year, this.price, this.type);
    }
}
