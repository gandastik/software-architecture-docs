package creational;

import java.io.IOException;
import java.io.PrintStream;

public class CSVBookMetadataExporter extends BookMetadataExporter {
    private CSVBookMetadataFormatter csvBookMetadataFormatter;

    public CSVBookMetadataExporter() {
        try {
            csvBookMetadataFormatter = new CSVBookMetadataFormatter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void export(PrintStream stream){
        for(Book book: books){
            csvBookMetadataFormatter.append(book);
        }
    
        stream.println(csvBookMetadataFormatter.getMetadataString());
    }
    
}
