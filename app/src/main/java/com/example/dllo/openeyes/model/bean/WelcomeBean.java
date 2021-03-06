package com.example.dllo.openeyes.model.bean;

import java.util.List;

/**
 * Created by mac on 16/8/24.
 * 欢迎页实体类
 * @author wangweijian
 */
public class WelcomeBean {

    private AutoCacheBean autoCache;

    private StartPageAdBean startPageAd;

    private StartPageBean startPage;

    private LogBean log;
    private IssueCoverBean issueCover;

    private ConsumptionBean consumption;

    private LaunchBean launch;

    private String version;


    private PushBean push;

    private AndroidPlayerBean androidPlayer;

    private FirstLaunchBean firstLaunch;

    private ShareTitleBean shareTitle;

    private CampaignInDetailBean campaignInDetail;

    private CampaignInFeedBean campaignInFeed;

    private ReplyBean reply;

    private PushInfoBean pushInfo;

    public AutoCacheBean getAutoCache() {
        return autoCache;
    }

    public void setAutoCache(AutoCacheBean autoCache) {
        this.autoCache = autoCache;
    }

    public StartPageAdBean getStartPageAd() {
        return startPageAd;
    }

    public void setStartPageAd(StartPageAdBean startPageAd) {
        this.startPageAd = startPageAd;
    }

    public StartPageBean getStartPage() {
        return startPage;
    }

    public void setStartPage(StartPageBean startPage) {
        this.startPage = startPage;
    }

    public LogBean getLog() {
        return log;
    }

    public void setLog(LogBean log) {
        this.log = log;
    }

    public IssueCoverBean getIssueCover() {
        return issueCover;
    }

    public void setIssueCover(IssueCoverBean issueCover) {
        this.issueCover = issueCover;
    }

    public ConsumptionBean getConsumption() {
        return consumption;
    }

    public void setConsumption(ConsumptionBean consumption) {
        this.consumption = consumption;
    }

    public LaunchBean getLaunch() {
        return launch;
    }

