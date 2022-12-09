package adv22w._3_1245.basr01_mistakes;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import adv22w.api.INamed;
import adv22w.api.IPlace;
import adv22w.api.IWorld;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;


/*******************************************************************************
 * Instance třídy {@code CK_World} reprezentuje svět červené Karkulky.
 * V dané hře je definována jako jedináček.
 * Má na starosti uspořádání jednotlivých prostorů a udržuje informaci o tom,
 * ve kterém z nich se hráč právě nachází.
 * Vzájemné uspořádání prostorů se v průběhu této hry nemění,
 * takže prostory v průběhu hry nezískávají ani neztrácejí sousedy.
 * <p>
 * V této hře je světem hry ...
 * a jednotlivé prostory jsou ....
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2021-Summer
 */
public   class CK_World
    implements IWorld
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Odkaz na jedinou instanci (jedináčka) této hry. */
    private static final CK_World SINGLETON = new CK_World();



//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================

    /***************************************************************************
     * Tovární metoda vracející odkaz na jedninou existující instanci dané hry.
     *
     * @return Instance dané hry
     */
    static CK_World getInstance()
    {
        return SINGLETON;
    }



//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================

//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Kolekce všech prostorů světa hry. */
    private final Collection<CK_Place> places;

    /** Kolekce všech prostorů světa hry poskytovaná tazatelům. */
    private final Collection<CK_Place> allPlaces;

    /** Výchozí aktuální prostor na počátku hry. */
    private final CK_Place startPlace;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Aktuální prostor, v němž se nachází hráč. */
    private CK_Place currentPlace;



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Soukromý konstruktor definující jedinou instanci.
     * Protože je soukromý, musí být definován, i když má prázdné tělo.
     */
    private CK_World()
    {
        places = new ArrayList<>();
        //Opis priestoru Zeľuvarenije
        places.add(startPlace =
                   new CK_Place("Zeľuvarenije",
                       "Obchod kde Černokňažník obsluhuje pocestných",
                       new String[] { "Varňa", "Dommosklo" },
                       "Pocestný", "Pokladňa", "Pohár", "Pult", "Stolička"));
        //Opis priestoru Dommosklo
        places.add(new CK_Place("Dommosklo",
                        """
                                Skleník v ktorom rastú: 
                                Zamiokulkas, Lopatkovec, Smíchovenec,
                                Afrikule a Šachamašmak
                                """,
                       new String[] { "Varňa", "Zeľuvarenije" },
                        "Zamiokulkas", "Lopatkovec",
                        "Smíchovenec", "Afrikule", "Šachamašmak"));
        //Opis priestoru Varňa
        places.add(new CK_Place("Varňa",
                        """
                        Varňa v ktorej Černokňažník varí lektvary.
                        Nachádza sa tu Kotlík, Špajza a Studňa.
                        """,
                       new String[] { "Dommosklo", "Zeľuvarenije",
                                    "Kotlík", "Špajza", "Studňa"},
                       "Kotlík", "Špajza", "Studňa"));
        //Opis priestoru Špajza
        places.add(new CK_Place("Špajza",
                        """
                        Špajza v ktorej sa nachádzajú vysušené ingrediencie:
                        Dračígrc, Okomlok, Šalvia, Stromohnát a Rumbagule.
                        """,
                       new String[] { "Varňa" },
                        "Dračígrc", "Okomlok", "Šalvia",
                        "Stromohnát", "Rumbagule"));
        //Opis priestoru Studňa
        places.add(new CK_Place("Studňa",
                       "Môžeš tu nabrať čistú vodu",
                       new String[] { "Varňa" }
                       /* nic */ ));
        //Opis priestoru Kotlík
        places.add(new CK_Place("Kotlík",
                "Tu daj všetky ingrediencie a zamiešaj ich.",
                new String[] { "Varňa" }
                /* nic */ ));
        allPlaces = Collections.unmodifiableCollection(places);
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí kolekci odkazů na všechny prostory vystupující ve hře.
     *
     * @return Kolekce odkazů na všechny prostory vystupující ve hře
     */
    @Override
    public Collection<? extends IPlace> places()
    {
        return allPlaces;
    }


    /***************************************************************************
     * Vrátí odkaz na aktuální prostor,
     * tj. na prostor, v němž se hráč pravé nachází.
     *
     * @return Prostor, v němž se hráč pravé nachází
     */
    @Override
    public CK_Place currentPlace()
    {
        return currentPlace;
    }


    /***************************************************************************
     * Je li ve světě hry prostor se zadaným názvem, vrátí jej zabalený
     * do objektu typu {@link Optional}, není-li tam, vrátí prázdný
     * {@link Optional}.
     *
     * @param  name Název hledané prostoru
     * @return Prostor zabalený do objektu {@link Optional},
     *         nebo prázdný {@link Optional}.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public Optional<IPlace> oPlace(String name)
    {
        Optional oPlace = INamed.getO(name.toLowerCase(), places);
        return oPlace;
    }


    /***************************************************************************
     * Nastaví zadaný prosto jako aktuální, tj. jako prostor,
     * v němž se aktuálně nachází hráč.
     *
     * @param destinationRoom Nastavovaný prostor
     */
    @Override
    public void setCurrentPlace(IPlace destinationRoom)
    {
        currentPlace = (CK_Place)destinationRoom;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Inicializuje svět hry, tj. inicializuje propojení prostorů
     * a jejich obsah a nastaví výchozí aktuální prostor.
     */
    @Override
    public void initialize()
    {
        places.stream().forEach(CK_Place::initialize);
        currentPlace = startPlace;
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
