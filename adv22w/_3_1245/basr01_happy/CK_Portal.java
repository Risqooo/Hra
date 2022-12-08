package adv22w._3_1245.basr01_happy;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. */

import adv22w.api.IPortal;
import adv22w.api.IGame;
import adv22w.api.Scenario;

import adv22w.testers.FactoryTester;
import adv22w.testers.Level;

import java.util.List;



/*******************************************************************************
 * Instance třídy {@code CK_Portal} představují tovární objekty,
 * které jsou schopny na požádání dodat informace o autorovi
 * a odkazy na instance klíčových objektů aplikace,
 * konkrétně aktuální hry, jejích scénářů.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2022-Winter
 */
public   class CK_Portal
    implements IPortal
{
//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     */
    public CK_Portal()
    {
    }



//##############################################################################
//\IA== INSTANCE METHODS =======================================================
/////// Identifikace autora/autorky celého balíčku

    /***************************************************************************
     * Vrátí identifikační řetězec autora/autorky programu
     * zapsaný VELKÝMI PÍSMENY.
     * Tímto řetězcem bývá většinou login do informačního systému školy.
     *
     * @return Identifikační řetězec autora/autorky programu
     */
    @Override
    public String authorID()
    {
        return "BASR01";
    }


    /***************************************************************************
     * Vrátí jméno autora/autorky programu ve formátu <b>PŘÍJMENÍ Křestní</b>,
     * tj. nejprve příjmení psané velkými písmeny a za ním křestní jméno,
     * u nějž bude velké pouze první písmeno a ostatní písmena budou malá.
     * Má-li autor programu více křestních jmen, může je uvést všechna.
     *
     * @return Jméno autora/autorky programu ve tvaru PŘÍJMENÍ Křestní
     */
    @Override
    public String authorName()
    {
        return "BAŠKO Richard";
    }


    /***************************************************************************
     * Vrátí jméno autora/autorky programu ve formátu <b>PŘÍJMENÍ Křestní</b>,
     * zapsané v jeho rodném jazyce.
     *
     * @return Jméno autora/autorky programu v jeho/jejím rodném jazyce
     */
    @Override
    public String authorNativeName()
    {
        return "BAŠKO Richard";
    }


    /***************************************************************************
     * Vrátí identifikační řetězec skupiny, kterou autor navštěvuje.
     * Ten začíná pořadovým číslem dne v týdnu následovaný znakem podtržení.
     * a čtyřčíslím označujícím začátek vyučovací hodiny,
     * takže v roce 2022 buď 3_1245 nebo 3_1430.
     *
     * @return Identifikační řetězec skupiny
     */
    @Override
    public String authorGroup()
    {
        return "3_1245";
    }



//##############################################################################
//\IA== INSTANCE METHODS =======================================================
/////// Metody vracející odkazy na klíčové objekty

    /***************************************************************************
     * Vrátí seznam definovaných scénářů.
     * <ul>
     *   <li>
     *     Scénářem s indexem 0 musí být základní úspěšný scénář dané hry
     *     definující možný postup vedoucí k úspěšnému ukončení hry.<br>
     *     &nbsp;</li>
     *   <li>
     *     Scénářem s indexem 1 musí být základní povinný scénář, jenž definuje
     *     postup, při němž se demonstruje reakce na korektně zadané příkazy
     *     vyvolávající některou ze základní šestice povinných akcí.<br>
     *     &nbsp;</li>
     *   <li>
     *     Scénářem s indexem 2 musí být základní chybový scénář
     *     definující reakce hry na všechny možné uživatelské chyby
     *     při aktivaci některé ze základní šestice povinných akcí.<br>
     *     &nbsp;</li>
     *   <li>
     *     Scénářem s indexem 3 musí být nadstavbový chybový scénář
     *     definující reakce hry na všechny běžné uživatelské chyby
     *     specifikující reakce hry na možné uživatelské chyby
     *     při aktivaci některé rozšiřujících akcí.<br>
     *     &nbsp;</li>
     * </ul>
     * Výše uvedeným scénářům budou při jejich vytvářený automaticky
     * přiděleny předem definované názvy.
     * Názvy a účely dalších scénářů jsou již na libovůli autora.<br>
     *
     * @return Seznam spravovaných scénářů
     */
    @Override
    public List<Scenario> scenarios()
    {
        return CK_Scenarios.scenarios();
    }


    /***************************************************************************
     * Vrátí odkaz na (jedinou) instanci textové verze hry;
     * dokud ještě hra neexistuje, vyhazuje po zavolání výjimku
     * {@link UnsupportedOperationException}.
     *
     * @return Požadovaný odkaz
     * @throws UnsupportedOperationException
     *         Potomek metodu korektně nepřebil
     */
    @Override
    public IGame game()
    {
        throw new UnsupportedOperationException("Není korektně definována "
                + "tovární metoda vracející instanci hry");
    }



//##############################################################################
//== MAIN METHOD ===============================================================

    /***************************************************************************
     * Metoda testuje danou hladinu rozpracovanosti aplikace,
     * zde definici šťastného scénáře.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {
        var m = new CK_Portal();
        new FactoryTester(m).testForLevel(Level.HAPPY);
    }
}
