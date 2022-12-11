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
 * Instance třídy {@code World} reprezentuje svět červené Karkulky.
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
public   class World
    implements IWorld
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Odkaz na jedinou instanci (jedináčka) této hry. */
    private static final World SINGLETON = new World();



//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================

    /***************************************************************************
     * Tovární metoda vracející odkaz na jedninou existující instanci dané hry.
     *
     * @return Instance dané hry
     */
    static World getInstance()
    {
        return SINGLETON;
    }



//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================

//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Kolekce všech prostorů světa hry. */
    private final Collection<Place> places;

    /** Kolekce všech prostorů světa hry poskytovaná tazatelům. */
    private final Collection<Place> allPlaces;

    /** Výchozí aktuální prostor na počátku hry. */
    private final Place startPlace;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Aktuální prostor, v němž se nachází hráč. */
    private Place currentPlace;



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Soukromý konstruktor definující jedinou instanci.
     * Protože je soukromý, musí být definován, i když má prázdné tělo.
     */
    private World()
    {
        places = new ArrayList<>();
        places.add(startPlace =
                   new Place("Domeček",
                       "Domeček, kde bydlí Karkulka",
                       new String[] { "Les" },
                       "_Bábovka", "_Víno", "#Stůl", "_Panenka"));
        places.add(new Place("Les",
                       "Les s jahodami, malinami a pramenem vody",
                       new String[] { "Domeček", "Temný_les" },
                       "_Maliny", "_Jahody", "#Studánka"));
        places.add(new Place("Temný_les",
                       "Temný_les s jeskyní a číhajícím vlkem",
                       new String[] { "Les", "Jeskyně", "Chaloupka"},
                       "#Vlk"));
        places.add(new Place("Chaloupka",
                       "Chaloupka, kde bydlí babička",
                       new String[] { "Temný_les" },
                       "#Postel", "#Stůl", "#Babička"));
        places.add(new Place("Jeskyně",
                       "Jeskyně, kde v zimě přespává medvěd",
                       new String[] { "Temný_les" }
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
    public Place currentPlace()
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
        currentPlace = (Place)destinationRoom;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Inicializuje svět hry, tj. inicializuje propojení prostorů
     * a jejich obsah a nastaví výchozí aktuální prostor.
     */
    @Override
    public void initialize()
    {
        places.stream().forEach(Place::initialize);
        currentPlace = startPlace;
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
