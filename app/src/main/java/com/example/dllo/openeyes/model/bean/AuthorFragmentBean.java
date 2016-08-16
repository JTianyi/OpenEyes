package com.example.dllo.openeyes.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/8/15.
 * 作者页面的实体类
 *
 * @author jiangtianyi
 */
public class AuthorFragmentBean {
    private int count;
    private int total;
    private String nextPageUrl;

    private List<ItemListBean> itemList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public List<ItemListBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBean {

        private String type;
        private DataBean data;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }


        public static class DataBean {
            private String dataType;
            private int id;
            private String icon;
            private String title;
            private String subTitle;
            private String description;
            private String actionUrl;
            private Object adTrack;

            private String text;
            private String font;

            private int height;

            private int count;
            private int total;
            private String nextPageUrl;

            private HeaderBean header;
            private List<NItemListBean> itemList;

            public HeaderBean getHeader() {
                return header;
            }

            public void setHeader(HeaderBean header) {
                this.header = header;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getFont() {
                return font;
            }

            public void setFont(String font) {
                this.font = font;
            }

            public String getDataType() {
                return dataType;
            }

            public void setDataType(String dataType) {
                this.dataType = dataType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(String subTitle) {
                this.subTitle = subTitle;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getActionUrl() {
                return actionUrl;
            }

            public void setActionUrl(String actionUrl) {
                this.actionUrl = actionUrl;
            }

            public Object getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(Object adTrack) {
                this.adTrack = adTrack;
            }


            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public String getNextPageUrl() {
                return nextPageUrl;
            }

            public void setNextPageUrl(String nextPageUrl) {
                this.nextPageUrl = nextPageUrl;
            }

            public void setItemList(List<NItemListBean> itemList) {
                this.itemList = itemList;
            }

            public List<NItemListBean> getItemList() {
                return itemList;
            }

            public static class HeaderBean {
                private int id;
                private String icon;
                private String title;
                private String subTitle;
                private String description;
                private String actionUrl;
                private Object adTrack;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getSubTitle() {
                    return subTitle;
                }

                public void setSubTitle(String subTitle) {
                    this.subTitle = subTitle;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public Object getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
                }
            }


            public static class NItemListBean {
                private String type;
                private NDataBean data;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public void setData(NDataBean data) {
                    this.data = data;
                }

                public NDataBean getData() {
                    return data;
                }

                public static class NDataBean {
                    private String dataType;
                    private int id;
                    private String title;
                    private String description;
                    /**
                     * name : YouTube
                     * alias : youtube
                     * icon : http://img.wdjimg.com/image/video/fa20228bc5b921e837156923a58713f6_256_256.png
                     */

                    private ProviderBean provider;
                    private String category;
                    /**
                     * id : 134
                     * icon : http://img.wdjimg.com/image/video/fef7cdcd26a44f0a30902838320d6b52_0_0.jpeg
                     * name : GoPro
                     * description : 用第一人称视角记录刺激的运动和温暖的生活。
                     * link :
                     * latestReleaseTime : 1471190400000
                     * videoNum : 49
                     * adTrack : null
                     */

                    private AuthorBean author;
                    /**
                     * feed : http://img.wdjimg.com/image/video/1ea46d8f93b2a0c280947426e706f89e_0_0.jpeg
                     * detail : http://img.wdjimg.com/image/video/1ea46d8f93b2a0c280947426e706f89e_0_0.jpeg
                     * blurred : http://img.wdjimg.com/image/video/f662b5eed9fbf47b7e11956695df69d0_0_0.jpeg
                     * sharing : null
                     */

                    private CoverBean cover;
                    private String playUrl;
                    private int duration;
                    /**
                     * raw : http://www.wandoujia.com/eyepetizer/detail.html?vid=8656
                     * forWeibo : http://wandou.im/2rgn0h
                     */

                    private WebUrlBean webUrl;
                    private long releaseTime;
                    /**
                     * collectionCount : 44
                     * shareCount : 81
                     * replyCount : 5
                     */

                    private ConsumptionBean consumption;
                    private Object campaign;
                    private Object waterMarks;
                    private Object adTrack;
                    private String type;
                    private int idx;
                    private Object shareAdTrack;
                    private Object favoriteAdTrack;
                    private Object webAdTrack;
                    private long date;
                    private Object promotion;
                    private Object label;
                    /**
                     * height : 360
                     * width : 640
                     * name : 流畅
                     * type : low
                     * url : http://baobab.wandoujia.com/api/v1/playUrl?vid=8656&editionType=low
                     */

                    private List<PlayInfoBean> playInfo;
                    /**
                     * id : 4
                     * name : 运动
                     * actionUrl : eyepetizer://tag/4/?title=%E8%BF%90%E5%8A%A8
                     * adTrack : null
                     */

                    private List<TagsBean> tags;

                    public String getDataType() {
                        return dataType;
                    }

                    public void setDataType(String dataType) {
                        this.dataType = dataType;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public ProviderBean getProvider() {
                        return provider;
                    }

                    public void setProvider(ProviderBean provider) {
                        this.provider = provider;
                    }

                    public String getCategory() {
                        return category;
                    }

                    public void setCategory(String category) {
                        this.category = category;
                    }

                    public AuthorBean getAuthor() {
                        return author;
                    }

                    public void setAuthor(AuthorBean author) {
                        this.author = author;
                    }

                    public CoverBean getCover() {
                        return cover;
                    }

                    public void setCover(CoverBean cover) {
                        this.cover = cover;
                    }

                    public String getPlayUrl() {
                        return playUrl;
                    }

                    public void setPlayUrl(String playUrl) {
                        this.playUrl = playUrl;
                    }

                    public int getDuration() {
                        return duration;
                    }

                    public void setDuration(int duration) {
                        this.duration = duration;
                    }

                    public WebUrlBean getWebUrl() {
                        return webUrl;
                    }

                    public void setWebUrl(WebUrlBean webUrl) {
                        this.webUrl = webUrl;
                    }

                    public long getReleaseTime() {
                        return releaseTime;
                    }

                    public void setReleaseTime(long releaseTime) {
                        this.releaseTime = releaseTime;
                    }

                    public ConsumptionBean getConsumption() {
                        return consumption;
                    }

                    public void setConsumption(ConsumptionBean consumption) {
                        this.consumption = consumption;
                    }

                    public Object getCampaign() {
                        return campaign;
                    }

                    public void setCampaign(Object campaign) {
                        this.campaign = campaign;
                    }

                    public Object getWaterMarks() {
                        return waterMarks;
                    }

                    public void setWaterMarks(Object waterMarks) {
                        this.waterMarks = waterMarks;
                    }

                    public Object getAdTrack() {
                        return adTrack;
                    }

                    public void setAdTrack(Object adTrack) {
                        this.adTrack = adTrack;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public int getIdx() {
                        return idx;
                    }

                    public void setIdx(int idx) {
                        this.idx = idx;
                    }

                    public Object getShareAdTrack() {
                        return shareAdTrack;
                    }

                    public void setShareAdTrack(Object shareAdTrack) {
                        this.shareAdTrack = shareAdTrack;
                    }

                    public Object getFavoriteAdTrack() {
                        return favoriteAdTrack;
                    }

                    public void setFavoriteAdTrack(Object favoriteAdTrack) {
                        this.favoriteAdTrack = favoriteAdTrack;
                    }

                    public Object getWebAdTrack() {
                        return webAdTrack;
                    }

                    public void setWebAdTrack(Object webAdTrack) {
                        this.webAdTrack = webAdTrack;
                    }

                    public long getDate() {
                        return date;
                    }

                    public void setDate(long date) {
                        this.date = date;
                    }

                    public Object getPromotion() {
                        return promotion;
                    }

                    public void setPromotion(Object promotion) {
                        this.promotion = promotion;
                    }

                    public Object getLabel() {
                        return label;
                    }

                    public void setLabel(Object label) {
                        this.label = label;
                    }

                    public List<PlayInfoBean> getPlayInfo() {
                        return playInfo;
                    }

                    public void setPlayInfo(List<PlayInfoBean> playInfo) {
                        this.playInfo = playInfo;
                    }

                    public List<TagsBean> getTags() {
                        return tags;
                    }

                    public void setTags(List<TagsBean> tags) {
                        this.tags = tags;
                    }

                    public static class ProviderBean {
                        private String name;
                        private String alias;
                        private String icon;

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getAlias() {
                            return alias;
                        }

                        public void setAlias(String alias) {
                            this.alias = alias;
                        }

                        public String getIcon() {
                            return icon;
                        }

                        public void setIcon(String icon) {
                            this.icon = icon;
                        }
                    }

                    public static class AuthorBean {
                        private int id;
                        private String icon;
                        private String name;
                        private String description;
                        private String link;
                        private long latestReleaseTime;
                        private int videoNum;
                        private Object adTrack;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getIcon() {
                            return icon;
                        }

                        public void setIcon(String icon) {
                            this.icon = icon;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getDescription() {
                            return description;
                        }

                        public void setDescription(String description) {
                            this.description = description;
                        }

                        public String getLink() {
                            return link;
                        }

                        public void setLink(String link) {
                            this.link = link;
                        }

                        public long getLatestReleaseTime() {
                            return latestReleaseTime;
                        }

                        public void setLatestReleaseTime(long latestReleaseTime) {
                            this.latestReleaseTime = latestReleaseTime;
                        }

                        public int getVideoNum() {
                            return videoNum;
                        }

                        public void setVideoNum(int videoNum) {
                            this.videoNum = videoNum;
                        }

                        public Object getAdTrack() {
                            return adTrack;
                        }

                        public void setAdTrack(Object adTrack) {
                            this.adTrack = adTrack;
                        }
                    }

                    public static class CoverBean {
                        private String feed;
                        private String detail;
                        private String blurred;
                        private Object sharing;

                        public String getFeed() {
                            return feed;
                        }

                        public void setFeed(String feed) {
                            this.feed = feed;
                        }

                        public String getDetail() {
                            return detail;
                        }

                        public void setDetail(String detail) {
                            this.detail = detail;
                        }

                        public String getBlurred() {
                            return blurred;
                        }

                        public void setBlurred(String blurred) {
                            this.blurred = blurred;
                        }

                        public Object getSharing() {
                            return sharing;
                        }

                        public void setSharing(Object sharing) {
                            this.sharing = sharing;
                        }
                    }

                    public static class WebUrlBean {
                        private String raw;
                        private String forWeibo;

                        public String getRaw() {
                            return raw;
                        }

                        public void setRaw(String raw) {
                            this.raw = raw;
                        }

                        public String getForWeibo() {
                            return forWeibo;
                        }

                        public void setForWeibo(String forWeibo) {
                            this.forWeibo = forWeibo;
                        }
                    }

                    public static class ConsumptionBean {
                        private int collectionCount;
                        private int shareCount;
                        private int replyCount;

                        public int getCollectionCount() {
                            return collectionCount;
                        }

                        public void setCollectionCount(int collectionCount) {
                            this.collectionCount = collectionCount;
                        }

                        public int getShareCount() {
                            return shareCount;
                        }

                        public void setShareCount(int shareCount) {
                            this.shareCount = shareCount;
                        }

                        public int getReplyCount() {
                            return replyCount;
                        }

                        public void setReplyCount(int replyCount) {
                            this.replyCount = replyCount;
                        }
                    }

                    public static class PlayInfoBean {
                        private int height;
                        private int width;
                        private String name;
                        private String type;
                        private String url;

                        public int getHeight() {
                            return height;
                        }

                        public void setHeight(int height) {
                            this.height = height;
                        }

                        public int getWidth() {
                            return width;
                        }

                        public void setWidth(int width) {
                            this.width = width;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getType() {
                            return type;
                        }

                        public void setType(String type) {
                            this.type = type;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }

                    public static class TagsBean {
                        private int id;
                        private String name;
                        private String actionUrl;
                        private Object adTrack;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getActionUrl() {
                            return actionUrl;
                        }

                        public void setActionUrl(String actionUrl) {
                            this.actionUrl = actionUrl;
                        }

                        public Object getAdTrack() {
                            return adTrack;
                        }

                        public void setAdTrack(Object adTrack) {
                            this.adTrack = adTrack;
                        }
                    }
                }
            }
        }
    }


}













