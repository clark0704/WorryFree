package com.hwm.unicom;

import android.support.annotation.Nullable;

import java.security.MessageDigest;

/**
 * 作者：Administrator on 2016/11/24 14:22
 * <p>
 * 功能：联通接口参数
 * 2 文字描述信息
 1.1 产品详细说明
 1) 订购、使用业务以本机实际使用号码为准；
 2) 订购成功后，产品功能费包含使用***客户端（浏览器）观看视频流量及内容费用；浏览
 视频页面消耗流量仍按照用户套餐资费计算；
 3) 请使用 3GNET 接入点访问本产品，使用其他接入点（包括 3GWAP）观看视频会照常收取
 流量费用。2G 用户无法使用此产品；
 4) 请在 WIFI 功能关闭下使用本视频业务，避免 WIFI 和 2G/3G 无线网络频繁切换而产生高
 额流量费；
 5) 订购成功后，仅在观看“***联通版”内的视频内容免流量。其他网站及客户端、微博中
 的视频内容仍按照用户套餐资费计费；
 6) 本产品所提供的视频定向流量为省内流量，在省外或国外使用本产品会照常收取流量费
 用。为避免因漫游而产生的高额流量费，我们建议您不要在漫游状态下使用本产品；<br/>
 7) 用户订购产品后，视频流量计入 6G 流量封顶信控策略，超过 6G 之后会自动关闭数据功
 能，下月自动开通；
 8) 订购产品立即生效，退订产品次月生效；

 1.2 未订购用户
 中国联通为联通 3G 用户提供“***联通版”视频包月服务，每月仅收取 15 元即可观看“***
 视频”的全部内容（含视频流量及内容的费用）。订购用户可访问：*******（产品地址），
 观看视频免流量费用。详情咨询：10010

 1.3 订购成功
 尊敬的联通 3G 用户，感谢您订购“***联通版”产品。***视频大餐马上为您呈上（此句可
 根据合作伙伴不同业务需求自行编写）。

 1.4 已订购用户
 您正在享受中国联通为联通 3G 用户提供的“***联通版”视频包月服务

 1.5 退订成功
 尊敬的联通 3G 用户，您已成功退订“***联通版”产品。

 1.6 退订未失效用户
 您正在享受中国联通为联通 3G 用户提供的“***联通版”视频包月服务，您的套餐已经退
 订，本月仍可享受服务。
 */

public class ChinaUnicomUtils {

    //参数配置
    public static final String CPID = "huashu";
    public static final String PASSWORD = "ed9d4e4d";
    public static final String SPID = "977";

    //播放参数配置
    public static final String PLAY_SPID = "22141";
    public static final String PLAY_PID = "8031006300";
    public static final String PLAY_PORTALID = "500";
    public static final String PLAY_KEY = "gd6716bf12wf0ddc6s8ad0efde6g2sdd";


    private static String netUrl = "http://114.255.201.228:86/videoif/netNumber.do";
    private static String v_code_url = "http://114.255.201.228:86/videoif/sendSmsCode.do?";
//    cpid=huashu&timestamp=xxx&response=xxx&apptype=2";


    public static String getNetUrl(){
        String timestamp = String.valueOf(System.currentTimeMillis()/1000);
        String response = MD5(CPID +timestamp+PASSWORD);

        StringBuilder builder = new StringBuilder();
        builder.append(netUrl)
                .append("?cpid=")
                .append(CPID)
                .append("&timestamp=")
                .append(timestamp)
                .append("&response=")
                .append(response)
                .append("&apptype=2");


        return builder.toString();

    }

    public static String getV_code_url(String userId) {
        StringBuilder builder = new StringBuilder();
        builder.append(netUrl)
                .append("?cpid=")
                .append(CPID)
                .append("&useid=")
                .append(userId)
                .append("&apptype=2");
        return builder.toString();
    }

    @Nullable
    public static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
