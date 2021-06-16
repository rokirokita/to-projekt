/*----------------------------------------------------------------------------
    World Database - Copyright ObjectDB Software. All Rights Reserved.
----------------------------------------------------------------------------*/

package com.objectdb.world;

import javax.persistence.Embeddable;


/**
 * The GDP class represents GDP details (PPP) of a country.
 */
@Embeddable
public class GDP {

    //--------------//
    // Data Members //
    //--------------//

	/** Total GDP in USD */
    private long total;

	/** GDP per capita in USD */
    private int perCapita;

    //------------//
    // Properties //
    //------------//
    
    // Total:

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

    // Per Capita:

	public int getPerCapita() {
		return perCapita;
	}

	public void setPerCapita(int perCapita) {
		this.perCapita = perCapita;
	}

    //--------------//
    // Misc Methods //
    //--------------//

	/**
	 * Gets a string representation of this.
	 */
	@Override
	public String toString() {
		return total + " " + perCapita;
	}
}
