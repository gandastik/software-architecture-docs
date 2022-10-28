package creational;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {
    private List books;

    // constructor
    public JSONBookMetadataFormatter(){
        reset();
    }

    public BookMetadataFormatter reset() {
        this.books  = new LinkedList();
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        Map map = new LinkedHashMap();
        map.put("id", b.getISBN());
        map.put("title", b.getTitle());
        map.put("publisher", b.getPublisher());
        List authors = new LinkedList();

        for(String author : b.getAuthors()){
            authors.add(author);
        }

        map.put("authors", authors);

        books.add(map);

        return this;
    }

    @Override
    public String getMetadataString() {
        return JSONValue.toJSONString(books);
    }
}
