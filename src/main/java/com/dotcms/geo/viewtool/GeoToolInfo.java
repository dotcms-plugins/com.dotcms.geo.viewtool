package com.dotcms.geo.viewtool;

import org.apache.velocity.tools.view.context.ViewContext;
import org.apache.velocity.tools.view.servlet.ServletToolInfo;

public class GeoToolInfo extends ServletToolInfo {

    @Override
    public String getKey () {
        return "geotool";
    }

    @Override
    public String getScope () {
        return ViewContext.REQUEST;
    }

    @Override
    public String getClassname () {
        return GeoTool.class.getName();
    }

    @Override
    public Object getInstance ( Object initData ) {

        GeoTool viewTool = new GeoTool();
        viewTool.init( initData );

        setScope( ViewContext.REQUEST );

        return viewTool;
    }

}