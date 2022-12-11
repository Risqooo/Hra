package adv22w._3_1245.basr01_all;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. */

import adv22w.api.Scenario;
import adv22w.api.ScenarioStep;


import java.util.List;
import java.util.Map;

import static adv22w.api.TypeOfScenario.*;
import static adv22w.api.TypeOfStep.*;



/*******************************************************************************
 * Třída {@code Scenarios} představuje sbírku scénářů,
 * podle kterých je možno hrát (anebo testovat) hru, pro niž jsou určeny.
 * Aby bylo možno jednotlivé scénáře od sebe odlišit,
 * je každý pojmenován a má přiřazen typ, podle které lze blíže určit,
 * k čemu je možno daný scénář použít.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2022-Winter
 */
public class Scenarios
{
//\CV== CLASS (STATIC) ATTRIBUTES (FIELDS) =====================================

/** Text popisující cíl hry a způsob jeho dosažení
 *  použitý jako uvítání hráče při startu hry a také při vyvolání nápovědy. */
public static final String WELCOME = """
Hra je o Černokňažníkovi a jeho obchode Zeľuvarenije.
Vašou úlohou je pripraviť lektvar Pocestnému.
Najprv ako slušný Černokňažník
musíte pozdraviť Pocestného a až potom môžete ísť
natrhať Smíchovec do dommosklo a presunúť sa do varni v ktorej je špajza
z ktorej vezmete dračígrc a šalviu. Nájdete tam však aj iné veci,
s ktorými môžete kľudne experimentovať a vymýšľat iné lektvary ;).
Vo varni okrem špajzi nájdete aj kotlík, varechu a studňu,
z ktorej musíte nabrať vodu.
Následne vložíte všetky ingrediencie do kotlíka, zalejete vodou
a zapálite oheň pod kotlíkom. Potom môžete zamiešať varechou.
Keď budete mať lektvar vychladný vezmite ho z kotlíka.
Už len zostáva vrátiť sa do obchodu a lektvar naservírovať pocestnému.
Keď sa nebudete vedieť pohnúť v hre ďalej zadajte znak ?.
To zobrazí nápovedu.
Prajeme Vám pekný zážitok z hry.
""";

/** Společný startovní krok všech scénářů. */
private static final ScenarioStep START_STEP =
    new ScenarioStep(tsSTART, "",
        "Vitajte!\n" + WELCOME,
        "Zeľuvarenije",// Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },// Sousedé
        new String[] { "Pocestný", "Pokladňa", "Pohár", "Pult", "Stolička" },
        new String[] { },// H-objekty v batohu
        Map.of(
                "pocestny.pozdraveny",  true,
                "voda.nabrata",         false,
                "ohen.zapaleny",        false,
                "lektvar.zamiesany",    false,
                "lektvar.naservirovany",false
        )
    );
////////////////////////////////////////////////////////////////////////////////
private static final Scenario HAPPY = new Scenario(scHAPPY,
    START_STEP,
    new ScenarioStep(1, tsNS_0, "Pozdrav",
        "Černokňažník pozdravil osobu: Pocestný",
        "Zeľuvarenije",                   // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný", "Pokladňa",
        "Pohár", "Pult", "Stolička" },          // H-obj.
        new String[] { },                       // H-objekty v batohu
        Map.of("pocestny.pozdraveny",  true),//Očekávané příznaky
        Map.of("pocestny.pozdraveny",  false) //Nastavené príznaky
    ),
    new ScenarioStep(2, tsGOTO, "Choď Dommosklo",
        "Černokňažník sa presunul do priestoru: Dommosklo",
        "Dommosklo",    // Aktuální prostor
        new String[] { "Varňa", "Zeľuvarenije"},    // Sousedé
        new String[] { "Zamiokulkas", "Lopatkovec",
        "Smíchovenec", "Afrikule", "Šachamašmak"},// H-objekty
        new String[] { }                         // H-objekty v batohu
    ),
    new ScenarioStep(tsTAKE, "Vezmi Smíchovenec",
        "Černokňažník vzal do kapsy objekt: Smíchovenec",
        "Dommosklo",    // Aktuální prostor
        new String[] { "Varňa", "Zeľuvarenije"},    //Sousedé
        new String[] { "Zamiokulkas", "Lopatkovec",
        "Afrikule", "Šachamašmak"},  	// H-objekty
        new String[] { "Smíchovenec" }  // H-objekty v batohu
    ),
    new ScenarioStep(tsGOTO, "Choď Varňa",
        "Černokňažník sa presunul do priestoru: Varňa",
        "Varňa",    // Aktuální prostor
        new String[] { "Dommosklo", "Zeľuvarenije",
        "Kotlík", "Špajza", "Studňa"},  // Sousedé
        new String[] {"Varecha"},   // H-objekty
        new String[] { "Smíchovenec" }  // H-objekty v batohu
    ),
    new ScenarioStep(tsGOTO, "Choď Špajza",
        "Černokňažník sa presunul do priestoru: Špajza",
        "Špajza",   // Aktuální prostor
        new String[] {"Varňa"}, // Sousedé
        new String[] { "Dračígrc", "Okomlok", "Šalvia",
        "Stromohnát", "Rumbagule" },  	// H-objekty
        new String[] { "Smíchovenec" }  // H-objekty v batohu
    ),
    new ScenarioStep(tsTAKE, "Vezmi Dračígrc",
        "Černokňažník vzal do kapsy objekt: Dračígrc",
        "Špajza",   // Aktuální prostor
        new String[] { "Varňa"},    // Sousedé
        new String[] { "Okomlok", "Šalvia",
        "Stromohnát", "Rumbagule" },    // H-objekty
        new String[] { "Smíchovenec", "Dračígrc" }  // H-objekty v batohu
    ),
    new ScenarioStep(tsTAKE, "Vezmi Šalvia",
        "Černokňažník vzal do kapsy objekt: Šalvia",
        "Špajza",   // Aktuální prostor
        new String[] { "Varňa"},    // Sousedé
        new String[] { "Okomlok", "Stromohnát",
        "Rumbagule" },  // H-objekty
        new String[] { "Smíchovenec", "Dračígrc",
        "Šalvia" }    // H-objekty v batohu
    ),
    new ScenarioStep(tsGOTO, "Choď Varňa",
        "Černokňažník sa presunul do priestoru: Varňa",
        "Varňa",    // Aktuální prostor
        new String[] { "Dommosklo", "Zeľuvarenije",
        "Kotlík", "Špajza", "Studňa"},  // Sousedé
        new String[] {"Varecha"},   // H-objekty
        new String[] { "Smíchovenec", "Dračígrc",
        "Šalvia" }  // H-objekty v batohu
    ),
    new ScenarioStep(tsTAKE, "Vezmi Varecha",
        "Černokňažník vzal do kapsy objekt: Varecha",
        "Varňa",    // Aktuální prostor
        new String[] { "Dommosklo", "Zeľuvarenije",
        "Kotlík", "Špajza", "Studňa"},  // Sousedé
        new String[] {},    // H-objekty
        new String[] { "Smíchovenec", "Dračígrc",
        "Šalvia","Varecha" }    // H-objekty v batohu
    ),
    new ScenarioStep(tsGOTO, "Choď Studňa",
        "Černokňažník sa presunul k: Studňa",
        "Studňa",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] {},    // H-objekty
        new String[] { "Smíchovenec", "Dračígrc",
        "Šalvia", "Varecha" }   // H-objekty v batohu
        )
        ,
    new ScenarioStep(tsNS_2, "Naber čistú vodu",
        "Černokňažník nabral zo studne vodu",
        "Studňa",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] {},    // H-objekty
        new String[] { "Smíchovenec", "Dračígrc",
        "Šalvia", "Varecha", "Voda" },  // H-objekty v batohu
        Map.of("voda.nabrata",  false),
        Map.of("voda.nabrata", true)
        )
        ,
    new ScenarioStep(tsGOTO, "Choď Kotlík",
        "Černokňažník sa presunul ku: Kotlík",
        "Kotlík",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] {},    // H-objekty
        new String[] { "Smíchovenec", "Dračígrc",
        "Šalvia", "Varecha", "Voda" } // H-objekty v batohu
        )
        ,
    new ScenarioStep(tsPUT_DOWN, "Polož Smíchovenec",
        "Černokňažník vybral z kapsy: Smíchovenec",
        "Kotlík",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] { "Smíchovenec" }, // H-objekty
        new String[] {"Dračígrc", "Šalvia",
        "Varecha", "Voda" } // H-objekty v batohu
        )
        ,
    new ScenarioStep(tsPUT_DOWN, "Polož Dračígrc",
        "Černokňažník vybral z kapsy: Dračígrc",
        "Kotlík",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] { "Smíchovenec", "Dračígrc" }, // H-objekty
        new String[] { "Šalvia","Varecha",
        "Voda" } // H-objekty v batohu
        )
        ,
    new ScenarioStep(tsPUT_DOWN, "Polož Šalvia",
        "Černokňažník vybral z kapsy: Šalvia",
        "Kotlík",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] { "Smíchovenec", "Dračígrc",
        "Šalvia"},    // H-objekty
        new String[] {"Varecha", "Voda"}    // H-objekty v batohu
        )
        ,
    new ScenarioStep(tsPUT_DOWN, "Polož Voda",
        "Černokňažník vybral z kapsy: Voda",
        "Kotlík",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] { "Smíchovenec", "Dračígrc",
        "Šalvia", "Voda"},  	// H-objekty
        new String[] {"Varecha"}    // H-objekty v batohu
        )
        ,
    new ScenarioStep(tsNS_3, "Zapáľ oheň pod kotlom",
        "Černokňažník zapálil oheň pod kotlom",
        "Kotlík",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] { "Smíchovenec", "Dračígrc",
        "Šalvia", "Voda"},  // H-objekty
        new String[] {"Varecha"},   // H-objekty v batohu
        Map.of("ohen.zapaleny", false),
        Map.of("ohen.zapaleny", true)
        )
        ,
    new ScenarioStep(tsNS_1, "Zamiešaj Lektvar",
        "Černokňažník zamiešal obsah kotlíka a vyrobil: Lektvar",
        "Kotlík",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] { "Lektvar"},  // H-objekty
        new String[] {"Varecha"},   // H-objekty v batohu
        Map.of("lektvar.zamiesany", false),
        Map.of("lektvar.zamiesany", true)
        )
        ,
    new ScenarioStep(tsTAKE, "Vezmi Lektvar",
        "Černokňažník vzal do kapsy objekt: Lektvar",
        "Kotlík",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] {},    // H-objekty
        new String[] {"Varecha", "Lektvar"} // H-objekty v batohu
        )
        ,
    new ScenarioStep(tsGOTO, "Choď Varňa",
        "Černokňažník sa presunul do priestoru: Varňa",
        "Varňa",    // Aktuální prostor
        new String[] { "Dommosklo", "Zeľuvarenije",
        "Kotlík", "Špajza", "Studňa"},  // Sousedé
        new String[] {},    // H-objekty
        new String[] {"Varecha", "Lektvar"} // H-objekty v batohu
        )
        ,
    new ScenarioStep(tsGOTO, "Choď Zeľuvarenije",
        "Černokňažník sa presunul do priestoru: Zeľuvarenije",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] {"Pocestný", "Pokladňa",
        "Pohár", "Pult", "Stolička"}, // H-objekty
        new String[] {"Lektvar","Varecha"}  // H-objekty v batohu
        )
        ,
    new ScenarioStep(tsPUT_DOWN, "Polož Lektvar",
        "Černokňažník vybral z kapsy: Lektvar",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný", "Pokladňa", "Pohár",
        "Pult", "Stolička", "Lektvar" },    // H-objekty
        new String[] {"Varecha"}    // H-objekty v batohu
        )
        ,

    new ScenarioStep(tsSUCCESS, "Naservíruj",
        """
                Černokňažník naservíroval Pocestnému: Lektvar
                Úspešne ste ukončili hru.
                Ďakujeme že ste si ju zahrali.
                """,
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný", "Pokladňa",
        "Pohár", "Pult", "Stolička" },  // H-objekty
        new String[] {"Varecha"},   // H-objekty v batohu
        Map.of("lektvar.naservirovany", false),
        Map.of("lektvar.naservirovany", true)
        )
);


