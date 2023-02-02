package com.example.retrofitactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    
    Button bt;
    TextView tvPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPost = findViewById(R.id.tv_Post);
        bt = findViewById(R.id.button1);
        
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicksendPost();
            }
        });
    }

    private void clicksendPost() {
        Post post = new Post(10, 01, "Thinh", "Tran Tuan Thinh");
        ApiInterface.apiIterface.sendPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();

                Post postResult = response.body();
                if(post != null){
                    tvPost.setText(postResult.toString());
                }

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }


}