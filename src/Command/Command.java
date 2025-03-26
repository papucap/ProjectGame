package Command;

/**
 * Rozhraní pro příkazy ve hře.
 */
public interface Command {

/**
 * Provádí příkaz.
 */
    String execute();

/**
 * Určuje, zda příkaz ukončuje hru.
 */
    boolean exit();
}
