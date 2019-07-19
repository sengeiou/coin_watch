package com.terry.watch.entitiy;

import java.util.List;

/**
 * 交易详情
 * @author 张全
 */
public class ExchangeDetail {

    /**
     * code : 0
     * msg : 成功
     * data : {"position":{"position_id":700284,"leverage":"空 21倍","title":"OKEx BTC季度","colors":{"leverage":1,"unrealised_pnl_ratio":2},"status":"1","type":"future","avg_price":"$10697.96","position_worth":"199.91BTC","quantity":"21387张","margin":"11.5208BTC","unrealised_pnl":"1.1375BTC","unrealised_pnl_ratio":"11.94%","realised_pnl":"-13.5375BTC","liquidation_price":"$11181.74"},"user":{"uid":"smoog","nickname":"5年老兵","verified_level":"1","verified_text":"","description":"","head_img":"http://wx3.sinaimg.cn/large/007DC2Evly1g0g8j3zhiyj30nc0nen2m.jpg","follow_status":0,"share":{"title":"「5年老兵」实盘直播中","image":"http://wx3.sinaimg.cn/large/007DC2Evly1g0g8j3zhiyj30nc0nen2m.jpg","description":"我正在合约帝做实盘交易直播，快来围观我的操作和分析吧!","url":"http://monitor.ppsyw.cn/live/user/homepage?uid=smoog"}},"trade_list":[{"id":"3466067","filled_qty":"1000张","price_avg":"$10652.08","type":3,"realised_pnl":"0.0402","colors":{"realised_pnl":2},"timestamp":"07.19 12:55"},{"id":"3466066","filled_qty":"1000张","price_avg":"$10659.41","type":3,"realised_pnl":"0.0338","colors":{"realised_pnl":2},"timestamp":"07.19 12:55"},{"id":"3464347","filled_qty":"2000张","price_avg":"$10772.23","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 11:34"},{"id":"3464057","filled_qty":"1000张","price_avg":"$10824.81","type":3,"realised_pnl":"-0.1155","colors":{"realised_pnl":1},"timestamp":"07.19 11:05"},{"id":"3464054","filled_qty":"909张","price_avg":"$10821.16","type":3,"realised_pnl":"-0.1022","colors":{"realised_pnl":1},"timestamp":"07.19 11:05"},{"id":"3464051","filled_qty":"209张","price_avg":"$10815.03","type":3,"realised_pnl":"-0.0224","colors":{"realised_pnl":1},"timestamp":"07.19 11:05"},{"id":"3460280","filled_qty":"1500张","price_avg":"$10800.19","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 07:52"},{"id":"3460041","filled_qty":"3000张","price_avg":"$10870.95","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 07:47"},{"id":"3459996","filled_qty":"1057张","price_avg":"$10918.78","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 07:46"},{"id":"3459953","filled_qty":"3000张","price_avg":"$10940.65","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 07:46"},{"id":"3459813","filled_qty":"5000张","price_avg":"$10946.19","type":3,"realised_pnl":"-1.5758","colors":{"realised_pnl":1},"timestamp":"07.19 07:45"},{"id":"3458995","filled_qty":"2000张","price_avg":"$10814.98","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 07:04"},{"id":"3458845","filled_qty":"1000张","price_avg":"$10833.08","type":3,"realised_pnl":"-0.2425","colors":{"realised_pnl":1},"timestamp":"07.19 07:00"},{"id":"3458840","filled_qty":"2000张","price_avg":"$10827.15","type":3,"realised_pnl":"-0.4749","colors":{"realised_pnl":1},"timestamp":"07.19 07:00"},{"id":"3458096","filled_qty":"3000张","price_avg":"$10780.34","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 05:22"},{"id":"3456073","filled_qty":"978张","price_avg":"$10740.76","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 02:58"},{"id":"3456061","filled_qty":"2000张","price_avg":"$10739.48","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 02:58"},{"id":"3455819","filled_qty":"1000张","price_avg":"$10890.34","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 02:49"},{"id":"3455813","filled_qty":"1000张","price_avg":"$10883.04","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 02:49"},{"id":"3455802","filled_qty":"2000张","price_avg":"$10855.33","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 02:49"},{"id":"3455704","filled_qty":"5000张","price_avg":"$10923.87","type":3,"realised_pnl":"-2.5876","colors":{"realised_pnl":1},"timestamp":"07.19 02:48"},{"id":"3455632","filled_qty":"3000张","price_avg":"$10849.93","type":3,"realised_pnl":"-1.3654","colors":{"realised_pnl":1},"timestamp":"07.19 02:48"},{"id":"3451955","filled_qty":"3000张","price_avg":"$10765.90","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 00:14"},{"id":"3451866","filled_qty":"2000张","price_avg":"$10756.24","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 00:13"},{"id":"3451637","filled_qty":"6000张","price_avg":"$10802.61","type":3,"realised_pnl":"-3.3043","colors":{"realised_pnl":1},"timestamp":"07.19 00:12"},{"id":"3448448","filled_qty":"2000张","price_avg":"$10536.20","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.18 23:19"},{"id":"3448402","filled_qty":"787张","price_avg":"$10537.60","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.18 23:19"},{"id":"3447166","filled_qty":"2000张","price_avg":"$10489.65","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.18 23:06"},{"id":"3445276","filled_qty":"2000张","price_avg":"$10390.79","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.18 22:48"},{"id":"3443763","filled_qty":"2888张","price_avg":"$10294.84","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.18 22:41"},{"id":"3443745","filled_qty":"2000张","price_avg":"$10290.00","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.18 22:41"},{"id":"3442990","filled_qty":"2000张","price_avg":"$10359.98","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.18 22:38"},{"id":"3442392","filled_qty":"8000张","price_avg":"$10270.00","type":3,"realised_pnl":"-3.8209","colors":{"realised_pnl":1},"timestamp":"07.18 22:36"},{"id":"3441561","filled_qty":"4000张","price_avg":"$10135.87","type":3,"realised_pnl":"-1.395","colors":{"realised_pnl":1},"timestamp":"07.18 22:35"}]}
     */

