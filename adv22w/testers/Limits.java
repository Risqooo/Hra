package adv22w.testers;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */



/*******************************************************************************
 * Instance třídy {@code Limits} představují přepravky
 * s minimálními požadovanými "rozměry" úspěšného scénáře.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2022-Winter
 */
public class Limits
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Jediná instance definuje základní omezení vytvářených her. */
    private static final
    Limits LIMITS = new Limits(12, //Minimální počet kroků scénáře HAPPY
                                6, //Minimální počet prostorů
                                4, //Minimální počet navštívených prostorů
                                3);//Minimální počet vlastních akcí



//##############################################################################
//\CF== CLASS (STATIC) FACTORY METHODS =========================================

    /***************************************************************************
     * Vrátí odkaz na jedinou instanci dané třídy.
     *
     * @return Odkaz na jedinou instanci dané třídy
     */
    public static Limits get()
    {
        return LIMITS;
    }



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Minimální počet kroků úspěšného scénáře. */
    public final int minSteps;

    /** Minimální počet prostorů hry. */
    public final int minPlaces;

    /** Minimální počet navštívených prostorů. */
    public final int minVisited;

    /** Minimální počet definic vlastních příkazů. */
    public final int minOwnActions;



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Vytvoří přepravku s minimálními požadovanými "rozměry"
     * úspěšného scénáře.
     *
     * @param minSteps      Minimální počet kroků scénáře
     * @param minPlaces     Minimální počet prostorů ve světě hry
     * @param minVisited    Minimální počet navštívených prostorů
     * @param minOwnActions Minimální počet definic vlastních příkazů
     */
    public Limits(int minSteps, int minPlaces, int minVisited,
                  int minOwnActions)
    {
        this.minSteps      = minSteps;
        this.minPlaces     = minPlaces;
        this.minVisited    = minVisited;
        this.minOwnActions = minOwnActions;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Textový podpis dané instance srozumitelně oznamující požadavky.
     *
     * @return Text s popisem požadavků
     */
    @Override
    public String toString()
    {
        return "Minimální požadované \"rozměry\" úspěšného scénáře:"
           + "\n   Minimální počet kroků = "                  + minSteps
           + "\n   Minimální počet prostorů hry = "           + minPlaces
           + "\n   Minimální počet navštívených prostorů = "  + minVisited
           + "\n   Minimální počet definic vlastních akcí = " + minOwnActions;
    }

}
