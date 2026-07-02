package factorymethod;

/**
 * WordDocument is a Concrete Product implementing the Document interface.
 * It provides the specific implementation for opening a Word document.
 */
public class WordDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Word Document");
    }
}