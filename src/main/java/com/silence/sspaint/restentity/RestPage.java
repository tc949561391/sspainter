package com.silence.sspaint.restentity;

import org.springframework.stereotype.Component;

import java.util.List;

/**搜索结果的显示，包含第几页，共多少页和搜到的结果泛型
 * Created by 杰 on 2016/2/11.
 */
public class RestPage<T> {

    private int totlePage;

    private int localPage;

    private List<T> content;


    public int getTotlePage() {
        return totlePage;
    }

    public void setTotlePage(int totlePage) {
        this.totlePage = totlePage;
    }

    public int getLocalPage() {
        return localPage;
    }

    public void setLocalPage(int localPage) {
        this.localPage = localPage;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }


    public void clean(){
        this.totlePage=0;
        this.localPage=0;
        this.content.forEach(C->content.remove(C));
    }
}