////////////////////////////////////////////////////////////////////////////////
private static final Scenario BASIC = new Scenario(scBASIC, START_STEP,
    new ScenarioStep(tsGOTO, "Choď Dommosklo",
        "Černokňažník sa presunul do priestoru: Dommosklo",
        "Dommosklo",    // Aktuální prostor
        new String[] { "Varňa", "Zeľuvarenije"},    // Sousedé
        new String[] { "Zamiokulkas", "Lopatkovec",
        "Smíchovenec", "Afrikule", "Šachamašmak"},  // H-objekty
        new String[] { }    // H-objekty v batohu
    ),
    new ScenarioStep(tsTAKE, "Vezmi Smíchovenec",
        "Černokňažník vzal do kapsy objekt: Smíchovenec",
        "Dommosklo",    // Aktuální prostor
        new String[] { "Varňa", "Zeľuvarenije"},    // Sousedé
        new String[] { "Zamiokulkas", "Lopatkovec",
        "Afrikule", "Šachamašmak"}, // H-objekty
        new String[] { "Smíchovenec" }  // H-objekty v batohu
    ),
    new ScenarioStep(tsPUT_DOWN, "Polož Smíchovenec",
        "Černokňažník vybral z kapsy: Smíchovenec",
        "Dommosklo",    // Aktuální prostor
        new String[] { "Varňa", "Zeľuvarenije" },   // Sousedé
        new String[] { "Zamiokulkas", "Lopatkovec", "Smíchovenec",
        "Afrikule", "Šachamašmak" },    // H-objekty
        new String[] { }    // H-objekty v batohu
    ),
    new ScenarioStep(tsHELP, "?",
        """
                 Tvojou úlohou je navariť Pocestnému  ten správny lektvar.
                 
                 Môžeš zadať tieto príkazy:
                 """,
        "Dommosklo",    // Aktuální prostor
        new String[] { "Varňa", "Zeľuvarenije" },   // Sousedé
        new String[] { "Zamiokulkas", "Lopatkovec", "Smíchovenec",
        "Afrikule", "Šachamašmak" },    // H-objekty
        new String[] { }    // H-objekty v batohu
    ),
    new ScenarioStep(tsEND, "Koniec",
        "Hru si ukončil príkazom: Koniec",
        "Dommosklo",    // Aktuální prostor
        new String[] { "Varňa", "Zeľuvarenije" },   // Sousedé
        new String[] { "Zamiokulkas", "Lopatkovec", "Smíchovenec",
        "Afrikule", "Šachamašmak"}, // H-objekty
        new String[] { }    // H-objekty v batohu
    )
);
////////////////////////////////////////////////////////////////////////////////
private static final Scenario MISTAKES = new Scenario(scMISTAKES,
    new ScenarioStep(-1, tsNOT_START, "Štart",
        """
        Prvým príkazom nie je štartovací príkaz.
        Hru, ktorá nebeží, môžeš spustiť iba štartovacím príkazom.
        """,
        "",
        new String[] {},
        new String[] {},
        new String[] {}
    ),
START_STEP,
    new ScenarioStep(1, tsEMPTY, "",
        "Prázdný príkaz sa dá použiť len na spustenie hry",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný", "Pokladňa", "Pohár",
        "Pult", "Stolička" },   // H-obj. v prostoru
        new String[] { }    // H-objekty v batohu
    ),
    new ScenarioStep(tsUNKNOWN, "piko",
        "Tento příkaz neznám: piko",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný", "Pokladňa", "Pohár",
        "Pult", "Stolička" },   // H-obj. v prostoru
        new String[] { }    // H-objekty v batohu
    ),
    new ScenarioStep(tsMOVE_WA, "Choď",
        "Neviemm, kam mám ísť :( . Musíš zadať meno cieľového priestoru.",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný", "Pokladňa", "Pohár",
        "Pult", "Stolička" },   // H-obj. v prostoru
        new String[] { }    // H-objekty v batohu
    ),
    new ScenarioStep(tsTAKE_WA, "Vezmi",
        "Neviem, čo mám zdvihnúť. Musíš zadaž meno objektu.",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný", "Pokladňa", "Pohár",
        "Pult", "Stolička" },   // H-obj. v prostoru
        new String[] { }    // H-objekty v batohu
    ),
    new ScenarioStep(tsPUT_DOWN_WA, "Polož",
        "Neviem, čo mám položiť. Musíš zadat meno objektu.",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný", "Pokladňa", "Pohár",
        "Pult", "Stolička" },   // H-obj. v prostoru
        new String[] { }    // H-objekty v batohu
    ),
    new ScenarioStep(tsBAD_NEIGHBOR, "Choď Šakesikatameles",
        "Do zadaného priestoru sa odtiaľto nedá ísť: Šakesikatameles",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný", "Pokladňa", "Pohár",
        "Pult", "Stolička" },   // H-obj. v prostoru
        new String[] { }    // H-objekty v batohu
    ),
    new ScenarioStep(tsBAD_ITEM, "Vezmi Mixér",
        "Zadaný objekt v priestore nie je: Mixér",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný", "Pokladňa", "Pohár",
        "Pult", "Stolička" },   // H-obj. v prostoru
        new String[] { }    // H-objekty v batohu
    ),
    new ScenarioStep(tsUNMOVABLE, "Vezmi Pult",
        "Zadaný objekt nemôžeš zdvihnúť: Pult",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný", "Pokladňa", "Pohár",
        "Pult", "Stolička" },   // H-obj. v prostoru
        new String[] { }    // H-objekty v batohu
    ),
    new ScenarioStep(tsTAKE, "Vezmi Pohár",
        "Černokňažník vzal do kapsy objekt: Pohár",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný", "Pokladňa",
        "Pult", "Stolička" },    // H-obj. v prostoru
        new String[] { "Pohár" }    // H-objekty v batohu
    )
    ,
    new ScenarioStep(tsTAKE, "Vezmi Pokladňa",
        "Černokňažník vzal do kapsy objekt: Pokladňa",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný",  "Pult",
        "Stolička" },   // H-obj. v prostoru
        new String[] { "Pokladňa", "Pohár" }    // H-objekty v batohu
    ),
    new ScenarioStep(tsBAG_FULL, "Vezmi Stolička",
        "Zadaný objekt sa už do kapsy nevojde: Stolička",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný",  "Pult",
        "Stolička"},    // H-obj. v prostoru
        new String[] { "Pokladňa", "Pohár"} // H-objekty v batohu
    ),
    new ScenarioStep(tsNOT_IN_BAG, "Polož Stolička",
        "Zadaný objekt nemáš v kapse: Stolička",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný",  "Pult",
        "Stolička"},    // H-obj. v prostoru
        new String[] { "Pokladňa", "Pohár"} // H-objekty v batohu
    ),
    new ScenarioStep(tsHELP, "?",
        """
        Tvojou úlohou je navariť Pocestnému  ten správny lektvar.
                 
        Môžeš zadať tieto príkazy:
        """,
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný",  "Pult",
        "Stolička"},    // H-obj. v prostoru
        new String[] { "Pokladňa", "Pohár"} // H-objekty v batohu
    ),
    new ScenarioStep(tsEND, "Koniec",
        "Hru si ukončil príkazom Koniec",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný",  "Pult",
        "Stolička"},    // H-obj. v prostoru
        new String[] { "Pokladňa", "Pohár"} // H-objekty v batohu
    )
);
////////////////////////////////////////////////////////////////////////////////
private static final Scenario MISTAKES_NS  = new Scenario(scMISTAKES_NS,
    HAPPY.steps().get(0),
    HAPPY.steps().get(1),   //Pozdrav Pocestný
    new ScenarioStep(tsNS0_WrongCond, "Pozdrav",
        "Už si pozdravil, načo to robiť zas.",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný", "Pokladňa",
        "Pohár", "Pult", "Stolička" },  // H-obj. v prostoru
        new String[] { },   // H-objekty v batohu
        Map.of("pocestny.pozdraveny",  true),   //Očekávané příznak
        null    //Nastavované příznaky
    ),
    HAPPY.steps().get(2),   //Choď Dommosklo
    HAPPY.steps().get(3),   //Vezmi Smíchovenec
    HAPPY.steps().get(4),   //Choď Varňa
    HAPPY.steps().get(5),   //Choď Špajza
    HAPPY.steps().get(6),   //Vezmi Dračigrc
    HAPPY.steps().get(7),   //Vezmi Šaliva
    HAPPY.steps().get(8),   //Choď Varňa
    HAPPY.steps().get(9),   //Vezmi Varecha
    HAPPY.steps().get(10),  //Choď studňa
    new ScenarioStep(tsNS2_1Args, "Naber vodu",
        "Musíš nabrať čistú vodu",
        "Studňa",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] {},    // H-objekty
        new String[] { "Smíchovenec", "Dračígrc",
        "Šalvia", "Varecha" },  // H-objekty v batohu
        Map.of("voda.nabrata",  false), //Očekávané příznaky
        null    //Nastavované příznaky
    ),
    new ScenarioStep(tsNS2_WRONG_1stARG, "Naber špinavú vodu",
        "Musíš nabrať čistú vodu.",
        "Studňa",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] {},    // H-objekty
        new String[] { "Smíchovenec", "Dračígrc",
        "Šalvia", "Varecha" },  // H-objekty v batohu
        Map.of("voda.nabrata",  false), //Očekávané příznaky
        null    //Nastavované příznaky
    ),
    new ScenarioStep(tsNS2_WRONG_2ndARG, "Naber čistú pálenku",
         "Musíš nabrať čistú vodu.",
         "Studňa",  // Aktuální prostor
         new String[] { "Varňa" },  // Sousedé
         new String[] {},   // H-objekty
         new String[] { "Smíchovenec", "Dračígrc",
         "Šalvia", "Varecha" }, // H-objekty v batohu
        Map.of("voda.nabrata",  false), //Očekávané příznaky
         null   //Nastavované příznaky
    ),
    HAPPY.steps().get(11),
    new ScenarioStep(tsNS2_WrongCond, "Naber čistú vodu",
        "Už si vodu nabral, načo to robiť znova",
        "Studňa",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] {},    // H-objekty
        new String[] { "Smíchovenec", "Dračígrc", "Šalvia",
        "Varecha", "Voda" },
        Map.of("voda.nabrata",  false), //Očekávané příznaky
        null    //Nastavované příznaky
        ),
    HAPPY.steps().get(12),
    HAPPY.steps().get(13),
    HAPPY.steps().get(14),
    HAPPY.steps().get(15),
    HAPPY.steps().get(16),
    new ScenarioStep(tsNS3_WRONG_1stARG, "Zapáľ seba pod kotlom",
        "Musíš zapáliť oheň pod kotlom",
        "Kotlík",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] { "Smíchovenec", "Dračígrc",
        "Šalvia", "Voda" }, // H-objekty
        new String[] {"Varecha"},   // H-objekty v batohu
        Map.of("ohen.zapaleny", false), //Očekávané příznaky
        null    // Nastavované příznaky
    ),
    new ScenarioStep(tsNS3_WRONG_2ndARG, "Zapáľ oheň nad kotlom",
        "Musíš zapáliť oheň pod kotlom",
        "Kotlík",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] { "Smíchovenec", "Dračígrc",
        "Šalvia", "Voda" },   // H-objekty
        new String[] {"Varecha"},   // H-objekty v batohu
        Map.of("ohen.zapaleny", false), //Očekávané příznaky
        null   // Nastavované příznaky
    ),
    new ScenarioStep(tsNS3_WRONG_3rdARG, "Zapáľ oheň pod sebou",
        "Musíš zapáliť oheň pod kotlom",
        "Kotlík",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] { "Smíchovenec", "Dračígrc",
        "Šalvia", "Voda" }, // H-objekty
        new String[] {"Varecha"},   // H-objekty v batohu
        Map.of("ohen.zapaleny", false), //Očekávané příznaky
        null    // Nastavované příznaky
    ),
    HAPPY.steps().get(17),
    new ScenarioStep(tsNS1_0Args, "Zamiešaj",
        "Neviem čo mám zamiešať. Musíš zadať meno objektu.",
        "Kotlík",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] { "Smíchovenec", "Dračígrc",
        "Šalvia", "Voda"},  // H-objekty
        new String[] {"Varecha"},   // H-objekty v batohu
        Map.of("lektvar.zamiesany", false), //Očekávané příznaky
        null    // Nastavované příznaky
    ),
    new ScenarioStep(tsNS1_WRONG_ARG, "Zamiešaj Kotlík",
        "Musíš zamiešať Lektvar",
        "Kotlík",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] { "Smíchovenec", "Dračígrc",
        "Šalvia", "Voda"},  // H-objekty
        new String[] {"Varecha"},   // H-objekty v batohu
        Map.of("lektvar.zamiesany", false), //Očekávané příznaky
        null    // Nastavované příznaky
        ),
    HAPPY.steps().get(18),
    new ScenarioStep(tsNS1_WrongCond, "Zamiešaj Lektvar",
        "Načo miešať lektvar, keď už je namiešaný.",
        "Kotlík",   // Aktuální prostor
        new String[] { "Varňa" },   // Sousedé
        new String[] { "Lektvar" }, // H-objekty
        new String[] {"Varecha"},   // H-objekty v batohu
        Map.of("lektvar.zamiesany", false), //Očekávané příznaky
        null    // Nastavované příznaky
    ),
    HAPPY.steps().get(19),
    HAPPY.steps().get(20),
    HAPPY.steps().get(21),
    new ScenarioStep(tsNOT_SUCCESS, "Naservíruj",
        "Černokňažník ešte neuvaril Lektvar",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný", "Pokladňa", "Pohár",
        "Pult", "Stolička" },   // H-objekty
        new String[] {"Varecha", "Lektvar"},    // H-objekty v batohu
        Map.of(
                "pocestny.pozdraveny",  true,
                "voda.nabrata",         false,
                "ohen.zapaleny",        false,
                "lektvar.zamiesany",    false,
                "lektvar.naservirovany",false), //Očekávané příznaky
        null    // Nastavované příznaky
    ),
    new ScenarioStep(tsEND, "Koniec",
        "Hru si ukončil príkazom Koniec",
        "Zeľuvarenije", // Aktuální prostor
        new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] { "Pocestný", "Pokladňa", "Pohár",
        "Pult", "Stolička" },   // H-objekty
        new String[] {"Varecha", "Lektvar"} // H-objekty v batohu
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
