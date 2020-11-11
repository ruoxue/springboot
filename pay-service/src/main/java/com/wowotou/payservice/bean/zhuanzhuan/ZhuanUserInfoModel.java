package com.wowotou.payservice.bean.zhuanzhuan;

import java.io.Serializable;
import java.util.List;

public class ZhuanUserInfoModel implements Serializable {

    /**
     * respData : {"gender":"1","userVideo":{"videoCount":"0","postIconTag":"shortVideoType2PostButton","postIconUrl":"http://pic1.zhuanstatic.com/zhuanzh/n_v2346c7066271c4aeea54c584450f8e7be.png","postIconJumpUrl":"zhuanzhuan://jump/shortVideo/tencentRecord/jump?videoType=2&showIntroduceGuide=1&fromSource=myselfPage"},"hasZhuanVideoTab":"0","userLabelArr":[],"userLabels":[],"friendsAmount":"0","soundSwitch":"0","score":"70","badcount":"0","zhimaUrl":"https://m.zhuanzhuan.com/Mzhuanzhuan/zzapppages/zhima/Offline.html?webview=zzn","friendTag":"","addressDetail":{"uid":"278364661835974784","areaId":"81","province":"浙江省","city":"杭州市 西湖区","name":"李小","mobile":"156****1691","id":"1195974866307776524","detail":"益乐新村区","cityId":"79","mailCode":"310000","timestamp":"1573977602000"},"pageType":"1","smallScore":"1","labelPosition":{"dialogIdLabels":["1022781636594368519"],"dialogLabels":[{"id":"1022781636594368519","jumpUrl":"https://m.zhuanzhuan.com/Mzhuanzhuan/ZZAppSupport/#/realpersonauth/state?verified=1&isme=1&from=selfmain_page"}],"userIdLabels":["1026362138941194271"]},"userBabyGender":"0","nickname":"陌上轻尘0ihun29q","userDataIntegrity":"60","residence":"","notifySwitch":"0","backgroundPic":"http://pic1.zhuanstatic.com/zhuanzh/n_v2d959877c8e934ae0935b00b509d19e29.png","realAuthInfos":[],"userIntroduction":"男生，加入转转2天。","fansNum":"0","zhima":"0","mobile":"156****1691","wechat":"陌上轻尘","isShowFocusButton":"0","portrait":"http://thirdwx.qlogo.cn/mmopen/vi_32/BjtFxicUrfHfCyIjokyibAwfftD5cBmbrMbhxpPnHicFhtv58VY60ickibyLfAetkWJwic60K4CZEyK0ArIkCCB8dgYg/132","miniAppShare":{"path":"pages/webview/bridge?url=subPages%2Fprofile%2Fhomepage%2Fhomepage%3Fuid%3D278364661835974784%26channel%3DAPPSharetoFriends%26isShowBackApp%3D1%26returnURL%3Dzhuanzhuan%253A%252F%252Fjump%252Fcore%252FpersonHome%252Fjump%253Fuid%253D278364661835974784%2526cateId%253D0%2526tab%253Dinfos","sharePic":"http://thirdwx.qlogo.cn/mmopen/vi_32/BjtFxicUrfHfCyIjokyibAwfftD5cBmbrMbhxpPnHicFhtv58VY60ickibyLfAetkWJwic60K4CZEyK0ArIkCCB8dgYg/132","appId":"gh_c2980df66965","title":"我在转转上发现一枚闲置达人，快来围观~"},"labels":[],"userBabyStatus":"1","focusNum":"0","tradeCount":"0","isAuthenticationUser":"0","zhimaScore":"-1","userActiveInfo":"当前在线","goodcount":"0","days":"2","verifyLabels":[],"tabShowInfos":[{"id":"homepageMyGoods","title":"宝贝"},{"id":"homepageMyMoments","title":"动态"}],"directNotifySwitch":"0","shareUrl":"https://m.zhuanzhuan.com/platform/zzmshare/index.html?isReplaced=1#/personal/278364661835974784?isReplaced=1","borderPic":"https://pic1.zhuanstatic.com/zhuanzh/n_v22fd236e511a74e1f84749b8ccc026f96.png","userType":"1","largeScore":"3","infocount":"0"}
     * respCode : 0
     */
    private RespDataEntity respData;
    private String respCode;

