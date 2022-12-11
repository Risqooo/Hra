package adv22w._3_1245.basr01_mistakes;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import adv22w.api.*;

import java.util.Collection;
import java.util.Map;


/*******************************************************************************
 * Instance třídy {@code Game} má na starosti řízení hry
 * a komunikaci s uživatelským rozhraním.
 * Je schopna akceptovat zadávané příkazy a poskytovat informace
 * o průběžném stavu hry a jejích součástí.
 * <p>
 * <b>Hra musí být definována jako jedináček (singleton)</b>
 * a kromě metod deklarovaných v interfejsu {@link IGame} musí definovat
 * statickou tovární metodu <b>{@code getInstance()}</b>
 * vracející instanci tohoto jedináčka.<br>
 * Splnění této podmínky nemůže prověřit překladač,
 * ale prověří ji až následné testy hry.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2021-Summer
 */
public   class Game
    implements IGame
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Odkaz na jedinou instanci (jedináčka) této hry. */
    private static final Game SINGLETON = new Game();

    /** Přepravka s názvy povinných akcí. */
    private static final BasicActions BASIC_ACTIONS =
                     new BasicActions("Jdi", "Vezmi", "Polož",
                                      "?",   "Konec");



//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================

    /***************************************************************************
     * Tovární metoda vracející odkaz na jedninou existující instanci dané hry.
     *
     * @return Instance dané hry
     */
    public static Game getInstance()
    {
        return SINGLETON;
    }



//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================

//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================




//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Soukromý konstruktor definující jedinou instanci.
     * Protože je soukromý, musí být definován, i když má prázdné tělo.
     */
    private Game()
    {
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí informaci o tom, je-li hra aktuálně spuštěná.
     * Spuštěnou hru není možno pustit znovu.
     * Chceme-li hru spustit znovu, musíme ji nejprve ukončit.
     *
     * @return Je-li hra spuštěná, vrátí {@code true},
     *         jinak vrátí {@code false}
     */
    @Override
    public boolean isAlive()
    {
        return Action.isAlive;
    }


    /***************************************************************************
     * Vrátí odkaz na batoh, do nějž bude hráč ukládat sebrané předměty.
     *
     * @return Batoh, do nějž hráč ukládá sebrané předměty
     */
    @Override
    public IBag bag()
    {
        return Bag.getInstance();
    }


    /***************************************************************************
     * Vrátí odkaz na mapu obsahující aktuální stav příznaků
     * ovlivňujících proveditelnost nestandardních akcí.
     *
     * @return Požadovaná mapa
     */
    //@Override
    public Map<String, Object> conditions()
    {
        return Action.conditions();
    }


    /***************************************************************************
     * Vrátí kolekci všech příkazů použitelných ve hře.
     *
     * @return Kolekce všech příkazů použitelných ve hře
     */
    @Override
    public Collection<? extends IAction> allActions()
    {
        return Action.allActions();
    }


    /***************************************************************************
     * Vrátí odkaz na přepravku s názvy povinných příkazů, tj. příkazů pro
     * <ul>
     *   <li>přesun hráče do jiného prostoru,</li>
     *   <li>zvednutí objektu (odebrání z prostoru a vložení do batohu),</li>
     *   <li>položení objektu (odebrání z batohu a vložení do prostoru),</li>
     *   <li>vyvolání nápovědy,</li>
     *   <li>okamžité ukončení hry.</li>
     * </ul>
     *
     * @return Přepravka s názvy povinných příkazů
     */
    @Override
    public BasicActions basicActions()
    {
        return BASIC_ACTIONS;
    }


    /***************************************************************************
     * Vrátí odkaz na objekt reprezentující svět, v němž se hra odehrává.
     *
     * @return Svět, v němž se hra odehrává
     */
    @Override
    public IWorld world()
    {
        return World.getInstance();
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Zpracuje zadaný příkaz a vrátí text zprávy pro uživatele.
     *
     * @param command Zadávaný příkaz
     * @return Textová odpověď hry na zadaný příkaz
     */
    @Override
    public String executeCommand(String command)
    {
        String result = Action.executeCommand(command);
        return result;
    }


    /***************************************************************************
     * Ukončí celou hru a uvolní alokované prostředky.
     */
    @Override
    public void stop()
    {
        Action.isAlive = false;
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
