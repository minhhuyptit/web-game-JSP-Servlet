/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snow.tool;

/**
 *
 * @author huyla
 */
public class Pagination {
    private int totalItems;         //Tổng số phần tử
    private int totalItemsPerPage;  //Số phần tử mỗi trang
    private int pageRange;          //Số lượng page hiện ra
    private int totalPage;;         //Tổng số trang
    private int currentPage;        //Trang hiện tại

    public Pagination() {
    }

    public Pagination(int totalItems, int totalItemsPerPage, int pageRange,  int currentPage) {
        this.totalItems = totalItems;
        this.totalItemsPerPage = totalItemsPerPage;
        pageRange = (pageRange % 2 == 0) ? ++pageRange : pageRange;
        this.pageRange = pageRange;
        this.totalPage = (int) Math.ceil(this.totalItems/this.totalItemsPerPage);
        this.currentPage = currentPage;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalItemsPerPage() {
        return totalItemsPerPage;
    }

    public void setTotalItemsPerPage(int totalItemsPerPage) {
        this.totalItemsPerPage = totalItemsPerPage;
    }

    public int getPageRange() {
        return pageRange;
    }

    public void setPageRange(int pageRange) {
        this.pageRange = pageRange;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
    public String showPagination(String link){
        String pagination = "";
        String prev = "";
        String next = "";
        String listPages = "";
        
        if(this.totalPage > 1){
            prev = "<li><a>« </a></li>";
            if(this.currentPage > 1){
                prev = "<li><a href=\""+ link +"&page="+ (this.currentPage-1) +"\">« </a></li>"; 
            }
            next = "<li><a> »</a></li>";
            if(this.currentPage < this.totalPage){
                next = "<li><a href=\"" + link + "&page=" + (this.currentPage+1) + "\"> »</a></li>";
            }
            int startPage;
            int endPage;
            if(this.pageRange < this.totalPage){
                startPage = this.currentPage - (this.pageRange-1)/2;
                endPage = this.currentPage + (this.pageRange-1)/2;
                if(startPage < 1){
                    startPage   = 1;
                    endPage     = this.pageRange;
                }else if(endPage > this.totalPage){
                    startPage   = this.totalPage - this.pageRange + 1;
                    endPage     = this.totalPage;
                }
            }else{
                startPage   = 1;
                endPage     = this.totalPage;
            }
            
            for (int i = startPage; i <= endPage; i++) {
                if(this.currentPage == i){
                    listPages += "<li><a class=\"active\">" + i + "</a></li>";
                }else{
                    listPages += "<li><a href=\"" + link + "&page=" + i + "\">" + i + "</a></li>";
                }
            }
            pagination = "<ul class=\"pagination\">" + prev + listPages + next + "</ul>";
        }
        
        return pagination;
    }
    
}
