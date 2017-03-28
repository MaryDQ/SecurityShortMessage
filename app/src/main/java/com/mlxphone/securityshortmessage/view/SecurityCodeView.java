package com.mlxphone.securityshortmessage.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mlxphone.securityshortmessage.R;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by MLXPHONE on 2017/3/28.
 */

public class SecurityCodeView extends View {

    @BindView(R.id.item_edittext)
    private EditText editText;
    @BindViews({R.id.item_code_iv1, R.id.item_code_iv2, R.id.item_code_iv3, R.id.item_code_iv4})
    private TextView[] TextViews;
    private StringBuffer stringBuffer = new StringBuffer();
    private int count = 4;
    private String inputContent;
    private View view;

    public SecurityCodeView(Context context) {
        super(context, null);
    }

    public SecurityCodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public SecurityCodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        view = View.inflate(context, R.layout.view_serurity_layout, null);
        ButterKnife.bind(this, view);

        editText.setCursorVisible(false);
    }
}
