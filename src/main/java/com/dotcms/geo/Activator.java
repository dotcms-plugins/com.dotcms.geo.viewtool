/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.dotcms.geo;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.osgi.framework.BundleContext;
import com.dotcms.geo.viewtool.GeoToolInfo;
import com.dotmarketing.loggers.Log4jUtil;
import com.dotmarketing.osgi.GenericBundleActivator;
import com.dotmarketing.util.Logger;

public final class Activator extends GenericBundleActivator {

    private LoggerContext pluginLoggerContext;



    @Override
    public void start(BundleContext context) throws Exception {
        initializeServices(context);
        // Initializing log4j...
        LoggerContext dotcmsLoggerContext = Log4jUtil.getLoggerContext();
        // Initialing the log4j context of this plugin based on the dotCMS logger context
        pluginLoggerContext = (LoggerContext) LogManager.getContext(this.getClass().getClassLoader(), false, dotcmsLoggerContext,
                        dotcmsLoggerContext.getConfigLocation());



        // Registering the ViewTool service
        registerViewToolService(context, new GeoToolInfo());

        Logger.info(this.getClass(), "Starting GeoTool");

    }


    @Override
    public void stop(BundleContext context) throws Exception {
        unregisterViewToolServices();



        // Shutting down log4j in order to avoid memory leaks
        Log4jUtil.shutdown(pluginLoggerContext);
    }



}
