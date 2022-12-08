package adv22w._3_1245.basr01_mistakes;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. */

import adv22w.api.Scenario;
import adv22w.api.ScenarioStep;

import java.util.List;
import java.util.Map;

import static adv22w.api.TypeOfScenario.*;
import static adv22w.api.TypeOfStep.*;



/*******************************************************************************
 * Třída {@code CK_Scenarios} představuje sbírku scénářů,
 * podle kterých je možno hrát (anebo testovat) hru, pro niž jsou určeny.
 * Aby bylo možno jednotlivé scénáře od sebe odlišit,
 * je každý pojmenován a má přiřazen typ, podle které lze blíže určit,
 * k čemu je možno daný scénář použít.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2022-Winter
 */
public class CK_Scenarios
{
//\CV== CLASS (STATIC) ATTRIBUTES (FIELDS) =====================================

/** Názvy proměnných s texty vracenými pro jednotlivé typy kroků. */
static String
    START, TAKE, GOTO, PUT_DOWN, NS_1, NS_0, SUCCESS, HELP, END,
    NOT_START, EMPTY, UNKNOWN, MOVE_WA, TAKE_WA, PUT_DOWN_WA,
    BAD_NEIGHBOR, BAD_ITEM, UNMOVABLE, BAG_FULL, NOT_IN_BAG,
    NS0_WrongCond, NS1_0Args, NS1_WRONG_ARG, NS1_WrongCond, NOT_SUCCESS
    ;

/** Text popisující cíl hry a způsob jeho dosažení
 *  použitý jako uvítání hráče při startu hry a také při vyvolání nápovědy. */
public static final String SUBJECT =
        "Toto je příběh o Červené Karkulce, babičce a vlkovi.\n"
      + "Svými příkazy řídíte Karkulku, aby donesla bábovku a víno\n"
      + "babičce v chaloupce za temným lesem.\n"
      + "Když přijde do chaloupky, měla by položit dárky, vzbudit babičku,\n"
      + "pozdravit a popřát jí k narozeninám.\n"
      + "Jste-li dobrodružné typy, můžete to místo s babičkou provést\n"
      + "s vlkem, který spí v temném lese.\n\n"
      + "Nebudete-li si vědět rady, zadejte znak ?, jenž zobrazí nápovědu.";

/** Společný startovní krok všech scénářů. */
private static final ScenarioStep START_STEP =
    new ScenarioStep(tsSTART, "",
        START = "Vítejte!\n" + SUBJECT,
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Bábovka", "Víno", "Stůl", "Panenka", },// H-o v prost
        new String[] { },                               // H-objekty v batohu
        //Nastavované příznaky
        Map.of("grandma.sleeping",  true,
               "grandma.greeted",   false,
               "wolf.sleeping",     true,
               "wolf.greeted",      false
        )
    );



////////////////////////////////////////////////////////////////////////////////
private static final Scenario HAPPY = new Scenario(scHAPPY,
    START_STEP,
    new ScenarioStep(1, tsTAKE, "Vezmi víno",
        (TAKE = "Karkulka dala do košíku objekt: ") + "Víno",
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Bábovka", "Stůl", "Panenka", }, // H-obj. v prostoru
        new String[] { "Víno", }                        // H-objekty v batohu
    ),
    new ScenarioStep(tsTAKE, "Vezmi Bábovka",
        TAKE + "Bábovka",
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Stůl", "Panenka", },            // H-obj. v prostoru
        new String[] { "Bábovka", "Víno", }             // H-objekty v batohu
    ),
    new ScenarioStep(tsGOTO, "Jdi Les",
        "Karkulka se přesunula do prostoru:\n"
      + "Les s jahodami, malinami a pramenem vody",
        "Les",                                          // Aktuální prostor
        new String[] { "Domeček", "Temný_les" },        // Sousedé
        new String[] { "Maliny", "Jahody", "Studánka", },// H-obj. v prostoru
        new String[] { "Bábovka", "Víno",  }            // H-objekty v batohu
    ),
    new ScenarioStep(tsGOTO, "Jdi Temný_les",
        (GOTO = "Karkulka se přesunula do prostoru:\n")
      + "Temný_les s jeskyní a číhajícím vlkem",
        "Temný_les",                                    // Aktuální prostor
        new String[] { "Les", "Jeskyně", "Chaloupka", },// Sousedé
        new String[] { "Vlk", },                        // H-obj. v prostoru
        new String[] { "Bábovka", "Víno", }             // H-objekty v batohu
    ),
    new ScenarioStep(tsGOTO, "Jdi Chaloupka",
        (GOTO = "Karkulka se přesunula do prostoru:\n")
      + "Chaloupka, kde bydlí babička",
        "Chaloupka",                                    // Aktuální prostor
        new String[] { "Temný_les" },                   // Sousedé
        new String[] { "Postel", "Stůl", "Babička", },  // H-obj. v prostoru
        new String[] { "Bábovka", "Víno", }             // H-objekty v batohu
    ),
    new ScenarioStep(tsPUT_DOWN, "Polož Bábovka",
        (PUT_DOWN = "Karkulka vyndala z košíku objekt: ") + "Bábovka",
        "Chaloupka",                                    // Aktuální prostor
        new String[] { "Temný_les" },                   // Sousedé
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", },
        new String[] { "Víno", }                        // H-objekty v batohu
    ),
    new ScenarioStep(tsPUT_DOWN, "Polož Víno",
        PUT_DOWN + "Víno",
        "Chaloupka",                                    // Aktuální prostor
        new String[] { "Temný_les" },                   // Sousedé
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
        new String[] { }                                // H-objekty v batohu
    ),
    new ScenarioStep(tsNS_1, "Probuď babička",
        (NS_1 = "Karkulka probudila osobu: ") + "Babička",
        "Chaloupka",                                    // Aktuální prostor
        new String[] { "Temný_les" },                   // Sousedé
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
        new String[] { },                               // H-objekty v batohu
        Map.of("grandma.sleeping",  true),              //Očekávané příznaky
        Map.of("grandma.sleeping",  false)              //Nastavované příznaky
    ),
    new ScenarioStep(tsNS_0, "Pozdrav",
        NS_0 = "Karkulka pozdravila",
        "Chaloupka",                                    // Aktuální prostor
        new String[] { "Temný_les" },                   // Sousedé
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
        new String[] { },                               // H-objekty v batohu
        Map.of("grandma.sleeping",  false,              //Očekávané příznaky
               "grandma.greeted",   false),
        Map.of("grandma.greeted",   true)               //Nastavované příznaky
    ),
    new ScenarioStep(tsSUCCESS, "Popřej",
        SUCCESS = "Karkulka popřála vše nejlepší k narozeninám\n"
      + "Úspěšně jste ukončili hru.\n"
      + "Děkujeme, že jste si zahráli.",
        "Chaloupka",                                    // Aktuální prostor
        new String[] { "Temný_les" },                   // Sousedé
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
        new String[] { },                               // H-objekty v batohu
        Map.of("grandma.greeted", true),                //Očekávané příznaky
        null                                            //Nastavované příznaky
    )
);


////////////////////////////////////////////////////////////////////////////////
private static final Scenario BASIC = new Scenario(scBASIC,
    START_STEP,
    new ScenarioStep(1, tsGOTO, "Jdi Les",
        GOTO + "Les s jahodami, malinami a pramenem vody",
        "Les",                                          // Aktuální prostor
        new String[] { "Domeček", "Temný_les" },        // Sousedé
        new String[] { "Maliny", "Jahody", "Studánka", },// H-obj. v prostoru
        new String[] { }                                // H-objekty v batohu
    ),
    new ScenarioStep(tsTAKE, "Vezmi Maliny",
        TAKE + "Maliny",
        "Les",                                          // Aktuální prostor
        new String[] { "Domeček", "Temný_les" },        // Sousedé
        new String[] { "Jahody", "Studánka", },         // H-obj. v prostoru
        new String[] { "Maliny", }                      // H-objekty v batohu
    ),
    new ScenarioStep(tsPUT_DOWN, "Polož Maliny",
        PUT_DOWN + "Maliny",
        "Les",                                          // Aktuální prostor
        new String[] { "Domeček", "Temný_les" },        // Sousedé
        new String[] { "Maliny", "Jahody", "Studánka",},// H-obj. v prostoru
        new String[] { }                                // H-objekty v batohu
    ),
    new ScenarioStep(tsHELP, "?",
        HELP = SUBJECT + "\nMůžete zadat tyto příkazy:\n",
        "Les",                                          // Aktuální prostor
        new String[] { "Domeček", "Temný_les" },        // Sousedé
        new String[] { "Maliny", "Jahody", "Studánka",},// H-obj. v prostoru
        new String[] { }                                // H-objekty v batohu
    ),
    new ScenarioStep(tsEND, "konec",
        END = "Hra ukončena příkazem Konec",
        "Les",                                          // Aktuální prostor
        new String[] { "Domeček", "Temný_les" },        // Sousedé
        new String[] { "Maliny", "Jahody", "Studánka",},// H-obj. v prostoru
        new String[] { }                                // H-objekty v batohu
    )
);



////////////////////////////////////////////////////////////////////////////////
private static final Scenario MISTAKES = new Scenario(scMISTAKES,
    new ScenarioStep(-1, tsNOT_START, "Start",
        NOT_START = "\nPrvním příkazem není startovací příkaz." +
        "\nHru, která neběží, lze spustit pouze startovacím příkazem.\n",
        "",
        new String[] {},
        new String[] {},
        new String[] {}
    ),
    START_STEP,
    new ScenarioStep(1, tsEMPTY, "",
        EMPTY = "Prázdný příkaz lze použít pouze pro start hry",
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Bábovka", "Víno", "Stůl", "Panenka", },
        new String[] { }                                // H-objekty v batohu
    ),
    new ScenarioStep(tsUNKNOWN, "maso",
        (UNKNOWN = "Tento příkaz neznám: ") + "maso",
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Bábovka", "Víno", "Stůl", "Panenka", },
        new String[] { }                                // H-objekty v batohu
    ),
    new ScenarioStep(tsMOVE_WA, "jdi",
        MOVE_WA = "Nevím, kam mám jít.\n"
      + "Je třeba zadat jméno cílového prostoru.",
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Bábovka", "Víno", "Stůl", "Panenka", },
        new String[] { }                                // H-objekty v batohu
    ),
    new ScenarioStep(tsTAKE_WA, "vezmi",
        TAKE_WA = "Nevím, co mám zvednout.\n"
      + "Je třeba zadat jméno zvedaného objektu.",
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Bábovka", "Víno", "Stůl", "Panenka", },
        new String[] { }                                // H-objekty v batohu
    ),
    new ScenarioStep(tsPUT_DOWN_WA, "polož",
        PUT_DOWN_WA = "Nevím, co mám položit.\n"
      + "Je třeba zadat jméno pokládaného objektu.",
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Bábovka", "Víno", "Stůl", "Panenka", },
        new String[] { }                                // H-objekty v batohu
    ),
    new ScenarioStep(tsBAD_NEIGHBOR, "jdi do_háje",
        (BAD_NEIGHBOR = "Do zadaného prostoru se odsud jít nedá: ") + "do_háje",
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Bábovka", "Víno", "Stůl", "Panenka", },
        new String[] { }                                // H-objekty v batohu
    ),
    new ScenarioStep(tsBAD_ITEM, "vezmi whisky",
        (BAD_ITEM = "Zadaný objekt v prostoru není: ") + "whisky",
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Bábovka", "Víno", "Stůl", "Panenka", },
        new String[] { }                                // H-objekty v batohu
    ),
    new ScenarioStep(tsUNMOVABLE, "vezmi stůl",
        (UNMOVABLE = "Zadaný objekt není možno zvednout: ") + "stůl",
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Bábovka", "Víno", "Stůl", "Panenka", },
        new String[] { }                                // H-objekty v batohu
    ),
    new ScenarioStep(tsTAKE, "vezmi víno",
        TAKE + "víno",
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Bábovka", "Stůl", "Panenka", }, // H-obj. v prostoru
        new String[] { "Víno", }                        // H-objekty v batohu
    )
    ,
    new ScenarioStep(tsTAKE, "vezmi bábovka",
        TAKE + "Bábovka",
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Stůl", "Panenka", },            // H-obj. v prostoru
        new String[] { "Bábovka", "Víno", }             // H-objekty v batohu
    ),
    new ScenarioStep(tsBAG_FULL, "vezmi panenka",
        (BAG_FULL = "Zadaný objekt se už do košíku nevejde: ") + "panenka",
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Stůl", "Panenka", },            // H-obj. v prostoru
        new String[] { "Bábovka", "Víno", }             // H-objekty v batohu
    ),
    new ScenarioStep(tsNOT_IN_BAG, "polož panenka",
        (NOT_IN_BAG = "Zadaný objekt v košíku není: ") + "panenka",
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Stůl", "Panenka", },            // H-obj. v prostoru
        new String[] { "Bábovka", "Víno", }             // H-objekty v batohu
    ),
    new ScenarioStep(tsHELP, "?",
        HELP,
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Stůl", "Panenka", },            // H-obj. v prostoru
        new String[] { "Bábovka", "Víno", }             // H-objekty v batohu
    ),
    new ScenarioStep(tsEND, "konec",
        END,
        "Domeček",                                      // Aktuální prostor
        new String[] { "Les" },                         // Sousedé
        new String[] { "Stůl", "Panenka", },            // H-obj. v prostoru
        new String[] { "Bábovka", "Víno", }             // H-objekty v batohu
    )
);

////////////////////////////////////////////////////////////////////////////////
private static final Scenario MISTAKES_NS  = new Scenario(scMISTAKES_NS,
    HAPPY.steps().get(0),
    HAPPY.steps().get(1),   //Vezmi víno
    HAPPY.steps().get(2),   //Vezmi Bábovka
    HAPPY.steps().get(3),   //Jdi les
    HAPPY.steps().get(4),   //Jdi Temný_les
    HAPPY.steps().get(5),   //Jdi Chaloupka
    HAPPY.steps().get(6),   //Polož Bábovka
    HAPPY.steps().get(7),   //Polož Víno

    new ScenarioStep(8, tsNS0_WrongCond, "Pozdrav",
        NS0_WrongCond = "Nemá smysl zdravit, babička ještě není probuzená",
        "Chaloupka",                                    // Aktuální prostor
        new String[] { "Temný_les" },                   // Sousedé
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
        new String[] { },                               // H-objekty v batohu
        Map.of("grandma.sleeping",  false,              //Očekávané příznaky
               "grandma.greeted",   false),
        null                                            //Nastavované příznaky
    ),
    new ScenarioStep(tsNS1_0Args, "Probuď",
        NS1_0Args = "Nevím, koho mám probudit.\n"
      + "Je třeba zadat jméno buzeného h-objektu.",
        "Chaloupka",                                    // Aktuální prostor
        new String[] { "Temný_les" },                   // Sousedé
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
        new String[] { },                               // H-objekty v batohu
        Map.of("grandma.sleeping",  true),              //Očekávané příznaky
        Map.of("grandma.sleeping",  false)              //Nastavované příznaky
    ),
    new ScenarioStep(tsNS1_WRONG_ARG, "Probuď stůl",
        (NS1_WRONG_ARG = "Nelze budit předmět: ") + "Stůl",
        "Chaloupka",                                    // Aktuální prostor
        new String[] { "Temný_les" },                   // Sousedé
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
        new String[] { },                               // H-objekty v batohu
        Map.of("grandma.sleeping",  true),              //Očekávané příznaky
        Map.of("grandma.sleeping",  false)              //Nastavované příznaky
    ),
    new ScenarioStep(tsNS_1, "Probuď babička",
        NS_1 + "Babička",
        "Chaloupka",                                    // Aktuální prostor
        new String[] { "Temný_les" },                   // Sousedé
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
        new String[] { },                               // H-objekty v batohu
        Map.of("grandma.sleeping",  true),              //Očekávané příznaky
        Map.of("grandma.sleeping",  false)              //Nastavované příznaky
    ),
    new ScenarioStep(tsNS1_WrongCond, "Probuď babička",
        (NS1_WrongCond = "Nelze budit osobu, která je již probuzená: ")
      + "Babička",
        "Chaloupka",                                    // Aktuální prostor
        new String[] { "Temný_les" },                   // Sousedé
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
        new String[] { },                               // H-objekty v batohu
        Map.of("grandma.sleeping",  true),              //Očekávané příznaky
        null
    ),
    new ScenarioStep(tsNOT_SUCCESS, "Popřej",
        NOT_SUCCESS = "Než budete přát, musíte nejprve pozdravit.",
        "Chaloupka",                                    // Aktuální prostor
        new String[] { "Temný_les" },                   // Sousedé
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
        new String[] { },                               // H-objekty v batohu
        Map.of("grandma.greeted",   true),              //Očekávané příznaky
        null
    ),
    new ScenarioStep(tsEND, "konec",
        "Hra ukončena příkazem Konec",
        "Chaloupka",                                    // Aktuální prostor
        new String[] { "Temný_les" },                   // Sousedé
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
        new String[] { }                                // H-objekty v batohu
    )
);



//##############################################################################
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================

    /***************************************************************************
     * Vrátí seznam definovaných základních scénářů.
     *
     * @return Seznam základních scénářů
     */
    public static List<Scenario> scenarios()
    {
        return List.of(HAPPY, BASIC, MISTAKES, MISTAKES_NS);
    }

}
