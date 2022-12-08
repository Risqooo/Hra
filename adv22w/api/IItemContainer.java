package api;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import java.util.Collection;
import java.util.Optional;



/*******************************************************************************
 * Instance interfejsu {@code IItemContainer} představují kontejnery,
 * které mohou obsahovat objekty vystupující ve hře.
 * Speciálními případy těchto kontejnerů jsou prostory a batoh.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2022-Winter
 */
public interface IItemContainer
{
//\AG== ABSTRACT GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí kolekci objektů nacházejících se v daném kontejneru.
     *
     * @return Kolekce objektů nacházejících se v daném kontejneru
     */
    //@Override
    public Collection<IItem> items()
    ;


    /***************************************************************************
     * Je li v kontejneru objekt se zadaným názvem, vrátí jej zabalený
     * do objektu typu {@link Optional}, není-li tam, vrátí prázdný
     * {@link Optional}.
     *
     * @param  name Název hledané objektu
     * @return Objekt zabalený do objektu {@link Optional},
     *         nebo prázdný {@link Optional}.
     */
    //@Override
    public Optional<IItem> oItem(String name)
    ;



//\AM== REMAINING ABSTRACT METHODS =============================================

    /***************************************************************************
     * Přidá zadaný objekt do kontejneru a vrátí informaci o tom,
     * jestli se to podařilo.
     *
     * @param item Přidávaný objekt
     * @return Podařilo-li se objekt přidat, vrátí {@code true}
     */
    //@Override
    public boolean addItem(IItem item)
    ;


    /***************************************************************************
     * Odebere zadaný objekt z kontejneru a vrátí informaci o tom,
     * jestli se to podařilo.
     *
     * @param item Odebíraný objekt
     * @return Podařilo-li se objekt odebrat, vrátí {@code true}
     */
    //@Override
    public boolean removeItem(IItem item)
    ;


    /***************************************************************************
     * Inicializuje kontejner na počátku hry.
     * Po inicializace bude obsahovat příslušnou výchozí sadu objektů.
     */
    //@Override
    public void initializeItems();
}
