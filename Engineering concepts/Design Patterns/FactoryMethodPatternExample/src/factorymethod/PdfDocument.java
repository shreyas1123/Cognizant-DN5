package factorymethod;

/**
 * PdfDocument is a Concrete Product implementing the Document interface.
 * It provides the specific implementation for opening a PDF document.
 */
public class PdfDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening PDF Document");
    }
}