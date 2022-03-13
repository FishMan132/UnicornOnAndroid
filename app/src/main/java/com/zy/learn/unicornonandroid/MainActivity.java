package com.zy.learn.unicornonandroid;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.zy.learn.unicornonandroid.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'unicornonandroid' library on application startup.
//    static {
//        System.loadLibrary("unicorn_java");
//    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        new Thread(new Runnable() {
            @Override
            public void run() {
                SampleArm.test_arm();
            }
        }).start();
//        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'unicornonandroid' native library, which is packaged with this
     * application.
     */
//    public native String stringFromJNI();
}