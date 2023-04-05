package com.project.mytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.project.mytest.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;

                case R.id.settings:
                    replaceFragment(new SettingsFragment());
                    break;
            }

            return true;

        });

        binding.mainLaunchButton.setOnClickListener(v -> {
            Toast.makeText(this, "Launch the rocket", Toast.LENGTH_SHORT).show();

//            Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
//            Uri intentUri =
//                    Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
//                            .appendQueryParameter("file", "https://https://absolutezero-cmd.github.io//nicemodel.gltf")
//                            .build();
//            sceneViewerIntent.setData(intentUri);
//            sceneViewerIntent.setPackage("com.google.ar.core");
//            startActivity(sceneViewerIntent);

            Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
            sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://absolutezero-cmd.github.io/nicemodel.gltf"));
            sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
            startActivity(sceneViewerIntent);
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}