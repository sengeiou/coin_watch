package com.terry.watch.entitiy;

import java.util.List;

/**
 * 关注列表
 * @author 张全
 */
public class FllowReponse {

    /**
     * code : 0
     * msg : 成功
     * data : [{"user":{"uid":"fvs","head_img":"http://head.ppsyw.cn/head_1553263683.jpg","nickname":"肥宅比特币","description":"2018年度多军","verified_level":"1","verified_text":""},"position":[{"position_id":"695488","exchange":"okex","exchange_name":"OKEx","type":"future","title":"BSV 季度·多","avg_price":"$131.83","unrealised_pnl_ratio":"55.49%","colors":{"unrealised_pnl_ratio":2,"title":2},"quantity":"1520张","position_worth":"115.29BSV"},{"position_id":"458514","exchange":"okex","exchange_name":"OKEx","type":"future","title":"LTC 永续·多","avg_price":"$41.230","unrealised_pnl_ratio":"576.47%","colors":{"unrealised_pnl_ratio":2,"title":2},"quantity":"3500张","position_worth":"848.89LTC"},{"position_id":"525632","exchange":"okex","exchange_name":"OKEx","type":"future","title":"LTC 永续·空","avg_price":"$106.140","unrealised_pnl_ratio":"90.29%","colors":{"unrealised_pnl_ratio":2,"title":1},"quantity":"3500张","position_worth":"329.75LTC"}],"leverage_long":"多 0.10倍","leverage_short":"空 0.07倍"},{"user":{"uid":"gpmw","head_img":"http://head.ppsyw.cn/head_1558234760.jpg","nickname":"HODL","description":"期待下一个牛市","verified_level":"1","verified_text":""},"position":[{"position_id":"648543","exchange":"bitmex","exchange_name":"BitMEX","type":"future","title":"ETH 永续·多","avg_price":"$210.07","unrealised_pnl_ratio":"0%","colors":{"unrealised_pnl_ratio":2,"title":2},"quantity":"10001张","position_worth":"99.7109ETH"}],"leverage_long":"多 0.67倍"},{"user":{"uid":"vgpw","head_img":"http://head.ppsyw.cn/head_1555685906.jpg","nickname":"欧阳拽白","description":"时间是唯一的货币","verified_level":"1","verified_text":""},"position":[{"position_id":"12","exchange":"binance","exchange_name":"Binance","type":"spot","title":"NANO","avg_price":"$1.8169967","unrealised_pnl_ratio":"-40.56%","colors":{"unrealised_pnl_ratio":1,"title":2},"quantity":"10000NANO","position_worth":"$10800"},{"position_id":"13","exchange":"binance","exchange_name":"Binance","type":"spot","title":"BNB","avg_price":"$-","unrealised_pnl_ratio":"0%","colors":{"unrealised_pnl_ratio":2,"title":2},"quantity":"905.8438297BNB","position_worth":"$-"},{"position_id":"91","exchange":"binance","exchange_name":"Binance","type":"spot","title":"ARN","avg_price":"$0.37096217","unrealised_pnl_ratio":"-29.38%","colors":{"unrealised_pnl_ratio":1,"title":2},"quantity":"10683ARN","position_worth":"$2798.26"},{"position_id":"391","exchange":"binance","exchange_name":"Binance","type":"spot","title":"REP","avg_price":"$20.233233","unrealised_pnl_ratio":"-41.48%","colors":{"unrealised_pnl_ratio":1,"title":2},"quantity":"1000.63REP","position_worth":"$11846.98"},{"position_id":"1030","exchange":"binance","exchange_name":"Binance","type":"spot","title":"DGD","avg_price":"$31.29427552","unrealised_pnl_ratio":"-44.92%","colors":{"unrealised_pnl_ratio":1,"title":2},"quantity":"1092.792DGD","position_worth":"$18834.73"},{"position_id":"1032","exchange":"binance","exchange_name":"Binance","type":"spot","title":"GXS","avg_price":"$2.35843596","unrealised_pnl_ratio":"-37.22%","colors":{"unrealised_pnl_ratio":1,"title":2},"quantity":"78015.86GXS","position_worth":"$115499.75"}]},{"user":{"uid":"mool","head_img":"http://head.ppsyw.cn/head_1561503699.jpg","nickname":"一叶知秋","description":"玩短线，小号很多都是尝试做，别乱跟单。微博：子胥先森","verified_level":"1","verified_text":""}},{"user":{"uid":"gmap","head_img":"http://head.ppsyw.cn/head_1557266620.jpg","nickname":"我的爆仓日记","description":"除了我都是猪","verified_level":"1","verified_text":""}},{"user":{"uid":"gfov","head_img":"http://head.ppsyw.cn/head_1558014719.jpg","nickname":"币圈防割佬","description":"低频复利量化机器人微信：fang-ge-lao","verified_level":"1","verified_text":""}},{"user":{"uid":"sgpf","head_img":"http://head.ppsyw.cn/head_1562491787.jpg","nickname":"比特皇","description":"避实击虚，知行合一。微博：比特皇","verified_level":"1","verified_text":""}}]
     */

    public int code;
    public String msg;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * user : {"uid":"fvs","head_img":"http://head.ppsyw.cn/head_1553263683.jpg","nickname":"肥宅比特币","description":"2018年度多军","verified_level":"1","verified_text":""}
         * position : [{"position_id":"695488","exchange":"okex","exchange_name":"OKEx","type":"future","title":"BSV 季度·多","avg_price":"$131.83","unrealised_pnl_ratio":"55.49%","colors":{"unrealised_pnl_ratio":2,"title":2},"quantity":"1520张","position_worth":"115.29BSV"},{"position_id":"458514","exchange":"okex","exchange_name":"OKEx","type":"future","title":"LTC 永续·多","avg_price":"$41.230","unrealised_pnl_ratio":"576.47%","colors":{"unrealised_pnl_ratio":2,"title":2},"quantity":"3500张","position_worth":"848.89LTC"},{"position_id":"525632","exchange":"okex","exchange_name":"OKEx","type":"future","title":"LTC 永续·空","avg_price":"$106.140","unrealised_pnl_ratio":"90.29%","colors":{"unrealised_pnl_ratio":2,"title":1},"quantity":"3500张","position_worth":"329.75LTC"}]
         * leverage_long : 多 0.10倍
         * leverage_short : 空 0.07倍
         */

        public UserBean user;
        public String leverage_long;
        public String leverage_short;
        public List<PositionBean> position;

        public static class UserBean {
            /**
             * uid : fvs
             * head_img : http://head.ppsyw.cn/head_1553263683.jpg
             * nickname : 肥宅比特币
             * description : 2018年度多军
             * verified_level : 1
             * verified_text :
             */

            public String uid;
            public String head_img;
            public String nickname;
            public String description;
            public String verified_level;
            public String verified_text;
        }

        public static class PositionBean {
            /**
             * position_id : 695488
             * exchange : okex
             * exchange_name : OKEx
             * type : future
             * title : BSV 季度·多
             * avg_price : $131.83
             * unrealised_pnl_ratio : 55.49%
             * colors : {"unrealised_pnl_ratio":2,"title":2}
             * quantity : 1520张
             * position_worth : 115.29BSV
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
                 * unrealised_pnl_ratio : 2
                 * title : 2
                 */

                public int unrealised_pnl_ratio;
                public int title;
            }
        }
    }

    @Override
    public String toString() {
        return "FllowReponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
