/*----------------------------------------------------------------------------
    World Database - Copyright � ObjectDB Software. All Rights Reserved.
----------------------------------------------------------------------------*/

package com.objectdb.world;

import java.util.*;

import javax.persistence.*;


/**
 * The Border class represents the boundary between two countries.
 */
@Entity
public class Border {

    //--------------//
    // Data Members //
    //--------------//

    /** Countries*/
	private Country[] countries;

    /** Length of the common boundary in kilometers */ 
	private int length;

    //------------//
    // Properties //
    //------------//

    // Countries:

	public Country[] getCountries() {
		if (countries == null)
			countries = new Country[2]; 
		return countries;
	}

    // Length:

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

    //--------------//
    // Misc Methods //
    //--------------//

	/**
	 * Gets a string representation of this.
	 */
	@Override
	public String toString() {
		return Arrays.toString(countries);
	}
}
