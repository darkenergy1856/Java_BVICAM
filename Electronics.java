public class Electronics {
    public static void main(String[] args) {
        Television tele = new Television(10000);
        tele.cost();
        Electronics.Television.cost(tele);

    }

    static class Television{
        int cost;
        Television(int cost){
            this.cost = cost;
        }
        void cost(){
            System.out.println("Cost is : "  + cost);
        }

        static void cost(Television t){
            System.out.println("Cost is : " + t.cost);
        }
    }
}
