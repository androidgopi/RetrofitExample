package com.sreeyainfotech.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.widget.EditText;

import com.sreeyainfotech.retrofitexample.adapter.ItemAdapter;
import com.sreeyainfotech.retrofitexample.model.AllData;
import com.sreeyainfotech.retrofitexample.model.Allcategorieslist;
import com.sreeyainfotech.retrofitexample.networkCall.APIClient;
import com.sreeyainfotech.retrofitexample.networkCall.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private APIInterface apiInterface;
    List<Allcategorieslist> allcategorieslists=new ArrayList<>();
    private RecyclerView recycler_view;
    private ItemAdapter itemAdapter_adapter;
    private SearchView search_view;
    private EditText search_parent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        recycler_view=(RecyclerView)findViewById(R.id.recycler_view);

        search_view=(SearchView)findViewById(R.id.search_view);
        search_parent=(EditText)findViewById(R.id.search_parent);

        serviceCall();
        setupSearchView();
    }

    private void serviceCall() {
        /**
         GET List Resources
         **/
        Call<AllData> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<AllData>() {
            @Override
            public void onResponse(Call<AllData> call, Response<AllData> response) {

                if (response.isSuccessful()) {
                    Log.d("TAG", response.body() + "");

                   for(int i=0;i<response.body().getAllcategories().size(); i++){
                       Allcategorieslist all=new Allcategorieslist();
                       all.setCategory_id(response.body().getAllcategories().get(i).getCategory_id());
                       all.setCategory_name(response.body().getAllcategories().get(i).getCategory_name());
                       all.setImage_path(response.body().getAllcategories().get(i).getImage_path());

                       allcategorieslists.add(all);
                   }
                    itemAdapter_adapter = new ItemAdapter(MainActivity.this, allcategorieslists);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    recycler_view.setLayoutManager(layoutManager);
                    recycler_view.setNestedScrollingEnabled(false);
                    recycler_view.setAdapter(itemAdapter_adapter);
                }

            }

            @Override
            public void onFailure(Call<AllData> call, Throwable t) {
                call.cancel();
            }
        });

    }

// searching following 3 methods
    private void setupSearchView() {
        search_view.setIconifiedByDefault(false);
        search_view.setOnQueryTextListener(this);
        search_view.setFocusableInTouchMode(true);
        search_view.setSubmitButtonEnabled(false);
        search_view.setQueryHint("Search Contact");
        search_parent.requestFocus();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if (itemAdapter_adapter != null) {
            itemAdapter_adapter.filter(query);
        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        if (itemAdapter_adapter != null) {
            itemAdapter_adapter.filter(query);
        }
        return true;
    }


}
