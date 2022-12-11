package adv22w._3_1245.basr01_basko;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import adv22w.api.IItem;
import adv22w.api.IItemContainer;
import adv22w.api.INamed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;


/*******************************************************************************
 * Instance abstraktní třídy {@code AItemContainer} jsou
 * rodičovskými podobjekty objektů, sloužícími jako kontejnery h-objektů,
 * konkrétně batohu a prostorů.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2021-Summer
 */
abstract class AItemContainer
       extends ANamed
    implements IItemContainer
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============
//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Výchozí h-objekty v prostoru. -*/
    private final ArrayList<IItem> initialItems;

    /** Položky aktuálně přítomné v kontejneru. */
    private final Collection<IItem> items;

    /** Immutable collection of items currently present in this container,
     *  that continuously maps the {@link #items} collection content. */
    private final Collection<IItem> exportedItems;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Creates the parent sub-object of the container of items
     * with the given names of its initial items.
     *
     * @param name      Name of the child object
     * @param itemNames Names of items in the container at the game beginning
     */
    AItemContainer(String name, String... itemNames)
    {
        super(name);
        initialItems   = new ArrayList<>();
        for (String itemName : itemNames) {
            initialItems.add(new Item(itemName));
        }
        this.items         = new ArrayList<>(initialItems);
        this.exportedItems = Collections.unmodifiableCollection(items);
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí kolekci objektů nacházejících se v daném kontejneru.
     *
     * @return Kolekce objektů nacházejících se v daném kontejneru
     */
    @Override
    public Collection<IItem> items()
    {
        return exportedItems;
    }


    /***************************************************************************
     * Je li v kontejneru objekt se zadaným názvem, vrátí jej zabalený
     * do objektu typu {@link Optional}, není-li tam, vrátí prázdný
     * {@link Optional}.
     *
     * @param  name Název hledané objektu
     * @return Objekt zabalený do objektu {@link Optional},
     *         nebo prázdný {@link Optional}.
     */
    @Override
    public Optional<IItem> oItem(String name)
    {
        return INamed.getO(name, items);
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Přidá zadaný objekt do kontejneru a vrátí informaci o tom,
     * jestli se mu to podařilo.
     *
     * @param item Přidávaný objekt
     * @return Podařilo-li se objekt přidat, vrátí {@code true}
     */
    @Override
    public boolean addItem(IItem item)
    {
        return items.add(item);
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
        return items.remove(item);
    }


    /***************************************************************************
     * Inicializuje kontejner na počátku hry.
     * Po inicializace bude obsahovat příslušnou výchozí sadu objektů.
     */
    @Override
    public void initializeItems()
    {
        items.clear();
        items.addAll(initialItems);
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
