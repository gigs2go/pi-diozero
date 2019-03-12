package com.gigs2go.diozero.motor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.diozero.api.DigitalOutputDevice;
import com.diozero.api.PwmOutputDevice;
import com.diozero.api.motor.MotorBase;
import com.diozero.util.RuntimeIOException;

public class PWMMotor extends MotorBase
{
        private static final Logger log = LoggerFactory.getLogger( PWMMotor.class );
        
        private float value = 0;
        private DigitalOutputDevice inA = null;
        private DigitalOutputDevice inB = null;
        private PwmOutputDevice pwm = null;
        

        public PWMMotor( int inA, int inB, int pwm )
        {
            log.debug( "Starting ... {},{},{}", inA, inB, pwm );
            this.inA = new DigitalOutputDevice( inA );
            this.inB = new DigitalOutputDevice( inB );
            this.pwm = new PwmOutputDevice( pwm );
        }

        @Override
        public void forward( float speed ) throws RuntimeIOException
        {
            value = speed;
            inA.on();
            inB.off();
            pwm.setValue( speed );
        }

        @Override
        public void backward( float speed ) throws RuntimeIOException
        {
            value = -speed;
            inA.off();
            inB.on();
            pwm.setValue( speed );
        }

        @Override
        public void stop() throws RuntimeIOException
        {
            value = 0;
            inA.off();
            inB.off();
            pwm.setValue( 0 );
        }

        @Override
        public float getValue() throws RuntimeIOException
        {
            return value;
        }

        @Override
        public boolean isActive() throws RuntimeIOException
        {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void close() throws IOException
        {
            // TODO Auto-generated method stub
            
        }

}
