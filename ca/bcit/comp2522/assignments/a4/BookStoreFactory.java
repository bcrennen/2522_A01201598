package ca.bcit.comp2522.assignments.a4;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Recreate bookstore XML.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public final class BookStoreFactory {
    /***/
    private static BookStoreFactory instance;
    /***/
    private static Document bookstoreDocument;

    private BookStoreFactory() throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder =
                documentBuilderFactory.newDocumentBuilder();
        bookstoreDocument = documentBuilder.newDocument();
    }
    /**
     * Method that load a file.
     *
     * @param fileName is the file name
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @return xmlFile
     * */
    private static Document getDOM(final String fileName) throws
            ParserConfigurationException, IOException, SAXException {

        File xmlFile =
                new File("ca/bcit/comp2522/assignments/a4/bookstore.xml");
        DocumentBuilderFactory factoryBuilder =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoryBuilder.newDocumentBuilder();

        return builder.parse(xmlFile);
    }
    /**
     * Create all the elements and nodes of a book.
     *
     * @param bookObj is the book object.
     * @return book
     * */
    private static Node createBook(final Book bookObj) {
        // <book>
        Element book = bookstoreDocument.createElement("book");
        book.setAttribute("isbn", bookObj.getIsbn());
        book.setAttribute("year", bookObj.getYear());
        book.setAttribute("edition", bookObj.getEdition());
        // <name>
        Element name = bookstoreDocument.createElement("name");
        Node nodeName = bookstoreDocument.createTextNode(bookObj.getBookName());
        name.insertBefore(nodeName, name.getLastChild());
        book.appendChild(name);
        // <description>
        Element description = bookstoreDocument.createElement("description");
        Node nodeDescription =
                bookstoreDocument.createTextNode(bookObj.getBookDescription());
        description.insertBefore(nodeDescription, description.getLastChild());
        book.appendChild(description);
        // <courseapplicability>
        Element courseApplicability =
                bookstoreDocument.createElement("courseapplicability");
        book.appendChild(courseApplicability);
        // <course>
        for (String courseList : bookObj.getCourseLists()) {
            Element course = bookstoreDocument.createElement("course");
            courseApplicability.appendChild(course);
            course.insertBefore(bookstoreDocument.createTextNode(
                    (String) courseList), course.getLastChild());
        }
        // <author>
        for (String authorList : bookObj.getAuthorLists()) {
            Element author = bookstoreDocument.createElement("author");
            String[] strArr = authorList.split(" ");
            author.setAttribute("firstname", strArr[0]);
            author.setAttribute("lastname", strArr[1]);
        }
        // <publisher>
        Element publisher = bookstoreDocument.createElement("publisher");
        publisher.insertBefore(
                bookstoreDocument.createTextNode(
                        bookObj.getPublishers()), publisher.getLastChild());
        book.appendChild(publisher);
        // <price>
        for (String prices : bookObj.getPrice()) {
            Element price = bookstoreDocument.createElement("price");
            String[] priceArr = prices.split(" ");
            price.setAttribute("currency", priceArr[0]);
            price.insertBefore(bookstoreDocument.createTextNode(priceArr[1]),
                    price.getLastChild());
            book.appendChild(price);
        }
        // <stock>
        Stock stockObject = bookObj.getStock();
        Element stock = bookstoreDocument.createElement("stock");
        book.appendChild(stock);
        // <category>
        Element category = bookstoreDocument.createElement("category");
        stock.appendChild(category);
        category.insertBefore(
                bookstoreDocument.createTextNode(
                        stockObject.getCategory()), category.getLastChild());
        // <subcategory>
        if (stockObject.getSubCategory() != null) {
            Element subcategory =
                    bookstoreDocument.createElement("subcategory");
            stock.appendChild(subcategory);
            subcategory.insertBefore(
                    bookstoreDocument.createTextNode(
                            stockObject.getSubCategory()),
                            subcategory.getLastChild());
        }
        // <copiesinstock>
        Element copiesInStock =
                bookstoreDocument.createElement("copiesinstock");
        stock.appendChild(copiesInStock);
        String copiesString =
                Integer.toString((int) stockObject.getCopiesInStock());
        copiesInStock.insertBefore(
                bookstoreDocument.createTextNode(
                        copiesString), copiesInStock.getLastChild());
        // <coverimage>
        Element coverImage = bookstoreDocument.createElement("coverimage");
        coverImage.setAttribute("url", stockObject.getCoverURL());
        stock.appendChild(coverImage);
        // <availability>
        Element availability = bookstoreDocument.createElement("availability");
        availability.setAttribute("days", stockObject.getAvailable());
        stock.appendChild(availability);

        return book;
    }
    /**
     * A book class that contains all the book data.
     * */
    private static final class Book {
        /**isbn number of a book.*/
        private String isbn;
        /**year of a book.*/
        private String year;
        /**edition of a book.*/
        private String edition;
        /**name of a book.*/
        private String bookName;
        /**description of a book.*/
        private String bookDescription;
        /**array list for different courses using a book.*/
        private ArrayList courseLists;
        /**array list for different author of a book.*/
        private ArrayList authorLists;
        /**publisher of a book.*/
        private String publishers;
        /**array list for different price of a book.*/
        private ArrayList price;
        /**stock that contains different data.*/
        private Stock stock;
        /**
         * A constructor for a book data.
         *
         * @param isbnNum is the International Standard Book Number of a book.
         * @param yr is the year of a book.
         * @param ed is the edition of a book.
         * @param name is the name of a book.
         * @param bookDesc is the description of a book.
         * @param courseList is list of courses uses a book.
         * @param authorList is list of authors in a book.
         * @param publisher is the publisher of a book.
         * @param prices is list of prices of a book.
         * @param stocks is additional data of a book.
         * */
        private Book(final String isbnNum, final String yr, final String ed,
                     final String name, final String bookDesc,
                     final ArrayList courseList, final ArrayList authorList,
                     final String publisher, final ArrayList prices,
                     final Stock stocks) {
            isbn = isbnNum;
            year = yr;
            edition = ed;
            bookName = name;
            bookDescription = bookDesc;
            courseLists = courseList;
            authorLists = authorList;
            publishers = publisher;
            price = prices;
            stock = stocks;
        }
        /**
         * Getter for isbn.
         * @return isbn
         * */
        public String getIsbn() {
            return isbn;
        }
        /**
         * Getter for year.
         * @return year
         * */
        public String getYear() {
            return year;
        }
        /**
         * Getter for edition.
         * @return edition
         * */
        public String getEdition() {
            return edition;
        }
        /**
         * Getter for book name.
         * @return bookName
         * */
        public String getBookName() {
            return bookName;
        }
        /**
         * Getter for book description.
         * @return bookDescription
         * */
        public String getBookDescription() {
            return bookDescription;
        }
        /**
         * Getter for course lists.
         * @return courseLists
         * */
        public ArrayList<String> getCourseLists() {
            return courseLists;
        }
        /**
         * Getter for author lists.
         * @return authorLists
         * */
        public ArrayList<String> getAuthorLists() {
            return authorLists;
        }
        /**
         * Getter for publishers.
         * @return publishers
         * */
        public String getPublishers() {
            return publishers;
        }
        /**
         * Getter for prices.
         * @return price
         * */
        public ArrayList<String> getPrice() {
            return price;
        }
        /**
         * Getter for stock.
         * @return stock
         * */
        public Stock getStock() {
            return stock;
        }
    }
    /**
     * A stock class that contains category,
     * copies-in-stock, cover image URL and availability.
     * */
    private static final class Stock {
        /**category of a book stock.*/
        private String category;
        /**subcategory of a book stock.*/
        private String subCategory;
        /**copies in stock of a book stock.*/
        private double copiesInStock;
        /**cover URL of a book stock.*/
        private String coverURL;
        /**availability of a book stock.*/
        private String available;
        /**
         * A constructor for a book stock data.
         *
         * @param cat is the category of a book stock.
         * @param subCate is the subcategory of a book stock.
         * @param stock is the amount left of a book stock.
         * @param url is the cover image URL of a book stock.
         * @param availability is if the book available or not.
         * */
        private Stock(final String cat, final String subCate,
                      final double stock, final String url,
                      final String availability) {
            category = cat;
            subCategory = subCate;
            copiesInStock = stock;
            coverURL = url;
            available = availability;
        }
        /**
         * Getter for category.
         * @return category
         * */
        public String getCategory() {
            return category;
        }
        /**
         * Getter for subcategory.
         * @return subcategory
         * */
        public String getSubCategory() {
            return subCategory;
        }
        /**
         * Getter for copies-in-stock.
         * @return copiesInStock
         * */
        public double getCopiesInStock() {
            return copiesInStock;
        }
        /**
         * Getter for cover image URL.
         * @return coverURL
         * */
        public String getCoverURL() {
            return coverURL;
        }
        /**
         * Getter for availability.
         * @return available
         * */
        public String getAvailable() {
            return available;
        }
    }
    /**
     * A method that assemble three different books.
     * @return bookstoreDocument of three books
     * */
    private static Document assembleBookstore() {
        // The first book.
        ArrayList<String> book1course = new ArrayList<>();
        book1course.add("PSYCH1101");
        ArrayList<String> book1author = new ArrayList<>();
        book1author.add("Carole Wade");
        book1author.add("Carol Tavris");
        ArrayList<String> book1price = new ArrayList<>();
        book1price.add("CAN 110.00");
        Stock book1stock = new Stock(
                "Psychology", null, 10, "./images/psychology-cover.jpg", "1");
        Book book1 = new Book(
                "0321049314", "2000", "6", "Psychology",
                "Introductory level Psychology course book",
                book1course, book1author, "Prentice Hall",
                book1price, book1stock);

        // The second book.
        ArrayList<String> book2course = new ArrayList<>();
        book2course.add("MMSD4670");
        ArrayList<String> book2author = new ArrayList<>();
        book2author.add("Eric Burke");
        ArrayList<String> book2price = new ArrayList<>();
        book2price.add("CAN 59.95");
        book2price.add("US 39.95");
        Stock book2stock = new Stock(
                "Java and XSLT", "Java Programming", 2,
                "./images/java-and-xslt-cover.jpg", "2");
        Book book2 = new Book(
                "0596001436", "2001", "1", "Java and XSLT",
                "Embedding XML Processing Into Java Applications",
                book2course, book2author, "O&amp;Reilly",
                book2price, book2stock);

        // The third book.
        ArrayList<String> book3course = new ArrayList<>();
        book3course.add("MMSD4670");
        book3course.add("MMSD0410");
        book3course.add("MMSD4620");
        ArrayList<String> book3author = new ArrayList<>();
        book3author.add("Priscilla Walmsley");
        ArrayList<String> book3price = new ArrayList<>();
        book3price.add("US 31.49");
        Stock book3stock = new Stock(
                "Technology", "XML Schema", 2,
                "./images/xml-schema-cover-.jpg", "4");
        Book book3 = new Book(
                "0130655678", "2001", "1", "Definitive XML Schema",
                "XML Schema Reference and Tutorial",
                book3course, book3author, "Prentice Hall",
                book3price, book3stock);

        Element rootElement = bookstoreDocument.createElement("bookstore");
        rootElement.appendChild(createBook(book1));
        rootElement.appendChild(createBook(book2));
        rootElement.appendChild(createBook(book3));
        bookstoreDocument.appendChild(rootElement);

        return bookstoreDocument;
    }
    /**
     * A method that out put the entire DOM as an XML file.
     * @param bSDocument is the bookstore document
     * */
    private void outputBookstore(final Document bSDocument)
            throws TransformerException {
            TransformerFactory transformerFactory =
                    TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(bSDocument);
            StreamResult result =
                    new StreamResult(new File("bookstore-reverse.xml"));
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
                    "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

            transformer.transform(source, result);
        }
    /**
     * A method that calling all other methods.
     *
     * @param ogXML is the original XML document.
     * @param newXML is the new XML document.
     * */
    public void duplicateBookstore(final String ogXML, final String newXML)
            throws Exception {
        outputBookstore(assembleBookstore());
    }
    /**
     * A method that checks the BookStoreFactory.
     *
     * @return instance
     * */
    private static BookStoreFactory getInstance()
            throws ParserConfigurationException {
        if (instance == null) {
            instance = new BookStoreFactory();
        }
        return instance;
    }
    /**
     * The main method to output a new bookstore XML file.
     *
     * @param args
     * */
    public static void main(final String args[]) throws Exception {
        BookStoreFactory bsf = BookStoreFactory.getInstance();
        bsf.duplicateBookstore("bookstore.xml", "bookstore-copy.xml");
    }
}
