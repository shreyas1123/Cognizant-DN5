package factorymethod;

/**
 * PdfDocumentFactory is a Concrete Creator extending the DocumentFactory class.
 * It overrides the factory method to return a PdfDocument instance.
 */
public class PdfDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}