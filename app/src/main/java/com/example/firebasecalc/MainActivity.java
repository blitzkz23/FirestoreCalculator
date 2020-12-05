package com.example.firebasecalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static final String KEY_NUM1 = "num1";
    private static final String KEY_NUM2 = "num2";
    private static final String KEY_TANDA = "tandaHitung";
    private static final String KEY_RESULT = "result";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference recordRef = db.collection("Perhitungan");
    private RecordAdapter adapter;
    private RecyclerView fireStoreList;


    EditText angka1, angka2;
    RadioButton tambah, kurang, kali, bagi;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angka1 = (EditText)findViewById(R.id.angka1);
        angka2 = (EditText)findViewById(R.id.angka2);
        tambah = (RadioButton)findViewById(R.id.tambahRadio);
        kurang = (RadioButton)findViewById(R.id.kurangRadio);
        kali = (RadioButton)findViewById(R.id.kaliRadio);
        bagi = (RadioButton)findViewById(R.id.bagiRadio);
        hasil = (TextView)findViewById(R.id.hasil);

        fireStoreList = findViewById(R.id.recordList);
        setUpRecyclerView();
    }

    public void simpandb(){

    }

    public void mengkalkulasi(View view) {
       double num1 = Double.parseDouble(angka1.getText().toString());
       double num2 = Double.parseDouble(angka2.getText().toString());
       double result = 0;
       if(tambah.isChecked()) {
           String tandaHitung = "+";
               result = num1+num2;
               hasil.setText(Double.toString(result));

           Map<String, Object> perhitungan = new HashMap<>();
           perhitungan.put(KEY_NUM1, num1);
           perhitungan.put(KEY_NUM2, num2);
           perhitungan.put(KEY_TANDA, tandaHitung);
           perhitungan.put(KEY_RESULT, result);

           String id = db.collection("Perhitungan").document().getId();
           db.collection("Perhitungan").document(id).set(perhitungan)
                   .addOnSuccessListener(new OnSuccessListener<Void>() {
                       @Override
                       public void onSuccess(Void aVoid) {
                           Toast.makeText(MainActivity.this, "Record Saved", Toast.LENGTH_SHORT).show();
                       }
                   })
                   .addOnFailureListener(new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull Exception e) {
                           Toast.makeText(MainActivity.this, "Error !", Toast.LENGTH_SHORT).show();
                           Log.d(TAG, e.toString());
                       }
                   });
       }else if(kurang.isChecked()){
           String tandaHitung = "-";
               result = num1-num2;
               hasil.setText(Double.toString(result));

           Map<String, Object> perhitungan = new HashMap<>();
           perhitungan.put(KEY_NUM1, num1);
           perhitungan.put(KEY_NUM2, num2);
           perhitungan.put(KEY_TANDA, tandaHitung);
           perhitungan.put(KEY_RESULT, result);

           String id = db.collection("Perhitungan").document().getId();
           db.collection("Perhitungan").document(id).set(perhitungan)
                   .addOnSuccessListener(new OnSuccessListener<Void>() {
                       @Override
                       public void onSuccess(Void aVoid) {
                           Toast.makeText(MainActivity.this, "Record Saved", Toast.LENGTH_SHORT).show();
                       }
                   })
                   .addOnFailureListener(new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull Exception e) {
                           Toast.makeText(MainActivity.this, "Error !", Toast.LENGTH_SHORT).show();
                           Log.d(TAG, e.toString());
                       }
                   });
       }else if(kali.isChecked()){
           String tandaHitung = "x";
               result = num1*num2;
               hasil.setText(Double.toString(result));

           Map<String, Object> perhitungan = new HashMap<>();
           perhitungan.put(KEY_NUM1, num1);
           perhitungan.put(KEY_NUM2, num2);
           perhitungan.put(KEY_TANDA, tandaHitung);
           perhitungan.put(KEY_RESULT, result);

           String id = db.collection("Perhitungan").document().getId();
           db.collection("Perhitungan").document(id).set(perhitungan)
                   .addOnSuccessListener(new OnSuccessListener<Void>() {
                       @Override
                       public void onSuccess(Void aVoid) {
                           Toast.makeText(MainActivity.this, "Record Saved", Toast.LENGTH_SHORT).show();
                       }
                   })
                   .addOnFailureListener(new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull Exception e) {
                           Toast.makeText(MainActivity.this, "Error !", Toast.LENGTH_SHORT).show();
                           Log.d(TAG, e.toString());
                       }
                   });
       }else{
           String tandaHitung = ":";
               result = num1/num2;
               hasil.setText(Double.toString(result));

           Map<String, Object> perhitungan = new HashMap<>();
           perhitungan.put(KEY_NUM1, num1);
           perhitungan.put(KEY_NUM2, num2);
           perhitungan.put(KEY_TANDA, tandaHitung);
           perhitungan.put(KEY_RESULT, result);

           String id = db.collection("Perhitungan").document().getId();
           db.collection("Perhitungan").document(id).set(perhitungan)
                   .addOnSuccessListener(new OnSuccessListener<Void>() {
                       @Override
                       public void onSuccess(Void aVoid) {
                           Toast.makeText(MainActivity.this, "Record Saved", Toast.LENGTH_SHORT).show();
                       }
                   })
                   .addOnFailureListener(new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull Exception e) {
                           Toast.makeText(MainActivity.this, "Error !", Toast.LENGTH_SHORT).show();
                           Log.d(TAG, e.toString());
                       }
                   });
       }


    }

    private void setUpRecyclerView(){
        Query query = recordRef;

        FirestoreRecyclerOptions<RecordModel> options = new FirestoreRecyclerOptions.Builder<RecordModel>()
                .setQuery(query, RecordModel.class)
                .build();

        adapter = new RecordAdapter(options);
        RecyclerView recyclerView = findViewById(R.id.recordList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                adapter.deleteItem(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
