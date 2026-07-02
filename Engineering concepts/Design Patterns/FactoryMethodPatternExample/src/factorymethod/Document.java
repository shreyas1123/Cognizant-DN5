package factorymethod;

/**
 * The Document interface represents the 'Product' in the Factory Method Pattern.
 * All concrete document types must implement this interface and define their open behavior.
 */
public interface Document {
    /**
     * Opens the document. Concrete subclasses will provide specific implementation.
     */
    void open();
}