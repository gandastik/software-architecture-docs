package creational;

import java.io.PrintStream;

import javax.xml.parsers.ParserConfigurationException;

public class XMLBookMetadataExporter extends BookMetadataExporter {
    private XMLBookMetadataFormatter xmlBookMetadataFormatter;

    public XMLBookMetadataExporter() {
        try {
            xmlBookMetadataFormatter = new XMLBookMetadataFormatter();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void export(PrintStream stream){
        for(Book book: books){
            xmlBookMetadataFormatter.append(book);
        }
        
        stream.println(xmlBookMetadataFormatter.getMetadataString());
    };
}
