package test_ver;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import adv22w.api.IPortal;
import adv22w.testers.ASolutionTester;
import adv22w.testers.Level;
import adv22w.testers.TestVisitor;



/*******************************************************************************
 * Instance třídy {@code T22w10_Basic_game} testují hru
 * vytvořenou podle zadání ze zimního semestru 2022 v podobě,
 * s níž mají studenti přijít na obhqajobu.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2022-Winter
 */
public class TestGame
     extends ASolutionTester
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Identifikátor testovaného zadání. */
    public static final String TEST_ID = "22w10";

    /** Popis požadované modifikace. */
    public static final String DESCRIPTION =
                        "Hra podle původního zadání bez modifikací";



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Vytvoří tester prověřující řešení základního zadání.
     */
    public TestGame()
    {
        super(Level.WHOLE, DESCRIPTION, Visitor::new);
    }



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================

    /***************************************************************************
     * Instance třídy {@code Visitor18s00} představují návštěvníky prověřující
     * splnění základního zadání semestrální práce.
     */
    private static class Visitor
                 extends TestVisitor
    {
    //\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===============================

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



    //\IG== INSTANCE GETTERS AND SETTERS =======================================

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
    public static void main(String[] args) {
//        IPortal    portal = new CK_Portal();
//        T07_Mistakes tester  = new T07_Mistakes();
//        tester.test(portal);
//        System.exit(0);
    }
}