    public int code;
    public String msg;
    public DataBean data;

    public static class DataBean {
        /**
         * position : {"position_id":700284,"leverage":"空 21倍","title":"OKEx BTC季度","colors":{"leverage":1,"unrealised_pnl_ratio":2},"status":"1","type":"future","avg_price":"$10697.96","position_worth":"199.91BTC","quantity":"21387张","margin":"11.5208BTC","unrealised_pnl":"1.1375BTC","unrealised_pnl_ratio":"11.94%","realised_pnl":"-13.5375BTC","liquidation_price":"$11181.74"}
         * user : {"uid":"smoog","nickname":"5年老兵","verified_level":"1","verified_text":"","description":"","head_img":"http://wx3.sinaimg.cn/large/007DC2Evly1g0g8j3zhiyj30nc0nen2m.jpg","follow_status":0,"share":{"title":"「5年老兵」实盘直播中","image":"http://wx3.sinaimg.cn/large/007DC2Evly1g0g8j3zhiyj30nc0nen2m.jpg","description":"我正在合约帝做实盘交易直播，快来围观我的操作和分析吧!","url":"http://monitor.ppsyw.cn/live/user/homepage?uid=smoog"}}
         * trade_list : [{"id":"3466067","filled_qty":"1000张","price_avg":"$10652.08","type":3,"realised_pnl":"0.0402","colors":{"realised_pnl":2},"timestamp":"07.19 12:55"},{"id":"3466066","filled_qty":"1000张","price_avg":"$10659.41","type":3,"realised_pnl":"0.0338","colors":{"realised_pnl":2},"timestamp":"07.19 12:55"},{"id":"3464347","filled_qty":"2000张","price_avg":"$10772.23","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 11:34"},{"id":"3464057","filled_qty":"1000张","price_avg":"$10824.81","type":3,"realised_pnl":"-0.1155","colors":{"realised_pnl":1},"timestamp":"07.19 11:05"},{"id":"3464054","filled_qty":"909张","price_avg":"$10821.16","type":3,"realised_pnl":"-0.1022","colors":{"realised_pnl":1},"timestamp":"07.19 11:05"},{"id":"3464051","filled_qty":"209张","price_avg":"$10815.03","type":3,"realised_pnl":"-0.0224","colors":{"realised_pnl":1},"timestamp":"07.19 11:05"},{"id":"3460280","filled_qty":"1500张","price_avg":"$10800.19","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 07:52"},{"id":"3460041","filled_qty":"3000张","price_avg":"$10870.95","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 07:47"},{"id":"3459996","filled_qty":"1057张","price_avg":"$10918.78","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 07:46"},{"id":"3459953","filled_qty":"3000张","price_avg":"$10940.65","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 07:46"},{"id":"3459813","filled_qty":"5000张","price_avg":"$10946.19","type":3,"realised_pnl":"-1.5758","colors":{"realised_pnl":1},"timestamp":"07.19 07:45"},{"id":"3458995","filled_qty":"2000张","price_avg":"$10814.98","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 07:04"},{"id":"3458845","filled_qty":"1000张","price_avg":"$10833.08","type":3,"realised_pnl":"-0.2425","colors":{"realised_pnl":1},"timestamp":"07.19 07:00"},{"id":"3458840","filled_qty":"2000张","price_avg":"$10827.15","type":3,"realised_pnl":"-0.4749","colors":{"realised_pnl":1},"timestamp":"07.19 07:00"},{"id":"3458096","filled_qty":"3000张","price_avg":"$10780.34","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 05:22"},{"id":"3456073","filled_qty":"978张","price_avg":"$10740.76","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 02:58"},{"id":"3456061","filled_qty":"2000张","price_avg":"$10739.48","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 02:58"},{"id":"3455819","filled_qty":"1000张","price_avg":"$10890.34","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 02:49"},{"id":"3455813","filled_qty":"1000张","price_avg":"$10883.04","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 02:49"},{"id":"3455802","filled_qty":"2000张","price_avg":"$10855.33","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 02:49"},{"id":"3455704","filled_qty":"5000张","price_avg":"$10923.87","type":3,"realised_pnl":"-2.5876","colors":{"realised_pnl":1},"timestamp":"07.19 02:48"},{"id":"3455632","filled_qty":"3000张","price_avg":"$10849.93","type":3,"realised_pnl":"-1.3654","colors":{"realised_pnl":1},"timestamp":"07.19 02:48"},{"id":"3451955","filled_qty":"3000张","price_avg":"$10765.90","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 00:14"},{"id":"3451866","filled_qty":"2000张","price_avg":"$10756.24","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.19 00:13"},{"id":"3451637","filled_qty":"6000张","price_avg":"$10802.61","type":3,"realised_pnl":"-3.3043","colors":{"realised_pnl":1},"timestamp":"07.19 00:12"},{"id":"3448448","filled_qty":"2000张","price_avg":"$10536.20","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.18 23:19"},{"id":"3448402","filled_qty":"787张","price_avg":"$10537.60","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.18 23:19"},{"id":"3447166","filled_qty":"2000张","price_avg":"$10489.65","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.18 23:06"},{"id":"3445276","filled_qty":"2000张","price_avg":"$10390.79","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.18 22:48"},{"id":"3443763","filled_qty":"2888张","price_avg":"$10294.84","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.18 22:41"},{"id":"3443745","filled_qty":"2000张","price_avg":"$10290.00","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.18 22:41"},{"id":"3442990","filled_qty":"2000张","price_avg":"$10359.98","type":2,"realised_pnl":"-","colors":{"realised_pnl":0},"timestamp":"07.18 22:38"},{"id":"3442392","filled_qty":"8000张","price_avg":"$10270.00","type":3,"realised_pnl":"-3.8209","colors":{"realised_pnl":1},"timestamp":"07.18 22:36"},{"id":"3441561","filled_qty":"4000张","price_avg":"$10135.87","type":3,"realised_pnl":"-1.395","colors":{"realised_pnl":1},"timestamp":"07.18 22:35"}]
         */

