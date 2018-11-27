package application.android.example.com.volleysingleton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView txt;
    String server_url="http://192.168.43.61/demo/first.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        txt=findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest=new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        txt.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        txt.setText("Error......");
                        error.printStackTrace();
                    }
                });
                SingleTon.getOurInstance(getApplicationContext()).addtorequestQue(stringRequest);
                
            }
        });
    }
}
