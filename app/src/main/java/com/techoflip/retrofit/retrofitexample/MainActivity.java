package com.techoflip.retrofit.retrofitexample;

/**
 * Created by Sarthak Verma (github.com/IAmSarthakVerma)
 */


import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.techoflip.retrofit.retrofitexample.data.model.ResponseModel;
import com.techoflip.retrofit.retrofitexample.data.remote.APIServiceRetrofit;
import com.techoflip.retrofit.retrofitexample.data.remote.AppUtilsRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private APIServiceRetrofit mAPIServiceRetrofit;
    TextView name_view, surname_view, gender_view, region_view;
    Button details_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAPIServiceRetrofit = AppUtilsRetrofit.getAPIService();

        name_view = (TextView) findViewById(R.id.name_field);
        surname_view = (TextView) findViewById(R.id.surname_field);
        gender_view = (TextView) findViewById(R.id.gender_field);
        region_view = (TextView) findViewById(R.id.region_field);

        details_btn = (Button) findViewById(R.id.details_button);

        details_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getDetails();
            }
        });

    }

    public void getDetails() {

        mAPIServiceRetrofit.detailsget().enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                if (response.isSuccessful()) {

                    Log.d("Response", response.body().toString());

                    name_view.setText(response.body().getName());
                    surname_view.setText(response.body().getSurname());
                    gender_view.setText(response.body().getGender());
                    region_view.setText(response.body().getRegion());

                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

                {
                    Snackbar.make(findViewById(android.R.id.content), "Unable to connect to the Server", Snackbar.LENGTH_LONG).setAction("Retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            getDetails();
                        }
                    }).show();
                }

            }
        });
    }
}
