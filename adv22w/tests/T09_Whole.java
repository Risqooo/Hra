package adv22w.tests;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import adv22w.api.IPortal;
import adv22w.testers.ASolutionTester;
import adv22w.testers.Level;
import adv22w.testers.TestVisitor;

/*******************************************************************************
 * Testuje hru vytvořenou podle zadání ze zimního semestru 2022
 * v podobě, s níž mají studenti přijít na obhqajobu.
 *
 * @author Rudolf Pecinovský
 * @version 2022-Winter
 */
public class T09_Whole
     extends ASolutionTester
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Identifikátor testovaného zadání. */
    public static final Level level = Level.WHOLE;

    /** Popis požadované modifikace. */
    public static final String DESCRIPTION =
           "Všechny akce odladěny jako robustní.";



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Vytvoří tester prověřující řešení základního zadání.
     */
    public T09_Whole()
    {
        super(Level.WHOLE, DESCRIPTION, Visitor::new);
    }



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================

    /***************************************************************************
     * Instance třídy {@code Visitor} představují návštěvníky prověřující
     * splnění základního zadání semestrální práce.
     */
    private static class Visitor
                 extends TestVisitor
    {

        /***********************************************************************
         * Vytvoří návštěvníka pro prověření základní funkčnosti hry
         * poskytnuté zadaným továrním objektem.
         *
         * @param myTest  Zadavatel požadující vyřešení základního zadání
         * @param portal Tovární objekt poskytující základní objekty
         *                prověřované aplikace
         */
        Visitor(ASolutionTester myTest, IPortal portal)
        {
            super(myTest, portal);
        }

        /***********************************************************************
         * Vrátí sdružený tester, jehož zadání prověřuje.
         *
         * @return Sdružený tester
         */
        @Override
        public ASolutionTester tester()
        {
            return tester;
        }

    }



//##############################################################################
//\MM== MAIN METHOD ============================================================

    /***************************************************************************
     * Metoda spouštějící celou aplikaci.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {
        IPortal   portal = null; //new Factory();
        T09_Whole tester = new T09_Whole();
        tester.test(portal);
        System.exit(0);
    }
}
