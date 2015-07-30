package com.sus.immerselayout;




import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * 关于界面
 * 
 * @author sus
 * @time 2015.07.29
 */
public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.activity_about);
        findViewById(R.id.setting_login_out_btn).setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this,BackgroundActivity.class);
                startActivity(intent);
                
            }
        });

        setImmerseLayout(findViewById(R.id.common_back));

        initBackButton();
        setTitleBar(R.string.durian_about);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
