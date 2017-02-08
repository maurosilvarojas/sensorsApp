package rms.sensorsapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener
{

    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Log.i ("SSSSSSSSSSSSSSM", "Before");
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION) != null)
            Log.i ("SSSSSSSSSSSSSSM", "Orienation");
        else
            Log.i ("SSSSSSSSSSSSSSM", "No Orienation");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        // for the system's orientation sensor registered listeners
        //sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_GAME);

    }

    @Override
    protected void onPause()
    {
        super.onPause();
        // to stop the listener and save battery
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        // TODO Auto-generated method stub
        Log.i("SensorID"," "+ event.sensor);
        String s = "X:" + event.values[0] + " Y:" + event.values[1] + " Z:" + event.values[2];
        Log.i("Accelerometer", s);
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText(s);
    }

}
