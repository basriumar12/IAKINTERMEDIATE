package info.blogbasbas.iakintermediate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.imgmakanan)
    ImageView imgmakanan;
    @BindView(R.id.txtnama)
    TextView txtnama;
    @BindView(R.id.txtdetail)
    TextView txtdetail;
    String idd, nama, namaGambar, detailResep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        //get data
        Intent getdata = getIntent();
        idd = getdata.getStringExtra("ID");
        nama = getdata.getStringExtra("NAMA");
       namaGambar = getdata.getStringExtra("GAMBAR");
        detailResep = getdata.getStringExtra("DETAIL");


        txtnama.setText(nama);
        txtdetail.setText(detailResep);
           Glide.with(DetailActivity.this)
                .load("http://192.168.1.33/db_resep/foto_makanan/"
                        +namaGambar)
                .into(imgmakanan);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.itemID){
            Intent kirimdata = new Intent(DetailActivity.this,
                    CRUDActivity.class);
            kirimdata.putExtra("I", idd);
            kirimdata.putExtra("N", nama);
            kirimdata.putExtra("D", detailResep);
            kirimdata.putExtra("G", namaGambar);
            startActivity(kirimdata);
        }

        return super.onOptionsItemSelected(item);
    }
}
