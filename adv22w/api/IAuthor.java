package adv22w.api;
/* Saved in UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤ */



/*******************************************************************************
 * Instance interfejsu {@code IAuthor} umějí na požádání vrátit
 * jméno a identifikační řetězec autora/autorky své třídy.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2022-Winter
 */
public interface IAuthor
{
//\AG== ABSTRACT GETTERS AND SETTERS ===========================================
////////// Identifikace autora/autorky celého balíčku //////////

    /***************************************************************************
     * Vrátí identifikační řetězec autora/autorky programu
     * zapsaný VELKÝMI PÍSMENY.
     * Tímto řetězcem bývá většinou login do informačního systému školy.
     *
     * @return Identifikační řetězec autora/autorky programu
     */
    //@Override
    public String authorID()
    ;


    /***************************************************************************
     * Vrátí jméno autora/autorky programu ve formátu <b>PŘÍJMENÍ Křestní</b>,
     * tj. nejprve příjmení psané velkými písmeny a za ním křestní jméno,
     * u nějž bude velké pouze první písmeno a ostatní písmena budou malá.
     * Má-li autor programu více křestních jmen, může je uvést všechna.
     *
     * @return Jméno autora/autorky programu ve tvaru PŘÍJMENÍ Křestní
     */
    //@Override
    public String authorName()
    ;


    /***************************************************************************
     * Vrátí jméno autora/autorky programu ve formátu <b>PŘÍJMENÍ Křestní</b>,
     * zapsané v jeho rodném jazyce.
     *
     * @return Jméno autora/autorky programu v jeho/jejím rodném jazyce
     */
    //@Override
    public String authorNativeName()
    ;


    /***************************************************************************
     * Vrátí identifikační řetězec skupiny, kterou autor navštěvuje.
     * Ten začíná pořadovým číslem dne v týdnu následovaný znakem podtržení.
     * a čtyřčíslím označujícím začátek vyučovací hodiny,
     * takže v roce 2022 buď 3_1245 nebo 3_1430.
     *
     * @return Identifikační řetězec skupiny
     */
    //@Override
    public String authorGroup()
    ;



//\DM== REMAINING DEFAULT METHODS ==============================================

    /***************************************************************************
     * Vrátí řetězec skládající se z ID autora následovaného jeho jménem.
     * Metoda slouží jako obejití nemožnosti implementace implicitní metody
     * přebíjející metodu {@code toString()}.
     *
     * @return ID a jméno autora
     */
    public default String authorString()
    {
        return authorID() + " — " + authorNativeName()
             + " (" + authorName() + " — " + authorGroup() + ")";
    }

}
