package adv22w._3_1245.basr01_basko;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import adv22w.api.IItem;


/*******************************************************************************
 * Instance třídy {@code Item} přestavují objekty v prostorech.
 * Objekty mohou být jak věci, tak i osoby či jiné skutečnosti (vůně,
 * světlo, fluidum, ...).
 * <p>
 * Některé z objektů mohou charakterizovat stav prostoru (např. je rozsvíceno),
 * jiné mohou být určeny k tomu, aby je hráč "zvednul" a získal tím nějakou
 * schopnost či možnost projít nějakým kritickým místem hry
 * (např. klíč k odemknutí dveří).
 * <p>
 * Rozhodnete-li se použít ve hře objekty, které budou obsahovat jiné objekty,
 * (truhla, stůl, ...), můžete je definovat paralelně jako zvláštní druh
 * prostoru, do kterého se "vstupuje" např. příkazem "<i>prozkoumej truhlu</i>"
 * a který se opouští např. příkazem "<i>zavři truhlu</i>".
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2021-Summer
 */
public   class Item
       extends ANamed
    implements IItem
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Kapacita batohu. */
    static final int HEAVY = Bag.CAPACITY +1;



//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Váha daného h-objektu. */
    private final int weight;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Vytvoří objekt se zadaným názvem a dalšími zadanými vlastnostmi.
     * Tyto dodatečné vlastnosti se zadávají prostřednictvím předpony
     * vkládané před vlastní název objektu
     *
     * @param name Název vytvářeného objektu
     */
    Item(String name)
    {
        super(name.substring(1));
        weight = (name.charAt(0) == '#')   ?  HEAVY
                                           :  1;
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí váhu h-objektu, resp. charakteristiku jí odpovídající.
     * Objekty, které není možno zvednout,
     * mají váhu větší, než je kapacita batohu.
     *
     * @return Váha n-objektu
     */
    @Override
    public int weight()
    {
        return weight;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
