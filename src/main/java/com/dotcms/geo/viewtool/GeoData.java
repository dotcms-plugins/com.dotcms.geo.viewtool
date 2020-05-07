package com.dotcms.geo.viewtool;

import java.io.Serializable;

public class GeoData implements Serializable {

    final String latitude,longitude,continent,city,country,stateRegion;

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatLong() {
        return latitude + "," + longitude;
    }
    
    public String getContinent() {
        return continent;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getStateRegion() {
        return stateRegion;
    }
    
    
    

    @Override
    public String toString() {
        return "GeoData [latitude=" + latitude + ", longitude=" + longitude + ", continent=" + continent + ", city=" + city
                        + ", country=" + country + ", stateRegion=" + stateRegion + "]";
    }

    public GeoData(String latitude, String longitude, String continent, String city, String country, String stateRegion) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
        this.continent = continent;
        this.city = city;
        this.country = country;
        this.stateRegion = stateRegion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((continent == null) ? 0 : continent.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
        result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
        result = prime * result + ((stateRegion == null) ? 0 : stateRegion.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GeoData other = (GeoData) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (continent == null) {
            if (other.continent != null)
                return false;
        } else if (!continent.equals(other.continent))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (latitude == null) {
            if (other.latitude != null)
                return false;
        } else if (!latitude.equals(other.latitude))
            return false;
        if (longitude == null) {
            if (other.longitude != null)
                return false;
        } else if (!longitude.equals(other.longitude))
            return false;
        if (stateRegion == null) {
            if (other.stateRegion != null)
                return false;
        } else if (!stateRegion.equals(other.stateRegion))
            return false;
        return true;
    }
    
    
    
    
    
}

