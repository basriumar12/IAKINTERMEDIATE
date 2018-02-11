package info.blogbasbas.iakintermediate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.blogbasbas.iakintermediate.adapter.AdapterResep;
import info.blogbasbas.iakintermediate.network.RestAPI;
import info.blogbasbas.iakintermediate.pojo.ResepItem;
import info.blogbasbas.iakintermediate.pojo.ResponseResep;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.namaresep)
    TextView namaresep;
    @BindView(R.id.detailresep)
    TextView detailresep;
    @BindView(R.id.rvDataResep)
    RecyclerView rvDataResep;
    //variabe layout manager
    RecyclerView.LayoutManager layoutManager;

    //list
    List<ResepItem> dataresep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //inisialisasi layout
        layoutManager = new LinearLayoutManager(this);
        rvDataResep.setLayoutManager(layoutManager);
        //inisialisasi list resep
        dataresep = new ArrayList<>();

        getData();

    }

    private void getData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.33/db_resep/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestAPI restAPI = retrofit.create(RestAPI.class);

        Call<ResponseResep> getData = restAPI.getDataResep();
        getData.enqueue(new Callback<ResponseResep>() {
            @Override
            public void onResponse(Call<ResponseResep> call, Response<ResponseResep> response) {
                String pesan = response.body().getPesan();
                String sukses = response.body().getSukses();
                String namaresep1 = response.body()
                        .getResep().get(0).getNamaResep1();

                String detailresep1 = response.body()
                        .getResep().get(0).getDetail1();


                if (sukses.equals("true")) {
                    Log.d("", "dapatkan data: " + pesan);
                    Log.d("", "dapatkan data: " + sukses);
                    Log.d("", "onResponse: " + namaresep);

                    namaresep.setText(namaresep1);
                    detailresep.setText(detailresep1);
                    dataresep = response.body().getResep();

                    //buat objek adapterresep
                    AdapterResep adapterResep =
                            new AdapterResep(MainActivity.this,
                                    dataresep);
                    //set adapter
                    rvDataResep.setAdapter(adapterResep);



                } else {

                    Toast.makeText(MainActivity.this,
                            "gagal", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseResep> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "gagal" + t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
