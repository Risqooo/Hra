package adv22w._3_1245.basr01_basko;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import adv22w.api.IBag;
import adv22w.api.IItem;

import java.util.ArrayList;
import java.util.Collection;


/*******************************************************************************
 * Instance třídy {@code Bag} představuje úložiště,
 * do nějž hráči ukládají objekty sebrané v jednotlivých prostorech,
 * aby je mohli přenést do jiných prostorů a/nebo použít.
 * Úložiště má konečnou kapacitu definující maximální povolený
 * součet vah objektů vyskytujících se v úložišti.
 * <p>
 * V této hře je tímto úložištěm Karkulčin košík
 * s kapacitou 2 položky.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2021-Summer
 */
public   class Bag
       extends AItemContainer
    implements IBag
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Kapacita batohu. */
    static final int CAPACITY = 2;

    /** Jediná instance batohu ve hře. */
    private static final Bag SINGLETON = new Bag();



//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================

    /***************************************************************************
     * Tovární metoda vracející odkaz na jedninou existující instanci dané hry.
     *
     * @return Instance dané hry
     */
    static Bag getInstance()
    {
        return SINGLETON;
    }



//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Kolekce všech prostorů světa hry. */
    private final Collection<Item> items;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Free capacity of the bag. */
    private int remains;



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     */
    @SuppressWarnings("unchecked")
    Bag()
    {
        super("Kapsa");
        items = new ArrayList<>();
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí kapacitu batohu, tj. maximální povolený součet vah objektů,
     * které je možno současně uložit do batohu.
     *
     * @return Kapacita batohu
     */
    @Override
    public int capacity()
    {
        return CAPACITY;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Inicializuje batoh na počátku hry. Vedle inicializace obsahu,
     * inicializuje i informaci o zbývající kapacitě.
     */
    @Override
    public void initialize()
    {
        super.initializeItems();
        remains = CAPACITY;
    }


    /***************************************************************************
     * Odebere zadaný objekt z kontejneru a vrátí informaci o tom,
     * jestli se mu to podařilo.
     *
     * @param item Odebíraný objekt
     * @return Podařilo-li se objekt odebrat, vrátí {@code true}
     */
    @Override
    public boolean removeItem(IItem item)
    {
        boolean result = super.removeItem(item);
        if (result) {
            remains += item.weight();
        }
        return result;
    }


    /***************************************************************************
     * If the given item fits to the bag, it adds it;
     * after that it returns the message on the result.
     *
     * @param item The item that has to be added into the bag
     * @return The message on the result: {@code true} = was added,
     *         {@code false} = was not added
     */
    public boolean addItem(Item item)
    {
        if (item.weight() > remains) {
            return false;
        }
        super.addItem(item);
        remains -= item.weight();
        return true;
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
