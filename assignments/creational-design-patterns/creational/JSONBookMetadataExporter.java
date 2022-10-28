package creational;

import java.io.PrintStream;

public class JSONBookMetadataExporter extends BookMetadataExporter {
    private JSONBookMetadataFormatter jsonBookMetadataFormatter;

    public JSONBookMetadataExporter() {
        jsonBookMetadataFormatter = new JSONBookMetadataFormatter();
    }

    public void export(PrintStream stream){
        for(Book book: books){
            jsonBookMetadataFormatter.append(book);
        }

        stream.println(jsonBookMetadataFormatter.getMetadataString());
    }

}
