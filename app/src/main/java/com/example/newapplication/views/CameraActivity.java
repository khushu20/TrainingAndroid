package com.example.newapplication.views;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;


import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.newapplication.BuildConfig;
import com.example.newapplication.R;
import com.example.newapplication.databinding.ActivityCameraBinding;
import com.example.newapplication.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> cameraActivityResultLauncher;
    ActivityResultLauncher<Intent> galleryActivityResultLauncher;
    ActivityResultLauncher<Intent> documentActivityResultLauncher;
    private ActivityCameraBinding binding;
    Bitmap bitmap;
    String currentPhotoPath="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_camera);
        // camera launcher
        cameraActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();

                        Uri selectedImage = null;
                        if (data != null) {
                            selectedImage = data.getData();
                            String imagePath = FileUtils.getPath(CameraActivity.this, selectedImage);
                            Log.e("uri", String.valueOf(imagePath));
                        }
                        if (currentPhotoPath == null) {
                            Toast.makeText(getBaseContext(), "Error while capturing image", Toast.LENGTH_LONG).show();
                        } else {
                            File img_file = new File(currentPhotoPath);
                            binding.ivImage.setImageURI(Uri.fromFile(img_file));

                        }
                    }
                });

        binding.btnCapture.setOnClickListener(view -> {

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null) {
                File photoFile = null;
                try {
                    photoFile = createImageFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (photoFile != null) {
                    Uri photoURI = FileProvider.getUriForFile(CameraActivity.this, BuildConfig.APPLICATION_ID + ".provider", photoFile);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                }
            }
            cameraActivityResultLauncher.launch(intent);

        });
        galleryActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();

                        Uri selectedImage = null;
                        if (data != null) {
                            selectedImage = data.getData();
                            String imagePath = FileUtils.getPath(CameraActivity.this, selectedImage);
                            Log.e("uri", String.valueOf(imagePath));
                            try {
                                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                                binding.ivImage.setImageBitmap(bitmap);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }


                    }
                });
        documentActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        Uri uri = data != null ? data.getData() : null;
                        Log.e("uri", String.valueOf(uri));

                    }
                });
        binding.btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                galleryActivityResultLauncher.launch(intent);
            }
        });
        binding.btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("application/pdf");
                documentActivityResultLauncher.launch(intent);
            }
        });


    }
    private File createImageFile() throws IOException {
        @SuppressLint("SimpleDateFormat") String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timestamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(
                    imageFileName,
                    ".jpg",
                    storageDir
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert image != null;
        currentPhotoPath = image.getAbsolutePath();

        Log.d("image path", "camera:::" + currentPhotoPath);
        return image;
    }

}