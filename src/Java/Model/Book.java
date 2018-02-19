package Java.Model;


public class Book{

    private int isbn;
    private String author;
    private String title;
    private String publisher;
    private int publication_year;
    private int price;
    private int type;

    public Book(int isbn, String author, String title, String publisher, int publication_year, int price, int type){
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.publication_year = publication_year;
        this.price = price;
        this.type = type;
    }

    public int getISBN(){
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

    public int price(){
        return this.price;
    }

    public int getType(){
        return this.type;
    }

    @Override
    public String toString(){
        return String.format("ISBN: %d, AUTHOR: %s, TITLE: %s, PUBLISHER: %s, PUBLICATION_YEAR: %d, PRICE: %d, TYPE: %d",
        this.isbn, this.author, this.title, this.publisher, this.publication_year, this.price, this.type);
    }
}
