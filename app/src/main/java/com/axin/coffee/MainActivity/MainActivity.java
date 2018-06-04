package com.axin.coffee.MainActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.axin.coffee.coffee.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.slideMenu)
    SlideMenu slideMenu;
    @BindView(R.id.physical_exam_menu)
    TextView physicalExamMenu;
    @BindView(R.id.drink_drive_menu)
    TextView drinkDriveMenu;
    @BindView(R.id.medicine_lib_menu)
    TextView medicineLibMenu;
    @BindView(R.id.test_game_menu)
    TextView testGameMenu;
    @BindView(R.id.setting_menu)
    TextView settingMenu;
    @BindView(R.id.about_us_menu)
    TextView aboutUsMenu;
    @BindView(R.id.exit_login_menu)
    TextView exitLoginMenu;

    FragmentManager fm = getFragmentManager();
    FragmentTransaction tran = fm.beginTransaction();
    Main_Fragment f1=new Main_Fragment();
    Test_game_Fragment f2=new Test_game_Fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tran.add(R.id.message, f1, "index").show(f1).add(R.id.message, f2, "bill").hide(f2);
        tran.commit();
    }



    @OnClick({R.id.physical_exam_menu, R.id.drink_drive_menu, R.id.medicine_lib_menu, R.id.test_game_menu, R.id.setting_menu, R.id.about_us_menu, R.id.exit_login_menu})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.physical_exam_menu:
                FragmentManager fm_1 = getFragmentManager();
                FragmentTransaction tran_0 = fm_1.beginTransaction();
                tran_0.show(f1).hide(f2).commit();
                break;
            case R.id.drink_drive_menu:
                break;
            case R.id.medicine_lib_menu:
                break;
            case R.id.test_game_menu:
                FragmentManager fm_2 = getFragmentManager();
                FragmentTransaction tran_1 = fm_2.beginTransaction();
                tran_1.show(f2).hide(f1).commit();
                break;
            case R.id.setting_menu:
                break;
            case R.id.about_us_menu:
                break;
            case R.id.exit_login_menu:
                break;
        }
    }
}
