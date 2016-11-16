package com.example.zhengjun.nocopypasteedittextdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_path)
    NoCopyPasteEditText etPath;
    @BindView(R.id.btn_download)
    Button btnDownload;
    @BindView(R.id.btn_browse)
    Button btnBrowse;
    @BindView(R.id.tv_response)
    TextView tvResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 getPicUri();
            }
        });
    }

    private void getPicUri() {
        String baseUrl = "https://api.douban.com/v2/movie/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(DownloadService.class).getTopMovie(0, 10).enqueue(new Callback<MovieEntity>() {
            @Override
            public void onResponse(Call<MovieEntity> call, Response<MovieEntity> response) {
                tvResponse.setText(response.body().getSubjects().toString());
            }

            @Override
            public void onFailure(Call<MovieEntity> call, Throwable t) {
                tvResponse.setText(t.getMessage());
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
