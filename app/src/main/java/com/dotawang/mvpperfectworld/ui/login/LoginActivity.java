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

import com.dotawang.mvpperfectworld.R;
import com.dotawang.mvpperfectworld.base.IView;
import com.dotawang.mvpperfectworld.base.MVPBaseActivity;
import com.dotawang.mvpperfectworld.ui.bean.ArticleListBean;
import com.dotawang.mvpperfectworld.ui.login.contract.LoginContract;
import com.dotawang.mvpperfectworld.ui.login.presenter.LoginPresenter;
import com.dotawang.mvpperfectworld.utils.ToastUtils;
import com.dotawang.mvpperfectworld.utils.custom.EditTextWithDeleteIcon;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author DotaWang
 */
public class LoginActivity extends MVPBaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.tv_new_user)
    TextView mTvNewUser;
    @BindView(R.id.rlTitlebar)
    RelativeLayout mRlTitlebar;
    @BindView(R.id.iv_login_logo)
    ImageView mIvLoginLogo;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.iv_login_userLogo)
    ImageView mIvLoginUserLogo;
    @BindView(R.id.et_login_userName)
    EditTextWithDeleteIcon mEtLoginUserName;
    @BindView(R.id.user_line)
    View mUserLine;
    @BindView(R.id.rl_liner1)
    RelativeLayout mRlLiner1;
    @BindView(R.id.iv_login_pswLogo)
    ImageView mIvLoginPswLogo;
    @BindView(R.id.et_login_passWord)
    EditTextWithDeleteIcon mEtLoginPassWord;
    @BindView(R.id.psw_line)
    View mPswLine;
    @BindView(R.id.rl_liner2)
    RelativeLayout mRlLiner2;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.ll_translate)
    LinearLayout mLlTranslate;
    @BindView(R.id.ll_name_psw)
    LinearLayout mLlNamePsw;
    @BindView(R.id.rb_release)
    RadioButton mRbRelease;
    @BindView(R.id.rb_test)
    RadioButton mRbTest;
    @BindView(R.id.rg_group)
    RadioGroup mRgGroup;
    @BindView(R.id.tv_login_desc)
    TextView mTvLoginDesc;
    @BindView(R.id.tv_login_register)
    TextView mTvLoginRegister;
    @BindView(R.id.background)
    RelativeLayout mBackground;

    private Unbinder mUnbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUnbinder = ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (null != mPresenter) {
            mPresenter.requestLoginData();
        }
    }

    @Override
    protected IView getView() {
        return this;
    }

    @Override
    public void setData(ArticleListBean dataMap) {

    }

    @Override
    public void setSomethingData(String msg) {
        mEtLoginUserName.setText(msg);
    }

    @OnClick({R.id.btn_login, R.id.tv_login_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_login_userName:
            case R.id.et_login_passWord:

                break;
            case R.id.btn_login:
                ToastUtils.showLong("login activity");
                break;
            case R.id.tv_login_register:
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}

