package simple.example.kocheng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import simple.example.kocheng.model.Kucing;

public class MainActivity extends AppCompatActivity {

    List<Kucing> kucings = new ArrayList<>();
    int indeksTampil = 0;
    Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
    TextView txJenis,txAsal,txDeskripsi;
    ImageView ivFotoKucing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialiasiDaftarKucing();
        inisialisasiView();
        tampilkanProfilKucing();
    }

    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> kucingPertama());
        btnTerakhir.setOnClickListener(view -> kucingTerakhir());
        btnSebelumnya.setOnClickListener(view -> kucingSebelumnya());
        btnBerikutnya.setOnClickListener(view -> kucingBerikutnya());

        txJenis = findViewById(R.id.txJenis);
        txAsal = findViewById(R.id.txAsal);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoKucing = findViewById(R.id.gambarKucing);
    }

    private void inisialiasiDaftarKucing() {
        kucings.add(new Kucing("Angora","Turki",
                "Aslinya berasal dari Ankara, Turki dengan ciri khas berbulu panjang dan lembut",R.drawable.angora));
        kucings.add(new Kucing("Bengal","Inggris",
                "Merupakan hasil persilangan antara Kucing Leopard Asia dengan kucing domestik Inggris",R.drawable.bengal));
        kucings.add(new Kucing("Birmani","Birma/Myanmar",
                "Konon awalnya merupakan ras kucing yand biasa menemani para biksu yang menetap pada kuil di Birma",R.drawable.birman));
        kucings.add(new Kucing("Persia","Iran",
                "Kucing berbulu panjang dengan wajah bundar dan hidung pesek. Awalnya berasal dari Iran kemudian diimpor ke Italia",R.drawable.persia));
        kucings.add(new Kucing("Siam","Thailand",
                "Kucing hasil turunan dari Wichian Maat (Kucing Thailand) dengan ciri khas berbadan panjang dan langsing, wajah lonjong, telinga lebar, dan mata kebiruan",R.drawable.siam));
        kucings.add(new Kucing("Siberia","Rusia",
                "Kucing domestik Rusia dengan bulu lebat dan badan besar tapi sangat lincah dan terkenal dengan kemampuan melompatnya ",R.drawable.siberian));
    }

    private void tampilkanProfilKucing() {
        Kucing k = kucings.get(indeksTampil);
        Log.d("MAIN","Menampilkan kucing "+k.getJenis());
        txJenis.setText(k.getJenis());
        txAsal.setText(k.getAsal());
        txDeskripsi.setText(k.getDeskripsi());
        ivFotoKucing.setImageDrawable(getDrawable(k.getDrawableRes()));
    }

    private void kucingPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this,"Sudah di posisi kucing pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanProfilKucing();
        }
    }

    private void kucingTerakhir() {
        int posAkhir = kucings.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this,"Sudah di posisi kucing terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanProfilKucing();
        }
    }

    private void kucingBerikutnya() {
        if (indeksTampil == kucings.size() - 1) {
            Toast.makeText(this,"Sudah di posisi kucing terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanProfilKucing();
        }
    }

    private void kucingSebelumnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this,"Sudah di posisi kucing pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanProfilKucing();
        }
    }
}