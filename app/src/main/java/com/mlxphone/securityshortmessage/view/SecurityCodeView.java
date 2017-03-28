package com.mlxphone.securityshortmessage.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
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

    /**
     * 清空输入内容
     */
    public void clearEditText() {
        stringBuffer.delete(0, stringBuffer.length());
        inputContent = stringBuffer.toString();
        for (int i = 0; i < TextViews.length; i++) {
            TextViews[i].setText("");
            TextViews[i].setBackgroundResource(R.mipmap.ic_launcher);
        }
    }

    /******************************************************************************/
    private InputCompleteListener inputCompleteListener;

    public void setInputCompleteListener(InputCompleteListener inputCompleteListener) {
        this.inputCompleteListener = inputCompleteListener;
    }

    public interface InputCompleteListener {
        void inputComplete();

        void deleteContent(boolean isDelete);
    }


    public String getEditContent() {
        return inputContent;
    }

    /***********************************************************************************/

    private void setListener() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //输入不为空进行后续操作
                if (!s.toString().equals("")) {
                    if (stringBuffer.length() > 3) {
                        // TODO: 2017/3/28 注释这段话意思
                        editText.setText("");
                        return;
                    }
                } else {
                    //文字添加到stringBuffer中
                    stringBuffer.append(s);
                    editText.setText("");

                    count = stringBuffer.length();//记录stringBuffer的长度
                    inputContent = stringBuffer.toString();
                    if (stringBuffer.length() == 4) {
                        if (inputCompleteListener != null) {
                            inputCompleteListener.inputComplete();
                        }
                    }
                    for (int i = 0; i < stringBuffer.length(); i++) {
                        TextViews[i].setText();
                    }
                }
            }
        });
    }
}
