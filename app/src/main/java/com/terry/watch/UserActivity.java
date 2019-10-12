package com.terry.watch;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

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
import com.terry.watch.viewmodel.HomeViewModel;
import com.terry.watch.viewmodel.NetReqResult;

import java.util.ArrayList;
import java.util.List;

/**
 * 肥仔
 */
public class UserActivity extends AppCompatActivity {
    private SmartRefreshLayout refreshLayout;
    private RecyclerView positionListView;
    private RecyclerView distributionListView;
    private DistributionAdapter distributionAdapter;
    private PositionListAdapter positionListAdapter, positionListAdapter2;
    private HomeViewModel homeViewModel;

    private static final String UID = "UID";
    private static final String PLATFORM = "PLATFORM";
    private String uid;
    private String platform = "okex";
    private String platform2 = "bitmex";

    public static void start(Context ctx, String uid) {
        ctx.startActivity(getIntent(ctx, uid));
    }

    public static Intent getIntent(Context ctx, String uid) {
        Intent intent = new Intent(ctx, UserActivity.class);
        intent.putExtra(UID, uid);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_position);
        uid = getIntent().getStringExtra(UID);


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
                        } else {
                            distributionAdapter.setNewData(new ArrayList<>());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        PositionResponse positionResponse = response.positionResponse;
                        List<PositionResponse.DataBean.PositionBean> position = positionResponse.data.position;
                        if (null != position) {
                            positionListAdapter.setNewData(position);
                        } else {
                            positionListAdapter.setNewData(new ArrayList<>());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        if (null != response.positionResponse2) {
                            PositionResponse positionResponse = response.positionResponse2;
                            List<PositionResponse.DataBean.PositionBean> position = positionResponse.data.position;
                            if (null != position) {
                                positionListAdapter2.setNewData(position);
                            } else {
                                positionListAdapter2.setNewData(new ArrayList<>());
                            }
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


    }

    private void initView() {
        refreshLayout = findViewById(R.id.home_refreshlayout);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                homeViewModel.getHomeData(uid, platform, platform2);
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


        //持仓分布-okex
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
                ExchangDetialActivity.start(UserActivity.this, position_id);
            }
        });

        //持仓分布-bitmex
        RecyclerView positionListView2 = headView.findViewById(R.id.poi_list2);
        gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        positionListView2.setLayoutManager(gridLayoutManager);
        dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.home_pos_list_divider));
        positionListView2.addItemDecoration(dividerItemDecoration);


        positionListAdapter2 = new PositionListAdapter();
        positionListView2.setAdapter(positionListAdapter2);
        positionListAdapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String position_id = positionListAdapter2.getData().get(position).position_id;
                ExchangDetialActivity.start(UserActivity.this, position_id);
            }
        });


        RecyclerView recyclerView = findViewById(R.id.position_list);
        HomeAdapter homeAdapter = new HomeAdapter();
        homeAdapter.addHeaderView(headView);
        recyclerView.setAdapter(homeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    protected void onResume() {
        super.onResume();
        homeViewModel.getHomeData(uid, platform, platform2);
    }
}
