package adv22w._3_1245.basr01_mistakes;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */

import adv22w.api.IAction;
import adv22w.api.IItem;
import adv22w.api.INamed;

import static adv22w._3_1245.basr01_mistakes.CK_Scenarios.*;

import java.util.*;
import java.util.function.Function;



/*******************************************************************************
 * Třída {@code CK_Action} má na starosti interpretaci příkazů
 * zadávaných uživatelem hrajícím hru.
 * Název spouštěné akce je první slovo příkazu zadávaného z klávesnice
 * a další slova pak bývají interpretována jako argumenty.
 * <br>
 * Můžete ale definovat příkaz, který odstartuje konverzaci
 * (např. s osobou přítomnou v místnosti) a tím přepne systém do režimu,
 * v němž se zadávané texty neinterpretují jako příkazy,
 * ale předávají se definovanému objektu až do chvíle,
 * kdy uživatel rozhovor ukončí a objekt rozhovoru přepne hru zpět
 * do režimu klasických příkazů.
 *
 * @author Rudolf PECINOVSKÝ
 * @version 2022-Winter
 */
public class    CK_Action
    extends CK_ANamed
    implements  IAction
{
//\CC== CONSTANT CLASS (STATIC) ATTRIBUTES (FIELDS) ============================

    /** Mapa definovaných akcí. */
    private static final Map<String, CK_Action> NAME_2_ACTION;

    /** Mapa testovaných a nastavovaných příznaků. */
    private static final Map<String, Object> conditions = new HashMap<>();


//\CV== VARIABLE CLASS (STATIC) ATTRIBUTES (FIELDS) ============================

    /** Příznak toho, že hra právě běží. */
    static boolean isAlive;



//##############################################################################
//\CI== STATIC INITIALIZER (CLASS CONSTRUCTOR) =================================
    // Je na konci definice

//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================

    /***************************************************************************
     * Vrátí kolekci všech příkazů použitelných ve hře.
     *
     * @return Kolekce všech příkazů použitelných ve hře
     */
    static Collection<CK_Action> allActions()
    {
        return Collections.unmodifiableCollection(NAME_2_ACTION.values());
    }


    /***************************************************************************
     * Vrátí odkaz na mapu obsahující aktuální stav příznaků
     * ovlivňujících proveditelnost nestandardních akcí.
     *
     * @return Požadovaná mapa
     */
    static Map<String, Object> conditions()
    {
        return Collections.unmodifiableMap(conditions);
    }


    /**
     * Zpracuje zadaný příkaz a vrátí text zprávy pro uživatele.
     *
     * @param command Zadávaný příkaz
     * @return Textová odpověď hry na zadaný příkaz
     */
    public static String executeCommand(String command)
    {
        command = command.trim();
        if (command.isEmpty()) {
            return executeEmptyCommand();
        }
        else {
            return executStandardCommand(command);
        }
    }



//\CM== OTHER NON-PRIVATE CLASS (STATIC) METHODS ===============================
//\CP== PRIVATE AND AUXILIARY CLASS (STATIC) METHODS ===========================

    /***************************************************************************
     * Inicializuje aplikaci při startu další hry.
     */
    private static void initialize()
    {
        CK_World.getInstance().initialize();
        CK_Bag  .getInstance().initialize();
        conditions.put("living", List.of("babička", "vlk"));
        conditions.put("babička.sleeping", true);
        conditions.put("babička.greeted",  false);
        conditions.put("vlk.sleeping", true);
        conditions.put("vlk.greeted",  false);
    }


    /***************************************************************************
     * Definuje reakci na prázdný příkaz.
     */
    private static String executeEmptyCommand()
    {
        if(isAlive) {
            return EMPTY;
        }
        isAlive = true;
        initialize();
        return START;
    }


    /***************************************************************************
     * Definuje reakci na neprázdný příkaz.
     */
    private static String executStandardCommand(String command)
    {
        if (isAlive) {
            String[]    words = command
                                .trim()
                                .toLowerCase()
                                .split("\\s+");
            String actionName = words[0];
            CK_Action action  = NAME_2_ACTION.get(actionName);
            String        answer;
            if (action == null) {
                answer = UNKNOWN + actionName;
            }
            else {
                answer = action.execute(words);
            }
            return answer;
        }
        else {
            return NOT_START;
        }
    }


//##############################################################################
//\IC== CONSTANT INSTANCE ATTRIBUTES (FIELDS) ==================================

    /** Stručný popis dané akce. */
    private final String description;

    /** Metoda realizující danou akci. */
    private final Function<String[], String> action;



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Konstruktor vytvářející instance daného příkazu.
     */
    CK_Action(String name, String description,
              Function<String[], String> action)
    {
        super(name);
        this.description = description;
        this.action      = action;
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí popis příkazu s vysvětlením jeho funkce,
     * významu jednotlivých parametrů
     * a možností (resp. účelu) použití daného příkazu.
     * Tento popis tak může sloužit jako nápověda k použití daného příkazu.
     *
     * @return Popis příkazu
     */
//    @Override
    public String description()
    {
        return this.description;
    }

//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Metoda realizující reakci hry na zadání daného příkazu.
     * Počet parametrů je závislý na konkrétní akci,
     * např. akce typu <i>konec</i> a <i>nápověda</i> nemají parametry,
     * akce typu <i>jdi</i> a <i>seber</i> mají jeden parametr
     * akce typu <i>použij</i> muže mít dva parametry atd.
     *
     * @param arguments Parametry příkazu – akce;
     *                  jejich počet muže byt pro každou akci jiný,
     *                  ale pro všechna spuštění stejné akce je stejný
     * @return Text zprávy vypsané po provedeni příkazu
     */
//    @Override
    public String execute(String... arguments)
    {
        return this.action.apply(arguments);
    }



//\CI== STATIC INITIALIZER (CLASS CONSTRUCTOR) =================================

    /***************************************************************************
     * Zjistí, je-li v aktuálním prostoru h-objekt, jehož název je v kolekci
     * uložené v mapě <code>conditions</code> pod klíčem <code>living</code>.
     *
     * @param currentPlace Aktuální prostor
     * @return Optional obsahující odkaz na daný h-objekt nebo nic
     */
    private static Optional<IItem> getiItem(CK_Place currentPlace) {
        List<String>    livings = (List)(conditions.get("living"));
        Optional<IItem>   oItem = Optional.empty();
        for (String s : livings) {
            oItem = INamed.getO(s, currentPlace.items());
            if (oItem.isPresent()) {
                break;
            }
        }
        return oItem;
    }


static {
NAME_2_ACTION = Map.of(
    "jdi", new CK_Action("Jdi",
        "Přesune Karkulku do zadaného sousedního prostoru.",
        arguments -> {
            if (arguments.length < 2) {
                return MOVE_WA;
            }
            String destinationName = arguments[1];
            CK_World         world = CK_World.getInstance();
            CK_Place currentPlace = world.currentPlace();
            Optional<CK_Place> oDestination = INamed.getO(destinationName,
                                                     currentPlace.neighbors());
            if (! oDestination.isPresent()) {
                return BAD_NEIGHBOR + destinationName;
            }
            CK_Place destinationRoom = oDestination.get();
            world.setCurrentPlace(destinationRoom);
            return GOTO + destinationRoom.description();
        }),
    "vezmi", new CK_Action("Vezmi",
        "Vezme zadaný předmět a vloží jej do košíku.\n"
      + "Předmět ale musí být v aktuálním prostoru, musí být přenositelný\n"
      + "a v košíku pro něj musí být volné místo.",
        arguments -> {
            if (arguments.length <2) {
                return TAKE_WA;
            }
            String         itemName = arguments[1];
            CK_World          world = CK_World.getInstance();
            CK_Place currentPlace = world.currentPlace();
            CK_Bag              bag = CK_Bag.getInstance();
            Optional<IItem> oItem = currentPlace.oItem(itemName);
            if (oItem.isEmpty()) {
                return BAD_ITEM + itemName;
            }
            CK_Item item = (CK_Item)oItem.get();
            if (item.weight() == CK_Item.HEAVY) {
                return UNMOVABLE + itemName;
            }
            boolean added = bag.addItem(item);
            if (added) {
                currentPlace.removeItem(item);
                return TAKE + itemName;
            }
            else {
                return BAG_FULL + itemName;
            }
        }),
    "polož", new CK_Action("Polož",
        "Zadaný předmět z košíku položí v aktuálním prostoru.",
        arguments -> {
            if (arguments.length < 2) {
                return PUT_DOWN_WA;
            }
            String         itemName = arguments[1];
            CK_Bag            bag = CK_Bag.getInstance();
            Optional<IItem> oItem = bag.oItem(itemName);
            if (! oItem.isPresent()) {
                return NOT_IN_BAG + itemName;
            }
            CK_Item item = (CK_Item)oItem.get();
            bag.removeItem(item);
            CK_Place currentPlace = CK_World.getInstance().currentPlace();
            currentPlace.addItem(item);
            return PUT_DOWN + item.name();
        }),
    "?", new CK_Action("?",
        "Zobrazí seznam dostupných akcí spolu s jejich stručnými popisy.",
        arguments -> {
            Collection<CK_Action> actions = allActions();
//        Collector col = Collectors.joining(
//                        "", "\n" + CK_Scenarios.SUBJECT, "");
//        String result = actions.stream()
//            .map(action -> '\n' + action.name()
//                         + '\n' + action.description())
//            .sorted()
//            .collect(col);
            StringBuilder sb = new StringBuilder(HELP);
            for (CK_Action action : actions) {
                sb.append("\n\n").append(action.name())
                  .append('\n')  .append(action.description());
            }
            return sb.toString();
        }),
    "konec", new CK_Action("Konec",
        "Předčasné ukončení hry.",
        arguments -> {
            CK_Game.getInstance().stop();
            return END;
        }),
    "probuď", new CK_Action("Probuď",
        "Karkulka probudí zadaný h-objekt (osobu, zvíře).\n"
      + "Objekt musí být v aktuálním prostoru a musí spát.",
        arguments -> {
            if (arguments.length < 2) {
                return NS1_0Args;
            }
            String      enteredName = arguments[1].toLowerCase();
            CK_World          world = CK_World.getInstance();
            CK_Place currentPlace = world.currentPlace();
            Optional<IItem>   oItem = INamed.getO(enteredName,
                                                  currentPlace.items());
            if (oItem.isEmpty()) {
                return BAD_ITEM + enteredName;
            }
            CK_Item item = (CK_Item)oItem.get();
            String  name = item.name().toLowerCase();
            if (! ((List)(conditions.get("living"))).contains(name)) {
                return NS1_WRONG_ARG + item;
            }
            String cond = name+".sleeping";
            if ((Boolean)(conditions.get(cond))) {
                conditions.put(cond, false);
                return NS_1 + name;
            }
            return NS1_WrongCond + name;
        }),
    "pozdrav", new CK_Action("Pozdrav",
        "Karkulka pozdraví. Příkaz je bezparametrický,\n"
      + "ale v aktuálním prostoru musí být probuzený objekt.",
        arguments -> {
            CK_World        world = CK_World.getInstance();
            CK_Place currentPlace = world.currentPlace();
            Optional<IItem> oItem = getiItem(currentPlace);
            if (oItem.isEmpty()) {
                return "V prostoru není nikdo, koho by mělo smysl zdravit";
            }
            CK_Item item = (CK_Item)oItem.get();
            String  name = item.name().toLowerCase();
            String  cond = name+".sleeping";
            if ((Boolean)(conditions.get(cond))) {
                return NS0_WrongCond;
            }
            cond = name+".greeted";
            if ((Boolean)(conditions.get(cond))) {
                return NS1_WrongCond;
            }
            conditions.put(cond, true);
            return NS_0;

        }),
    "popřej", new CK_Action("Popřej",
        "Karkulka popřeje k narozeninám. Příkaz je bezparametrický,\n"
      + "ale v aktuálním prostoru musí být pozdravený h-objekt.",
        arguments -> {
            CK_World        world = CK_World.getInstance();
            CK_Place currentPlace = world.currentPlace();
            Optional<IItem> oItem = getiItem(currentPlace);
            if (oItem.isEmpty()) {
                return "V prostoru není nikdo, komu by mělo smysl přát";
            }
            CK_Item item = (CK_Item)oItem.get();
            String  name = item.name().toLowerCase();
            String  cond = name+".greeted";
            if ((Boolean)(conditions.get(cond))) {
                return SUCCESS;
            }
            return NOT_SUCCESS;
        })
);  // Konec definice mapy
} // Konec konstruktoru třídy
}