        public PositionBean position;
        public UserBean user;
        public List<TradeListBean> trade_list;

        public static class PositionBean {
            /**
             * position_id : 700284
             * leverage : 空 21倍
             * title : OKEx BTC季度
             * colors : {"leverage":1,"unrealised_pnl_ratio":2}
             * status : 1
             * type : future
             * avg_price : $10697.96
             * position_worth : 199.91BTC
             * quantity : 21387张
             * margin : 11.5208BTC
             * unrealised_pnl : 1.1375BTC
             * unrealised_pnl_ratio : 11.94%
             * realised_pnl : -13.5375BTC
             * liquidation_price : $11181.74
             */

            public int position_id;
            public String leverage;
            public String title;
            public ColorsBean colors;
            public String status;
            public String type;
            public String avg_price;
            public String position_worth;
            public String quantity;
            public String margin;
            public String unrealised_pnl;
            public String unrealised_pnl_ratio;
            public String realised_pnl;
            public String liquidation_price;

            public static class ColorsBean {
                /**
                 * leverage : 1
                 * unrealised_pnl_ratio : 2
                 */

                public int leverage;
                public int unrealised_pnl_ratio;
            }
        }

        public static class UserBean {
            /**
             * uid : smoog
             * nickname : 5年老兵
             * verified_level : 1
             * verified_text :
             * description :
             * head_img : http://wx3.sinaimg.cn/large/007DC2Evly1g0g8j3zhiyj30nc0nen2m.jpg
             * follow_status : 0
             * share : {"title":"「5年老兵」实盘直播中","image":"http://wx3.sinaimg.cn/large/007DC2Evly1g0g8j3zhiyj30nc0nen2m.jpg","description":"我正在合约帝做实盘交易直播，快来围观我的操作和分析吧!","url":"http://monitor.ppsyw.cn/live/user/homepage?uid=smoog"}
             */

            public String uid;
            public String nickname;
            public String verified_level;
            public String verified_text;
            public String description;
            public String head_img;
            public int follow_status;
            public ShareBean share;

            public static class ShareBean {
                /**
                 * title : 「5年老兵」实盘直播中
                 * image : http://wx3.sinaimg.cn/large/007DC2Evly1g0g8j3zhiyj30nc0nen2m.jpg
                 * description : 我正在合约帝做实盘交易直播，快来围观我的操作和分析吧!
                 * url : http://monitor.ppsyw.cn/live/user/homepage?uid=smoog
                 */

                public String title;
                public String image;
                public String description;
                public String url;
            }
        }

        public static class TradeListBean {
            /**
             * id : 3466067
             * filled_qty : 1000张
             * price_avg : $10652.08
             * type : 3
             * realised_pnl : 0.0402
             * colors : {"realised_pnl":2}
             * timestamp : 07.19 12:55
             */

            public String id;
            public String filled_qty;
            public String price_avg;
            public int type;
            public String realised_pnl;
            public ColorsBeanX colors;
            public String timestamp;

            public static class ColorsBeanX {
                /**
                 * realised_pnl : 2
                 */

                public int realised_pnl;
            }
        }
    }
}
