package adv22w.testers;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import adv22w.api.IGame;
import adv22w.api.IPortal;
import adv22w.api.Scenario;

import java.util.*;

import java.util.function.BiFunction;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;


/*******************************************************************************
 * Instance třídy {@code ASolutionTester} představují rodičovské podobjekty
 * testovacích objektů prověřujících správnou realizaci daného zadání.
 * Toto zadání může být jak základního zadání semestrální práce,
 * tak modifikované zadání, které studenti řeší v rámci obhajoby své práce.
 * <p>
 * Detaily toho,
 * jak a co testovat při ověřování správného naprogramování příslušného zadání,
 * jsou definovány prostřednictvím objektu návštěvníka předaného testům.
 * Testy pak v kritických chvílích volají jeho předem definované metody,
 * a ty pak ověří správnost zapracování příslušných modifikací.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2022-Winter
 */
public abstract class ASolutionTester
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============
//
//    /** Mapa konvertující ID jednotlivých zadání na odpovídající testery,
//     *  které jsou schopny zkontrolovat příslušné řešení. */
//    private static final Map<String, ASolutionTester> ID_2_TESTER =
//                                                      new HashMap<>();
//
//    /** Implicitní sada názvů scénářů, podle nichž se testuje. */
//    private static final String[] DEFAULT_TESTING_SCENARIO_NAMES =
//                                { Scenario.HAPPY_NAME,
//                                  Scenario.HAPPY_NAME,
//                                  Scenario.MISTAKE_NAME,
//                                  Scenario.MISTAKE_NS_NAME };



//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//
//    /***************************************************************************
//     * Vrátí tester schopný prověřit zadání s příslušným ID
//     */
//    static ASolutionTester testerFor(String id)
//    {
//        ASolutionTester tester = ID_2_TESTER.get(id);
//        if (tester == null) {
//            throw new RuntimeException(
//                "\nThere is no tester with the ID=" + id);
//        }
//        return tester;
//    }
//
//
//
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================




