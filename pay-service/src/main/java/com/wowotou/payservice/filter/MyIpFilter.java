package com.wowotou.payservice.filter;//package com.mfypay.pay.filter;
//
//import com.mfypay.model.model.IpModel;
//import com.mfypay.model.model.IpRecordModel;
//import com.mfypay.pay.util.IpUtil;
//import com.mfypay.service.service.IpService;
//import com.mfypay.service.util.MapUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.annotation.Resource;
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;
//
//@WebFilter(urlPatterns = "/*")
//public class MyIpFilter implements Filter {
//
//    @Resource
//    IpService ipService;
//
//    private static final Logger logger = LoggerFactory.getLogger(MyIpFilter.class);
//
//    /**
//     * 默认限制时间（单位：ms）
//     */
//    private static final long LIMITED_TIME_MILLIS =   60*60 * 1000;
//
//    /**
//     * 用户连续访问最高阀值，超过该值则认定为恶意操作的IP，进行限制
//     */
//    private static final int LIMIT_NUMBER =   1;
//
//    /**
//     * 用户访问最小安全时间，在该时间内如果访问次数大于阀值，则记录为恶意IP，否则视为正常访问
//     */
//    private static final int MIN_SAFE_TIME = 10*1000;
//
//    private FilterConfig config;
//
//    @Override
//    public void init(FilterConfig filterConfig) {
//        System.out.println("111111");
//        this.config = filterConfig;    //设置属性filterConfig
//    }
//
//    /**
//     * (non-Javadoc)
//     *
//     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
//     */
//    @SuppressWarnings("unchecked")
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        ServletContext context = config.getServletContext();
//        Map<String, Long> limitedIpMap = (Map<String, Long>) context.getAttribute("limitedIpMap");
//        filterLimitedIpMap(limitedIpMap);
//        String ip = IpUtil.getIpAddress(request);// request.getRemoteHost();
//
//        IpModel ipModel = ipService.getIpByIp(ip);
//
//        Map<String, String> params = new HashMap();
//        try {
//
//            Map requestParams = request.getParameterMap();
//            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
//                String name = (String) iter.next();
//                String[] values = (String[]) requestParams.get(name);
//                String valueStr = "";
//                for (int i = 0; i < values.length; i++) {
//                    valueStr = (i == values.length - 1) ? valueStr + values[i]
//                            : valueStr + values[i] + ",";
//                }
//                params.put(name, valueStr);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        if (ipModel == null || ipModel.getStatus() >= 9) {
//            IpRecordModel ipRecordModel = new IpRecordModel();
//            ipRecordModel.setcTime(System.currentTimeMillis() / 1000);
//            ipRecordModel.setmTime(System.currentTimeMillis() / 1000);
//            ipRecordModel.setIp(ip);
//            ipRecordModel.setStatus(0);
//
//            if (params==null||params.size()==0){
//                params=new HashMap<>();
//                params.put("msg","空参数");
//            }
//            if (ipModel != null && ipModel.getStatus() > 9) {
//                ipRecordModel.setUrl("黑名单：" +
//                        request.getRequestURL().append(MapUtil.getParamStr(params)));
//            } else {
//                ipRecordModel.setUrl(request.getRequestURL().append(MapUtil.getParamStr(params))
//                        .toString());
//            }
//
//
//            ipService.addIpRecord(ipRecordModel);
//
//           if (ipModel!=null){
//               response.getWriter().write(ipModel.getInfo());
//               response.sendRedirect(ipModel.getInfo());
//           }else {
//               response.getWriter().write("err");
//               response.sendRedirect("https://google.com");
//           }
//            return;
//        }
//
//
//
//
//        if (ipModel.getStatus() == 0) {
//            // 判断是否是被限制的IP，如果是则跳到异常页面
//            if (isLimitedIP(limitedIpMap, ip)) {
//                long limitedTime = limitedIpMap.get(ip) - System.currentTimeMillis();
//                request.setAttribute("remainingTime", ((limitedTime / 1000) + (limitedTime % 1000 > 0 ? 1 : 0)));
//                logger.error("IP访问过于频繁=>：" + ip);
//                request.getRequestDispatcher(ipModel.getInfo()).forward(request, response);
//                return;
//            }
//            // 获取IP存储器
//            Map<String, Long[]> ipMap = (Map<String, Long[]>) context.getAttribute("ipMap");
//            // 判断存储器中是否存在当前IP，如果没有则为初次访问，初始化该ip
//            // 如果存在当前ip，则验证当前ip的访问次数
//            // 如果大于限制阀值，判断达到阀值的时间，如果不大于[用户访问最小安全时间]则视为恶意访问，跳转到异常页面
//            if (ipMap.containsKey(ip)) {
//                Long[] ipInfo = ipMap.get(ip);
//                ipInfo[0] = ipInfo[0] + 1;
//                logger.info("当前IP第[" + (ipInfo[0]) + "]次访问");
//                if (ipInfo[0] > LIMIT_NUMBER) {
//                    Long ipAccessTime = ipInfo[1];
//                    Long currentTimeMillis = System.currentTimeMillis();
//                    if (currentTimeMillis - ipAccessTime <= MIN_SAFE_TIME) {
//                        limitedIpMap.put(ip, currentTimeMillis + LIMITED_TIME_MILLIS);
//                        request.setAttribute("remainingTime", ((LIMITED_TIME_MILLIS / 1000) + (LIMITED_TIME_MILLIS % 1000 > 0 ? 1 : 0)));
//                        logger.error("IP访问过于频繁：" + ip);
//                        request.getRequestDispatcher(ipModel.getInfo()).forward(request, response);
//                        return;
//                    } else {
//                        initIpVisitsNumber(ipMap, ip);
//                    }
//                }
//            } else {
//                initIpVisitsNumber(ipMap, ip);
//                logger.info("首次访问该网站");
//            }
//            context.setAttribute("ipMap", ipMap);
//        }
//        System.out.println("ok");//172.31.17.211
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//        // TODO Auto-generated method stub
//    }
//
//    /**
//     * @param limitedIpMap
//     * @Description 过滤受限的IP，剔除已经到期的限制IP
//     */
//    private void filterLimitedIpMap(Map<String, Long> limitedIpMap) {
//        if (limitedIpMap == null) {
//            return;
//        }
//        Set<String> keys = limitedIpMap.keySet();
//        Iterator<String> keyIt = keys.iterator();
//        long currentTimeMillis = System.currentTimeMillis();
//        while (keyIt.hasNext()) {
//            long expireTimeMillis = limitedIpMap.get(keyIt.next());
//            if (expireTimeMillis <= currentTimeMillis) {
//                keyIt.remove();
//            }
//        }
//    }
//
//    /**
//     * @param limitedIpMap
//     * @param ip
//     * @return true : 被限制 | false : 正常
//     * @Description 是否是被限制的IP
//     */
//    private boolean isLimitedIP(Map<String, Long> limitedIpMap, String ip) {
//
//        if (limitedIpMap.containsKey(ip)) {
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 初始化用户访问次数和访问时间
//     *
//     * @param ipMap
//     * @param ip
//     */
//    private void initIpVisitsNumber(Map<String, Long[]> ipMap, String ip) {
//        Long[] ipInfo = new Long[2];
//        ipInfo[0] = 0L;// 访问次数
//        ipInfo[1] = System.currentTimeMillis();// 初次访问时间
//        ipMap.put(ip, ipInfo);
//    }
//}