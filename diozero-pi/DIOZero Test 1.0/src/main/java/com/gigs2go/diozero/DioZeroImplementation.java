package com.gigs2go.diozero;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DioZeroImplementation
{
    private static final Logger log = LoggerFactory.getLogger( DioZeroImplementation.class );

    public void run( String lookupsFile, String outputDirectory ) throws Exception
    {
        log.debug( "Here " + lookupsFile + " and " + outputDirectory );
    }
}
