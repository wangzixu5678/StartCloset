package administrator.example.com.startcloset.model;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */

public class Banner {
    private String message;
    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * items : [{"component":{"componentType":"cell","picUrl":"http://s0.mingxingyichu.cn/group5/M00/13/73/wKgBf1ephWiAZWfSAASSLcjY69Q270.jpg?imageMogr2?imageMogr2?imageMogr2","action":{"unixtime":1470846911,"actionType":"detail","type":"thread","id":"229623","bannerId":"23155","title":"晒出小疯狂，免费领《那件疯狂的小事叫爱情》电影票","post_id":"353","banner_id":"23155","tab_id":"43"},"title":"晒出小疯狂，免费领《那件疯狂的小事叫爱情》电影票","width":"750","height":"350"},"width":"750","height":"350"},{"component":{"componentType":"cell","picUrl":"http://s0.mingxingyichu.cn/group6/M00/53/F3/wKgBjVesKT2ABPeuAAOjIxTn0Xk072.jpg?imageMogr2?imageMogr2?imageMogr2","action":{"unixtime":1470900513,"actionType":"detail","type":"thread","id":"229503","bannerId":"23296","title":"令抹茶控尖叫的抹茶美食全解读","post_id":"354","banner_id":"23296","tab_id":"43"},"title":"令抹茶控尖叫的抹茶美食全解读","width":"750","height":"350"},"width":"750","height":"350"},{"component":{"componentType":"cell","picUrl":"http://s0.mingxingyichu.cn/group6/M00/53/A1/wKgBjVeqqPSAKBTmAAQebB4y-dg854.jpg?imageMogr2?imageMogr2?imageMogr2","action":{"unixtime":1470802142,"actionType":"detail","type":"thread","id":"228996","bannerId":"23230","title":"今夏不穿蓝白条纹，就要被时尚甩几条街了","post_id":"355","banner_id":"23230","tab_id":"43"},"title":"今夏不穿蓝白条纹，就要被时尚甩几条街了","width":"750","height":"350"},"width":"750","height":"350"}]
         * appApi :
         */

        private String appApi;
        private List<ItemsBean> items;

        public String getAppApi() {
            return appApi;
        }

        public void setAppApi(String appApi) {
            this.appApi = appApi;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            @Override
            public String toString() {
                return "ItemsBean{" +
                        "component=" + component +
                        ", width='" + width + '\'' +
                        ", height='" + height + '\'' +
                        '}';
            }

            /**
             * component : {"componentType":"cell","picUrl":"http://s0.mingxingyichu.cn/group5/M00/13/73/wKgBf1ephWiAZWfSAASSLcjY69Q270.jpg?imageMogr2?imageMogr2?imageMogr2","action":{"unixtime":1470846911,"actionType":"detail","type":"thread","id":"229623","bannerId":"23155","title":"晒出小疯狂，免费领《那件疯狂的小事叫爱情》电影票","post_id":"353","banner_id":"23155","tab_id":"43"},"title":"晒出小疯狂，免费领《那件疯狂的小事叫爱情》电影票","width":"750","height":"350"}
             * width : 750
             * height : 350
             */

            private ComponentBean component;
            private String width;
            private String height;

            public ComponentBean getComponent() {
                return component;
            }

            public void setComponent(ComponentBean component) {
                this.component = component;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public static class ComponentBean {
                /**
                 * componentType : cell
                 * picUrl : http://s0.mingxingyichu.cn/group5/M00/13/73/wKgBf1ephWiAZWfSAASSLcjY69Q270.jpg?imageMogr2?imageMogr2?imageMogr2
                 * action : {"unixtime":1470846911,"actionType":"detail","type":"thread","id":"229623","bannerId":"23155","title":"晒出小疯狂，免费领《那件疯狂的小事叫爱情》电影票","post_id":"353","banner_id":"23155","tab_id":"43"}
                 * title : 晒出小疯狂，免费领《那件疯狂的小事叫爱情》电影票
                 * width : 750
                 * height : 350
                 */

                private String componentType;
                private String picUrl;
                private ActionBean action;
                private String title;
                private String width;
                private String height;

                public String getComponentType() {
                    return componentType;
                }

                public void setComponentType(String componentType) {
                    this.componentType = componentType;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public ActionBean getAction() {
                    return action;
                }

                public void setAction(ActionBean action) {
                    this.action = action;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public static class ActionBean {
                    /**
                     * unixtime : 1470846911
                     * actionType : detail
                     * type : thread
                     * id : 229623
                     * bannerId : 23155
                     * title : 晒出小疯狂，免费领《那件疯狂的小事叫爱情》电影票
                     * post_id : 353
                     * banner_id : 23155
                     * tab_id : 43
                     */

                    private int unixtime;
                    private String actionType;
                    private String type;
                    private String id;
                    private String bannerId;
                    private String title;
                    private String post_id;
                    private String banner_id;
                    private String tab_id;

                    public int getUnixtime() {
                        return unixtime;
                    }

                    public void setUnixtime(int unixtime) {
                        this.unixtime = unixtime;
                    }

                    public String getActionType() {
                        return actionType;
                    }

                    public void setActionType(String actionType) {
                        this.actionType = actionType;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getBannerId() {
                        return bannerId;
                    }

                    public void setBannerId(String bannerId) {
                        this.bannerId = bannerId;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getPost_id() {
                        return post_id;
                    }

                    public void setPost_id(String post_id) {
                        this.post_id = post_id;
                    }

                    public String getBanner_id() {
                        return banner_id;
                    }

                    public void setBanner_id(String banner_id) {
                        this.banner_id = banner_id;
                    }

                    public String getTab_id() {
                        return tab_id;
                    }

                    public void setTab_id(String tab_id) {
                        this.tab_id = tab_id;
                    }
                }
            }
        }
    }
}
