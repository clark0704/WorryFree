package com.hwm.unicom;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.net.ConnectivityManager.TYPE_WIFI;
import static com.hwm.unicom.NetWork.NET_3G;
import static com.hwm.unicom.NetWork.TYPE_CM_NET;
import static com.hwm.unicom.NetWork.TYPE_CM_NET_2G;
import static com.hwm.unicom.NetWork.TYPE_CM_WAP;
import static com.hwm.unicom.NetWork.TYPE_CM_WAP_2G;
import static com.hwm.unicom.NetWork.TYPE_CT_NET;
import static com.hwm.unicom.NetWork.TYPE_CT_NET_2G;
import static com.hwm.unicom.NetWork.TYPE_CT_WAP;
import static com.hwm.unicom.NetWork.TYPE_CT_WAP_2G;
import static com.hwm.unicom.NetWork.TYPE_CU_NET;
import static com.hwm.unicom.NetWork.TYPE_CU_NET_2G;
import static com.hwm.unicom.NetWork.TYPE_CU_WAP;
import static com.hwm.unicom.NetWork.TYPE_CU_WAP_2G;
import static com.hwm.unicom.NetWork.TYPE_NET_WORK_DISABLED;
import static com.hwm.unicom.NetWork.TYPE_OTHER;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Bind(R.id.button)
    Button mButton;
    @Bind(R.id.button2)
    Button mButton2;
    @Bind(R.id.button3)
    Button mButton3;
    @Bind(R.id.textView2)
    TextView mTextView2;
    @Bind(R.id.activity_main)
    RelativeLayout mActivityMain;

    private String v_code_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        RequestQueue mQueue = Volley.newRequestQueue(this);
        String url = ChinaUnicomUtils.getNetUrl();
//        Log.e(TAG, url);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e(TAG, response.toString());
                        try {
                            String userId = response.getString("userid");
                            if (userId!=null&& !userId.equals("")) {
                                v_code_url = ChinaUnicomUtils.getV_code_url(userId);
                                Log.e(TAG,v_code_url);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage(), error);
            }
        });
//        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(v_code_url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.e(TAG, response.toString());
//                        try {
//                            String userId = response.getString("userid");
//                            if (userId!=null&& !userId.equals("")) {
//                                v_code_url = ChinaUnicomUtils.getV_code_url(userId);
//
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, error.getMessage(), error);
//            }
//        });
        mQueue.add(jsonObjectRequest);
        Log.e(TAG,NetWorkUtil.getCurrentNetworkType(this.getApplicationContext()));
        switch (NetWork.checkNetworkType(this)) {
            case TYPE_WIFI:
                Log.e("NetType", "================wifi");
                break;
            case TYPE_NET_WORK_DISABLED:
                Log.e("NetType", "================no network");
                break;
            case TYPE_CT_WAP:
                Log.e("NetType", "================ctwap");
                break;
            case TYPE_CT_WAP_2G:
                Log.e("NetType", "================ctwap_2g");
                break;
            case TYPE_CT_NET:
                Log.e("NetType", "================ctnet");
                break;
            case TYPE_CT_NET_2G:
                Log.e("NetType", "================ctnet_2g");
                break;
            case TYPE_CM_WAP:
                Log.e("NetType", "================cmwap_3g");
                break;
            case TYPE_CM_WAP_2G:
                Log.e("NetType", "================cmwap_2g");
                break;
            case TYPE_CM_NET:
                Log.e("NetType", "================cmnet");
                break;
            case TYPE_CM_NET_2G:
                Log.e("NetType", "================cmnet_2g");
                break;
            case TYPE_CU_NET:
                Log.e("NetType", "================cunet_3g");
                break;
            case TYPE_CU_NET_2G:
                Log.e("NetType", "================cunet_2g");
                break;
            case TYPE_CU_WAP:
                Log.e("NetType", "================cuwap");
                break;
            case TYPE_CU_WAP_2G:
                Log.e("NetType", "================cuwap_2g");
                break;
            case TYPE_OTHER:
                Log.e("NetType", "================other");
                break;
            default:
                break;
        }
    }
}
