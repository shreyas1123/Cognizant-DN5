package factorymethod;

/**
 * ExcelDocument is a Concrete Product implementing the Document interface.
 * It provides the specific implementation for opening an Excel document.
 */
public class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Excel Document");
    }
}