    public void setRespData(RespDataEntity respData) {
        this.respData = respData;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public RespDataEntity getRespData() {
        return respData;
    }

    public String getRespCode() {
        return respCode;
    }

    public class RespDataEntity {
        /**
         * gender : 1
         * userVideo : {"videoCount":"0","postIconTag":"shortVideoType2PostButton","postIconUrl":"http://pic1.zhuanstatic.com/zhuanzh/n_v2346c7066271c4aeea54c584450f8e7be.png","postIconJumpUrl":"zhuanzhuan://jump/shortVideo/tencentRecord/jump?videoType=2&showIntroduceGuide=1&fromSource=myselfPage"}
         * hasZhuanVideoTab : 0
         * userLabelArr : []
         * userLabels : []
         * friendsAmount : 0
         * soundSwitch : 0
         * score : 70
         * badcount : 0
         * zhimaUrl : https://m.zhuanzhuan.com/Mzhuanzhuan/zzapppages/zhima/Offline.html?webview=zzn
         * friendTag :
         * addressDetail : {"uid":"278364661835974784","areaId":"81","province":"浙江省","city":"杭州市 西湖区","name":"李小","mobile":"156****1691","id":"1195974866307776524","detail":"益乐新村区","cityId":"79","mailCode":"310000","timestamp":"1573977602000"}
         * pageType : 1
         * smallScore : 1
         * labelPosition : {"dialogIdLabels":["1022781636594368519"],"dialogLabels":[{"id":"1022781636594368519","jumpUrl":"https://m.zhuanzhuan.com/Mzhuanzhuan/ZZAppSupport/#/realpersonauth/state?verified=1&isme=1&from=selfmain_page"}],"userIdLabels":["1026362138941194271"]}
         * userBabyGender : 0
         * nickname : 陌上轻尘0ihun29q
         * userDataIntegrity : 60
         * residence :
         * notifySwitch : 0
         * backgroundPic : http://pic1.zhuanstatic.com/zhuanzh/n_v2d959877c8e934ae0935b00b509d19e29.png
         * realAuthInfos : []
         * userIntroduction : 男生，加入转转2天。
         * fansNum : 0
         * zhima : 0
         * mobile : 156****1691
         * wechat : 陌上轻尘
         * isShowFocusButton : 0
         * portrait : http://thirdwx.qlogo.cn/mmopen/vi_32/BjtFxicUrfHfCyIjokyibAwfftD5cBmbrMbhxpPnHicFhtv58VY60ickibyLfAetkWJwic60K4CZEyK0ArIkCCB8dgYg/132
         * miniAppShare : {"path":"pages/webview/bridge?url=subPages%2Fprofile%2Fhomepage%2Fhomepage%3Fuid%3D278364661835974784%26channel%3DAPPSharetoFriends%26isShowBackApp%3D1%26returnURL%3Dzhuanzhuan%253A%252F%252Fjump%252Fcore%252FpersonHome%252Fjump%253Fuid%253D278364661835974784%2526cateId%253D0%2526tab%253Dinfos","sharePic":"http://thirdwx.qlogo.cn/mmopen/vi_32/BjtFxicUrfHfCyIjokyibAwfftD5cBmbrMbhxpPnHicFhtv58VY60ickibyLfAetkWJwic60K4CZEyK0ArIkCCB8dgYg/132","appId":"gh_c2980df66965","title":"我在转转上发现一枚闲置达人，快来围观~"}
         * labels : []
         * userBabyStatus : 1
         * focusNum : 0
         * tradeCount : 0
         * isAuthenticationUser : 0
         * zhimaScore : -1
         * userActiveInfo : 当前在线
         * goodcount : 0
         * days : 2
         * verifyLabels : []
         * tabShowInfos : [{"id":"homepageMyGoods","title":"宝贝"},{"id":"homepageMyMoments","title":"动态"}]
         * directNotifySwitch : 0
         * shareUrl : https://m.zhuanzhuan.com/platform/zzmshare/index.html?isReplaced=1#/personal/278364661835974784?isReplaced=1
         * borderPic : https://pic1.zhuanstatic.com/zhuanzh/n_v22fd236e511a74e1f84749b8ccc026f96.png
         * userType : 1
         * largeScore : 3
         * infocount : 0
         */
        private String gender;
        private UserVideoEntity userVideo;
        private String hasZhuanVideoTab;
        private List<?> userLabelArr;
        private List<?> userLabels;
        private String friendsAmount;
        private String soundSwitch;
        private String score;
        private String badcount;
        private String zhimaUrl;
        private String friendTag;
        private AddressDetailEntity addressDetail;
        private String pageType;
        private String smallScore;
        private LabelPositionEntity labelPosition;
        private String userBabyGender;
        private String nickname;
        private String userDataIntegrity;
        private String residence;
        private String notifySwitch;
        private String backgroundPic;
        private List<?> realAuthInfos;
        private String userIntroduction;
        private String fansNum;
        private String zhima;
        private String mobile;
        private String wechat;
        private String isShowFocusButton;
        private String portrait;
        private MiniAppShareEntity miniAppShare;
        private List<?> labels;
        private String userBabyStatus;
        private String focusNum;
        private String tradeCount;
        private String isAuthenticationUser;
        private String zhimaScore;
        private String userActiveInfo;
        private String goodcount;
        private String days;
        private List<?> verifyLabels;
        private List<TabShowInfosEntity> tabShowInfos;
        private String directNotifySwitch;
        private String shareUrl;
        private String borderPic;
        private String userType;
        private String largeScore;
        private String infocount;

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setUserVideo(UserVideoEntity userVideo) {
            this.userVideo = userVideo;
        }

        public void setHasZhuanVideoTab(String hasZhuanVideoTab) {
            this.hasZhuanVideoTab = hasZhuanVideoTab;
        }

        public void setUserLabelArr(List<?> userLabelArr) {
            this.userLabelArr = userLabelArr;
        }

        public void setUserLabels(List<?> userLabels) {
            this.userLabels = userLabels;
        }

        public void setFriendsAmount(String friendsAmount) {
            this.friendsAmount = friendsAmount;
        }

        public void setSoundSwitch(String soundSwitch) {
            this.soundSwitch = soundSwitch;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public void setBadcount(String badcount) {
            this.badcount = badcount;
        }

        public void setZhimaUrl(String zhimaUrl) {
            this.zhimaUrl = zhimaUrl;
        }

        public void setFriendTag(String friendTag) {
            this.friendTag = friendTag;
        }

        public void setAddressDetail(AddressDetailEntity addressDetail) {
            this.addressDetail = addressDetail;
        }

        public void setPageType(String pageType) {
            this.pageType = pageType;
        }

        public void setSmallScore(String smallScore) {
            this.smallScore = smallScore;
        }

        public void setLabelPosition(LabelPositionEntity labelPosition) {
            this.labelPosition = labelPosition;
        }

        public void setUserBabyGender(String userBabyGender) {
            this.userBabyGender = userBabyGender;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setUserDataIntegrity(String userDataIntegrity) {
            this.userDataIntegrity = userDataIntegrity;
        }

        public void setResidence(String residence) {
            this.residence = residence;
        }

        public void setNotifySwitch(String notifySwitch) {
            this.notifySwitch = notifySwitch;
        }

        public void setBackgroundPic(String backgroundPic) {
            this.backgroundPic = backgroundPic;
        }

        public void setRealAuthInfos(List<?> realAuthInfos) {
            this.realAuthInfos = realAuthInfos;
        }

        public void setUserIntroduction(String userIntroduction) {
            this.userIntroduction = userIntroduction;
        }

        public void setFansNum(String fansNum) {
            this.fansNum = fansNum;
        }

        public void setZhima(String zhima) {
            this.zhima = zhima;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
        }

        public void setIsShowFocusButton(String isShowFocusButton) {
            this.isShowFocusButton = isShowFocusButton;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public void setMiniAppShare(MiniAppShareEntity miniAppShare) {
            this.miniAppShare = miniAppShare;
        }

        public void setLabels(List<?> labels) {
            this.labels = labels;
        }

        public void setUserBabyStatus(String userBabyStatus) {
            this.userBabyStatus = userBabyStatus;
        }

        public void setFocusNum(String focusNum) {
            this.focusNum = focusNum;
        }

        public void setTradeCount(String tradeCount) {
            this.tradeCount = tradeCount;
        }

        public void setIsAuthenticationUser(String isAuthenticationUser) {
            this.isAuthenticationUser = isAuthenticationUser;
        }

        public void setZhimaScore(String zhimaScore) {
            this.zhimaScore = zhimaScore;
        }

        public void setUserActiveInfo(String userActiveInfo) {
            this.userActiveInfo = userActiveInfo;
        }

        public void setGoodcount(String goodcount) {
            this.goodcount = goodcount;
        }

        public void setDays(String days) {
            this.days = days;
        }

        public void setVerifyLabels(List<?> verifyLabels) {
            this.verifyLabels = verifyLabels;
        }

        public void setTabShowInfos(List<TabShowInfosEntity> tabShowInfos) {
            this.tabShowInfos = tabShowInfos;
        }

        public void setDirectNotifySwitch(String directNotifySwitch) {
            this.directNotifySwitch = directNotifySwitch;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public void setBorderPic(String borderPic) {
            this.borderPic = borderPic;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public void setLargeScore(String largeScore) {
            this.largeScore = largeScore;
        }

        public void setInfocount(String infocount) {
            this.infocount = infocount;
        }

        public String getGender() {
            return gender;
        }

        public UserVideoEntity getUserVideo() {
            return userVideo;
        }

        public String getHasZhuanVideoTab() {
            return hasZhuanVideoTab;
        }

        public List<?> getUserLabelArr() {
            return userLabelArr;
        }

        public List<?> getUserLabels() {
            return userLabels;
        }

        public String getFriendsAmount() {
            return friendsAmount;
        }

        public String getSoundSwitch() {
            return soundSwitch;
        }

        public String getScore() {
            return score;
        }

        public String getBadcount() {
            return badcount;
        }

        public String getZhimaUrl() {
            return zhimaUrl;
        }

        public String getFriendTag() {
            return friendTag;
        }

        public AddressDetailEntity getAddressDetail() {
            return addressDetail;
        }

        public String getPageType() {
            return pageType;
        }

        public String getSmallScore() {
            return smallScore;
        }

        public LabelPositionEntity getLabelPosition() {
            return labelPosition;
        }

        public String getUserBabyGender() {
            return userBabyGender;
        }

        public String getNickname() {
            return nickname;
        }

        public String getUserDataIntegrity() {
            return userDataIntegrity;
        }

        public String getResidence() {
            return residence;
        }

        public String getNotifySwitch() {
            return notifySwitch;
        }

        public String getBackgroundPic() {
            return backgroundPic;
        }

        public List<?> getRealAuthInfos() {
            return realAuthInfos;
        }

        public String getUserIntroduction() {
            return userIntroduction;
        }

        public String getFansNum() {
            return fansNum;
        }

        public String getZhima() {
            return zhima;
        }

        public String getMobile() {
            return mobile;
        }

        public String getWechat() {
            return wechat;
        }

        public String getIsShowFocusButton() {
            return isShowFocusButton;
        }

        public String getPortrait() {
            return portrait;
        }

        public MiniAppShareEntity getMiniAppShare() {
            return miniAppShare;
        }

        public List<?> getLabels() {
            return labels;
        }

        public String getUserBabyStatus() {
            return userBabyStatus;
        }

        public String getFocusNum() {
            return focusNum;
        }

        public String getTradeCount() {
            return tradeCount;
        }

        public String getIsAuthenticationUser() {
            return isAuthenticationUser;
        }

        public String getZhimaScore() {
            return zhimaScore;
        }

        public String getUserActiveInfo() {
            return userActiveInfo;
        }

        public String getGoodcount() {
            return goodcount;
        }

        public String getDays() {
            return days;
        }

        public List<?> getVerifyLabels() {
            return verifyLabels;
        }

        public List<TabShowInfosEntity> getTabShowInfos() {
            return tabShowInfos;
        }

        public String getDirectNotifySwitch() {
            return directNotifySwitch;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public String getBorderPic() {
            return borderPic;
        }

        public String getUserType() {
            return userType;
        }

        public String getLargeScore() {
            return largeScore;
        }

        public String getInfocount() {
            return infocount;
        }

        public class UserVideoEntity {
            /**
             * videoCount : 0
             * postIconTag : shortVideoType2PostButton
             * postIconUrl : http://pic1.zhuanstatic.com/zhuanzh/n_v2346c7066271c4aeea54c584450f8e7be.png
             * postIconJumpUrl : zhuanzhuan://jump/shortVideo/tencentRecord/jump?videoType=2&showIntroduceGuide=1&fromSource=myselfPage
             */
            private String videoCount;
            private String postIconTag;
            private String postIconUrl;
            private String postIconJumpUrl;

            public void setVideoCount(String videoCount) {
                this.videoCount = videoCount;
            }

            public void setPostIconTag(String postIconTag) {
                this.postIconTag = postIconTag;
            }

            public void setPostIconUrl(String postIconUrl) {
                this.postIconUrl = postIconUrl;
            }

            public void setPostIconJumpUrl(String postIconJumpUrl) {
                this.postIconJumpUrl = postIconJumpUrl;
            }

            public String getVideoCount() {
                return videoCount;
            }

            public String getPostIconTag() {
                return postIconTag;
            }

            public String getPostIconUrl() {
                return postIconUrl;
            }

            public String getPostIconJumpUrl() {
                return postIconJumpUrl;
            }
        }

        public class AddressDetailEntity {
            /**
             * uid : 278364661835974784
             * areaId : 81
             * province : 浙江省
             * city : 杭州市 西湖区
             * name : 李小
             * mobile : 156****1691
             * id : 1195974866307776524
             * detail : 益乐新村区
             * cityId : 79
             * mailCode : 310000
             * timestamp : 1573977602000
             */
            private String uid;
            private String areaId;
            private String province;
            private String city;
            private String name;
            private String mobile;
            private String id;
            private String detail;
            private String cityId;
            private String mailCode;
            private String timestamp;

            public void setUid(String uid) {
                this.uid = uid;
            }

            public void setAreaId(String areaId) {
                this.areaId = areaId;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public void setMailCode(String mailCode) {
                this.mailCode = mailCode;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }

            public String getUid() {
                return uid;
            }

            public String getAreaId() {
                return areaId;
            }

            public String getProvince() {
                return province;
            }

            public String getCity() {
                return city;
            }

            public String getName() {
                return name;
            }

            public String getMobile() {
                return mobile;
            }

            public String getId() {
                return id;
            }

            public String getDetail() {
                return detail;
            }

            public String getCityId() {
                return cityId;
            }

            public String getMailCode() {
                return mailCode;
            }

            public String getTimestamp() {
                return timestamp;
            }
        }

        public class LabelPositionEntity {
            /**
             * dialogIdLabels : ["1022781636594368519"]
             * dialogLabels : [{"id":"1022781636594368519","jumpUrl":"https://m.zhuanzhuan.com/Mzhuanzhuan/ZZAppSupport/#/realpersonauth/state?verified=1&isme=1&from=selfmain_page"}]
             * userIdLabels : ["1026362138941194271"]
             */
            private List<String> dialogIdLabels;
            private List<DialogLabelsEntity> dialogLabels;
            private List<String> userIdLabels;

            public void setDialogIdLabels(List<String> dialogIdLabels) {
                this.dialogIdLabels = dialogIdLabels;
            }

            public void setDialogLabels(List<DialogLabelsEntity> dialogLabels) {
                this.dialogLabels = dialogLabels;
            }

            public void setUserIdLabels(List<String> userIdLabels) {
                this.userIdLabels = userIdLabels;
            }

            public List<String> getDialogIdLabels() {
                return dialogIdLabels;
            }

            public List<DialogLabelsEntity> getDialogLabels() {
                return dialogLabels;
            }

            public List<String> getUserIdLabels() {
                return userIdLabels;
            }

            public class DialogLabelsEntity {
                /**
                 * id : 1022781636594368519
                 * jumpUrl : https://m.zhuanzhuan.com/Mzhuanzhuan/ZZAppSupport/#/realpersonauth/state?verified=1&isme=1&from=selfmain_page
                 */
                private String id;
                private String jumpUrl;

                public void setId(String id) {
                    this.id = id;
                }

                public void setJumpUrl(String jumpUrl) {
                    this.jumpUrl = jumpUrl;
                }

                public String getId() {
                    return id;
                }

                public String getJumpUrl() {
                    return jumpUrl;
                }
            }
        }

        public class MiniAppShareEntity {
            /**
             * path : pages/webview/bridge?url=subPages%2Fprofile%2Fhomepage%2Fhomepage%3Fuid%3D278364661835974784%26channel%3DAPPSharetoFriends%26isShowBackApp%3D1%26returnURL%3Dzhuanzhuan%253A%252F%252Fjump%252Fcore%252FpersonHome%252Fjump%253Fuid%253D278364661835974784%2526cateId%253D0%2526tab%253Dinfos
             * sharePic : http://thirdwx.qlogo.cn/mmopen/vi_32/BjtFxicUrfHfCyIjokyibAwfftD5cBmbrMbhxpPnHicFhtv58VY60ickibyLfAetkWJwic60K4CZEyK0ArIkCCB8dgYg/132
             * appId : gh_c2980df66965
             * title : 我在转转上发现一枚闲置达人，快来围观~
             */
            private String path;
            private String sharePic;
            private String appId;
            private String title;

            public void setPath(String path) {
                this.path = path;
            }

            public void setSharePic(String sharePic) {
                this.sharePic = sharePic;
            }

            public void setAppId(String appId) {
                this.appId = appId;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPath() {
                return path;
            }

            public String getSharePic() {
                return sharePic;
            }

            public String getAppId() {
                return appId;
            }

            public String getTitle() {
                return title;
            }
        }

        public class TabShowInfosEntity {
            /**
             * id : homepageMyGoods
             * title : 宝贝
             */
            private String id;
            private String title;

            public void setId(String id) {
                this.id = id;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getId() {
                return id;
            }

            public String getTitle() {
                return title;
            }
        }
    }
}
