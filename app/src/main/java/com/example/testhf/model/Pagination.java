package com.example.testhf.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Pagination {
    @SerializedName("size")
    @Expose
    private int size;

    @SerializedName("totalhits")
    @Expose
    private int totalhits;

    @SerializedName("totalpages")
    @Expose
    private int totalpages;

    @SerializedName("nextpage")
    @Expose
    private String nextpage;
}

/*
"page":1,
      "size":40,
      "totalhits":743,
      "totalpages":19,
      "nextpage":"http://api.sr.se/v2/programs?format=json&size=40&page=2"
 */