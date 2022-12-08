package adv22w.api;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */



/*******************************************************************************
 * Instance interfejsu {@code IBag} představuje úložiště,
 * do nějž hráči ukládají objekty sebrané v jednotlivých prostorech,
 * aby je mohli přenést do jiných prostorů a/nebo použít.
 * Úložiště má konečnou kapacitu definující maximální povolený
 * součet vah objektů vyskytujících se v úložišti.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2022-Winter
 */
public interface IBag
         extends IItemContainer
{
//\AG== ABSTRACT GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Vrátí kapacitu batohu, tj. maximální povolený součet vah objektů,
     * které je možno současně uložit do batohu.
     *
     * @return Kapacita batohu
     */
    //@Override
    public int capacity()
    ;



//\AM== REMAINING ABSTRACT METHODS =============================================

    /***************************************************************************
     * Inicializuje batoh na počátku hry. Vedle inicializace obsahu,
     * inicializuje i informaci o zbývající kapacitě.
     */
    //@Override
    public void initialize()
    ;

}
