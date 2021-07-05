package com.jsstech.quoteuserpanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.jsstech.quoteuserpanel.Adapter.ViewQuoteAdapter;
import com.jsstech.quoteuserpanel.Model.YourQuotesModel;

import java.util.ArrayList;
import java.util.List;

public class ViewYourQuotes extends AppCompatActivity {

    private ListView listView;
    private Query databaseReference;
    private List<YourQuotesModel> list;
    private ViewQuoteAdapter viewQuoteAdapter;
    private YourQuotesModel yourQuotesModel;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_your_quotes);

        listView = (ListView) findViewById(R.id.listView_YourQuotes);
        list = new ArrayList<>();

        progressBar = findViewById(R.id.progressbar_viewyourquotes);
        progressBar.setVisibility(View.VISIBLE);

        databaseReference = FirebaseDatabase.getInstance().getReference("yourQuotes");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    yourQuotesModel = snap.getValue(YourQuotesModel.class);
                    list.add(yourQuotesModel);
                }
                viewQuoteAdapter = new ViewQuoteAdapter(ViewYourQuotes.this, list);
                listView.setAdapter(viewQuoteAdapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
