package adv22w.testers;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import adv22w.api.BasicActions;
import adv22w.api.Scenario;
import adv22w.api.ScenarioStep;
import adv22w.api.TypeOfStep;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;



/***************************************************************************
 * Instance třídy {@code ScenariosSummary} představují přepravky
 * pro uchování informacích charakterizujících svět hry
 * na základě vyhodnocení scénářů a jejich kroků.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2022-Winter
 */
public class ScenariosSummary
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============
//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================



//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Informace, zda je scénář bez chyb. */
    public final boolean ok;

    /** Množina názvů všech dosud zmíněných prostorů. */
    public final Set<String> mentionedPlaces;

    /** Množina názvů všech doposud zadaných akcí. */
    public final Set<String> enteredActions;

    /** Množina názvů všech dosud zahlédnutých objektů. */
    public final Set<String> seenItems;

    /** Počáteční krok v základním úspěšném scénáři. */
    public final ScenarioStep startStep;

    /** Poslední krok základního úspěšného scénáře. */
    public final ScenarioStep endStep;

    /** Mapa mapující typy základních (povinných) příkazů na jejich názvy. */
    public final BasicActions basicActions;

    /** Pole seznamů názvů nestandardních akcí. */
    private final List<Set<String>> nsActions;

    /** Mapa mapující názvy příkazů na skupinu jejich typu. */
    public final Map<String, TypeOfStep> name2typeGroup;

    /** Seznam prověřovaných scénářů. */
    public final List<Scenario> scenarios;

    /** Výsledky prověření jednotlivých scénářů:
     *  {@code true} vyhověl, {@code false} nevyhověl. */
    public final boolean[] results;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***********************************************************************
     * Konstruktor inicializující atributy přepravky.
     *
     * @param ok              Informace, zda je scénář bez chyb
     * @param mentionedPlaces Množina názvů všech dosud zmíněných prostorů
     * @param enteredActions  Množina názvů všech doposud zadaných příkazů
     * @param seenItems       Množina názvů všech dosud zahlédnutých objektů
     * @param startStep       Počáteční krok v základním úspěšném scénáři
     * @param endStep         Poslední krok základního úspěšného scénáře
     * @param basicActions    Mapa mapující typy příkazů na jejich názvy
     * @param nsActions       Pole seznamů názvů nestandardních akcí
     * @param name2typeGroup  Mapa názvů příkazů na skupinu jejich typu
     * @param scenarios       Seznam prověřovaných scénářů
     * @param results         Výsledky prověření jednotlivých scénářů:
     *                        {@code true} vyhověl, {@code false} nevyhověl
     */
    public ScenariosSummary(boolean ok,
                     Set<String>        mentionedPlaces,
                     Set<String>        enteredActions,
                     Set<String>        seenItems,
                     ScenarioStep       startStep,
                     ScenarioStep       endStep,
                     BasicActions       basicActions,
                     List<Set<String>>  nsActions,
                     Map<String,TypeOfStep>     name2typeGroup,
                     List<Scenario>  scenarios,
                     boolean[]                  results)
    {
        this.ok = ok;
        this.mentionedPlaces= mentionedPlaces;
        this.enteredActions = enteredActions;
        this.seenItems      = seenItems;
        this.startStep      = startStep;
        this.endStep        = endStep;
        this.basicActions   = basicActions;
        this.nsActions      = nsActions;
        this.name2typeGroup = name2typeGroup;
        this.scenarios      = Collections.unmodifiableList(scenarios);
        this.results        = results;
    }


    /***********************************************************************
     * Konstruktor vytvářející prázdnou přepravku pro dočasné použití.
     */
    @SuppressWarnings( {"unchecked", "rawtypes"})
    public ScenariosSummary()
    {
        this.ok = false;
        this.mentionedPlaces= Collections.EMPTY_SET;
        this.enteredActions = Collections.EMPTY_SET;
        this.seenItems      = Collections.EMPTY_SET;
        this.startStep      = new ScenarioStep("AUXILIARY-START");
        this.endStep        = new ScenarioStep("AUXILIARY-STOP");
        this.basicActions   = new BasicActions("M", "D", "U", "H", "E");
        this.nsActions      = List.of(Collections.EMPTY_SET,
                                      Collections.EMPTY_SET,
                                      Collections.EMPTY_SET,
                                      Collections.EMPTY_SET);
        this.name2typeGroup = Collections.EMPTY_MAP;
        this.scenarios      = Collections.EMPTY_LIST;
        this.results        = new boolean[] {};
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================
//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================




//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================

    /***************************************************************************
     * Vrátí textový podpis instance s hodnotami všech jejích atributů.
     *
     * @return Textový podpis instance
     */
    @Override
    public String toString()
    {
        String result = "Souhrnné informace testu scénářů (ScenariosSummary):"
                + "\nÚspěšnost testu: " + ok
                + "\nZmíněné prostory: " + mentionedPlaces
                + "\nZadané akce: "      + enteredActions
                + "\nViděné h.objekty: " + seenItems
                + "\nNázvy povinných akcí: " + basicActions
                + "\nNepovinné akce: "   + nsActions
                + "\nPřevod názvu akce na typ:" + name2typeGroup
                + "\nProjité scénáře"    + scenarios
                + "\nVýsledky: "         + Arrays.toString(results)
                + "\nPočáteční krok: "   + startStep
                + "\nKoncový krok šťastného scénáře: " + endStep
                + "====================================================";
        return result;
    }
}
