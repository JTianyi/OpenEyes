package com.example.dllo.openeyes.selection;

import java.util.List;

/**
 * Created by dllo on 16/8/12.
 */
public class SelectionBean {
    private long date;
    private long nextPublishTime;
    private int count;
    private String nextPageUrl;
    private Object dialog;


    private List<SectionListBean> sectionList;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getNextPublishTime() {
        return nextPublishTime;
    }

    public void setNextPublishTime(long nextPublishTime) {
        this.nextPublishTime = nextPublishTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public Object getDialog() {
        return dialog;
    }

    public void setDialog(Object dialog) {
        this.dialog = dialog;
    }

    public List<SectionListBean> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<SectionListBean> sectionList) {
        this.sectionList = sectionList;
    }

    public static class SectionListBean {
        private int id;
        private String type;
        private Object header;


        private FooterBean footer;
        private int count;
        private Object adTrack;

        private List<ItemListBean> itemList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getHeader() {
            return header;
        }

        public void setHeader(Object header) {
            this.header = header;
        }

        public FooterBean getFooter() {
            return footer;
        }

        public void setFooter(FooterBean footer) {
            this.footer = footer;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Object getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(Object adTrack) {
            this.adTrack = adTrack;
        }

        public List<ItemListBean> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemListBean> itemList) {
            this.itemList = itemList;
        }

        public static class FooterBean {
            private String type;
            /**
             * text : 查看更多精选
             * font : normal
             * actionUrl : eyepetizer://feed/
             * adTrack : null
             */

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
                private String text;
                private String font;
                private String actionUrl;
                private Object adTrack;

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

        public static class ItemListBean {
            private String type;
            /**
             * dataType : VideoBeanForClient
             * id : 6094
             * title : 回顾展丨菲尔普斯：掌控自己的人生
             * description : 31 岁的菲尔普斯今日斩获第 22 枚奥运金牌，对于这个经历了大起大落的三项世界纪录保持者来说，这支气质十足的广告最后那句话大概就是他人生的写照吧。From Under Armour
             * provider : {"name":"YouTube","alias":"youtube","icon":"http://img.wdjimg.com/image/video/fa20228bc5b921e837156923a58713f6_256_256.png"}
             * category : 广告
             * author : null
             * cover : {"feed":"http://img.wdjimg.com/image/video/37fceeaada61064901f69f23340d489b_0_0.jpeg","detail":"http://img.wdjimg.com/image/video/37fceeaada61064901f69f23340d489b_0_0.jpeg","blurred":"http://img.wdjimg.com/image/video/ec7f0659f4410a94b265678877c15b65_0_0.jpeg","sharing":null}
             * playUrl : http://baobab.wandoujia.com/api/v1/playUrl?vid=6094&editionType=default
             * duration : 91
             * webUrl : {"raw":"http://www.wandoujia.com/eyepetizer/detail.html?vid=6094","forWeibo":"http://wandou.im/1oj302"}
             * releaseTime : 1470970360000
             * playInfo : [{"height":360,"width":640,"name":"流畅","type":"low","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=6094&editionType=low"},{"height":480,"width":854,"name":"标清","type":"normal","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=6094&editionType=normal"},{"height":720,"width":1280,"name":"高清","type":"high","url":"http://baobab.wandoujia.com/api/v1/playUrl?vid=6094&editionType=high"}]
             * consumption : {"collectionCount":4102,"shareCount":5436,"replyCount":84}
             * campaign : null
             * waterMarks : null
             * adTrack : [{"organization":"admaster","viewUrl":"","clickUrl":"http://c.admaster.com.cn/c/a64875,b985187,c3101,i0,m101"}]
             * tags : [{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null},{"id":510,"name":"励志","actionUrl":"eyepetizer://tag/510/?title=%E5%8A%B1%E5%BF%97","adTrack":null},{"id":4,"name":"运动","actionUrl":"eyepetizer://tag/4/?title=%E8%BF%90%E5%8A%A8","adTrack":null},{"id":566,"name":"传记","actionUrl":"eyepetizer://tag/566/?title=%E4%BC%A0%E8%AE%B0","adTrack":null}]
             * type : NORMAL
             * idx : 0
             * shareAdTrack : null
             * favoriteAdTrack : null
             * webAdTrack : null
             * date : 1470931200000
             * promotion : null
             * label : null
             */

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
                private String title;
                private String description;
                private String text;
                private HeaderBean header;
                private List<ChildItemListBean> itemList;
                /**
                 * name : YouTube
                 * alias : youtube
                 * icon : http://img.wdjimg.com/image/video/fa20228bc5b921e837156923a58713f6_256_256.png
                 */

                private ProviderBean provider;
                private String category;
                private AuthorBean author;
                /**
                 * feed : http://img.wdjimg.com/image/video/37fceeaada61064901f69f23340d489b_0_0.jpeg
                 * detail : http://img.wdjimg.com/image/video/37fceeaada61064901f69f23340d489b_0_0.jpeg
                 * blurred : http://img.wdjimg.com/image/video/ec7f0659f4410a94b265678877c15b65_0_0.jpeg
                 * sharing : null
                 */

