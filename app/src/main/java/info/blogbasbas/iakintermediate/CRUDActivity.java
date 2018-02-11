package info.blogbasbas.iakintermediate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.blogbasbas.iakintermediate.network.RestAPI;
import info.blogbasbas.iakintermediate.network.RetroServer;
import info.blogbasbas.iakintermediate.pojo.ResponseModel;
import info.blogbasbas.iakintermediate.pojo.ResponseResep;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CRUDActivity extends AppCompatActivity {

    @BindView(R.id.edt_nama)
    EditText edtNama;
    @BindView(R.id.edtResep)
    EditText edtResep;
    @BindView(R.id.edt_gambar)
    EditText edtGambar;
    @BindView(R.id.pd)
    ProgressBar pd;
    @BindView(R.id.btn_insertdata)
    Button btnInsertdata;
    @BindView(R.id.btntampildata)
    Button btntampildata;
    @BindView(R.id.btnUpdate)
    Button btnUpdate;
    @BindView(R.id.btnhapus)
    Button btnhapus;
    String idresep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);
        ButterKnife.bind(this);

        Intent terimaData = getIntent();
        idresep = terimaData.getStringExtra("I");
        if (idresep != null){
            btnInsertdata.setVisibility(View.GONE);
            btntampildata.setVisibility(View.GONE);
            btnhapus.setVisibility(View.VISIBLE);
            btnUpdate.setVisibility(View.VISIBLE);
            edtNama.setText(terimaData.getStringExtra("N"));
            edtResep.setText(terimaData.getStringExtra("D"));
            edtGambar.setText(terimaData.getStringExtra("G"));
        }



    }

    @OnClick({R.id.btn_insertdata, R.id.btntampildata, R.id.btnUpdate, R.id.btnhapus})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_insertdata:

                String namaresep = edtNama.getText().toString();
                String detailResep = edtResep.getText().toString();
                String namaGambar = edtGambar.getText().toString();
                //validate data
                if (namaresep.isEmpty()){
                    edtNama.setError("Isilah Nama Resep");
                    Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                    Snackbar.make(view,"ISilah Nama Resep",Snackbar.LENGTH_LONG).show();
                }else if (detailResep.isEmpty()){

                }else if (namaGambar.isEmpty()){

                } else {
                    RestAPI api = RetroServer.getClient().create(RestAPI.class);
                    Call<ResponseModel> insertData = api.insertData(namaresep,
                                                                    detailResep,
                                                                    namaGambar);
                    insertData.enqueue(new Callback<ResponseModel>() {
                        @Override
                        public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                            String kode = response.body().getKode();
                            if (kode.equals("1")){
                                Toast.makeText(CRUDActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(CRUDActivity.this,
                                        MainActivity.class));
                                finish();

                                edtGambar.setText("");
                                edtNama.setText("");
                                edtResep.setText("");

                            }
                            else {
                                Toast.makeText(CRUDActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<ResponseModel> call, Throwable t) {
                            Log.d("", "onFailure: "+t.toString());
                        }
                    });







                }


                break;
            case R.id.btntampildata:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btnUpdate:
                //update data
                RestAPI api = RetroServer.getClient().create(RestAPI.class);
                Call<ResponseModel> updateData = api.updateData(idresep,
                        edtNama.getText().toString(),
                        edtResep.getText().toString(),
                        edtGambar.getText().toString()
                        );
                updateData.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        Toast.makeText(CRUDActivity.this, "berhasil", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CRUDActivity.this,
                                MainActivity.class));
                        finish();

                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        Toast.makeText(CRUDActivity.this, "gagal"+t.toString(),
                                Toast.LENGTH_SHORT).show();

                    }
                });

                break;
            case R.id.btnhapus:
                RestAPI api3 = RetroServer.getClient().create(RestAPI.class);
                Call<ResponseModel> deleteData = api3.deleteData(idresep);
                deleteData.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                        Toast.makeText(CRUDActivity.this,
                                "data berhasil di hapus "+idresep, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        Toast.makeText(CRUDActivity.this,
                                "gagal di hapus", Toast.LENGTH_SHORT).show();

                    }
                });
                break;
        }
    }
}
