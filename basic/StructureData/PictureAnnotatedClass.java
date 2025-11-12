@Entity
public class Picture {
    @PrimaryKey
    protected Integer pictureId;
    @Persistent
    protected String pictureName = null;

    @Getter
    public String getPictureName() {
        return this.pictureName;
    }

    @Setter
    public void setPictureName(@Optional String pictureName) {
        this.pictureName = pictureName;
    }
}