                private CoverBean cover;
                private String playUrl;
                private int duration;
                /**
                 * raw : http://www.wandoujia.com/eyepetizer/detail.html?vid=6094
                 * forWeibo : http://wandou.im/1oj302
                 */

                private WebUrlBean webUrl;
                private long releaseTime;
                /**
                 * collectionCount : 4102
                 * shareCount : 5436
                 * replyCount : 84
                 */

                private ConsumptionBean consumption;
                private Object campaign;
                private Object waterMarks;
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
                 * url : http://baobab.wandoujia.com/api/v1/playUrl?vid=6094&editionType=low
                 */

                private List<PlayInfoBean> playInfo;
                /**
                 * organization : admaster
                 * viewUrl :
                 * clickUrl : http://c.admaster.com.cn/c/a64875,b985187,c3101,i0,m101
                 */

                private List<AdTrackBean> adTrack;
                /**
                 * id : 16
                 * name : 广告
                 * actionUrl : eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A
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

                public HeaderBean getHeader() {
                    return header;
                }

                public DataBean setHeader(HeaderBean header) {
                    this.header = header;
                    return this;
                }

                public List<ChildItemListBean> getItemList() {
                    return itemList;
                }

                public DataBean setItemList(List<ChildItemListBean> itemList) {
                    this.itemList = itemList;
                    return this;
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

                public DataBean setAuthor(AuthorBean author) {
                    this.author = author;
                    return this;
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

                public String getText() {
                    return text;
                }

                public DataBean setText(String text) {
                    this.text = text;
                    return this;
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

                public List<AdTrackBean> getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(List<AdTrackBean> adTrack) {
                    this.adTrack = adTrack;
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

                public class AuthorBean {
                    private String name;

                    public String getName() {
                        return name;
                    }

                    public AuthorBean setName(String name) {
                        this.name = name;
                        return this;
                    }
                }

                public class HeaderBean {
                    private int id;
                    private String cover;
                    private String actionUrl;

                    public int getId() {
                        return id;
                    }

                    public HeaderBean setId(int id) {
                        this.id = id;
                        return this;
                    }

                    public String getCover() {
                        return cover;
                    }

                    public HeaderBean setCover(String cover) {
                        this.cover = cover;
                        return this;
                    }

                    public String getActionUrl() {
                        return actionUrl;
                    }

                    public HeaderBean setActionUrl(String actionUrl) {
                        this.actionUrl = actionUrl;
                        return this;
                    }
                }

                public class ChildItemListBean {
                    private String type;
                    private ChildDataBean data;

                    public String getType() {
                        return type;
                    }

                    public ChildItemListBean setType(String type) {
                        this.type = type;
                        return this;
                    }

                    public ChildDataBean getData() {
                        return data;
                    }

                    public ChildItemListBean setData(ChildDataBean data) {
                        this.data = data;
                        return this;
                    }

                    public class ChildDataBean {
                        private int id;
                        private String title;
                        private String description;
                        private String category;
                        private String playUrl;
                        private int duration;
                        private ChildCoverBean cover;

                        public int getId() {
                            return id;
                        }

                        public ChildDataBean setId(int id) {
                            this.id = id;
                            return this;
                        }

                        public ChildCoverBean getCover() {
                            return cover;
                        }

                        public ChildDataBean setCover(ChildCoverBean cover) {
                            this.cover = cover;
                            return this;
                        }

                        public String getTitle() {
                            return title;
                        }

                        public ChildDataBean setTitle(String title) {
                            this.title = title;
                            return this;
                        }

                        public String getDescription() {
                            return description;
                        }

                        public ChildDataBean setDescription(String description) {
                            this.description = description;
                            return this;
                        }

                        public String getCategory() {
                            return category;
                        }

                        public ChildDataBean setCategory(String category) {
                            this.category = category;
                            return this;
                        }

                        public String getPlayUrl() {
                            return playUrl;
                        }

                        public ChildDataBean setPlayUrl(String playUrl) {
                            this.playUrl = playUrl;
                            return this;
                        }

                        public int getDuration() {
                            return duration;
                        }

                        public ChildDataBean setDuration(int duration) {
                            this.duration = duration;
                            return this;
                        }

                        public class ChildCoverBean {
                            private String feed;
                            private String detail;
                            private String blurred;

                            public String getFeed() {
                                return feed;
                            }

                            public ChildCoverBean setFeed(String feed) {
                                this.feed = feed;
                                return this;
                            }

                            public String getDetail() {
                                return detail;
                            }

                            public ChildCoverBean setDetail(String detail) {
                                this.detail = detail;
                                return this;
                            }

                            public String getBlurred() {
                                return blurred;
                            }

                            public ChildCoverBean setBlurred(String blurred) {
                                this.blurred = blurred;
                                return this;
                            }
                        }
                    }
                }
            }
        }
    }
}
