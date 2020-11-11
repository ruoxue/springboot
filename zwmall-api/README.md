# zwmall-api

#### 掌沃商城后端 - 基于JDK14+JFinal4.9

#### 项目介绍
掌沃商城（zwmall）是精仿小米官网开发的前后端分离的PC商城

前台预览地址：[掌沃商城](https://zwmall.chengdongqing.top)

后台预览地址：[掌沃商城管理系统](https://admin.zwmall.chengdongqing.top)

在JFinal官网的分享地址：[掌沃商城](https://jfinal.com/share/2127)

在uni-app插件市场的分享地址：[掌沃商城](https://ext.dcloud.net.cn/plugin?id=1431)

#### 源码获取
后端接口：[zwmall-api](https://gitee.com/chengdongqing/zwmall-api)

前台前端：[zwmall-uni](https://gitee.com/chengdongqing/zwmall-uni)

后台前端：[zwmall-admin](https://gitee.com/chengdongqing/zwmall-admin)

#### 项目配置
- JDK版本：JDK 14

- 数据库：MySQL 8.0
- 核心框架：JFinal 4.9
- 项目构建工具：maven 3.6.3
- Web容器：jfinal-undertow 2.1
- Eclipse版本：Eclipse 2020-06

#### 技术亮点
- 微信和支付宝支付、关闭订单、订单退款及回调处理等，
包括参数封装、签名、验签、xml与map互转等，无需SDK

- 发送邮件及发送短信，发送短信无需SDK
- 基于JDK11的Http Client封装的HTTP工具类，包括发送GET、POST请求及微信退款需要的带本地证书的POST请求，读取HttpServletRequest字符流等
- 文件上传包括上传到阿里云OSS、服务器本地指定文件夹
- excel生成及字节流渲染器、文件流渲染器
- 缓存、拦截器、定时器、渲染器、文件上传、路由配置、SQL模板、事务、批量插入数据、跨域处理、实体类生成、参数校验、多态、继承、WebSocket、注解、集合流处理、文本块、switch箭头函数表达式等
- 接口访问限制，包括限制IP或指定账号在指定时间段只能请求某接口的次数，比如发送短信验证码限制某手机号一天只能发送5次，限制同一ip请求管理员登录接口1分钟不超过3次等
- 统一登录拦截、权限拦截，完善的权限管理
- 还有若干未提及的技术点

#### 项目历程
    本项目是我在疫情期间独立开发的商城项目，源自我在学校的毕业项目。毕业两年多，该项目经过不断优化和不同版本的重构开发，今天终于可以和大家见面了。本项目未经过企业级验证，欢迎大家给我反馈问题及提出建议。
    
    路遥  2020-06-01
    邮箱：1912525497@qq.com
    QQ群：550850198
    
![QQ群](https://images.gitee.com/uploads/images/2020/0701/152053_ac7e505c_1499515.jpeg)

#### 项目说明
    测试账号：19999999999
    密码：123456789

    管理系统账号同上，修改及删除数据将被限制。

    由于我没有商品闪购相关开发经验，所以闪购这块暂时是静态的。由于缺少微信支付、短信验证码的账号信息，故微信支付和短信验证码暂时无法预览，但相关功能均已通过测验。

    支付宝测试是在沙箱环境，需要用到支付宝沙箱版app，沙箱环境可能会不稳定。
    下载地址：https://sandbox.alipaydev.com/user/downloadApp.htm
    账号：ippgcu2572@sandbox.com    登录密码：111111    支付密码：111111
    可以扫描下方二维码下载支付宝沙箱版APP：
![支付宝沙箱版APP](https://images.gitee.com/uploads/images/2020/0701/162333_8848fa81_1499515.png "支付宝沙箱版APP")