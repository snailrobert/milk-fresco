package f.star.iota.milk.ui.pixivic;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import f.star.iota.milk.base.BaseBean;


public class PixivicBean {

    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<ResultsBean> results;

    private static final String prefixUrl = "https://img.pixivic.com:23334/get/";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean extends BaseBean {

        @SerializedName("id")
        private String id;

        @SerializedName("title")
        private String desc;

        @SerializedName("type")
        private String type;

        @SerializedName("imageUrls")
        private List<ImageUrls> imageUrls;

        public ResultsBean() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<ImageUrls> getImageUrls() {
            return imageUrls;
        }

        public void setImageUrls(List<ImageUrls> imageUrls) {
            this.imageUrls = imageUrls;
        }

        public static class ImageUrls {
            @SerializedName("squareMedium")
            private String  squareMedium;

            @SerializedName("medium")
            private String medium;

            @SerializedName("large")
            private String large;

            @SerializedName("original")
            private String original;

            public ImageUrls() {
            }

            public String getSquareMedium() {
                return prefixUrl + squareMedium;
            }

            public void setSquareMedium(String squareMedium) {
                this.squareMedium = squareMedium;
            }

            public String getMedium() {
                return prefixUrl + medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getLarge() {
                return prefixUrl + large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getOriginal() {
                return prefixUrl + original;
            }

            public void setOriginal(String original) {
                this.original = original;
            }
        }
    }


}
