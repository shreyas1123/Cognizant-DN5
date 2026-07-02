package factorymethod;

/**
 * The DocumentFactory class represents the 'Creator' in the Factory Method Pattern.
 * It declares the abstract factory method createDocument() which concrete creators will override.
 */
public abstract class DocumentFactory {

    /**
     * The Factory Method. Subclasses override this method to return 
     * specific instances of Document.
     * 
     * @return a new Document instance
     */
    public abstract Document createDocument();
}