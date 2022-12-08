/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package testers;

import adv22w.api.IGame;
import adv22w.api.IPortal;
import adv22w.api.Scenario;
import adv22w.api.ScenarioStep;


/*******************************************************************************
 * Instance třídy {@code TestVisitor} představují rodičovské podobjekty
 * návštěvníků schopných ovlivnit způsob testování hry
 * podle jim známých dispozic.
 * <p>
 * Slouží především k tomu, aby bylo možno doplnit základní testy
 * o doplňkové kontroly prověřující, zda byly správně zapracovány
 * všechny úpravy vyžadované při obhajobách aplikace.
 * <p>
 * Tato třída definuje všechny virtuální metody návštěvníka jako prázdné s tím,
 * že pro každé zadání požadované modifikace pro obhajobu
 * bude definován odpovídající potomek kontrolující správnost řešení.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2022-Winter
 */
public class TestVisitor
{
//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Test konkrétního řešení, pro které daný návštěvník pracuje. */
    protected final ASolutionTester tester;

    /** Tovární objekt schopný dodat hlavní objekty aplikace. */
    protected final IPortal portal;

    /** Testovaná hra. */
    protected final IGame game;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Testovací scénář. */
    protected Scenario scenario;



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Vytvoří návštěvníka, který bude připraven prověřit, nakolik testované
     * řešení splňuje modifikované zadání prověřované zadaným testerem.
     *
     * @param tester  Tester zadání, jehož správnou realizaci
     *                návštěvník kontroluje
     * @param portal Tovární objekt schopný dodat klíčové objekty
     *                testované aplikace
     */
    protected TestVisitor(ASolutionTester tester, IPortal portal)
    {
        this.tester = tester;
        this.portal = portal;

        IGame iGame;
        try                 { iGame = portal.game(); }
        catch(Exception ex) { iGame = null; }
        this.game = iGame;
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================

    /***************************************************************************
     * Vrátí sdružený tester, jehož zadání prověřuje.
     *
     * @return Sdružený tester
     */
    public ASolutionTester tester()
    {
        return this.tester;
    }



//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***********************************************************************
     * Vrátí testovanou hru. Nutnost použít zjišťovací metody zabezpečí,
     * aby potomci nemohli omylem tento odkaz změnit
     *
     * @return Testovaná hra
     */
    public final IGame game()
    {
        return game;
    }


    /***************************************************************************
     * Vrátí informaci o tom, je-li v prověřovaném zadání povoleno testování hry
     * i v případě, kdy správce scénářů neprojde verifikací.
     *
     * @return Je-li v prověřovaném zadání povoleno testování hry
     *         i v případě, kdy správce scénářů neprojde verifikací,
     *         vrátí {@code true}, jinak vrátí {@code false}
     */
    public boolean isAllowedImperfectSM()
    {
        return false;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Akce, která se má provést po provedení startovacího kroku hry
     * (tj. ve chvíli, kde je hra již inicializována),
     * ale před jeho testem, tj. před ověření, že stav hry odpovídá scénáři.
     * Cílem metody je připravit potřebné informace o testované hře.
     *
     * @param scenario Scénář, podle nějž se bude hra provádět
     */
    public void afterGameStart(Scenario scenario)
    {
    }


    /***************************************************************************
     * Akce, která se má provést po provedení kroku hry,
     * ale před jeho testem, tj. před ověření, že stav hry odpovídá scénáři.
     *
     * @param step      Aktuálně testovaný krok scénáře
     * @param message   Zpráva vrácená hrou v daném kroku
     */
    public void beforeStepTest(ScenarioStep step, String message)
    {
    }


    /***************************************************************************
     * Akce, která se má provést po testu aktuálního kroku.
     *
     * @param step      Aktuálně testovaný krok scénáře
     * @param message   Zpráva vrácená hrou v daném kroku
     */
    public void afterStepTest(ScenarioStep step, String message)
    {
    }


    /***************************************************************************
     * Akce, která se má provést po testu posledního kroku.
     *
     * @param throwable      Objekt případně vyhozené chyby či výjimky
     * @param verboseMessage Kompletní zpráva o průběhu testu
     */
    public void afterGameEnd(Throwable throwable, String verboseMessage)
    {
    }


    /***************************************************************************
     * Akce, která se má provést po testu posledního kroku.
     *
     * @param summary Přepravka s kompletními informacemi o průběhu hry
     */
    public void afterGameEnd(GameSummary summary)
    {
        afterGameEnd(summary.getThrowable(), summary.getVerboseMessage());
    }

}
