package com.dotcms.geo.viewtool;

import java.io.IOException;
import java.util.TimeZone;
import javax.servlet.http.HttpServletRequest;
import org.apache.velocity.tools.view.context.ViewContext;
import org.apache.velocity.tools.view.tools.ViewTool;
import com.dotcms.repackage.com.maxmind.geoip2.exception.GeoIp2Exception;
import com.dotcms.util.GeoIp2CityDbUtil;
import com.dotmarketing.util.UtilMethods;


public class GeoTool implements ViewTool {
    private HttpServletRequest request;
    private final static String GEODATA_IN_SESSION = "GEODATA_IN_SESSION";



    String ipAddress;

    @Override
    public void init(Object initData) {

        ViewContext context = (ViewContext) initData;
        request = context.getRequest();
        
        
        
        
        
        
        ipAddress = resolveIPAddress() ;

    }
    
    private String resolveIPAddress() {

        String xForwardedFor = request.getHeader("x-real-ip");
        if(UtilMethods.isSet(xForwardedFor)) {
            return xForwardedFor;
        }
        return request.getRemoteAddr();
        
    }
    
    
    



    public GeoData getGeo() throws IOException, GeoIp2Exception {

        if (request.getSession().getAttribute(GEODATA_IN_SESSION) != null) {
            return (GeoData) request.getSession().getAttribute(GEODATA_IN_SESSION);
        }
        String city = GeoIp2CityDbUtil.getInstance().getCityName(ipAddress);
        String[] latLong = GeoIp2CityDbUtil.getInstance().getLocationAsString(ipAddress).split(",");

        String continent = GeoIp2CityDbUtil.getInstance().getContinent(ipAddress);

        String country = GeoIp2CityDbUtil.getInstance().getCountryIsoCode(ipAddress);

        TimeZone timeZone = GeoIp2CityDbUtil.getInstance().getTimeZone(ipAddress);

        String stateRegion = GeoIp2CityDbUtil.getInstance().getSubdivisionIsoCode(ipAddress);

        GeoData geo = new GeoData(latLong[0], latLong[1], continent, city, country, stateRegion);
        request.getSession().setAttribute(GEODATA_IN_SESSION, geo);
        return geo;

    }



}
