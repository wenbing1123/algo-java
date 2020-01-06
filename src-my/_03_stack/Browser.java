package _03_stack;

public class Browser {

    private String currentPage;
    private BrowserStack forward;
    private BrowserStack back;

    public Browser() {
        forward = new BrowserStack();
        back = new BrowserStack();
    }

    public void showUrl(String url, String prefix) {
        this.currentPage = url;
        System.out.println(prefix + " page == " + url);
    }

    public void checkCurrentPage() {
        System.out.println("Current page is: " + this.currentPage);
    }

    public void open(String url) {
        if (this.currentPage != null) {
            this.back.push(this.currentPage);
            this.forward.clear();
        }
        showUrl(url, "Open");
    }

    public boolean canGoBack() {
        return this.back.size() > 0;
    }

    public boolean canGoForward() {
        return this.forward.size() > 0;
    }

    public String goBack() {
        if (this.canGoBack()) {
            this.forward.push(this.currentPage);
            String backUrl = this.back.pop();
            showUrl(backUrl, "Back");
            return backUrl;
        }

        System.out.println("* Cannot go back, no pages behind.");
        return null;
    }

    public String goForward() {
        if (this.canGoForward()) {
            this.back.push(this.currentPage);
            String forwardUrl = this.forward.pop();
            showUrl(forwardUrl, "Foward");
            return forwardUrl;
        }

        System.out.println("** Cannot go forward, no pages ahead.");
        return null;
    }


    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentPage();
    }

}

class BrowserStack {

    private BrowserNode top;
    private int size;

    public void push(String value) {
        BrowserNode newNode = new BrowserNode(value, null);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    public String pop() {
        if (top == null) {
            return "";
        }

        String data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public void clear() {
        this.top = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public void printAll() {
        BrowserNode p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
}

class BrowserNode {
    public String data;
    public BrowserNode next;

    public BrowserNode(String data, BrowserNode next) {
        this.data = data;
        this.next = next;
    }

}