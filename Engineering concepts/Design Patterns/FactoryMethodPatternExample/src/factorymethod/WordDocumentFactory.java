package factorymethod;

/**
 * WordDocumentFactory is a Concrete Creator extending the DocumentFactory class.
 * It overrides the factory method to return a WordDocument instance.
 */
public class WordDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}