//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Hladina testování, z níž se odvozují použité scénáře. */
    private final Level level;

    /** Popis požadovaného řešení. */
    private final String description;

    /** Návštěvník zabezpečující prověření specifik daného testu. */
    protected final BiFunction<ASolutionTester, IPortal,
                    TestVisitor> visitorFactory;

    /** Názvy scénářů, podle nichž se řešení testuje. */
    protected final List<String> testingScenarioNames;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Přepravka na informace o testu a jeho výsledcích. */
    protected GameSummary gameSummary;



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================
//
//    /***************************************************************************
//     * Vytvoří rodičovský podobjekt pro zadaného návštěvníka a sadu scénářů.
//     *
//     * @param id             Identifikátor testovaného zadání sestávající
//     *                       z označení semestru a čísla daného zadání
//     * @param visitorFactory Továrna na návštěvníky schopné prověřit správnost
//     *                       testovaného řešení
//     * @param scenarioNames  Názvy scénářů, podle nichž bude testováno
//     */
//    protected ASolutionTester(String id,
//                              BiFunction<ASolutionTester, IPortal,
//                                         TestVisitor> visitorFactory,
//                             String... scenarioNames)
//    {
//        this(id, "", visitorFactory, scenarioNames);
//    }
//

    /***************************************************************************
     * Vytvoří rodičovský podobjekt pro zadaného návštěvníka a sadu scénářů.
     *
     * @param level          Identifikátor testovaného zadání sestávající
     *                       z označení semestru a čísla daného zadání
     * @param description    Popis testovaného zadání
     * @param visitorFactory Továrna na návštěvníky schopné prověřit správnost
     *                       testovaného řešení
     */
    protected ASolutionTester(Level level, String description,
                              BiFunction<ASolutionTester, IPortal,
                                         TestVisitor>  visitorFactory)
    {
//        ID_2_TESTER.put(ID, this);
        this.level          = level;
        this.description    = description;
        this.visitorFactory = visitorFactory;
        List<String> names  = new ArrayList<>();
        for (String s : level.testSequence()) { names.add(s); }
        this.testingScenarioNames = names;
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí hladinu testování daného testeru.
     *
     * @return Hladinu testování daného testeru
     */
    public Level level()
    {
        return level;
    }


    /***************************************************************************
     * Vrátí popis testovaného zadání.
     *
     * @return Popis testovaného zadání
     */
    public String description()
    {
        if (description.isEmpty()) {
            return "Podrobný popis zadání je uveden "
                 + "v dokumentačním komentáři třídy";
        }
        else {
            return description;
        }
    }


    /***************************************************************************
     * Vrátí seznam scénářů, podle nichž se má dané řešení testovat.
     *
     * @param portal Tovární objekt poskytující testovanou hru
     * @return Seznam scénářů, podle nichž se má dané řešení testovat
     */
    public List<Scenario> scenarios(IPortal portal)
    {
        List<Scenario> result = new ArrayList<>();
        for (String s : testingScenarioNames) {
            for (Scenario sc : portal.scenarios()) {
                if (sc.name().equals(s)){
                    result.add(sc);
                    break;
                }
            }
        }
        return result;
    }


    /***************************************************************************
     * Vrátí seznam názvů scénářů, podle nichž se má dané řešení testovat.
     *
     * @return Seznam názvů scénářů, podle nichž se má dané řešení testovat
     */
    protected List<String> scenarioNames()
    {
        return Collections.unmodifiableList(testingScenarioNames);
    }


    /***************************************************************************
     * Nastaví názvy scénářů, podle nichž se má dané řešení testovat.
     *
     * @param scenarioNames Seznam názvů scénářů,
     *                      podle nichž se má dané řešení testovat
     */
    protected void scenarioNames(List<String> scenarioNames)
    {
        testingScenarioNames.clear();
        testingScenarioNames.addAll(scenarioNames);
    }


    /***************************************************************************
     * Vrátí návštěvníka testujícího hru poskytovanou zadaným továrním objektem.
     *
     * @param portal Tovární objekt poskytující testovanou hru
     * @return Požadovaný návštěvník
     */
    public TestVisitor visitor(IPortal portal)
    {
        return visitorFactory.apply(this, portal);
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Doplní název scénáře, podle nějž se má dané řešení testovat.
     *
     * @param name Název scénáře, jenž se má přidat na konec seznamu názvů
     *             scénářů, podle nichž se má dané řešení testovat
     */
    protected void addScenarioName(String name)
    {
        testingScenarioNames.add(name);
    }


    /***************************************************************************
     * Vypíše zadání na standardní výstup a poté
     * zobrazí dialogové okno, v němž je vypíše také.
     */
    public void showDescription()
    {
        System.out.println("Požadovaná modifikace:\n" + description);
        JOptionPane.showMessageDialog(null,
                   "<html>" + description + "</html>",
                   level + " – Solution description",
                   JOptionPane.INFORMATION_MESSAGE);
//        JFrame frame = new JFrame(id + " – Solution description");
    }


    /***************************************************************************
     * Otestuje práci zadanou prostřednictvím class-objektu její tovární třídy
     * podle základní sady scénářů.
     *
     * @param portalClass  Class-objekt tovární třídy testované práce
     */
    final
    public void test(Class<? extends IPortal> portalClass)
    {
        IPortal portal = IPortal.getInstanceOfFactory(portalClass);
        test(portal);
    }


    /***************************************************************************
     * Otestuje práci zadanou prostřednictvím jejího továrního objektu
     * podle sady scénářů odpovídajících danému testu.
     *
     * @param portal  Tovární objekt testované práce
     */
    public void test(IPortal portal)
    {
        TGameTester tester = new TGameTester(this, portal);
        tester.testGame();
    }


    /***************************************************************************
     * Otestuje práci zadanou prostřednictvím jejího továrního objektu
     * podle sady scénářů odpovídajících danému testu.
     */
    public void test()
    {
        throw new IllegalArgumentException(
            "\nNebyla zadána tovární třída, resp. její instance!");
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================

    /***************************************************************************
     * Pomocná zástupná třída pro vytvořená zástupného továrního objektu.
     */
    public static  class MockFactory
              implements IPortal
    {
        @Override public String authorID        () { return "";}
        @Override public String authorName      () { return "";}
        @Override public String authorNativeName() { return "";}
        @Override public String authorGroup     () { return "";}
        @Override public List<Scenario>scenarios() {return null;}
        @Override public IGame  game            () {return null;}
    }
    /** Zástupný tovární objekt - jedináček. */
    public static final IPortal NOTHING = new MockFactory();

//##############################################################################
//\NT== NESTED DATA TYPES ======================================================

}
