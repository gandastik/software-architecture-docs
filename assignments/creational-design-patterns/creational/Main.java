package creational;

public class Main {

    public static void main(String[] args) {

        // Current usage
        // BookMetadataFormatter formatter = null;
        // try {
        //     formatter = BookMetadataFormatterFactory.getBookMetadataFormatter(BookMetadataFormatterFactory.Format.JSON);
        //     formatter.append(TestData.dragonBook);
        //     formatter.append(TestData.dinosaurBook);
        //     formatter.append(TestData.cleanArchBook);
        //     System.out.print(formatter.getMetadataString());
        // } catch (IOException e) {
        //     e.printStackTrace();
        // } catch (ParserConfigurationException e) {
        //     e.printStackTrace();
        // }

        // Expected usage -> All should give the same result as above
       BookMetadataExporter exporter = new CSVBookMetadataExporter();
    //    BookMetadataExporter exporter = new XMLBookMetadataExporter();
    //    BookMetadataExporter exporter = new JSONBookMetadataExporter();
       exporter.add(TestData.sailboatBook);
       exporter.add(TestData.GoFBook);
       exporter.add(TestData.cleanArchBook);
       exporter.add(TestData.dinosaurBook);
       exporter.add(TestData.dragonBook);
       exporter.export(System.out);
    }
}
