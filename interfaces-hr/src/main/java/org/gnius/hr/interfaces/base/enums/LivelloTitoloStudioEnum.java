package org.gnius.hr.interfaces.base.enums;

/** Elenco dei possibili livelli dei titoli di studio.<br>
 * N.B. mantenere allineato con relativo elenco sul frontend.<br>
 * @author gianluca
 *
 */
public enum LivelloTitoloStudioEnum {
	INFANZIA, 		// Scuola infanzia
	PRIMARIA,		// Scuola primaria (elementari)
	SECONDARIA1,	// Secondaria 1° grado (medie)
	SECONDARIA2,	// Secondaria 2° grado (superiori, tecnico/professionale/liceo)
	SUPERIORE1,		// Superiore 1° ciclo (Laurea Breve)
	SUPERIORE2,		// Superiore 2° ciclo (Laurea magistrale)
	SUPERIORE3,		// Superiore 3° ciclo (dottorato ricerca)
	SUPERIOREALT;	// Superiore Altro (Diploma specializzazione, master, diploma perfezionamento)
}
