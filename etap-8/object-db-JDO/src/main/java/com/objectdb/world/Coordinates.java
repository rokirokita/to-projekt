/*----------------------------------------------------------------------------
    World Database - Copyright � ObjectDB Software. All Rights Reserved.
----------------------------------------------------------------------------*/

package com.objectdb.world;

import javax.persistence.Embeddable;


/**
 * The Coordinates class represents country position coordinate.
 */
@Embeddable
public class Coordinates {
	
    //------------//
    // Type Enums //
    //------------//

    /** Latitude type - North or South */
    public enum LatitudeType { N, S }

    /** Longitude type - West or East */
    public enum LongitudeType { W , E }

    //--------------//
    // Data Members //
    //--------------//

    /** North or South */
    private LatitudeType latitudeType;
    
    /** Latitude position */
    private float latitude;
    
    /** West or East  */
    private LongitudeType longitudeType;

    /** Longitude position */
    private float longitude;

    //------------//
    // Properties //
    //------------//

    // North or South:

	public LatitudeType getLatitudeType() {
		return latitudeType;
	}

	public void setLatitudeType(LatitudeType latitudeType) {
		this.latitudeType = latitudeType;
	}

    // Latitude position:
	
	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

    // West or East:
	
	public LongitudeType getLongitudeType() {
		return longitudeType;
	}

	public void setLongitudeType(LongitudeType longitudeType) {
		this.longitudeType = longitudeType;
	}

    // Longitude position:

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

    //--------------//
    // Misc Methods //
    //--------------//

	/**
	 * Gets a string representation of this.
	 */
	@Override
	public String toString() {
		return latitude + " " + latitudeType +
			" " + longitude + " " + longitudeType;
	}
}
