package com.terry.watch.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.terry.watch.R;
import com.terry.watch.entitiy.DistributionResponse;

/**
 * 资产分布
 * @author 张全
 */
public class DistributionAdapter extends BaseQuickAdapter<DistributionResponse.DataBeanX.DistributionBean, BaseViewHolder> {

    public DistributionAdapter() {
        super(R.layout.distribution_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, DistributionResponse.DataBeanX.DistributionBean item) {
        helper.setText(R.id.item_name, item.coin.toUpperCase());
        helper.setText(R.id.item_num, item.getAmountStr());
    }
}
