package com.terry.watch.entitiy;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * @author 张全
 */
public class DistributionResponse {

    /**
     * code : 0
     * msg : 成功
     * data : {"exchange":"okex","balance":"$432364","profit":"$1743497","profit_ratio":"828.61%","week_profit":"$8055","week_profit_ratio":"3.82%","victory_ratio":"60%","live_duration":"122天","trading_frequency":"40次/周","distribution":[{"coin":"btc","amount":"19.74481445","worth":"209920","ratio":"0.4855","color":"#7E78FF"},{"coin":"ltc","amount":"617.25293498","worth":"61361","ratio":"0.1419","color":"#32BEFF"},{"coin":"eth","amount":"204.13843109","worth":"46194","ratio":"0.1068","color":"#03C69C"},{"coin":"trx","amount":"1195019.12423908","worth":"35611","ratio":"0.0823","color":"#F65273"},{"coin":"其他","amount":"-","worth":"-","ratio":"0.18","color":"#FFB04D"}],"profit_history":[{"title":"收益率","data":[{"time":"03-22","value":"-0.28"},{"time":"03-23","value":"4.11"},{"time":"03-24","value":"1.38"},{"time":"03-25","value":"-2.48"},{"time":"03-26","value":"-5.53"},{"time":"03-27","value":"18.56"},{"time":"03-28","value":"12.32"},{"time":"03-29","value":"12.29"},{"time":"03-30","value":"5.95"},{"time":"03-31","value":"5.82"},{"time":"04-01","value":"6.14"},{"time":"04-02","value":"89.42"},{"time":"04-03","value":"190.34"},{"time":"04-04","value":"190.15"},{"time":"04-05","value":"189.88"},{"time":"04-06","value":"197.68"},{"time":"04-07","value":"203.12"},{"time":"04-08","value":"209.19"},{"time":"04-09","value":"204.89"},{"time":"04-10","value":"216.63"},{"time":"04-11","value":"174.15"},{"time":"04-12","value":"178.94"},{"time":"04-13","value":"178.31"},{"time":"04-14","value":"173.93"},{"time":"04-15","value":"181.92"},{"time":"04-16","value":"177.42"},{"time":"04-17","value":"185.22"},{"time":"04-18","value":"192.14"},{"time":"04-19","value":"191.95"},{"time":"04-20","value":"194.55"},{"time":"04-21","value":"176.45"},{"time":"04-22","value":"185.11"},{"time":"04-23","value":"202.17"},{"time":"04-24","value":"171.97"},{"time":"04-25","value":"169.60"},{"time":"04-26","value":"88.40"},{"time":"04-27","value":"87.87"},{"time":"04-28","value":"85.25"},{"time":"04-29","value":"80.27"},{"time":"04-30","value":"90.12"},{"time":"05-01","value":"94.13"},{"time":"05-02","value":"97.25"},{"time":"05-03","value":"112.47"},{"time":"05-04","value":"110.55"},{"time":"05-05","value":"110.05"},{"time":"05-06","value":"108.02"},{"time":"05-07","value":"109.64"},{"time":"05-08","value":"111.71"},{"time":"05-09","value":"112.82"},{"time":"05-10","value":"122.55"},{"time":"05-11","value":"182.00"},{"time":"05-12","value":"191.74"},{"time":"05-13","value":"236.60"},{"time":"05-14","value":"255.28"},{"time":"05-15","value":"267.46"},{"time":"05-16","value":"290.00"},{"time":"05-17","value":"255.54"},{"time":"05-18","value":"251.61"},{"time":"05-19","value":"291.46"},{"time":"05-20","value":"276.26"},{"time":"05-21","value":"272.50"},{"time":"05-22","value":"275.31"},{"time":"05-23","value":"253.33"},{"time":"05-24","value":"291.73"},{"time":"05-25","value":"290.03"},{"time":"05-26","value":"280.81"},{"time":"05-27","value":"358.70"},{"time":"05-28","value":"333.67"},{"time":"05-29","value":"330.75"},{"time":"05-30","value":"338.18"},{"time":"05-31","value":"334.97"},{"time":"06-01","value":"320.19"},{"time":"06-02","value":"319.08"},{"time":"06-03","value":"315.15"},{"time":"06-04","value":"317.02"},{"time":"06-05","value":"309.28"},{"time":"06-06","value":"308.46"},{"time":"06-07","value":"323.91"},{"time":"06-08","value":"323.34"},{"time":"06-09","value":"320.57"},{"time":"06-10","value":"335.91"},{"time":"06-11","value":"333.20"},{"time":"06-12","value":"352.57"},{"time":"06-13","value":"347.62"},{"time":"06-14","value":"344.95"},{"time":"06-15","value":"353.26"},{"time":"06-16","value":"369.22"},{"time":"06-17","value":"369.37"},{"time":"06-18","value":"356.47"},{"time":"06-19","value":"358.33"},{"time":"06-20","value":"357.28"},{"time":"06-21","value":"383.05"},{"time":"06-22","value":"424.21"},{"time":"06-23","value":"432.31"},{"time":"06-24","value":"427.88"},{"time":"06-25","value":"447.09"},{"time":"06-26","value":"522.25"},{"time":"06-27","value":"531.47"},{"time":"06-28","value":"561.61"},{"time":"06-29","value":"563.74"},{"time":"06-30","value":"564.88"},{"time":"07-01","value":"562.70"},{"time":"07-02","value":"602.41"},{"time":"07-03","value":"640.52"},{"time":"07-04","value":"653.17"},{"time":"07-05","value":"639.52"},{"time":"07-06","value":"645.85"},{"time":"07-07","value":"642.23"},{"time":"07-08","value":"669.19"},{"time":"07-09","value":"683.75"},{"time":"07-10","value":"667.60"},{"time":"07-11","value":"669.67"},{"time":"07-12","value":"675.57"},{"time":"07-13","value":"682.84"},{"time":"07-14","value":"680.63"},{"time":"07-15","value":"702.55"},{"time":"07-16","value":"693.63"},{"time":"07-17","value":"749.04"},{"time":"07-18","value":"845.48"},{"time":"07-19","value":"827.58"},{"time":"07-20","value":"835.61"},{"time":"07-21","value":"824.79"},{"time":"07-22","value":"825.81"}],"unit":"%","max":"845.48","min":"-5.53"},{"title":"总收益","data":[{"time":"03-22","value":"-540"},{"time":"03-23","value":"7806"},{"time":"03-24","value":"2639"},{"time":"03-25","value":"-4714"},{"time":"03-26","value":"-10518"},{"time":"03-27","value":"35261"},{"time":"03-28","value":"25845"},{"time":"03-29","value":"25787"},{"time":"03-30","value":"12523"},{"time":"03-31","value":"12253"},{"time":"04-01","value":"12939"},{"time":"04-02","value":"188163"},{"time":"04-03","value":"400498"},{"time":"04-04","value":"400098"},{"time":"04-05","value":"399531"},{"time":"04-06","value":"415949"},{"time":"04-07","value":"427403"},{"time":"04-08","value":"440176"},{"time":"04-09","value":"431114"},{"time":"04-10","value":"455829"},{"time":"04-11","value":"366433"},{"time":"04-12","value":"376526"},{"time":"04-13","value":"375189"},{"time":"04-14","value":"365967"},{"time":"04-15","value":"382780"},{"time":"04-16","value":"373319"},{"time":"04-17","value":"389732"},{"time":"04-18","value":"404287"},{"time":"04-19","value":"403890"},{"time":"04-20","value":"409372"},{"time":"04-21","value":"371281"},{"time":"04-22","value":"389504"},{"time":"04-23","value":"425405"},{"time":"04-24","value":"361846"},{"time":"04-25","value":"356874"},{"time":"04-26","value":"186023"},{"time":"04-27","value":"184888"},{"time":"04-28","value":"179395"},{"time":"04-29","value":"168901"},{"time":"04-30","value":"189624"},{"time":"05-01","value":"198061"},{"time":"05-02","value":"204643"},{"time":"05-03","value":"236658"},{"time":"05-04","value":"232617"},{"time":"05-05","value":"231567"},{"time":"05-06","value":"227291"},{"time":"05-07","value":"230702"},{"time":"05-08","value":"235052"},{"time":"05-09","value":"237393"},{"time":"05-10","value":"257868"},{"time":"05-11","value":"382964"},{"time":"05-12","value":"403447"},{"time":"05-13","value":"497840"},{"time":"05-14","value":"537140"},{"time":"05-15","value":"562769"},{"time":"05-16","value":"610191"},{"time":"05-17","value":"537685"},{"time":"05-18","value":"529414"},{"time":"05-19","value":"613264"},{"time":"05-20","value":"581284"},{"time":"05-21","value":"573386"},{"time":"05-22","value":"579299"},{"time":"05-23","value":"533048"},{"time":"05-24","value":"613833"},{"time":"05-25","value":"610261"},{"time":"05-26","value":"590860"},{"time":"05-27","value":"754747"},{"time":"05-28","value":"702091"},{"time":"05-29","value":"695935"},{"time":"05-30","value":"711575"},{"time":"05-31","value":"704828"},{"time":"06-01","value":"673723"},{"time":"06-02","value":"671391"},{"time":"06-03","value":"663124"},{"time":"06-04","value":"667043"},{"time":"06-05","value":"650764"},{"time":"06-06","value":"649042"},{"time":"06-07","value":"681547"},{"time":"06-08","value":"680352"},{"time":"06-09","value":"674523"},{"time":"06-10","value":"706792"},{"time":"06-11","value":"701104"},{"time":"06-12","value":"741857"},{"time":"06-13","value":"731433"},{"time":"06-14","value":"725813"},{"time":"06-15","value":"743312"},{"time":"06-16","value":"776878"},{"time":"06-17","value":"777200"},{"time":"06-18","value":"750067"},{"time":"06-19","value":"753977"},{"time":"06-20","value":"751762"},{"time":"06-21","value":"805986"},{"time":"06-22","value":"892594"},{"time":"06-23","value":"909642"},{"time":"06-24","value":"900310"},{"time":"06-25","value":"940739"},{"time":"06-26","value":"1098884"},{"time":"06-27","value":"1118276"},{"time":"06-28","value":"1181684"},{"time":"06-29","value":"1186174"},{"time":"06-30","value":"1188570"},{"time":"07-01","value":"1183988"},{"time":"07-02","value":"1267534"},{"time":"07-03","value":"1347721"},{"time":"07-04","value":"1374350"},{"time":"07-05","value":"1345618"},{"time":"07-06","value":"1358949"},{"time":"07-07","value":"1351333"},{"time":"07-08","value":"1408052"},{"time":"07-09","value":"1438692"},{"time":"07-10","value":"1404718"},{"time":"07-11","value":"1409067"},{"time":"07-12","value":"1421474"},{"time":"07-13","value":"1436772"},{"time":"07-14","value":"1432127"},{"time":"07-15","value":"1478250"},{"time":"07-16","value":"1459479"},{"time":"07-17","value":"1576072"},{"time":"07-18","value":"1778995"},{"time":"07-19","value":"1741321"},{"time":"07-20","value":"1758227"},{"time":"07-21","value":"1735442"},{"time":"07-22","value":"1737595"}],"unit":"$","max":"1778995","min":"-10518"}],"colors":{"profit":2,"profit_ratio":2,"week_profit":2,"week_profit_ratio":2},"chart_list":[{"title":"收益率走势","url":"http://chart.heyuedi.com/chart/profit/okex/fvs_2019072212.png"}]}
     */

