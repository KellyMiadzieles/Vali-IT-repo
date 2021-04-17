package ee.bcs.valiit.DTO;

public class Book {

        private String title;
        private String author;
        private int publishedyear;

        public String getTitle() { //cmd N ja valin kõik
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getPublishedyear() {
            return publishedyear;
        }

        public void setPublishedyear(int publishedyear) {
            this.publishedyear = publishedyear;
        }
    }

