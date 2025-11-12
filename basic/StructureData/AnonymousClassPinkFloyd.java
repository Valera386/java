public class AnonymousClassPinkFloyd {
    public static void main(String[] args) {
        Group pinkFloyd = new Group() {
            @Override
            public String bestAlbum() {
                return "Wish You Were Here";
            }
        };
        String album = pinkFloyd.bestAlbum();
        System.out.println(album);
    }
}