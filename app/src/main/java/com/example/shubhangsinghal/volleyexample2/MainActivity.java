package com.example.shubhangsinghal.volleyexample2;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Gson gson;
    private static final String ENDPOINT = "http://www.mocky.io/v2/597c41390f0000d002f4dbd1";
    private RequestQueue requestQueue;
    private List<users> list;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvUsers);
        gson = new Gson();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        fetchUsers();
    }

    private void fetchUsers() {
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT, onUsersLoaded, onUsersError);
        requestQueue.add(request);
    }


    private final Response.Listener<String> onUsersLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            UserData d = gson.fromJson(response,UserData.class);
            list = d.usersList;
            Log.i("UserActivity", list.size() + " Users loaded.");
            for (users user : list) {
                Log.i("UserActivity", user.ID + ": " + user.name);
            }
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        UserViewAdapter userViewAdapter = new UserViewAdapter();
        recyclerView.setAdapter(userViewAdapter);
        }
    };

    private final Response.ErrorListener onUsersError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("UserActivity", error.toString());
        }
    };

    class UserViewAdapter extends RecyclerView.Adapter<UserViewAdapter.UserViewHolder>{

        @NonNull
        @Override
        public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.item,parent,false);
            return new UserViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

            holder.id.setText(list.get(position).getID());
            holder.name.setText(list.get(position).getName());
            holder.email.setText(list.get(position).getEmail());
            holder.gender.setText(list.get(position).getEmail());
            holder.mobile.setText(list.get(position).getContact().getMobile());
            holder.home.setText(list.get(position).getContact().getHome());
            holder.office.setText(list.get(position).getContact().getOffice());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class UserViewHolder extends RecyclerView.ViewHolder{

            TextView id,name,email,gender,home,office,mobile;


            public UserViewHolder(View itemView) {
                super(itemView);

                id = itemView.findViewById(R.id.Id);
                name = itemView.findViewById(R.id.name);
                email = itemView.findViewById(R.id.email);
                gender = itemView.findViewById(R.id.gender);
                mobile = itemView.findViewById(R.id.mobile);
                home = itemView.findViewById(R.id.home);
                office = itemView.findViewById(R.id.office);
            }
        }
    }


}
