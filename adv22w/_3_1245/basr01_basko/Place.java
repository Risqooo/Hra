package adv22w._3_1245.basr01_basko;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import adv22w.api.IPlace;

import java.util.*;


/*******************************************************************************
 * Instance třídy {@code Place} představují prostory ve hře.
 * Dosažení prostoru si můžeme představovat jako částečný cíl,
 * kterého se hráč ve hře snaží dosáhnout.
 * Prostory mohou být místnosti, planety, životní etapy atd.
 * Prostory mohou obsahovat různé objekty,
 * které mohou hráči pomoci v dosažení cíle hry.
 * Každý prostor zná své aktuální bezprostřední sousedy
 * a ví, jaké objekty se v něm v daném okamžiku nacházejí.
 * Sousedé daného prostoru i v něm se nacházející objekty
 * se mohou v průběhu hry měnit.
 * <p>
 * V tomto programu jsou prostory ...
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2021-Summer
 */
public   class Place
       extends AItemContainer
    implements IPlace
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

    /** Stručný popis daného prostoru. */
    private final String description;

    /** Názvy výchozích sousedů. -*/
    private final String[] initialNeighborNames;

    /** Kolekce aktuálních sousedů. */
    private final Map<String, Place> name2neighbor;

    /** Exportovaná kolekce aktuálních sousedů. */
    private final Collection<Place> exportedNeighbors;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     *
     */
    Place(String name, String description,
             String[] neighborNames, String... itemNames)
    {
        super(name, itemNames);
        this.description = description;
        this.initialNeighborNames = neighborNames;
        name2neighbor     = new HashMap<>();
        exportedNeighbors = Collections.
                            unmodifiableCollection(name2neighbor.values());
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí stručný popis daného prostoru.
     *
     * @return Stručný popis daného prostoru
     */
    public String description()
    {
        return description;
    }


    /***************************************************************************
     * Vrátí kolekci sousedů daného prostoru, tj. kolekci prostorů,
     * do nichž je možno se z tohoto prostoru přesunout příkazem typu
     * @link eu.pedu.adv20w.api.TypeOfStep#tsGOTO
     * TypeOfStep.tsGOTO.
     *
     * @return Kolekce sousedů
     */
    @Override
    public Collection<Place> neighbors()
    {
        return exportedNeighbors;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Inicializuje danýá prostor, tj. přiřadi mu počáteční sadu sousedů
     * a umístí do něj počáteční sadu objektů.
     */
    @Override
    public void initialize()
    {
        initializeNeighbors();
        super.initializeItems();
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================

    /***************************************************************************
     * Inicializuje sousedy prostoru.
     */
    private void initializeNeighbors()
    {
        World world = World.getInstance();
        name2neighbor.clear();
        Arrays.stream(initialNeighborNames)
            .forEach(name ->
                name2neighbor.put(name.toLowerCase(),
                                  (Place)(world.oPlace(name).get())));
    }



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
