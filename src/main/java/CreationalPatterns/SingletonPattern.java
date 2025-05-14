package CreationalPatterns;

public class SingletonPattern {

    public static class Browser{

        //1. Create a private static instance of that class
        private static Browser browser;

        //2. Make the constructor private so we cannot create instances outside the class
        private Browser() {}

        //3. Create a public method to access the instance
        // 3.1 Make it thread safe by using synchronized (Locks until the current
        // Thread finish using it

        /*
        All the method thread safe

        public synchronized static Browser getInstance() {
            if(browser == null){
                browser = new Browser();
            }
            return browser;
        }

        */

        public static Browser getInstance() {
            if(browser == null) {
                synchronized (Browser.class) {
                    browser = new Browser();
                }
            }
            return browser;
        }

        public void displayMsg(){
            System.out.println("Browser Info");
        }
    }

    public static void main(String[] args) {
        Browser.getInstance().displayMsg();
    }
}