    public void setLaunch(LaunchBean launch) {
        this.launch = launch;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public PushBean getPush() {
        return push;
    }

    public void setPush(PushBean push) {
        this.push = push;
    }

    public AndroidPlayerBean getAndroidPlayer() {
        return androidPlayer;
    }

    public void setAndroidPlayer(AndroidPlayerBean androidPlayer) {
        this.androidPlayer = androidPlayer;
    }

    public FirstLaunchBean getFirstLaunch() {
        return firstLaunch;
    }

    public void setFirstLaunch(FirstLaunchBean firstLaunch) {
        this.firstLaunch = firstLaunch;
    }

    public ShareTitleBean getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(ShareTitleBean shareTitle) {
        this.shareTitle = shareTitle;
    }

    public CampaignInDetailBean getCampaignInDetail() {
        return campaignInDetail;
    }

    public void setCampaignInDetail(CampaignInDetailBean campaignInDetail) {
        this.campaignInDetail = campaignInDetail;
    }

    public CampaignInFeedBean getCampaignInFeed() {
        return campaignInFeed;
    }

    public void setCampaignInFeed(CampaignInFeedBean campaignInFeed) {
        this.campaignInFeed = campaignInFeed;
    }

    public ReplyBean getReply() {
        return reply;
    }

    public void setReply(ReplyBean reply) {
        this.reply = reply;
    }

    public PushInfoBean getPushInfo() {
        return pushInfo;
    }

    public void setPushInfo(PushInfoBean pushInfo) {
        this.pushInfo = pushInfo;
    }

    public static class AutoCacheBean {
        private boolean forceOff;
        private int videoNum;
        private String version;
        private int offset;

        public boolean isForceOff() {
            return forceOff;
        }

        public void setForceOff(boolean forceOff) {
            this.forceOff = forceOff;
        }

        public int getVideoNum() {
            return videoNum;
        }

        public void setVideoNum(int videoNum) {
            this.videoNum = videoNum;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }
    }

    public static class StartPageAdBean {
        private int displayTimeDuration;
        private String imageUrl;
        private boolean countdown;
        private String actionUrl;
        private String blurredImageUrl;
        private long startTime;
        private boolean canSkip;
        private long endTime;
        private String version;
        /**
         * organization : miaozhen
         * viewUrl : http://g.cn.miaozhen.com/x/k=2026264&p=71lid&dx=__IPDX__&rt=2&ns=__IP__&ni=__IESID__&v=__LOC__&xa=__ADPLATFORM__&mo=__OS__&m0=__OPENUDID__&m0a=__DUID__&m1=__ANDROIDID1__&m1a=__ANDROIDID__&m2=__IMEI__&m4=__AAID__&m5=__IDFA__&m6=__MAC1__&m6a=__MAC__&o=
         * clickUrl : http://e.cn.miaozhen.com/r/k=2026264&p=71lid&dx=__IPDX__&rt=2&ns=__IP__&ni=__IESID__&v=__LOC__&xa=__ADPLATFORM__&ro=sm&vo=376ac5837&vr=2&o=http://originals.adidasevents.com/nmd/fw16/mob
         */

        private List<AdTrackBean> adTrack;

        public int getDisplayTimeDuration() {
            return displayTimeDuration;
        }

        public void setDisplayTimeDuration(int displayTimeDuration) {
            this.displayTimeDuration = displayTimeDuration;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public boolean isCountdown() {
            return countdown;
        }

        public void setCountdown(boolean countdown) {
            this.countdown = countdown;
        }

        public String getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(String actionUrl) {
            this.actionUrl = actionUrl;
        }

        public String getBlurredImageUrl() {
            return blurredImageUrl;
        }

        public void setBlurredImageUrl(String blurredImageUrl) {
            this.blurredImageUrl = blurredImageUrl;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public boolean isCanSkip() {
            return canSkip;
        }

        public void setCanSkip(boolean canSkip) {
            this.canSkip = canSkip;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public List<AdTrackBean> getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(List<AdTrackBean> adTrack) {
            this.adTrack = adTrack;
        }

        public static class AdTrackBean {
            private String organization;
            private String viewUrl;
            private String clickUrl;

            public String getOrganization() {
                return organization;
            }

            public void setOrganization(String organization) {
                this.organization = organization;
            }

            public String getViewUrl() {
                return viewUrl;
            }

            public void setViewUrl(String viewUrl) {
                this.viewUrl = viewUrl;
            }

            public String getClickUrl() {
                return clickUrl;
            }

            public void setClickUrl(String clickUrl) {
                this.clickUrl = clickUrl;
            }
        }
    }

    public static class StartPageBean {
        private String imageUrl;
        private String actionUrl;
        private String version;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(String actionUrl) {
            this.actionUrl = actionUrl;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public static class LogBean {
        private boolean playLog;
        private String version;

        public boolean isPlayLog() {
            return playLog;
        }

        public void setPlayLog(boolean playLog) {
            this.playLog = playLog;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public static class IssueCoverBean {
        /**
         * weekendExtra : http://img.wdjimg.com/image/video/6ac75af6fd23b286eafdb3798072a15c_0_0.jpeg
         * adapter : false
         */

        private IssueLogoBean issueLogo;
        private String version;

        public IssueLogoBean getIssueLogo() {
            return issueLogo;
        }

        public void setIssueLogo(IssueLogoBean issueLogo) {
            this.issueLogo = issueLogo;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public static class IssueLogoBean {
            private String weekendExtra;
            private boolean adapter;

            public String getWeekendExtra() {
                return weekendExtra;
            }

            public void setWeekendExtra(String weekendExtra) {
                this.weekendExtra = weekendExtra;
            }

            public boolean isAdapter() {
                return adapter;
            }

            public void setAdapter(boolean adapter) {
                this.adapter = adapter;
            }
        }
    }

    public static class ConsumptionBean {
        private boolean display;
        private String version;

        public boolean isDisplay() {
            return display;
        }

        public void setDisplay(boolean display) {
            this.display = display;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public static class LaunchBean {
        private String version;
        private Object adTrack;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public Object getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(Object adTrack) {
            this.adTrack = adTrack;
        }
    }

    public static class PushBean {
        private int startTime;
        private int endTime;
        private String message;
        private String version;

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public static class AndroidPlayerBean {
        private String version;
        private List<String> playerList;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public List<String> getPlayerList() {
            return playerList;
        }

        public void setPlayerList(List<String> playerList) {
            this.playerList = playerList;
        }
    }

    public static class FirstLaunchBean {
        private boolean showFirstDetail;
        private String version;

        public boolean isShowFirstDetail() {
            return showFirstDetail;
        }

        public void setShowFirstDetail(boolean showFirstDetail) {
            this.showFirstDetail = showFirstDetail;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public static class ShareTitleBean {
        private String weibo;
        private String wechatMoments;
        private String qzone;
        private String version;

        public String getWeibo() {
            return weibo;
        }

        public void setWeibo(String weibo) {
            this.weibo = weibo;
        }

        public String getWechatMoments() {
            return wechatMoments;
        }

        public void setWechatMoments(String wechatMoments) {
            this.wechatMoments = wechatMoments;
        }

        public String getQzone() {
            return qzone;
        }

        public void setQzone(String qzone) {
            this.qzone = qzone;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public static class CampaignInDetailBean {
        private String imageUrl;
        private boolean available;
        private String actionUrl;
        private String showType;
        private String version;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public String getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(String actionUrl) {
            this.actionUrl = actionUrl;
        }

        public String getShowType() {
            return showType;
        }

        public void setShowType(String showType) {
            this.showType = showType;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public static class CampaignInFeedBean {
        private String imageUrl;
        private boolean available;
        private String actionUrl;
        private String version;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public String getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(String actionUrl) {
            this.actionUrl = actionUrl;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public static class ReplyBean {
        private String version;
        private boolean on;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public boolean isOn() {
            return on;
        }

        public void setOn(boolean on) {
            this.on = on;
        }
    }

    public static class PushInfoBean {
        /**
         * startTime : 32400
         * endTime : 43200
         * message : 今天的日报准备好了
         */

        private NormalBean normal;
        private String version;

        public NormalBean getNormal() {
            return normal;
        }

        public void setNormal(NormalBean normal) {
            this.normal = normal;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public static class NormalBean {
            private int startTime;
            private int endTime;
            private String message;

            public int getStartTime() {
                return startTime;
            }

            public void setStartTime(int startTime) {
                this.startTime = startTime;
            }

            public int getEndTime() {
                return endTime;
            }

            public void setEndTime(int endTime) {
                this.endTime = endTime;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }
        }
    }
}
