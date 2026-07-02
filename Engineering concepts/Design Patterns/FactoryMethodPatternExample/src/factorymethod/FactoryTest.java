package factorymethod;

/**
 * FactoryTest is the Client class that demonstrates the use of the 
 * Factory Method Design Pattern.
 */
public class FactoryTest {

    public static void main(String[] args) {

        // Instantiate a WordDocumentFactory (Concrete Creator)
        DocumentFactory wordFactory = new WordDocumentFactory();
        // Create the Word document via the factory method
        Document word = wordFactory.createDocument();
        // Open the document
        word.open();

        // Instantiate a PdfDocumentFactory (Concrete Creator)
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        // Create the PDF document via the factory method
        Document pdf = pdfFactory.createDocument();
        // Open the document
        pdf.open();

        // Instantiate an ExcelDocumentFactory (Concrete Creator)
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        // Create the Excel document via the factory method
        Document excel = excelFactory.createDocument();
        // Open the document
        excel.open();
    }
}