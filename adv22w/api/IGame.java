package api;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import java.util.Collection;
import java.util.Map;



/*******************************************************************************
 * Instance interfejsu {@code IGame} má na starosti řízení hry
 * a komunikaci s uživatelským rozhraním.
 * Je schopna akceptovat zadávané příkazy a poskytovat informace
 * o průběžném stavu hry a jejích součástí.
 * <p>
 * <b>Hra musí být definována jako jedináček (singleton)</b>
 * a kromě metod deklarovaných v tomto interfejsu musí její třída definovat
 * statickou tovární metodu <b>{@code getInstance()}</b>
 * vracející instanci tohoto jedináčka.<br>
 * Splnění této podmínky nemůže prověřit překladač,
 * ale prověří ji až následné testy hry.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2022-Winter
 */
public interface IGame
{
//\AG== ABSTRACT GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí informaci o tom, je-li hra aktuálně spuštěná.
     * Spuštěnou hru není možno pustit znovu.
     * Chceme-li hru spustit znovu, musíme ji nejprve ukončit.
     *
     * @return Je-li hra spuštěná, vrátí {@code true},
     *         jinak vrátí {@code false}
     */
    //@Override
    public boolean isAlive()
    ;


    /***************************************************************************
     * Vrátí odkaz na batoh, do nějž bude hráč ukládat sebrané objekty.
     *
     * @return Batoh, do nějž hráč ukládá sebrané objekty
     */
    //@Override
    public IBag bag()
    ;


    /***************************************************************************
     * Vrátí kolekci všech příkazů použitelných ve hře.
     *
     * @return Kolekce všech příkazů použitelných ve hře
     */
    //@Override
    public Collection<? extends IAction> allActions()
    ;


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
    //@Override
    public BasicActions basicActions()
    ;


    /***************************************************************************
     * Vrátí odkaz na mapu obsahující aktuální stav příznaků
     * ovlivňujících proveditelnost nestandardních akcí.
     *
     * @return Požadovaná mapa
     */
    //@Override
    public Map<String, Object> conditions()
    ;


    /***************************************************************************
     * Vrátí odkaz na objekt reprezentující svět, v němž se hra odehrává.
     *
     * @return Svět, v němž se hra odehrává
     */
    //@Override
    public IWorld world()
    ;



//\AM== REMAINING ABSTRACT METHODS =============================================

    /***************************************************************************
     * Zpracuje zadaný příkaz a vrátí text zprávy pro uživatele.
     *
     * @param command Zadávaný příkaz
     * @return Textová odpověď hry na zadaný příkaz
     */
    //@Override
    public String executeCommand(String command)
    ;


    /***************************************************************************
     * Ukončí celou hru a uvolní alokované prostředky.
     * Zadáním prázdného příkazu lze následně spustit hru znovu.
     */
    //@Override
    public void stop()
    ;

}
