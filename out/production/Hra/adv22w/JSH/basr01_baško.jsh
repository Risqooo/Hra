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
import adv22w.testers.FactoryTester;    // Tester jenž vše prověří
import adv22w.api.IFactory;             // Interface pro závěrečný test
import java.util.List;                  // Bude potřeba v závěrečném testu


/**************************************************************************/
// Identifikace autora/autorky

/** Login autora/autorky velkými písmeny. */
String AUTHOR_ID = "BASR01";

/** Jméno autora ve tvaru PŘÍJMENÍ Křestní. */
String AUTHOR_NAME = "BAŠKO Richard";

/** Jméno autora ve tvaru PŘÍJMENÍ Křestní zapsané v jeho rodném jazyce. */
public String NATIVE_NAME =  "BAŠKO Richard";

/** Ćas začátku kroužku - jedna z hodnot 3_1245, 3_1430. */
public String AUTHOR_GROUP = "3_1245";



/**************************************************************************/
// Vlastní šťastný scénář

Scenario HAPPY = new Scenario(TypeOfScenario.scHAPPY,
    new ScenarioStep(0, tsSTART, "",
        "Vitajte!\n"
		+"Toto je príbeh o Černokňažníkovi a jeho obchode Zeľuvarenije.\n"
		+"Vašou úlohou je pripraviť lektvar Pocestnému.\n"
		+"Najprv ako slušný Černokňažník \n"
		+"musíte pozdraviť Pocestného a až potom môžete ísť \n"
		+"natrhať Smíchovec do dommosklo a presunúť sa do varni v ktorej je špajza,\n"
		+"z ktorej vezmete dračígrc a šalviu. Nájdete tam však aj iné veci, \n"
		+"s ktorými môžete kľudne experimentovať a vymýšľat iné lektvary ;).\n"
		+"Vo varni okrem špajzi nájdete aj kotlík, varechu a studňu,\n"
		+"z ktorej musíte nabrať vodu.\n"
		+"Následne vložíte všetky ingrediencie do kotlíka, zalejete vodou\n"
		+"a zapálite oheň pod kotlíkom. Potom môžete zamiešať varechou.\n"
		+"Keď budete mať lektvar vychladný vezmite ho z kotlíka.\n"
		+"Už len zostáva vrátiť sa do obchodu a lektvar naservírovať pocestnému.\n"
		+"Keď sa nebudete vedieť pohnúť v hre ďalej zadajte znak ?. To zobrazí nápovedu.\n"
		+"Prajeme Vám pekný zážitok z hry."
        ,

        "Zeľuvarenije",                                         	// Aktuální prostor
    	new String[] { "Varňa", "Dommosklo" },   					// Sousedé
        new String[] {"Pocestný"},                                  // H-objekty
        new String[] { }                                        	// H-objekty v batohu
        )
    ,
		new ScenarioStep(tsNS_1, "Pozdrav Pocestný",
				"Černokňažník pozdravil osobu: \n"
				+"Pocestný"
	,
		"Zeľuvarenije",												//Aktuální prostor
		new String[] {"Varňa", "Dommosklo" },   					// Sousedé
		new String[] {"Pocestný"},                                  // H-objekty
		new String[] { }                                        	// H-objekty v batohu
		)
	,
        new ScenarioStep(tsGOTO, "Choď Dommosklo",
                "Černokňažník sa presunul do priestoru:\n"
                + "Dommosklo v ktorom rastú: \n"
				+ "Zamiokulkas, Lopatkovec, Smíchovenec, Afrikule a Šachamašmak"
	,
        "Dommosklo",                               	          									// Aktuální prostor
    	new String[] { "Varňa", "Zeľuvarenije"},   												// Sousedé
        new String[] { "Zamiokulkas", "Lopatkovec", "Smíchovenec", "Afrikule", "Šachamašmak"},  // H-objekty
        new String[] { }                                        								// H-objekty v batohu
        )
	,

	new ScenarioStep(tsTAKE, "Vezmi Smíchovenec",
		"Černokňažník vzal do kapsy objekt: "
		+ "Smíchovenec"
		,
		"Dommosklo",                               	          						// Aktuální prostor
    	new String[] { "Varňa", "Zeľuvarenije"},   									// Sousedé
        new String[] { "Zamiokulkas", "Lopatkovec", "Afrikule", "Šachamašmak"},  	// H-objekty
        new String[] { "Smíchovenec" }                                        		// H-objekty v batohu
        )
	,

	new ScenarioStep(tsGOTO, "Choď Varňa",
                "Černokňažník sa presunul do priestoru:\n"
                + "Varňa v ktorom sa nachádza: \n"
				+"kotlík, špajza, studňa a varecha"
	,
        "Varňa",                               	          							// Aktuální prostor
    	new String[] { "Dommosklo", "Zeľuvarenije", "Kotlík", "Špajza", "Studňa"},  // Sousedé
        new String[] {"Varecha"},  													// H-objekty
        new String[] { "Smíchovenec" }                                      		// H-objekty v batohu
        )
	,

	new ScenarioStep(tsGOTO, "Choď Špajza",
                "Černokňažník sa presunul do priestoru:\n"
                + "Špajza v ktorom sa nachádza: \n"
				+"Dračígrc, Okomlok, Šalvia, Stromohnát a Rumbagule"
	,
        "Špajza",                               	          							// Aktuální prostor
    	new String[] {"Varňa"},   														// Sousedé
        new String[] { "Dračígrc", "Okomlok", "Šalvia", "Stromohnát", "Rumbagule" },  	// H-objekty
        new String[] { "Smíchovenec" }                                        			// H-objekty v batohu
        )
	,

	new ScenarioStep(tsTAKE, "Vezmi Dračígrc",
		"Černokňažník vzal do kapsy objekt: "
		+ "Dračígrc"
		,
		"Špajza",                               	          				// Aktuální prostor
    	new String[] { "Varňa"},   											// Sousedé
        new String[] { "Okomlok", "Šalvia", "Stromohnát", "Rumbagule" },  	// H-objekty
        new String[] { "Smíchovenec", "Dračígrc" }                          // H-objekty v batohu
        )
	,

	new ScenarioStep(tsTAKE, "Vezmi Šalvia",
		"Černokňažník vzal do kapsy objekt: "
		+ "Šalvia"
		,
		"Špajza",                               	          		// Aktuální prostor
    	new String[] { "Varňa"},   									// Sousedé
        new String[] { "Okomlok", "Stromohnát", "Rumbagule" },  	// H-objekty
        new String[] { "Smíchovenec", "Dračígrc", "Šalvia" }        // H-objekty v batohu
        )
	,

	new ScenarioStep(tsGOTO, "Choď Varňa",
                "Černokňažník sa presunul do priestoru:\n"
                + "Varňa v ktorom sa nachádza: \n"
				+"kotlík, špajza, studňa a varecha"
	,
    	"Varňa",                               	          							// Aktuální prostor
    	new String[] { "Dommosklo", "Zeľuvarenije", "Kotlík", "Špajza", "Studňa"},  // Sousedé
        new String[] {"Varecha"},  													// H-objekty
        new String[] { "Smíchovenec", "Dračígrc", "Šalvia" }                		// H-objekty v batohu
        )
	,

	new ScenarioStep(tsTAKE, "Vezmi Varecha",
		"Černokňažník vzal do kapsy objekt: "
		+ "Varecha"
	,
		"Varňa",                               	          							// Aktuální prostor
		new String[] { "Dommosklo", "Zeľuvarenije", "Kotlík", "Špajza", "Studňa"},  // Sousedé
		new String[] {},  															// H-objekty
		new String[] { "Smíchovenec", "Dračígrc", "Šalvia","Varecha" }              // H-objekty v batohu
		)
	,
	new ScenarioStep(tsGOTO, "Choď Studňa",
		"Černokňažník sa presunul k:\n"
		+ "Studňa"
	,
		"Studňa",                               	          				// Aktuální prostor
		new String[] { "Varňa" },   										// Sousedé
		new String[] {},  													// H-objekty
		new String[] { "Smíchovenec", "Dračígrc", "Šalvia", "Varecha" }   	// H-objekty v batohu
		)
	,
	new ScenarioStep(tsNS_1, "Naber vodu",
		"Černokňažník nabral zo studne vodu a dal si ju do batohu\n"
	,
		"Studňa",                               	          						// Aktuální prostor
		new String[] { "Varňa" },   												// Sousedé
		new String[] {},  															// H-objekty
		new String[] { "Smíchovenec", "Dračígrc", "Šalvia", "Varecha", "Voda" }   	// H-objekty v batohu
		)
		,




	new ScenarioStep(tsGOTO, "Choď Kotlík",
                "Černokňažník sa presunul ku:\n"
                + "Kotlík ktorý je prázdny."
	,
    	"Kotlík",                               	          						// Aktuální prostor
    	new String[] { "Varňa" },   												// Sousedé
        new String[] {},  															// H-objekty
        new String[] { "Smíchovenec", "Dračígrc", "Šalvia", "Varecha", "Voda" }   	// H-objekty v batohu
        )
	,


	new ScenarioStep(tsPUT_DOWN, "Polož Smíchovenec",
                "Černokňažník vybral z kapsy:\n"
                + "Smíchovenec."
	,
        "Kotlík",                               						// Aktuální prostor
    	new String[] { "Varňa" },   									// Sousedé
        new String[] { "Smíchovenec" },  								// H-objekty
        new String[] {"Dračígrc", "Šalvia", "Varecha", "Voda" }        	// H-objekty v batohu
        )
	,

	new ScenarioStep(tsPUT_DOWN, "Polož Dračígrc",
                "Černokňažník vybral z kapsy:\n"
                + "Dračígrc."
	,
        "Kotlík",                               	    		// Aktuální prostor
    	new String[] { "Varňa" },   							// Sousedé
        new String[] { "Smíchovenec", "Dračígrc" },  			// H-objekty
        new String[] { "Šalvia","Varecha", "Voda" }           	// H-objekty v batohu
        )
	,

	new ScenarioStep(tsPUT_DOWN, "Polož Šalvia",
                "Černokňažník vybral z kapsy:\n"
                + "Šalvia."
	,
        "Kotlík",                               	          				// Aktuální prostor
    	new String[] { "Varňa" },   								// Sousedé
        new String[] { "Smíchovenec", "Dračígrc", "Šalvia"},  		// H-objekty
        new String[] {"Varecha", "Voda"}                                    			// H-objekty v batohu
        )
	,
	new ScenarioStep(tsPUT_DOWN, "Polož Voda",
				"Černokňažník vybral z kapsy:\n"
				+ "Voda."
	,
		"Kotlík",                               	          			// Aktuální prostor
		new String[] { "Varňa" },   									// Sousedé
		new String[] { "Smíchovenec", "Dračígrc", "Šalvia", "Voda"},  	// H-objekty
		new String[] {"Varecha"}                                    	// H-objekty v batohu
		)
	,
	new ScenarioStep(tsNS_3, "Zapáľ oheň pod kotlom",
			"Černokňažník zapálil oheň pod kotlom aby mohol variť lektvary."
	,
		"Kotlík",                               	          			// Aktuální prostor
		new String[] { "Varňa" },   									// Sousedé
		new String[] { "Smíchovenec", "Dračígrc", "Šalvia", "Voda"},  	// H-objekty
		new String[] {"Varecha"}                                    	// H-objekty v batohu
		)
	,

	new ScenarioStep(tsNS_0, "Zamiešaj",
			"Černokňažník zamiešal obsah kotlíka a vyrobil: \n"
			+"Lektvar"
	,
		"Kotlík",                           // Aktuální prostor
		new String[] { "Varňa" },   		// Sousedé
		new String[] { "Lektvar"},  		// H-objekty
		new String[] {"Varecha"}            // H-objekty v batohu
		)
	,
	new ScenarioStep(tsTAKE, "Vezmi Lektvar",
			"Černokňažník vzal do kapsy objekt: \n"
			+"Lektvar"
	,
		"Kotlík",                           	// Aktuální prostor
		new String[] { "Varňa" },   			// Sousedé
		new String[] {},  						// H-objekty
		new String[] {"Varecha", "Lektvar"}     // H-objekty v batohu
		)
	,
	new ScenarioStep(tsGOTO, "Choď Varňa",
			"Černokňažník sa presunul do priestoru:\n"
			+ "Varňa v ktorom sa nachádza: \n"
			+"kotlík, špajza, studňa"
	,
		"Varňa",                               	          							// Aktuální prostor
		new String[] { "Dommosklo", "Zeľuvarenije", "Kotlík", "Špajza", "Studňa"},  // Sousedé
		new String[] {},  															// H-objekty
		new String[] {"Varecha", "Lektvar"}                							// H-objekty v batohu
		)
	,
	new ScenarioStep(tsGOTO, "Choď Zeľuvarenije",
			"Černokňažník sa presunul do priestoru:\n"
			+ "Zeľuvarenije v ktorom sa nachádza: \n"
			+ "Pocestný"
	,
				"Zeľuvarenije",                         // Aktuální prostor
				new String[] { "Varňa", "Dommosklo" },  // Sousedé
				new String[] {"Pocestný"},  						// H-objekty
				new String[] {"Lektvar","Varecha"}      // H-objekty v batohu
	)
	,

	new ScenarioStep(tsSUCCESS, "Naservíruj",
			"Černokňažník naservíroval Pocestnému: "
			+ "Lektvar."
			+ "Úspešne ste ukončili hru.\n"
      		+ "Ďakujeme, že ste si ju zahrali."
	,
        "Zeľuvarenije",                         // Aktuální prostor
    	new String[] { "Varňa", "Dommosklo" },  // Sousedé
        new String[] {},  						// H-objekty
        new String[] {"Varecha"}      // H-objekty v batohu
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
