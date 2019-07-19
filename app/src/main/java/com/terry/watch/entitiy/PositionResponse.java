package com.terry.watch.entitiy;

import java.util.List;

/**
 * 持仓
 * @author 张全
 */
public class PositionResponse {

    /**
     * code : 0
     * msg : 成功
     * data : {"position":[{"position_id":"694167","exchange":"okex","exchange_name":"OKEx","type":"future","title":"BCH 季度·空","avg_price":"$292.64","unrealised_pnl_ratio":"-66.5%","colors":{"unrealised_pnl_ratio":1,"title":1},"quantity":"700张","position_worth":"23.92BCH"},{"position_id":"700284","exchange":"okex","exchange_name":"OKEx","type":"future","title":"BTC 季度·空","avg_price":"$10697.96","unrealised_pnl_ratio":"10.1%","colors":{"unrealised_pnl_ratio":2,"title":1},"quantity":"21387张","position_worth":"199.91BTC"},{"position_id":"698002","exchange":"okex","exchange_name":"OKEx","type":"future","title":"EOS 季度·空","avg_price":"$4.148","unrealised_pnl_ratio":"37.46%","colors":{"unrealised_pnl_ratio":2,"title":1},"quantity":"53620张","position_worth":"129258.39EOS"},{"position_id":"695996","exchange":"okex","exchange_name":"OKEx","type":"future","title":"ETH 季度·空","avg_price":"$214.016","unrealised_pnl_ratio":"-84.29%","colors":{"unrealised_pnl_ratio":1,"title":1},"quantity":"13060张","position_worth":"610.23ETH"},{"position_id":"703261","exchange":"okex","exchange_name":"OKEx","type":"future","title":"LTC 季度·空","avg_price":"$100.867","unrealised_pnl_ratio":"61.32%","colors":{"unrealised_pnl_ratio":2,"title":1},"quantity":"71173张","position_worth":"7056.13LTC"}],"leverage_short":"空 7.38倍"}
     */

    public int code;
    public String msg;
    public DataBean data;

    public static class DataBean {
        /**
         * position : [{"position_id":"694167","exchange":"okex","exchange_name":"OKEx","type":"future","title":"BCH 季度·空","avg_price":"$292.64","unrealised_pnl_ratio":"-66.5%","colors":{"unrealised_pnl_ratio":1,"title":1},"quantity":"700张","position_worth":"23.92BCH"},{"position_id":"700284","exchange":"okex","exchange_name":"OKEx","type":"future","title":"BTC 季度·空","avg_price":"$10697.96","unrealised_pnl_ratio":"10.1%","colors":{"unrealised_pnl_ratio":2,"title":1},"quantity":"21387张","position_worth":"199.91BTC"},{"position_id":"698002","exchange":"okex","exchange_name":"OKEx","type":"future","title":"EOS 季度·空","avg_price":"$4.148","unrealised_pnl_ratio":"37.46%","colors":{"unrealised_pnl_ratio":2,"title":1},"quantity":"53620张","position_worth":"129258.39EOS"},{"position_id":"695996","exchange":"okex","exchange_name":"OKEx","type":"future","title":"ETH 季度·空","avg_price":"$214.016","unrealised_pnl_ratio":"-84.29%","colors":{"unrealised_pnl_ratio":1,"title":1},"quantity":"13060张","position_worth":"610.23ETH"},{"position_id":"703261","exchange":"okex","exchange_name":"OKEx","type":"future","title":"LTC 季度·空","avg_price":"$100.867","unrealised_pnl_ratio":"61.32%","colors":{"unrealised_pnl_ratio":2,"title":1},"quantity":"71173张","position_worth":"7056.13LTC"}]
         * leverage_short : 空 7.38倍
         */

        public String leverage_short;
        public List<PositionBean> position;

        public static class PositionBean {
            /**
             * position_id : 694167
             * exchange : okex
             * exchange_name : OKEx
             * type : future
             * title : BCH 季度·空
             * avg_price : $292.64
             * unrealised_pnl_ratio : -66.5%
             * colors : {"unrealised_pnl_ratio":1,"title":1}
             * quantity : 700张
             * position_worth : 23.92BCH
             */

            public String position_id;
            public String exchange;
            public String exchange_name;
            public String type;
            public String title;
            public String avg_price;
            public String unrealised_pnl_ratio;
            public ColorsBean colors;
            public String quantity;
            public String position_worth;

            public static class ColorsBean {
                /**
                 * unrealised_pnl_ratio : 1
                 * title : 1
                 */

                public int unrealised_pnl_ratio;
                public int title;
            }
        }
    }
}
