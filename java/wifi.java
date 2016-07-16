    package com.pocketdigi.wifi;
    import android.app.Activity;
    import android.content.Context;
    import android.net.wifi.WifiManager;
    import android.os.Bundle;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.Button;
     
    public class WIFIActivity extends Activity {
    	/** Called when the activity is first created. */
    	Button open, close;
     
    	@Override
    	public void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		setContentView(R.layout.main);
    		open = (Button) findViewById(R.id.open);
    		close = (Button) findViewById(R.id.close);
    		final WifiManager wm = (WifiManager) this
    				.getSystemService(Context.WIFI_SERVICE);
    		// 得到WifiManager对象
    		open.setOnClickListener(new OnClickListener() {
     
    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				if (wm.getWifiState() == WifiManager.WIFI_STATE_DISABLED) {
    					// 判断是否处理关闭状态，其他状态（已打开、正在关闭、正在打开、未知）不操作
    					wm.setWifiEnabled(true);
    					// 打开WIFI
    				}
    			}
    		});
    		close.setOnClickListener(new OnClickListener() {
     
    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				if (wm.getWifiState() == WifiManager.WIFI_STATE_ENABLED) {
    					// 与上同，不解释
    					wm.setWifiEnabled(false);
    				}
    			}
    		});
    	}
    }
