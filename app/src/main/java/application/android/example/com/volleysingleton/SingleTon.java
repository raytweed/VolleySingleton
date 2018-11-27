package application.android.example.com.volleysingleton;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SingleTon {
    private static  SingleTon ourInstance;
    private RequestQueue requestQueue;
    private static Context context;


    private SingleTon(Context mcontext) {
        context=mcontext;
        requestQueue=getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        }
        return  requestQueue;
    }
    public static synchronized SingleTon getOurInstance(Context context){
        if(ourInstance==null){
            ourInstance=new SingleTon(context);
        }
        return  ourInstance;
    }
    public void addtorequestQue(Request request){
        requestQueue.add(request);
    }
}
