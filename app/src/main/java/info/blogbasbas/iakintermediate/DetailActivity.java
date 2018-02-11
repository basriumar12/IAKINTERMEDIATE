package info.blogbasbas.iakintermediate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        //get data
        Intent getdata = getIntent();
        txtnama.setText(getdata.getStringExtra("NAMA"));
        txtdetail.setText(getdata.getStringExtra("DETAIL"));
           Glide.with(DetailActivity.this)
                .load("http://192.168.1.33/db_resep/foto_makanan/"
                        +getdata.getStringExtra("GAMBAR"))
                .into(imgmakanan);
    }
}
