public class AnonymousClassQueen {
    public static void main(String[] args) {
        showGroup(new Group() {
            @Override
            public String bestAlbum() {
                return "A Night At The Opera";
            }
        });
    }
}