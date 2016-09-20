package com.example.chenhaolong.myframe.view;


import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.example.chenhaolong.myframe.R;
import com.example.chenhaolong.myframe.bean.RvBean;
import com.example.chenhaolong.myframe.net.PicassoUtil;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/9/18.
 */

public class RvAdapter extends CommonAdapter<RvBean> {

    public RvAdapter(Context context, int layoutId, List<RvBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, RvBean rvBean, int position) {
        holder.setText(R.id.tv, rvBean.getName());
        PicassoUtil.INSTANCE.getPicasso().load(rvBean.getImageUrl()).into((ImageView) holder.getView(R.id.iv));
    }
}
