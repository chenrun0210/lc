package test;

public class Toy {
    private String head;
    private String body;

    public String fun() {
        System.out.println("toy fun");
        return "";
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public static class Builder<T extends Toy> {
        private T toy ;
        public Builder(T data) {
            toy = data;
        }

        public Builder setHead(String head) {
            toy.setHead(head);
            return this;
        }

        public Builder setBody(String body) {
            toy.setBody(body);
            return this;
        }

        public Toy build() {
            return toy;
        }
    }
    public static void main(String[] hh) {
        String body = "1";
        String head = "2";
    }
}

