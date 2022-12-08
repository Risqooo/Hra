/* L:/p2_IMP/a0a_happy.jsh
Příliš žluťoučký kůň úpěl ďábelské ó - PŘÍLIŠ ŽLUŤOUČKÝ KŮŇ ÚPĚL ĎÁBELSKÉ Ó

Dokumentační komentář skriptu

/**************************************************************************/
// Potřebné importy

// Datové typy, které budou použity v definici požadovaného scénáře
import adv22w.api.Scenario;             // Vytvářený scénář
import adv22w.api.ScenarioStep;         // jednotlivé kroky scénáře
import adv22w.api.TypeOfScenario;       // Podle typu se zadává název
import static adv22w.api.TypeOfStep.*;  // Importujeme všechny typy kroků

// Datové typy pro test, kterým prověříte korektnost zadání svého scénáře
import adv22w.api.IFactory;             // Interface pro závěrečný test


/**************************************************************************/
// Identifikace autora/autorky

/** Login autora/autorky velkými písmeny. */
String AUTHOR_ID = "A0A";

/** Jméno autora ve tvaru PŘÍJMENÍ Křestní. */
String AUTHOR_NAME = "HAPPY Scenario";

/** Jméno autora ve tvaru PŘÍJMENÍ Křestní zapsané v jeho rodném jazyce. */
public String NATIVE_NAME =  "ŠŤASTNÝ Scénář";

/** Ćas začátku kroužku - jedna z hodnot 3_1245, 3_1430. */
public String AUTHOR_GROUP = "0_0000";



/**************************************************************************/
// Vlastní šťastný scénář

Scenario HAPPY = new Scenario(TypeOfScenario.scHAPPY,
    new ScenarioStep(0, tsSTART, "",
        Vítejte!\nToto je příběh o Červené Karkulce, babičce a vlkovi.\n"
        Svými příkazy řídíte Karkulku, aby donesla bábovku a víno\n"
        babičce v chaloupce za temným lesem.\n"
        Když přijde do chaloupky, měla by položit dárky, vzbudit babičku,\n"
        pozdravit a popřát jí k narozeninám.\n"
        Jste-li dobrodružné typy, můžete to místo s babičkou provést\n"
        s vlkem, který spí v temném lese.\n\n"
        Nebudete-li si vědět rady, zadejte znak ?, jenž zobrazí nápovědu."
        ,
        "Domeček",                                       // Aktuální prostor
    new String[] { "Les" },                              // Sousedé
        new String[] { "Bábovka", "Víno", "Stůl", "Panenka", }, // H-objekty
        new String[] { }                                // H-objekty v batohu
        )
        ,
    new ScenarioStep(tsTAKE, "Vezmi víno",
            "Karkulka dala do košíku objekt: "
          + "Víno"
            ,
            "Domeček",                                  // Aktuální prostor
            new String[] { "Les" },                     // Sousedé
            new String[] { "Bábovka", "Stůl", "Panenka", },// H-o v prostoru
            new String[] { "Víno", }                    // H-objekty v batohu
        )
        ,
    new ScenarioStep(tsTAKE, "Vezmi Bábovka",
            "Karkulka dala do košíku objekt: "
          + "Bábovka"
            ,
            "Domeček",                                // Aktuální prostor
            new String[] { "Les" },                   // Sousedé
            new String[] { "Stůl", "Panenka", },      // H-objekty v prostoru
            new String[] { "Bábovka", "Víno", }       // H-objekty v batohu
        )
        ,
    new ScenarioStep(tsGOTO, "Jdi Les",
        "Karkulka se přesunula do prostoru:\n"
      + "Les s jahodami, malinami a pramenem vody"
        ,
        "Les",                                      // Aktuální prostor
        new String[] { "Domeček", "Temný_les" },    // Sousedé
        new String[] { "Maliny", "Jahody", "Studánka", },// H-o v prostoru
        new String[] { "Bábovka", "Víno",  }        // H-objekty v batohu
        )
        ,
    new ScenarioStep(tsGOTO, "Jdi Temný_les",
        "Karkulka se přesunula do prostoru:\n"
      + "Temný_les s jeskyní a číhajícím vlkem"
        ,
        "Temný_les",
        new String[] { "Les", "Jeskyně", "Chaloupka", },
        new String[] { "Vlk", },
        new String[] { "Bábovka", "Víno", }
        )
        ,
    new ScenarioStep(tsGOTO, "Jdi Chaloupka",
        "Karkulka se přesunula do prostoru:\n"
      + "Chaloupka, kde bydlí babička"
        ,
        "Chaloupka",
        new String[] { "Temný_les" },
        new String[] { "Postel", "Stůl", "Babička", },
        new String[] { "Bábovka", "Víno", }
        )
        ,
    new ScenarioStep(tsPUT_DOWN, "Polož Bábovka",
        "Karkulka vyndala z košíku objekt: "
      + "Bábovka"
        ,
        "Chaloupka",
        new String[] { "Temný_les" },
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", },
        new String[] { "Víno", }
        )
        ,
    new ScenarioStep(tsPUT_DOWN, "Polož Víno",
        "Karkulka vyndala z košíku objekt: "
      + "Víno"
        ,
        "Chaloupka",
        new String[] { "Temný_les" },
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
        new String[] { }
        )
        ,
    new ScenarioStep(tsNS_1, "Probuď babička",
        "Karkulka probudila osobu: "
      + "Babička"
        ,
        "Chaloupka",
        new String[] { "Temný_les" },
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
        new String[] { }
        )
        ,
    new ScenarioStep(tsNS_0, "Pozdrav",
        "Karkulka pozdravila osobu: "
      + "Babička"
        ,
        "Chaloupka",
        new String[] { "Temný_les" },
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
        new String[] { }
        )
        ,
    new ScenarioStep(tsSUCCESS, "Popřej",
        "Karkulka popřála babičce vše nejlepší k narozeninám\n"
      + "Úspěšně jste ukončili hru.\n"
      + "Děkujeme, že jste si zahráli."
        ,
        "Chaloupka",
        new String[] { "Temný_les" },
        new String[] { "Postel", "Stůl", "Babička", "Bábovka", "Víno", },
        new String[] { }
        )
    );

/**************************************************************************/
// Test korektnosti scénáře -- NEMĚNIT

void test()
{
    new FactoryTester( new IFactory() {
            public String authorID()    { return AUTHOR_ID;     }
            public String authorName()  { return AUTHOR_NAME;   }
            public String nativeName()  { return NATIVE_NAME;   }
            public String authorGroup() { return AUTHOR_GROUP;  }
            public List<Scenario> scenarios() { return List.of(HAPPY); }
        }).testForLevel(FactoryTester.HAPPY_LEVEL);
}


/**************************************************************************/
