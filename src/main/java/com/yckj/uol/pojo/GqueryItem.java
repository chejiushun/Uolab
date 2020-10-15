package com.yckj.uol.pojo;

/**
 * Description:描述
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 *
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/9/24
 */
public class GqueryItem {

    private String match_year;

    public String getMatch_year() {
        return match_year;
    }

    public void setMatch_year(String match_year) {
        this.match_year = match_year;
    }

    @Override
    public String toString() {
        return "GqueryItem{" +
                "match_year='" + match_year + '\'' +
                '}';
    }
}
