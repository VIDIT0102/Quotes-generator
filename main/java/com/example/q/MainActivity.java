package com.example.q;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] quotes = {
            "Believe in yourself!",
            "Stay positive, work hard, make it happen.",
            "Don’t watch the clock; do what it does. Keep going.",
            "Success is what comes after you stop making excuses.",
            "Dream big and dare to fail.",
            "Push yourself, because no one else is going to do it for you.",
            "Great things never come from comfort zones."
    };

    TextView quoteTextView;
    Button generateButton;
    ProgressBar loadingSpinner;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteTextView);
        generateButton = findViewById(R.id.generateButton);
        loadingSpinner = findViewById(R.id.loadingSpinner);
        random = new Random();

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show spinner and clear current quote
                loadingSpinner.setVisibility(View.VISIBLE);
                quoteTextView.setText("");

                // Simulate loading delay
                new Handler().postDelayed(() -> {
                    int index = random.nextInt(quotes.length);
                    quoteTextView.setText(quotes[index]);
                    loadingSpinner.setVisibility(View.GONE);
                }, 1000); // 1 second delay
            }
        });
    }
}
