package com.terry.watch;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.android.util.ext.ToastUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.terry.watch.adapter.DistributionAdapter;
import com.terry.watch.adapter.HomeAdapter;
import com.terry.watch.adapter.PositionListAdapter;
import com.terry.watch.entitiy.DistributionResponse;
import com.terry.watch.entitiy.HomeResponse;
import com.terry.watch.entitiy.PositionResponse;
import com.terry.watch.task.CoreService;
import com.terry.watch.task.ProgroundService;
import com.terry.watch.viewmodel.HomeViewModel;
import com.terry.watch.viewmodel.NetReqResult;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SmartRefreshLayout refreshLayout;
    private RecyclerView positionListView;
    private RecyclerView distributionListView;
    private DistributionAdapter distributionAdapter;
    private PositionListAdapter positionListAdapter;
    private HomeViewModel homeViewModel;

    private static final String UID = Constant.UID_FVS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, CoreService.class));
        startService(new Intent(this, ProgroundService.class));

//        startActivity(new Intent(this,WebViewActivity.class));

//        Intent intent = new Intent();
//        intent.setComponent(new ComponentName("com.heyuedi.market","heyuedi.market.mvp.masterhome.MasterHomeActivity"));
//        startActivity(intent);

        initView();
        initData();
    }

    private void initData() {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        homeViewModel.liveData.observe(this, new Observer<NetReqResult>() {
            @Override
            public void onChanged(@Nullable NetReqResult netReqResult) {
                if (netReqResult.successful) {
                    refreshLayout.finishRefresh(true);
                    HomeResponse response = (HomeResponse) netReqResult.data;
                    try {
                        DistributionResponse distributionResponse = response.distributionResponse;
                        List<DistributionResponse.DataBeanX.DistributionBean> distribution = distributionResponse.data.distribution;
                        if (null != distribution) {
                            distributionAdapter.setNewData(distribution);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        PositionResponse positionResponse = response.positionResponse;
                        List<PositionResponse.DataBean.PositionBean> position = positionResponse.data.position;
                        if (null != position) {
                            positionListAdapter.setNewData(position);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ToastUtil.show("请求失败");
                    refreshLayout.finishRefresh(false);
                }
            }
        });

        homeViewModel.getHomeData(UID);
    }

    private void initView() {
        refreshLayout = findViewById(R.id.home_refreshlayout);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                homeViewModel.getHomeData(UID);
            }
        });

        View headView = LayoutInflater.from(this).inflate(R.layout.position_header, null, false);
        //资产分布
        distributionListView = headView.findViewById(R.id.distribution_list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        distributionListView.setLayoutManager(gridLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.home_pos_list_divider));
        distributionListView.addItemDecoration(dividerItemDecoration);

        distributionAdapter = new DistributionAdapter();
        distributionListView.setAdapter(distributionAdapter);


        //持仓分布
        positionListView = headView.findViewById(R.id.poi_list);
        gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        positionListView.setLayoutManager(gridLayoutManager);
        dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.home_pos_list_divider));
        positionListView.addItemDecoration(dividerItemDecoration);


        positionListAdapter = new PositionListAdapter();
        positionListView.setAdapter(positionListAdapter);
        positionListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String position_id = positionListAdapter.getData().get(position).position_id;
                ExchangDetialActivity.start(MainActivity.this,position_id);
            }
        });



        RecyclerView recyclerView = findViewById(R.id.position_list);
        HomeAdapter homeAdapter = new HomeAdapter();
        homeAdapter.addHeaderView(headView);
        recyclerView.setAdapter(homeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
