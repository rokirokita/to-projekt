/*----------------------------------------------------------------------------
    World Database - Copyright  ObjectDB Software. All Rights Reserved.
----------------------------------------------------------------------------*/

package com.objectdb.world;

import javax.persistence.*;


/**
 * The City class represents a major city.
 */
@Entity
public class City {
	
    //--------------//
    // Data Members //
    //--------------//

    /** ID (Auto) */
    @Id @GeneratedValue
    private long id;

	/** City name */
    private String name;

	/** Population size */
    private long population;

	/** Indicates a capital city */
    private boolean capital;

    //------------//
    // Properties //
    //------------//

    // Name:

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    // Population:

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

    // Capital:

	public boolean isCapital() {
		return capital;
	}

	public void setCapital(boolean capital) {
		this.capital = capital;
	}

    //--------------//
    // Misc Methods //
    //--------------//

	/**
	 * Gets a string representation of this.
	 */
	@Override
	public String toString() {
		return name;
	}
}
