package com.example.dllo.openeyes.model.net;

/**
 * Created by mac on 16/8/12.
 */
public final class NetUrls {
    /**
     * 发现界面的网址
     */
    public final static String FIND_URL = "http://baobab.wandoujia.com/api/v3/discovery?udid=fc33d7ade6d5482bba5eeae629440fe0c6ac1a9e&vc=126&vn=2.4.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";
    /**
     * 精选界面的Url
     */
    public final static String SELECTION_URL = "http://baobab.wandoujia.com/api/v3/tabs/selected?udid=86f35dc937824e09bf8d0c7dc0cfea543ed2a2a3&vc=126&vn=2.4.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_360_market&last_channel=eyepetizer_360_market&system_version_code=22";
    /**
     * 作者界面的Url
     */
    public final static String AUTHOR_URL = "http://baobab.wandoujia.com/api/v3/tabs/pgcs?udid=fc33d7ade6d5482bba5eeae629440fe0c6ac1a9e&vc=126&vn=2.4.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";
    /**
     * 作者详情界面的Url前缀
     */
    public final static String AUTHOR_DETAIL_HEAD_URL ="http://baobab.wandoujia.com/api/v3/pgc/videos?pgcId=";
    /**
     * 作者详情界面的Url尾缀
     */
    public final static String AUTHOR_DETAIL_FOOT_URL ="&udid=fc33d7ade6d5482bba5eeae629440fe0c6ac1a9e&vc=126&vn=2.4.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";
    /**
     * 作者详情界面按<时间>排序的拼接Url
     */
    public final static String AUTHOR_DETAIL_DATE_URL ="&strategy=date";
    /**
     * 作者详情界面按<分享数量>排序的拼接Url
     */
    public final static String AUTHOR_DETAIL_SHARE_URL ="&strategy=shareCount";
    /**
     * 查看往期编辑精选界面的Url
     */
    public final static String LOOK_BEFORE_SELECTON_URL="http://baobab.wandoujia.com/api/v2/feed?num=2&udid=86f35dc937824e09bf8d0c7dc0cfea543ed2a2a3&vc=126&vn=2.4.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_360_market&last_channel=eyepetizer_360_market&system_version_code=22";
    /**
     * 搜索PopWindow界面数据的Url
     */
    public final static String SEARCH_URL="http://baobab.wandoujia.com/api/v3/queries/hot?udid=86f35dc937824e09bf8d0c7dc0cfea543ed2a2a3&vc=126&vn=2.4.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_360_market&last_channel=eyepetizer_360_market&system_version_code=22";
    /**
     * 搜索PopWindow界面,查询界面的Url前缀
     */
    public final static String SEARCH_HEAD_URL="http://baobab.wandoujia.com/api/v1/search?query=";
    /**
     * 搜索PopWindow界面,查询界面的Url后缀
     */
    public final static String SEARCH_END_URL="&udid=86f35dc937824e09bf8d0c7dc0cfea543ed2a2a3&vc=126&vn=2.4.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_360_market&last_channel=eyepetizer_360_market&system_version_code=22";

    public final static String ACCORD_TIME_URL = "http://baobab.wandoujia.com/api/v3/tag/videos?tagId=658&strategy=date&udid=86f35dc937824e09bf8d0c7dc0cfea543ed2a2a3&vc=126&vn=2.4.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_360_market&last_channel=eyepetizer_360_market&system_version_code=22";
    /**
     * 发现界面360全景的根据分享排序的Url
     */
    public final static String ACCORD_SHARE_URL = "http://baobab.wandoujia.com/api/v3/tag/videos?tagId=658&strategy=shareCount&udid=86f35dc937824e09bf8d0c7dc0cfea543ed2a2a";

    /**
     * 轮播图探索的Url
     */
    public static final String EXPLORE_BANNER_URL = "http://baobab.wandoujia.com/api/v3/recommend?udid=fc33d7ade6d5482bba5eeae629440fe0c6ac1a9e&vc=126&vn=2.4.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";

}