    public int code;
    public String msg;
    public DataBeanX data;

    public static class DataBeanX {
        /**
         * exchange : okex
         * balance : $432364
         * profit : $1743497
         * profit_ratio : 828.61%
         * week_profit : $8055
         * week_profit_ratio : 3.82%
         * victory_ratio : 60%
         * live_duration : 122天
         * trading_frequency : 40次/周
         * distribution : [{"coin":"btc","amount":"19.74481445","worth":"209920","ratio":"0.4855","color":"#7E78FF"},{"coin":"ltc","amount":"617.25293498","worth":"61361","ratio":"0.1419","color":"#32BEFF"},{"coin":"eth","amount":"204.13843109","worth":"46194","ratio":"0.1068","color":"#03C69C"},{"coin":"trx","amount":"1195019.12423908","worth":"35611","ratio":"0.0823","color":"#F65273"},{"coin":"其他","amount":"-","worth":"-","ratio":"0.18","color":"#FFB04D"}]
         * profit_history : [{"title":"收益率","data":[{"time":"03-22","value":"-0.28"},{"time":"03-23","value":"4.11"},{"time":"03-24","value":"1.38"},{"time":"03-25","value":"-2.48"},{"time":"03-26","value":"-5.53"},{"time":"03-27","value":"18.56"},{"time":"03-28","value":"12.32"},{"time":"03-29","value":"12.29"},{"time":"03-30","value":"5.95"},{"time":"03-31","value":"5.82"},{"time":"04-01","value":"6.14"},{"time":"04-02","value":"89.42"},{"time":"04-03","value":"190.34"},{"time":"04-04","value":"190.15"},{"time":"04-05","value":"189.88"},{"time":"04-06","value":"197.68"},{"time":"04-07","value":"203.12"},{"time":"04-08","value":"209.19"},{"time":"04-09","value":"204.89"},{"time":"04-10","value":"216.63"},{"time":"04-11","value":"174.15"},{"time":"04-12","value":"178.94"},{"time":"04-13","value":"178.31"},{"time":"04-14","value":"173.93"},{"time":"04-15","value":"181.92"},{"time":"04-16","value":"177.42"},{"time":"04-17","value":"185.22"},{"time":"04-18","value":"192.14"},{"time":"04-19","value":"191.95"},{"time":"04-20","value":"194.55"},{"time":"04-21","value":"176.45"},{"time":"04-22","value":"185.11"},{"time":"04-23","value":"202.17"},{"time":"04-24","value":"171.97"},{"time":"04-25","value":"169.60"},{"time":"04-26","value":"88.40"},{"time":"04-27","value":"87.87"},{"time":"04-28","value":"85.25"},{"time":"04-29","value":"80.27"},{"time":"04-30","value":"90.12"},{"time":"05-01","value":"94.13"},{"time":"05-02","value":"97.25"},{"time":"05-03","value":"112.47"},{"time":"05-04","value":"110.55"},{"time":"05-05","value":"110.05"},{"time":"05-06","value":"108.02"},{"time":"05-07","value":"109.64"},{"time":"05-08","value":"111.71"},{"time":"05-09","value":"112.82"},{"time":"05-10","value":"122.55"},{"time":"05-11","value":"182.00"},{"time":"05-12","value":"191.74"},{"time":"05-13","value":"236.60"},{"time":"05-14","value":"255.28"},{"time":"05-15","value":"267.46"},{"time":"05-16","value":"290.00"},{"time":"05-17","value":"255.54"},{"time":"05-18","value":"251.61"},{"time":"05-19","value":"291.46"},{"time":"05-20","value":"276.26"},{"time":"05-21","value":"272.50"},{"time":"05-22","value":"275.31"},{"time":"05-23","value":"253.33"},{"time":"05-24","value":"291.73"},{"time":"05-25","value":"290.03"},{"time":"05-26","value":"280.81"},{"time":"05-27","value":"358.70"},{"time":"05-28","value":"333.67"},{"time":"05-29","value":"330.75"},{"time":"05-30","value":"338.18"},{"time":"05-31","value":"334.97"},{"time":"06-01","value":"320.19"},{"time":"06-02","value":"319.08"},{"time":"06-03","value":"315.15"},{"time":"06-04","value":"317.02"},{"time":"06-05","value":"309.28"},{"time":"06-06","value":"308.46"},{"time":"06-07","value":"323.91"},{"time":"06-08","value":"323.34"},{"time":"06-09","value":"320.57"},{"time":"06-10","value":"335.91"},{"time":"06-11","value":"333.20"},{"time":"06-12","value":"352.57"},{"time":"06-13","value":"347.62"},{"time":"06-14","value":"344.95"},{"time":"06-15","value":"353.26"},{"time":"06-16","value":"369.22"},{"time":"06-17","value":"369.37"},{"time":"06-18","value":"356.47"},{"time":"06-19","value":"358.33"},{"time":"06-20","value":"357.28"},{"time":"06-21","value":"383.05"},{"time":"06-22","value":"424.21"},{"time":"06-23","value":"432.31"},{"time":"06-24","value":"427.88"},{"time":"06-25","value":"447.09"},{"time":"06-26","value":"522.25"},{"time":"06-27","value":"531.47"},{"time":"06-28","value":"561.61"},{"time":"06-29","value":"563.74"},{"time":"06-30","value":"564.88"},{"time":"07-01","value":"562.70"},{"time":"07-02","value":"602.41"},{"time":"07-03","value":"640.52"},{"time":"07-04","value":"653.17"},{"time":"07-05","value":"639.52"},{"time":"07-06","value":"645.85"},{"time":"07-07","value":"642.23"},{"time":"07-08","value":"669.19"},{"time":"07-09","value":"683.75"},{"time":"07-10","value":"667.60"},{"time":"07-11","value":"669.67"},{"time":"07-12","value":"675.57"},{"time":"07-13","value":"682.84"},{"time":"07-14","value":"680.63"},{"time":"07-15","value":"702.55"},{"time":"07-16","value":"693.63"},{"time":"07-17","value":"749.04"},{"time":"07-18","value":"845.48"},{"time":"07-19","value":"827.58"},{"time":"07-20","value":"835.61"},{"time":"07-21","value":"824.79"},{"time":"07-22","value":"825.81"}],"unit":"%","max":"845.48","min":"-5.53"},{"title":"总收益","data":[{"time":"03-22","value":"-540"},{"time":"03-23","value":"7806"},{"time":"03-24","value":"2639"},{"time":"03-25","value":"-4714"},{"time":"03-26","value":"-10518"},{"time":"03-27","value":"35261"},{"time":"03-28","value":"25845"},{"time":"03-29","value":"25787"},{"time":"03-30","value":"12523"},{"time":"03-31","value":"12253"},{"time":"04-01","value":"12939"},{"time":"04-02","value":"188163"},{"time":"04-03","value":"400498"},{"time":"04-04","value":"400098"},{"time":"04-05","value":"399531"},{"time":"04-06","value":"415949"},{"time":"04-07","value":"427403"},{"time":"04-08","value":"440176"},{"time":"04-09","value":"431114"},{"time":"04-10","value":"455829"},{"time":"04-11","value":"366433"},{"time":"04-12","value":"376526"},{"time":"04-13","value":"375189"},{"time":"04-14","value":"365967"},{"time":"04-15","value":"382780"},{"time":"04-16","value":"373319"},{"time":"04-17","value":"389732"},{"time":"04-18","value":"404287"},{"time":"04-19","value":"403890"},{"time":"04-20","value":"409372"},{"time":"04-21","value":"371281"},{"time":"04-22","value":"389504"},{"time":"04-23","value":"425405"},{"time":"04-24","value":"361846"},{"time":"04-25","value":"356874"},{"time":"04-26","value":"186023"},{"time":"04-27","value":"184888"},{"time":"04-28","value":"179395"},{"time":"04-29","value":"168901"},{"time":"04-30","value":"189624"},{"time":"05-01","value":"198061"},{"time":"05-02","value":"204643"},{"time":"05-03","value":"236658"},{"time":"05-04","value":"232617"},{"time":"05-05","value":"231567"},{"time":"05-06","value":"227291"},{"time":"05-07","value":"230702"},{"time":"05-08","value":"235052"},{"time":"05-09","value":"237393"},{"time":"05-10","value":"257868"},{"time":"05-11","value":"382964"},{"time":"05-12","value":"403447"},{"time":"05-13","value":"497840"},{"time":"05-14","value":"537140"},{"time":"05-15","value":"562769"},{"time":"05-16","value":"610191"},{"time":"05-17","value":"537685"},{"time":"05-18","value":"529414"},{"time":"05-19","value":"613264"},{"time":"05-20","value":"581284"},{"time":"05-21","value":"573386"},{"time":"05-22","value":"579299"},{"time":"05-23","value":"533048"},{"time":"05-24","value":"613833"},{"time":"05-25","value":"610261"},{"time":"05-26","value":"590860"},{"time":"05-27","value":"754747"},{"time":"05-28","value":"702091"},{"time":"05-29","value":"695935"},{"time":"05-30","value":"711575"},{"time":"05-31","value":"704828"},{"time":"06-01","value":"673723"},{"time":"06-02","value":"671391"},{"time":"06-03","value":"663124"},{"time":"06-04","value":"667043"},{"time":"06-05","value":"650764"},{"time":"06-06","value":"649042"},{"time":"06-07","value":"681547"},{"time":"06-08","value":"680352"},{"time":"06-09","value":"674523"},{"time":"06-10","value":"706792"},{"time":"06-11","value":"701104"},{"time":"06-12","value":"741857"},{"time":"06-13","value":"731433"},{"time":"06-14","value":"725813"},{"time":"06-15","value":"743312"},{"time":"06-16","value":"776878"},{"time":"06-17","value":"777200"},{"time":"06-18","value":"750067"},{"time":"06-19","value":"753977"},{"time":"06-20","value":"751762"},{"time":"06-21","value":"805986"},{"time":"06-22","value":"892594"},{"time":"06-23","value":"909642"},{"time":"06-24","value":"900310"},{"time":"06-25","value":"940739"},{"time":"06-26","value":"1098884"},{"time":"06-27","value":"1118276"},{"time":"06-28","value":"1181684"},{"time":"06-29","value":"1186174"},{"time":"06-30","value":"1188570"},{"time":"07-01","value":"1183988"},{"time":"07-02","value":"1267534"},{"time":"07-03","value":"1347721"},{"time":"07-04","value":"1374350"},{"time":"07-05","value":"1345618"},{"time":"07-06","value":"1358949"},{"time":"07-07","value":"1351333"},{"time":"07-08","value":"1408052"},{"time":"07-09","value":"1438692"},{"time":"07-10","value":"1404718"},{"time":"07-11","value":"1409067"},{"time":"07-12","value":"1421474"},{"time":"07-13","value":"1436772"},{"time":"07-14","value":"1432127"},{"time":"07-15","value":"1478250"},{"time":"07-16","value":"1459479"},{"time":"07-17","value":"1576072"},{"time":"07-18","value":"1778995"},{"time":"07-19","value":"1741321"},{"time":"07-20","value":"1758227"},{"time":"07-21","value":"1735442"},{"time":"07-22","value":"1737595"}],"unit":"$","max":"1778995","min":"-10518"}]
         * colors : {"profit":2,"profit_ratio":2,"week_profit":2,"week_profit_ratio":2}
         * chart_list : [{"title":"收益率走势","url":"http://chart.heyuedi.com/chart/profit/okex/fvs_2019072212.png"}]
         */

