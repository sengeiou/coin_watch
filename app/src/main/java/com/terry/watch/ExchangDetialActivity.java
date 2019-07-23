package com.terry.watch;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.android.util.ext.ToastUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.terry.watch.entitiy.ExchangeDetail;
import com.terry.watch.viewmodel.HomeViewModel;
import com.terry.watch.viewmodel.NetReqResult;

/**
 * 仓位详情
 *
 * @author 张全
 */
public class ExchangDetialActivity extends AppCompatActivity {
    private HomeViewModel homeViewModel;
    private SmartRefreshLayout refreshLayout;
    TextView tv_ratio;
    TextView tv_name;
    TextView tv_avg_price;
    TextView tv_unrealised_pnl_ratio;
    TextView tv_unrealised_pnl;
    TextView tv_realised_pnl;
    TextView tv_quantity;
    TextView tv_position_worth;
    TextView tv_margin;
    TextView tv_liquidation_price;

    private static final String PARAM = "PARAM";
    private String id;

    public static void start(Context ctx, String id) {
        Intent intent = new Intent(ctx, ExchangDetialActivity.class);
        intent.putExtra(PARAM, id);
        ctx.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.position_detail);
        id = getIntent().getStringExtra(PARAM);
        initView();
        initData();
    }

    private void initView() {
        refreshLayout = findViewById(R.id.refreshlayout);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                homeViewModel.getExchangeDetail(id);
            }
        });
        tv_ratio = findViewById(R.id.tv_ratio);
        tv_name = findViewById(R.id.tv_name);
        tv_avg_price = findViewById(R.id.tv_avg_price);
        tv_unrealised_pnl_ratio = findViewById(R.id.tv_unrealised_pnl_ratio);
        tv_unrealised_pnl = findViewById(R.id.unrealised_pnl);
        tv_realised_pnl = findViewById(R.id.realised_pnl);
        tv_quantity = findViewById(R.id.quantity);
        tv_position_worth = findViewById(R.id.position_worth);
        tv_margin = findViewById(R.id.margin);
        tv_liquidation_price = findViewById(R.id.liquidation_price);

    }

    private void initData() {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        homeViewModel.liveData.observe(this, new Observer<NetReqResult>() {
            @Override
            public void onChanged(@Nullable NetReqResult netReqResult) {
                if (TextUtils.equals(netReqResult.tag, HomeViewModel.TAG_EXCHANGE)) {
                    if (netReqResult.successful) {
                        refreshLayout.finishRefresh(true);
                        ExchangeDetail exchangDetial = (ExchangeDetail) netReqResult.data;
                        ExchangeDetail.DataBean.PositionBean position = exchangDetial.data.position;
                        int primaryColor = getResources().getColor(R.color.colorPrimary);
                        if (position.leverage.startsWith("空")) {
                            tv_ratio.setBackgroundColor(Color.RED);
                        } else {
                            tv_ratio.setBackgroundColor(primaryColor);
                        }
                        tv_ratio.setText(position.leverage);
                        tv_name.setText(position.title);
                        tv_avg_price.setText(position.avg_price);
                        if(position.unrealised_pnl_ratio.startsWith("-")){
                            tv_unrealised_pnl_ratio.setTextColor(Color.RED);
                        }else{
                            tv_unrealised_pnl_ratio.setTextColor(primaryColor);
                        }
                        tv_unrealised_pnl_ratio.setText(position.unrealised_pnl_ratio);
                        tv_unrealised_pnl.setText(position.unrealised_pnl);
                        tv_realised_pnl.setText(position.realised_pnl);
                        tv_quantity.setText(position.quantity);
                        tv_position_worth.setText(position.position_worth);
                        tv_margin.setText(position.margin);
                        tv_liquidation_price.setText(position.liquidation_price);

                    } else {
                        ToastUtil.show("请求失败");
                        refreshLayout.finishRefresh(false);
                    }
                }
            }
        });
        homeViewModel.getExchangeDetail(id);
    }
}
