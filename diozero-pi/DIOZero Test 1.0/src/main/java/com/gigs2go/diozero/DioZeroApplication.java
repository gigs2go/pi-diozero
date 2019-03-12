package com.gigs2go.diozero;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gigs2go.diozero.motor.PWMMotor;

@SpringBootApplication
public class DioZeroApplication implements ApplicationRunner
{
    private static final Logger log = LoggerFactory.getLogger( DioZeroApplication.class );

    @Autowired
    private DioZeroImplementation runner;

    public static void main( String[] args )
    {
        System.err.println( "Starting ..." );
        SpringApplication.run( DioZeroApplication.class, args );
    }

    // Ignore call with no arguments - avoid UnitTest error
    public void run() throws Exception
    {
        log.debug( "Called with no args" );
    }

    @Override
    public void run( ApplicationArguments args ) throws Exception
    {
        String[] sourceArgs = args.getSourceArgs();
        log.debug( "Got {} args", sourceArgs.length );
        PWMMotor pwmMotor = new PWMMotor( 1, 2 ,3);
        
    }

}