        public String exchange;
        public String balance;
        public String profit;
        public String profit_ratio;
        public String week_profit;
        public String week_profit_ratio;
        public String victory_ratio;
        public String live_duration;
        public String trading_frequency;
        public ColorsBean colors;
        public List<DistributionBean> distribution;
        public List<ProfitHistoryBean> profit_history;
        public List<ChartListBean> chart_list;

        public static class ColorsBean {
            /**
             * profit : 2
             * profit_ratio : 2
             * week_profit : 2
             * week_profit_ratio : 2
             */

            public int profit;
            public int profit_ratio;
            public int week_profit;
            public int week_profit_ratio;
        }

        public static class DistributionBean {
            /**
             * coin : btc
             * amount : 19.74481445
             * worth : 209920
             * ratio : 0.4855
             * color : #7E78FF
             */

            public String coin;
            public String amount;
            public String worth;
            public String ratio;
            public String color;

            public String getAmountStr() {
                if(TextUtils.equals(amount,"-")){
                    return amount;
                }
                try {
                    if (TextUtils.isEmpty(amount) || Float.valueOf(amount) == 0f)
                        return "0";

                    float value = Float.valueOf(amount);
                    return formatDouble(value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "";
            }

            public static String formatDouble(double d) {
                BigDecimal bg = new BigDecimal(d).setScale(2, RoundingMode.FLOOR);
                double num = bg.doubleValue();
                if (Math.round(num) - num == 0) {
                    return String.valueOf((long) num);
                }
                return String.valueOf(num);
            }
        }

        public static class ProfitHistoryBean {
            /**
             * title : 收益率
             * data : [{"time":"03-22","value":"-0.28"},{"time":"03-23","value":"4.11"},{"time":"03-24","value":"1.38"},{"time":"03-25","value":"-2.48"},{"time":"03-26","value":"-5.53"},{"time":"03-27","value":"18.56"},{"time":"03-28","value":"12.32"},{"time":"03-29","value":"12.29"},{"time":"03-30","value":"5.95"},{"time":"03-31","value":"5.82"},{"time":"04-01","value":"6.14"},{"time":"04-02","value":"89.42"},{"time":"04-03","value":"190.34"},{"time":"04-04","value":"190.15"},{"time":"04-05","value":"189.88"},{"time":"04-06","value":"197.68"},{"time":"04-07","value":"203.12"},{"time":"04-08","value":"209.19"},{"time":"04-09","value":"204.89"},{"time":"04-10","value":"216.63"},{"time":"04-11","value":"174.15"},{"time":"04-12","value":"178.94"},{"time":"04-13","value":"178.31"},{"time":"04-14","value":"173.93"},{"time":"04-15","value":"181.92"},{"time":"04-16","value":"177.42"},{"time":"04-17","value":"185.22"},{"time":"04-18","value":"192.14"},{"time":"04-19","value":"191.95"},{"time":"04-20","value":"194.55"},{"time":"04-21","value":"176.45"},{"time":"04-22","value":"185.11"},{"time":"04-23","value":"202.17"},{"time":"04-24","value":"171.97"},{"time":"04-25","value":"169.60"},{"time":"04-26","value":"88.40"},{"time":"04-27","value":"87.87"},{"time":"04-28","value":"85.25"},{"time":"04-29","value":"80.27"},{"time":"04-30","value":"90.12"},{"time":"05-01","value":"94.13"},{"time":"05-02","value":"97.25"},{"time":"05-03","value":"112.47"},{"time":"05-04","value":"110.55"},{"time":"05-05","value":"110.05"},{"time":"05-06","value":"108.02"},{"time":"05-07","value":"109.64"},{"time":"05-08","value":"111.71"},{"time":"05-09","value":"112.82"},{"time":"05-10","value":"122.55"},{"time":"05-11","value":"182.00"},{"time":"05-12","value":"191.74"},{"time":"05-13","value":"236.60"},{"time":"05-14","value":"255.28"},{"time":"05-15","value":"267.46"},{"time":"05-16","value":"290.00"},{"time":"05-17","value":"255.54"},{"time":"05-18","value":"251.61"},{"time":"05-19","value":"291.46"},{"time":"05-20","value":"276.26"},{"time":"05-21","value":"272.50"},{"time":"05-22","value":"275.31"},{"time":"05-23","value":"253.33"},{"time":"05-24","value":"291.73"},{"time":"05-25","value":"290.03"},{"time":"05-26","value":"280.81"},{"time":"05-27","value":"358.70"},{"time":"05-28","value":"333.67"},{"time":"05-29","value":"330.75"},{"time":"05-30","value":"338.18"},{"time":"05-31","value":"334.97"},{"time":"06-01","value":"320.19"},{"time":"06-02","value":"319.08"},{"time":"06-03","value":"315.15"},{"time":"06-04","value":"317.02"},{"time":"06-05","value":"309.28"},{"time":"06-06","value":"308.46"},{"time":"06-07","value":"323.91"},{"time":"06-08","value":"323.34"},{"time":"06-09","value":"320.57"},{"time":"06-10","value":"335.91"},{"time":"06-11","value":"333.20"},{"time":"06-12","value":"352.57"},{"time":"06-13","value":"347.62"},{"time":"06-14","value":"344.95"},{"time":"06-15","value":"353.26"},{"time":"06-16","value":"369.22"},{"time":"06-17","value":"369.37"},{"time":"06-18","value":"356.47"},{"time":"06-19","value":"358.33"},{"time":"06-20","value":"357.28"},{"time":"06-21","value":"383.05"},{"time":"06-22","value":"424.21"},{"time":"06-23","value":"432.31"},{"time":"06-24","value":"427.88"},{"time":"06-25","value":"447.09"},{"time":"06-26","value":"522.25"},{"time":"06-27","value":"531.47"},{"time":"06-28","value":"561.61"},{"time":"06-29","value":"563.74"},{"time":"06-30","value":"564.88"},{"time":"07-01","value":"562.70"},{"time":"07-02","value":"602.41"},{"time":"07-03","value":"640.52"},{"time":"07-04","value":"653.17"},{"time":"07-05","value":"639.52"},{"time":"07-06","value":"645.85"},{"time":"07-07","value":"642.23"},{"time":"07-08","value":"669.19"},{"time":"07-09","value":"683.75"},{"time":"07-10","value":"667.60"},{"time":"07-11","value":"669.67"},{"time":"07-12","value":"675.57"},{"time":"07-13","value":"682.84"},{"time":"07-14","value":"680.63"},{"time":"07-15","value":"702.55"},{"time":"07-16","value":"693.63"},{"time":"07-17","value":"749.04"},{"time":"07-18","value":"845.48"},{"time":"07-19","value":"827.58"},{"time":"07-20","value":"835.61"},{"time":"07-21","value":"824.79"},{"time":"07-22","value":"825.81"}]
             * unit : %
             * max : 845.48
             * min : -5.53
             */

            public String title;
            public String unit;
            public String max;
            public String min;
            public List<DataBean> data;

            public static class DataBean {
                /**
                 * time : 03-22
                 * value : -0.28
                 */

                public String time;
                public String value;
            }
        }

        public static class ChartListBean {
            /**
             * title : 收益率走势
             * url : http://chart.heyuedi.com/chart/profit/okex/fvs_2019072212.png
             */

            public String title;
            public String url;
        }
    }
}
