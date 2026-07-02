package factorymethod;

/**
 * ExcelDocumentFactory is a Concrete Creator extending the DocumentFactory class.
 * It overrides the factory method to return an ExcelDocument instance.
 */
public class ExcelDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}