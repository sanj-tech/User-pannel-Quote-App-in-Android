package com.jsstech.quoteuserpanel.ViewQuotes;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.jsstech.quoteuserpanel.Adapter.QuotesAdapter;
import com.jsstech.quoteuserpanel.Model.QuotesModel;
import com.jsstech.quoteuserpanel.R;

import java.util.ArrayList;
import java.util.List;

public class VPeace extends AppCompatActivity {

    private ListView listView;
    private Query databaseReference;
    private List<QuotesModel> list;
    private QuotesAdapter quotesAdapter;
    private QuotesModel quotesModel;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vpeace);

        listView = (ListView) findViewById(R.id.v_listview_peace);
        list = new ArrayList<>();

        progressBar = findViewById(R.id.pro_peace);
        progressBar.setVisibility(View.VISIBLE);

        databaseReference = FirebaseDatabase.getInstance().getReference("quotes").orderByChild("qt_cat").equalTo("Peace");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    quotesModel = snap.getValue(QuotesModel.class);
                    list.add(quotesModel);
                }
                quotesAdapter = new QuotesAdapter(VPeace.this, list);
                listView.setAdapter(quotesAdapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
