class BrowserHistory {
    class Node {
        String page;
        Node nextPage;
        Node prevPage;
    }
    Node home;
    Node currentPage;
    Node lastPage;


    public BrowserHistory(String homepage) {
        home = new Node();
        home.page = homepage;
        currentPage = home;
        lastPage = home;    
    }
    
    public void visit(String url) {
        Node visit = new Node();
        visit.page = url;
        visit.prevPage = currentPage;
        currentPage.nextPage = visit;
        lastPage = visit;
        currentPage = visit;
        
    }
    
    public String back(int steps) {
        while(currentPage != null) {
            if(steps == 0){
                return currentPage.page;
            }
            steps--;
            currentPage = currentPage.prevPage;
        }
        currentPage = home;
        return currentPage.page;
        
    }
    
    public String forward(int steps) {
        while(currentPage != null) {
            if(steps == 0){
                return currentPage.page;
            }
            steps--;
            currentPage = currentPage.nextPage;
        }
        currentPage = lastPage;
        return currentPage.page;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */