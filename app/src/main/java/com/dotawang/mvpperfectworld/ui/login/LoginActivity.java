package com.dotawang.mvpperfectworld.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Map;

import com.dotawang.mvpperfectworld.R;
import com.dotawang.mvpperfectworld.base.IView;
import com.dotawang.mvpperfectworld.base.MVPBaseActivity;
import com.dotawang.mvpperfectworld.ui.login.contract.LoginContract;
import com.dotawang.mvpperfectworld.ui.login.presenter.LoginPresenter;
import com.dotawang.mvpperfectworld.utils.custom.EditTextWithDeleteIcon;

/**
 * @author DotaWang
 */
public class LoginActivity extends MVPBaseActivity<LoginPresenter> implements LoginContract.View{

    private RelativeLayout rlTitleBar;
    private TextView tvNewUser;

    private LinearLayout llNewUser,llTranslate;
    private ImageView ivLoginLogo;
    private View mView;
    private RelativeLayout rlLiner1,rlLiner2;
    private ImageView ivLoginUserLogo,iv_login_pswLogo;
    private EditTextWithDeleteIcon etLoginUserName,etLoginPassWord;
    private View userLine,pswLine;
    private Button btnLogin;
    private RadioGroup rgGroup;
    private RadioButton rbRelease,rbTest;
    private TextView tvRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        rlTitleBar = findViewById(R.id.rlTitlebar);
        tvNewUser = findViewById(R.id.tv_new_user);
        llNewUser = findViewById(R.id.ll_name_psw);
        llTranslate = findViewById(R.id.ll_translate);
        ivLoginLogo = findViewById(R.id.iv_login_logo);
        mView = findViewById(R.id.view);
        rlLiner1 = findViewById(R.id.rl_liner1);
        rlLiner1 = findViewById(R.id.rl_liner2);
        ivLoginUserLogo = findViewById(R.id.iv_login_userLogo);
        etLoginUserName = findViewById(R.id.et_login_userName);
        userLine = findViewById(R.id.user_line);
        iv_login_pswLogo = findViewById(R.id.iv_login_pswLogo);
        etLoginPassWord = findViewById(R.id.et_login_passWord);
        pswLine = findViewById(R.id.psw_line);
        btnLogin = findViewById(R.id.btn_login);
        rgGroup = findViewById(R.id.rg_group);
        rbRelease = findViewById(R.id.rb_release);
        rbTest = findViewById(R.id.rb_test);
        tvRegister = findViewById(R.id.tv_login_register);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (null!= mPresenter){
            mPresenter.requestLoginData();
        }
    }

    @Override
    protected IView getView() {
        return this;
    }

    @Override
    public void setData(Map<String, String> dataMap) {

    }

    @Override
    public void setSomethingData(String msg) {
//        tv.setText(msg);
    }
}

