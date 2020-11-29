package id.ac.ui.cs.mobileprogramming.jeremy.lab05;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


class WifiReceiver extends BroadcastReceiver {
    WifiManager wifiManager;
    ListView wifiDeviceList;
    ArrayList<String> tempList = new ArrayList<>();
    private final OkHttpClient client = new OkHttpClient();


    public WifiReceiver(WifiManager wifiManager, ListView wifiDeviceList) {
        this.wifiManager = wifiManager;
        this.wifiDeviceList = wifiDeviceList;
    }
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action)) {

            List<ScanResult> wifiList = wifiManager.getScanResults();

            for (ScanResult scanResult : wifiList) {
                tempList.add(scanResult.SSID + " - " + scanResult.capabilities);
            }

            ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, tempList.toArray());
            wifiDeviceList.setAdapter(arrayAdapter);
            new IOAsyncTask().execute();
        }
    }

    private String makePost() {
        RequestBody requestBody = null;
        MultipartBody.Builder multipart = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("Application", "Lab05-Jeremy-1706039742");

        for (int i = 0; i < tempList.size(); i++) {
            multipart.addFormDataPart("Wifi-Name-" + i, tempList.get(i));
        }

        requestBody = multipart.build();

        Request request = new Request.Builder()
                .url("https://0210081ad0d91b9c14afaed340aa42c9.m.pipedream.net")
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }
            return response.body().string();
        } catch (IOException e) {
            return "Error:"+ e.getMessage();
        }

    }

    class IOAsyncTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            return makePost();
        }

        @Override
        protected void onPostExecute(String response) {
            Log.d("networking", response);
        }
    }
}