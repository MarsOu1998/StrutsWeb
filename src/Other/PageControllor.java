package Other;

import java.util.ArrayList;

//负责传入一个大的集合，根据页号返回所需要的数据
public class PageControllor {

    private ArrayList bigList;      //大的集合，外界传入
    private int currentPageIndex=1; //当前页号，外界传入
    private int countPerPage=3;      //每页条数，外界可以设定
    private ArrayList smallList;    //小的集合，返回
    private int pageCount;
    private int recordCount;
    private int prePageIndex;
    private int nextPageIndex;
    private boolean first;
    private boolean last;

    public ArrayList getSmallList() {
        return smallList;
    }

    public void setSmallList(ArrayList smallList) {
        this.smallList = smallList;
    }

    public ArrayList getBigList() {
        return bigList;
    }

    public void setBigList(ArrayList bigList) {
        this.bigList = bigList;
        recordCount=bigList.size();
        System.out.println(recordCount);
        if(recordCount%countPerPage==0){
            pageCount=recordCount/countPerPage;
            System.out.println(pageCount);
        }
        else {
            pageCount = (recordCount / countPerPage) + 1;
            System.out.println(pageCount);
        }
    }

    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(int currentPageIndex) {
        //每当页面改变，都会调用这个方法
        this.currentPageIndex = currentPageIndex;
        this.prePageIndex=currentPageIndex-1;
        this.nextPageIndex=currentPageIndex+1;
        if(currentPageIndex==1){
            first=true;
        }
        else
            first=false;
        if(currentPageIndex==pageCount){
            last=true;
        }
        else
        {
            last=false;
        }
        smallList = new ArrayList();
        for (int i = (currentPageIndex-1)*countPerPage; i < currentPageIndex*countPerPage&&i<recordCount; i++) {
            smallList.add(bigList.get(i));
        }
    }

    public int getCountPerPage() {
        return countPerPage;
    }

    public void setCountPerPage(int countPerPage) {

        this.countPerPage=countPerPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPrePageIndex() {
        return prePageIndex;
    }

    public void setPrePageIndex(int prePageIndex) {
        this.prePageIndex = prePageIndex;
    }

    public int getNextPageIndex() {
        return nextPageIndex;
    }

    public void setNextPageIndex(int nextPageIndex) {
        this.nextPageIndex = nextPageIndex;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }
}
