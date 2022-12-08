package adv22w._3_1245.basr01_happy;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. */

import adv22w.api.Scenario;
import adv22w.api.ScenarioStep;
import adv22w.api.TypeOfScenario;
import java.util.List;

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
// Vlastní šťastný scénář

private static final Scenario HAPPY = new Scenario(TypeOfScenario.scHAPPY,
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
                "Černokňažník pozdravil osobu: Pocestný"
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
                "Varňa",                               	          					// Aktuální prostor
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
                "Černokňažník nabral zo studne vodu"
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
                "Černokňažník vybral z kapsy: Smíchovenec"
                ,
                "Kotlík",                               						// Aktuální prostor
                new String[] { "Varňa" },   									// Sousedé
                new String[] { "Smíchovenec" },  								// H-objekty
                new String[] {"Dračígrc", "Šalvia", "Varecha", "Voda" }        	// H-objekty v batohu
        )
        ,

        new ScenarioStep(tsPUT_DOWN, "Polož Dračígrc",
                "Černokňažník vybral z kapsy: Dračígrc"
                ,
                "Kotlík",                               	    		// Aktuální prostor
                new String[] { "Varňa" },   							// Sousedé
                new String[] { "Smíchovenec", "Dračígrc" },  			// H-objekty
                new String[] { "Šalvia","Varecha", "Voda" }           	// H-objekty v batohu
        )
        ,

        new ScenarioStep(tsPUT_DOWN, "Polož Šalvia",
                "Černokňažník vybral z kapsy: Šalvia"
                ,
                "Kotlík",                               	          				// Aktuální prostor
                new String[] { "Varňa" },   								// Sousedé
                new String[] { "Smíchovenec", "Dračígrc", "Šalvia"},  		// H-objekty
                new String[] {"Varecha", "Voda"}                                    			// H-objekty v batohu
        )
        ,
        new ScenarioStep(tsPUT_DOWN, "Polož Voda",
                "Černokňažník vybral z kapsy: Voda"
                ,
                "Kotlík",                               	          			// Aktuální prostor
                new String[] { "Varňa" },   									// Sousedé
                new String[] { "Smíchovenec", "Dračígrc", "Šalvia", "Voda"},  	// H-objekty
                new String[] {"Varecha"}                                    	// H-objekty v batohu
        )
        ,
        new ScenarioStep(tsNS_3, "Zapáľ oheň pod kotlom",
                "Černokňažník zapálil oheň pod kotlom"
                ,
                "Kotlík",                               	          			// Aktuální prostor
                new String[] { "Varňa" },   									// Sousedé
                new String[] { "Smíchovenec", "Dračígrc", "Šalvia", "Voda"},  	// H-objekty
                new String[] {"Varecha"}                                    	// H-objekty v batohu
        )
        ,

        new ScenarioStep(tsNS_0, "Zamiešaj",
                "Černokňažník zamiešal obsah kotlíka a vyrobil: Lektvar Zamiešaj"
                ,
                "Kotlík",                           // Aktuální prostor
                new String[] { "Varňa" },   		// Sousedé
                new String[] { "Lektvar"},  		// H-objekty
                new String[] {"Varecha"}            // H-objekty v batohu
        )
        ,
        new ScenarioStep(tsTAKE, "Vezmi Lektvar",
                "Černokňažník vzal do kapsy objekt: Lektvar"
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



//##############################################################################
//\CF== CLASS (STATIC) METHODS =================================================

    /***************************************************************************
     * Vrátí seznam definovaných scénářů.
     *
     * @return Seznam spravovaných scénářů
     */
    static List<Scenario> scenarios()
    {
        return List.of(HAPPY);
    }



//##############################################################################
//\IC== INSTANCE ATTRIBUTES (FIELDS) ===========================================



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     */
    public CK_Scenarios()
    {
    }



//##############################################################################
//\IA== INSTANCE METHODS =======================================================
}
