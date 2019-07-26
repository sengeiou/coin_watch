package com.terry.watch.adapter;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.terry.watch.R;
import com.terry.watch.entitiy.DistributionResponse;
import com.terry.watch.entitiy.PositionResponse;

/**
 * 资产分布
 *
 * @author 张全
 */
public class PositionListAdapter extends BaseQuickAdapter<PositionResponse.DataBean.PositionBean, BaseViewHolder> {

    public PositionListAdapter() {
        super(R.layout.position_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, PositionResponse.DataBean.PositionBean item) {
        View container = helper.getView(R.id.item_container);
        if(item.title.endsWith("多")){
            helper.setBackgroundRes(R.id.item_container,R.drawable.position_border);
            helper.setBackgroundColor(R.id.item_name,container.getResources().getColor(R.color.color_008577));
            helper.setTextColor(R.id.item_name,container.getResources().getColor(R.color.colorPrimary));
        }else{
            helper.setBackgroundRes(R.id.item_container,R.drawable.kong_border);
            helper.setBackgroundColor(R.id.item_name,container.getResources().getColor(R.color.kong_color_bg));
            helper.setTextColor(R.id.item_name,container.getResources().getColor(R.color.kong_color));
        }
        helper.setText(R.id.item_name, item.title);
        TextView tv_ratio = helper.getView(R.id.item_ratio);
        helper.setText(R.id.item_ratio, item.unrealised_pnl_ratio);
        if (item.unrealised_pnl_ratio.startsWith("-")) {
            tv_ratio.setTextColor(Color.RED);
        } else {
            tv_ratio.setTextColor(tv_ratio.getContext().getResources().getColor(R.color.colorPrimary));
        }
        helper.setText(R.id.item_avg_price, item.avg_price);
        helper.setText(R.id.item_quantity, item.quantity);
        helper.setText(R.id.item_position_worth, item.position_worth);
    }
}
