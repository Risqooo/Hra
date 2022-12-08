/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package adv22w.testers;


import adv22w.api.TypeOfScenario;

import java.util.ArrayList;
import java.util.Arrays;

/*******************************************************************************
 * Instance výčtového typu {@code Level} reprezentují úrovně testování.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2022-Winter
 */
public enum Level
{
//\CE== VALUES OF THE ENUMERATION TYPE =========================================

    /** Tovární třída s identifikací autora.          0 */
    FACTORY     (0),
    /** Šťastný scénář bez deklarací příznaků.        1 */
    HAPPY       (1),
    /** 4 základní scénáře včetně deklarací příznaků. 2 */
    SCENARIOS   (4),
    /** Přítomnost požadovaných objektů a metod.      3 */
    ARCHITECTURE(4),
    /** Hra úspěšně odstartuje.                       4 */
    START       (4, 1),
    /** Hra úspěšně vybuduje svůj svět.               5 */
    WORLD       (4, 1),
    /** Zprovoznění základních akcí.                  6 */
    BASIC       (4, 1, 1),
    /** Základní akce jsou navržené robustní.         7 */
    MISTAKES    (4, 1, 2, 2),
    /** Zprovoznění hry podle šťastného scénáře.      8 */
    RUNNING     (4, 0, 0, 2),
    /** Včetně testu robustnosti nestandardních akcí. 9 */
    WHOLE       (4, 0, 0, 2, 3),
    /** Test aplikace s nadstavbovými úpravami.      10 */
    MODIFIED    (4, 0, 0, 2, 3),
    /** Test upravené aplikace s dalším scénářem.    11 */
    EXTENDED    (5, 0, 0, 2, 3, 4),
    ;



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Minimální požadovaný počet definovaných scénářů. */
    private final int minScenarios;

    /** Posloupnost indexů scénářů, jak budou postupně zadávány. */
    private final String[] testSequence;



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Vytvoří hladinu se zadaným minimálním požadovaným počtem definovaných
     * scénářů a posloupnost indexů scénářů, jak by měly být postupně zadávány.
     */
    private Level(int minScenarios, int... testSequence)
    {
        this.minScenarios = minScenarios;
        this.testSequence = new String[testSequence.length];
        int t = 0;
        for (int i : testSequence) {
            int v = TypeOfScenario.values().length;
            this.testSequence[t++] = TypeOfScenario.values()[i]
                                                   .requiredName();
        }
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Vrátí posloupnost indexů scénářů, jak by měly být postupně zadávány.
     */
    public int minScenarios()
    {
        return minScenarios;
    }


    /***************************************************************************
     * Vrátí minimální požadovaný počet definovaných scénářů.
     */
    public String[] testSequence()
    {
        return Arrays.copyOf(testSequence, testSequence.length);
    }

}
