package p06_TirePressureMonitoringSystem;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {

    //1. If we have pressure below the minimum(pressure < 17).-> alarm on(true)
    @Test
    public void testAlarmIsOnWithLowerValue(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.9);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.getAlarmOn());

    }
    //2. if we have pressure above the maximum(pressure > 21).-> alarm on(true)
    @Test
    public void testAlarmIsOnWithPressureAboveTheMax(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(21.2);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.getAlarmOn());

    }

    //3. if the pressure is between 17 and 21. alarm should stay off(false).

    @Test
    public void testAlarmIsOffWhenPressureIsNormal(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.9);

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

}