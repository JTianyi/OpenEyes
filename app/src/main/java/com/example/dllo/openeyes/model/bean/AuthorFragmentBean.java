package com.example.dllo.openeyes.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/15.
 * 作者页面的实体类
 *
 * @author jiangtianyi
 */
public class AuthorFragmentBean  {
    private int count;
    private int total;
    private String nextPageUrl;

    private List<ItemListBean> itemList;

    protected AuthorFragmentBean(Parcel in) {
        count = in.readInt();
        total = in.readInt();
        nextPageUrl = in.readString();
    }

    public AuthorFragmentBean() {
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


        public static class DataBean implements Parcelable{
            private String dataType;
            private int id;
            private String icon;
            private String title;
            private String subTitle;
            private String description;
            private String actionUrl;
            private String adTrack;

            private String text;
            private String font;

            private int height;

            private int count;
            private int total;
            private String nextPageUrl;

            private HeaderBean header;
            private ArrayList<NItemListBean> itemList;

            protected DataBean(Parcel in) {
                dataType = in.readString();
                id = in.readInt();
                icon = in.readString();
                title = in.readString();
                subTitle = in.readString();
                description = in.readString();
                actionUrl = in.readString();
                adTrack = in.readString();
                text = in.readString();
                font = in.readString();
                height = in.readInt();
                count = in.readInt();
                total = in.readInt();
                nextPageUrl = in.readString();
                header = in.readParcelable(HeaderBean.class.getClassLoader());
                itemList = in.createTypedArrayList(NItemListBean.CREATOR);
            }

            public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
                @Override
                public DataBean createFromParcel(Parcel in) {
                    return new DataBean(in);
                }

                @Override
                public DataBean[] newArray(int size) {
                    return new DataBean[size];
                }
            };

            public DataBean() {
            }

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

            public String getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(String adTrack) {
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

            public void setItemList(ArrayList<NItemListBean> itemList) {
                this.itemList = itemList;
            }

            public ArrayList<NItemListBean> getItemList() {
                return itemList;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(dataType);
                dest.writeInt(id);
                dest.writeString(icon);
                dest.writeString(title);
                dest.writeString(subTitle);
                dest.writeString(description);
                dest.writeString(actionUrl);
                dest.writeString(adTrack);
                dest.writeString(text);
                dest.writeString(font);
                dest.writeInt(height);
                dest.writeInt(count);
                dest.writeInt(total);
                dest.writeString(nextPageUrl);
                dest.writeParcelable(header, flags);
                dest.writeTypedList(itemList);
            }

            public static class HeaderBean implements Parcelable{
                private int id;
                private String icon;
                private String title;
                private String subTitle;
                private String description;
                private String actionUrl;
                private String adTrack;

                protected HeaderBean(Parcel in) {
                    id = in.readInt();
                    icon = in.readString();
                    title = in.readString();
                    subTitle = in.readString();
                    description = in.readString();
                    actionUrl = in.readString();
                    adTrack = in.readString();
                }

                public static final Creator<HeaderBean> CREATOR = new Creator<HeaderBean>() {
                    @Override
                    public HeaderBean createFromParcel(Parcel in) {
                        return new HeaderBean(in);
                    }

                    @Override
                    public HeaderBean[] newArray(int size) {
                        return new HeaderBean[size];
                    }
                };

                public HeaderBean() {
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

                public String getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(String adTrack) {
                    this.adTrack = adTrack;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(id);
                    dest.writeString(icon);
                    dest.writeString(title);
                    dest.writeString(subTitle);
                    dest.writeString(description);
                    dest.writeString(actionUrl);
                    dest.writeString(adTrack);
                }
            }


            public static class NItemListBean implements Parcelable{
                private String type;
                private NDataBean data;


                protected NItemListBean(Parcel in) {
                    type = in.readString();
                    data = in.readParcelable(NDataBean.class.getClassLoader());
                }

                public static final Creator<NItemListBean> CREATOR = new Creator<NItemListBean>() {
                    @Override
                    public NItemListBean createFromParcel(Parcel in) {
                        return new NItemListBean(in);
                    }

                    @Override
                    public NItemListBean[] newArray(int size) {
                        return new NItemListBean[size];
                    }
                };

                public NItemListBean() {
                }

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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(type);
                    dest.writeParcelable(data, flags);
                }


                public static class NDataBean implements Parcelable{
                    private String dataType;
                    private int id;
                    private String title;
                    private String description;
                    private ProviderBean provider;
                    private String category;
                    private AuthorBean author;
                    private CoverBean cover;
                    private String playUrl;
                    private int duration;
                    private WebUrlBean webUrl;
                    private long releaseTime;
                    private ConsumptionBean consumption;
                    private String campaign;
                    private String waterMarks;
                    private String adTrack;
                    private String type;
                    private int idx;
                    private String shareAdTrack;
                    private String favoriteAdTrack;
                    private String webAdTrack;
                    private long date;
                    private String promotion;
                    private String label;
                    private List<PlayInfoBean> playInfo;
                    private List<TagsBean> tags;

                    public NDataBean() {
                    }


                    protected NDataBean(Parcel in) {
                        dataType = in.readString();
                        id = in.readInt();
                        title = in.readString();
                        description = in.readString();
                        provider = in.readParcelable(ProviderBean.class.getClassLoader());
                        category = in.readString();
                        author = in.readParcelable(AuthorBean.class.getClassLoader());
                        cover = in.readParcelable(CoverBean.class.getClassLoader());
                        playUrl = in.readString();
                        duration = in.readInt();
                        webUrl = in.readParcelable(WebUrlBean.class.getClassLoader());
                        releaseTime = in.readLong();
                        consumption = in.readParcelable(ConsumptionBean.class.getClassLoader());
                        campaign = in.readString();
                        waterMarks = in.readString();
                        adTrack = in.readString();
                        type = in.readString();
                        idx = in.readInt();
                        shareAdTrack = in.readString();
                        favoriteAdTrack = in.readString();
                        webAdTrack = in.readString();
                        date = in.readLong();
                        promotion = in.readString();
                        label = in.readString();
                        playInfo = in.createTypedArrayList(PlayInfoBean.CREATOR);
                        tags = in.createTypedArrayList(TagsBean.CREATOR);
                    }

                    public static final Creator<NDataBean> CREATOR = new Creator<NDataBean>() {
                        @Override
                        public NDataBean createFromParcel(Parcel in) {
                            return new NDataBean(in);
                        }

                        @Override
                        public NDataBean[] newArray(int size) {
                            return new NDataBean[size];
                        }
                    };

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

                    public String getCampaign() {
                        return campaign;
                    }

                    public void setCampaign(String campaign) {
                        this.campaign = campaign;
                    }

                    public String getWaterMarks() {
                        return waterMarks;
                    }

                    public void setWaterMarks(String waterMarks) {
                        this.waterMarks = waterMarks;
                    }

                    public String getAdTrack() {
                        return adTrack;
                    }

                    public void setAdTrack(String adTrack) {
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

                    public String getShareAdTrack() {
                        return shareAdTrack;
                    }

                    public void setShareAdTrack(String shareAdTrack) {
                        this.shareAdTrack = shareAdTrack;
                    }

                    public String getFavoriteAdTrack() {
                        return favoriteAdTrack;
                    }

                    public void setFavoriteAdTrack(String favoriteAdTrack) {
                        this.favoriteAdTrack = favoriteAdTrack;
                    }

                    public String getWebAdTrack() {
                        return webAdTrack;
                    }

                    public void setWebAdTrack(String webAdTrack) {
                        this.webAdTrack = webAdTrack;
                    }

                    public long getDate() {
                        return date;
                    }

                    public void setDate(long date) {
                        this.date = date;
                    }

                    public String getPromotion() {
                        return promotion;
                    }

                    public void setPromotion(String promotion) {
                        this.promotion = promotion;
                    }

                    public String getLabel() {
                        return label;
                    }

                    public void setLabel(String label) {
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

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeString(dataType);
                        dest.writeInt(id);
                        dest.writeString(title);
                        dest.writeString(description);
                        dest.writeParcelable(provider, flags);
                        dest.writeString(category);
                        dest.writeParcelable(author, flags);
                        dest.writeParcelable(cover, flags);
                        dest.writeString(playUrl);
                        dest.writeInt(duration);
                        dest.writeParcelable(webUrl, flags);
                        dest.writeLong(releaseTime);
                        dest.writeParcelable(consumption, flags);
                        dest.writeString(campaign);
                        dest.writeString(waterMarks);
                        dest.writeString(adTrack);
                        dest.writeString(type);
                        dest.writeInt(idx);
                        dest.writeString(shareAdTrack);
                        dest.writeString(favoriteAdTrack);
                        dest.writeString(webAdTrack);
                        dest.writeLong(date);
                        dest.writeString(promotion);
                        dest.writeString(label);
                        dest.writeTypedList(playInfo);
                        dest.writeTypedList(tags);
                    }

                    public static class ProviderBean implements Parcelable{
                        private String name;
                        private String alias;
                        private String icon;

                        protected ProviderBean(Parcel in) {
                            name = in.readString();
                            alias = in.readString();
                            icon = in.readString();
                        }

                        public static final Creator<ProviderBean> CREATOR = new Creator<ProviderBean>() {
                            @Override
                            public ProviderBean createFromParcel(Parcel in) {
                                return new ProviderBean(in);
                            }

                            @Override
                            public ProviderBean[] newArray(int size) {
                                return new ProviderBean[size];
                            }
                        };

                        public ProviderBean() {
                        }

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

                        @Override
                        public int describeContents() {
                            return 0;
                        }

                        @Override
                        public void writeToParcel(Parcel dest, int flags) {
                            dest.writeString(name);
                            dest.writeString(alias);
                            dest.writeString(icon);
                        }
                    }

                    public static class AuthorBean implements Parcelable{
                        private int id;
                        private String icon;
                        private String name;
                        private String description;
                        private String link;
                        private long latestReleaseTime;
                        private int videoNum;
                        private String adTrack;

                        protected AuthorBean(Parcel in) {
                            id = in.readInt();
                            icon = in.readString();
                            name = in.readString();
                            description = in.readString();
                            link = in.readString();
                            latestReleaseTime = in.readLong();
                            videoNum = in.readInt();
                            adTrack = in.readString();
                        }

                        public static final Creator<AuthorBean> CREATOR = new Creator<AuthorBean>() {
                            @Override
                            public AuthorBean createFromParcel(Parcel in) {
                                return new AuthorBean(in);
                            }

                            @Override
                            public AuthorBean[] newArray(int size) {
                                return new AuthorBean[size];
                            }
                        };

                        public AuthorBean() {
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

                        public String getAdTrack() {
                            return adTrack;
                        }

                        public void setAdTrack(String adTrack) {
                            this.adTrack = adTrack;
                        }

                        @Override
                        public int describeContents() {
                            return 0;
                        }

                        @Override
                        public void writeToParcel(Parcel dest, int flags) {
                            dest.writeInt(id);
                            dest.writeString(icon);
                            dest.writeString(name);
                            dest.writeString(description);
                            dest.writeString(link);
                            dest.writeLong(latestReleaseTime);
                            dest.writeInt(videoNum);
                            dest.writeString(adTrack);
                        }
                    }

                    public static class CoverBean implements Parcelable {
                        private String feed;
                        private String detail;
                        private String blurred;
                        private String sharing;

                        protected CoverBean(Parcel in) {
                            feed = in.readString();
                            detail = in.readString();
                            blurred = in.readString();
                        }

                        public static final Creator<CoverBean> CREATOR = new Creator<CoverBean>() {
                            @Override
                            public CoverBean createFromParcel(Parcel in) {
                                return new CoverBean(in);
                            }

                            @Override
                            public CoverBean[] newArray(int size) {
                                return new CoverBean[size];
                            }
                        };

                        public CoverBean() {
                        }

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

                        public String getSharing() {
                            return sharing;
                        }

                        public void setSharing(String sharing) {
                            this.sharing = sharing;
                        }

                        @Override
                        public int describeContents() {
                            return 0;
                        }

                        @Override
                        public void writeToParcel(Parcel dest, int flags) {
                            dest.writeString(feed);
                            dest.writeString(detail);
                            dest.writeString(blurred);
                        }
                    }

                    public static class WebUrlBean implements Parcelable{
                        private String raw;
                        private String forWeibo;

                        protected WebUrlBean(Parcel in) {
                            raw = in.readString();
                            forWeibo = in.readString();
                        }

                        public static final Creator<WebUrlBean> CREATOR = new Creator<WebUrlBean>() {
                            @Override
                            public WebUrlBean createFromParcel(Parcel in) {
                                return new WebUrlBean(in);
                            }

                            @Override
                            public WebUrlBean[] newArray(int size) {
                                return new WebUrlBean[size];
                            }
                        };

                        public WebUrlBean() {
                        }

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

                        @Override
                        public int describeContents() {
                            return 0;
                        }

                        @Override
                        public void writeToParcel(Parcel dest, int flags) {
                            dest.writeString(raw);
                            dest.writeString(forWeibo);
                        }
                    }

                    public static class ConsumptionBean implements Parcelable{
                        private int collectionCount;
                        private int shareCount;
                        private int replyCount;

                        protected ConsumptionBean(Parcel in) {
                            collectionCount = in.readInt();
                            shareCount = in.readInt();
                            replyCount = in.readInt();
                        }

                        public static final Creator<ConsumptionBean> CREATOR = new Creator<ConsumptionBean>() {
                            @Override
                            public ConsumptionBean createFromParcel(Parcel in) {
                                return new ConsumptionBean(in);
                            }

                            @Override
                            public ConsumptionBean[] newArray(int size) {
                                return new ConsumptionBean[size];
                            }
                        };

                        public ConsumptionBean() {
                        }

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

                        @Override
                        public int describeContents() {
                            return 0;
                        }

                        @Override
                        public void writeToParcel(Parcel dest, int flags) {
                            dest.writeInt(collectionCount);
                            dest.writeInt(shareCount);
                            dest.writeInt(replyCount);
                        }
                    }

                    public static class PlayInfoBean implements Parcelable{
                        private int height;
                        private int width;
                        private String name;
                        private String type;
                        private String url;

                        protected PlayInfoBean(Parcel in) {
                            height = in.readInt();
                            width = in.readInt();
                            name = in.readString();
                            type = in.readString();
                            url = in.readString();
                        }

                        public static final Creator<PlayInfoBean> CREATOR = new Creator<PlayInfoBean>() {
                            @Override
                            public PlayInfoBean createFromParcel(Parcel in) {
                                return new PlayInfoBean(in);
                            }

                            @Override
                            public PlayInfoBean[] newArray(int size) {
                                return new PlayInfoBean[size];
                            }
                        };

                        public PlayInfoBean() {
                        }

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

                        @Override
                        public int describeContents() {
                            return 0;
                        }

                        @Override
                        public void writeToParcel(Parcel dest, int flags) {
                            dest.writeInt(height);
                            dest.writeInt(width);
                            dest.writeString(name);
                            dest.writeString(type);
                            dest.writeString(url);
                        }
                    }

                    public static class TagsBean implements Parcelable{
                        private int id;
                        private String name;
                        private String actionUrl;
                        private String adTrack;

                        protected TagsBean(Parcel in) {
                            id = in.readInt();
                            name = in.readString();
                            actionUrl = in.readString();
                            adTrack = in.readString();
                        }

                        public static final Creator<TagsBean> CREATOR = new Creator<TagsBean>() {
                            @Override
                            public TagsBean createFromParcel(Parcel in) {
                                return new TagsBean(in);
                            }

                            @Override
                            public TagsBean[] newArray(int size) {
                                return new TagsBean[size];
                            }
                        };

                        public TagsBean() {
                        }

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

                        public String getAdTrack() {
                            return adTrack;
                        }

                        public void setAdTrack(String adTrack) {
                            this.adTrack = adTrack;
                        }

                        @Override
                        public int describeContents() {
                            return 0;
                        }

                        @Override
                        public void writeToParcel(Parcel dest, int flags) {
                            dest.writeInt(id);
                            dest.writeString(name);
                            dest.writeString(actionUrl);
                            dest.writeString(adTrack);
                        }
                    }
                }
            }
        }
    }


}













