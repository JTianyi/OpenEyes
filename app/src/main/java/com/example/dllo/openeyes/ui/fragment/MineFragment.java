package com.example.dllo.openeyes.ui.fragment;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.ActivityChooserView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.ui.fragment.AbsBaseFragment;


/**
 * Created by dllo on 16/8/12.
 */
public class MineFragment extends AbsBaseFragment implements View.OnClickListener {
    private ImageView loginIv, dismissIv;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;


    @Override
    protected int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initViews(View view) {
        loginIv = byView(R.id.mine_login_iv);


    }

    @Override
    protected void initDatas() {
        loginIv.setOnClickListener(this);
//         dismissIv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_dismiss:
//                dialog.dismiss();
                break;
            case R.id.mine_login_iv:
                builder = new AlertDialog.Builder(context,R.style.dialog);
                View view = LayoutInflater.from(context).inflate(R.layout.item_mine_login_dialog, null);
                dismissIv = (ImageView) view.findViewById(R.id.dialog_dismiss);
                dismissIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                builder.setView(view);


//                        WindowManager.LayoutParams winlp = builder.getWindow()
//                                .getAttributes();
//                        winlp.alpha = 0.5f; // 0.0-1.0
//                        alertDialog.getWindow().setAttributes(winlp);

//                View layout = getActivity().getLayoutInflater().inflate(R.layout.mydialog,null);
//                AlertDialog.Builder dialog = new AlertDialog.Builder(DialogActivity.this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
//                final AlertDialog dialog = builder.create(context);
//                dialog.setView(view);

//                Window window = dialog.getWindow();
//                WindowManager.LayoutParams lp = window.getAttributes();
//                lp.alpha = 0.2f;
//                window.setAttributes(lp);
//                dialog .show();
                alertDialog=builder.show();
                alertDialog.setCanceledOnTouchOutside(false);
                break;


        }

    }
}
